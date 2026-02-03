package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Metodos_Select {

    // Método para obtener productos y agregarlos a la JTable
    public void get_productos(DefaultTableModel modeloTabla, String condicion) {
        int id = 0;
        String querySelect = "SELECT * FROM producto " + condicion + " ORDER BY codigo ASC";
        Connection conex = null;

        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return;
            }

            try (PreparedStatement solicitud = conex.prepareStatement(querySelect); ResultSet respuesta = solicitud.executeQuery()) {
                while (respuesta.next()) {
                    id++;
                    int codigo = respuesta.getInt("codigo");
                    String nombre = respuesta.getString("nombre");
                    float precio = respuesta.getFloat("precio");
                    float iva = respuesta.getFloat("iva");
                    int min = respuesta.getInt("min");
                    int max = respuesta.getInt("max");
                    int cantidad = respuesta.getInt("cantidad");
                    boolean estado = respuesta.getBoolean("estado");
                    String aux;
                    if (estado) {
                        aux = "Activo";
                    } else {
                        aux = "Inactivo";
                    }
                    modeloTabla.addRow(new Object[]{id, codigo, nombre, precio, iva, cantidad, min, max, aux});
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener productos: " + e.getMessage(), "Inicio", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }

    }

    //contar cantidad de productos en sistema
    public int contarProductos() {
        int totalProductos = 0;
        String queryCount = "SELECT COUNT(*) FROM producto WHERE estado = true";
        Connection conex = null;

        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return 0;
            }

            try (PreparedStatement solicitud = conex.prepareStatement(queryCount); ResultSet respuesta = solicitud.executeQuery()) {
                if (respuesta.next()) {
                    totalProductos = respuesta.getInt(1); // Obtiene el número total de productos
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al contar productos: " + e.getMessage(), "Inicio", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
        //retorna la cantidad
        return totalProductos;
    }

    // Método para login comprobar, verifica credenciales ingresadas
    public Object[] get_login(int ced, String clave_param) {
        String query = "SELECT rol, cedula, nombre FROM usuario WHERE cedula=? AND clave=?";
        Object[] datos = new Object[]{"", -1, 0, ""}; // Valor inicial por defecto

        try (Connection conex = Conexion.Conectar(); PreparedStatement solicitud = conex.prepareStatement(query)) {

            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", JOptionPane.ERROR_MESSAGE);
                return datos;
            }

            solicitud.setInt(1, ced);
            solicitud.setString(2, clave_param);

            try (ResultSet respuesta = solicitud.executeQuery()) {
                if (respuesta.next()) {
                    datos[0] = respuesta.getString("rol");
                    datos[1] = 1; // Indica éxito en la validación
                    datos[2] = respuesta.getInt("cedula");
                    datos[3] = respuesta.getString("nombre");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta de login: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        //retorna la informacion del usuarios, si no se encontro el usuario el objeto estara vacio y eso se comprueba en la interfaz
        return datos;
    }

    //obtener informacion de un producto en especidfico mediante su codigo
    public Object[] get_prod(int cod) {
        String query = "SELECT * FROM producto WHERE codigo=?";
        Connection conex = null;
        Object[] datosProducto = null;

        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                return new Object[]{"Error: No se pudo conectar a la base de datos"};
            }

            try (PreparedStatement solicitud = conex.prepareStatement(query)) {
                solicitud.setInt(1, cod);

                try (ResultSet respuesta = solicitud.executeQuery()) {
                    if (respuesta.next()) {
                        datosProducto = new Object[]{
                            respuesta.getInt("codigo"),
                            respuesta.getString("nombre"),
                            respuesta.getFloat("precio"),
                            respuesta.getFloat("iva"),
                            respuesta.getInt("min"),
                            respuesta.getInt("max"),
                            respuesta.getInt("cantidad"),
                            respuesta.getBoolean("estado")
                        };
                    } else {
                        datosProducto = new Object[]{"No se encontró el producto con ID: " + cod};
                        JOptionPane.showMessageDialog(null, datosProducto[0], "Actualización", 0);
                    }
                }
            }
        } catch (SQLException e) {
            datosProducto = new Object[]{"Error al buscar el producto: " + e.getMessage()};
            JOptionPane.showMessageDialog(null, datosProducto[0], "Actualización", 0);

        } finally {
            Conexion.cerrarConexion(conex);
        }
        return datosProducto;
    }//fin

    // Método para obtener usuarios y agregarlos a la JTable
    public void get_usuarios(DefaultTableModel modeloTabla) {
        String querySelect = "SELECT * FROM usuario";
        Connection conex = null;
        int i = 0;
        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return;
            }
            try (PreparedStatement solicitud = conex.prepareStatement(querySelect); ResultSet respuesta = solicitud.executeQuery()) {
                while (respuesta.next()) {
                    i++;
                    int cedula = respuesta.getInt("cedula");
                    String nombre = respuesta.getString("nombre");
                    String tlfn = respuesta.getString("tlfn");
                    String clave = respuesta.getString("clave");
                    String rol = respuesta.getString("rol");
                    modeloTabla.addRow(new Object[]{i, cedula, nombre, tlfn, clave, rol});
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener usuarios: " + e.getMessage(), "Inicio", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
    }//FIN

    //obtener informacion de todos los proveedores e insertarlos en la Jtable
    public void get_provee(DefaultTableModel modeloTabla, String condicion) {
        String querySelect = "SELECT * FROM proveedor " + condicion + " ORDER BY nombre ASC";
        Connection conex = null;
        int id = 0;

        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return;
            }

            try (PreparedStatement solicitud = conex.prepareStatement(querySelect); ResultSet respuesta = solicitud.executeQuery()) {
                while (respuesta.next()) {
                    id++;
                    int codigo = respuesta.getInt("codigo");
                    String nombre = respuesta.getString("nombre");
                    String telefono = respuesta.getString("telefono");
                    String direccion = respuesta.getString("direccion");
                    modeloTabla.addRow(new Object[]{id, codigo, nombre, telefono, direccion});
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener proveedor: " + e.getMessage(), "Inicio", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
    }//FIN
    //contar cantidad de proveedores en el sistema

    public int contarProveedor() {
        int totalProveedor = 0;
        String queryCount = "SELECT COUNT(*) FROM proveedor WHERE estado = true";
        Connection conex = null;

        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return 0;
            }

            try (PreparedStatement solicitud = conex.prepareStatement(queryCount); ResultSet respuesta = solicitud.executeQuery()) {
                if (respuesta.next()) {
                    totalProveedor = respuesta.getInt(1); // Obtiene el número total de proveedores
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al contar proveedor: " + e.getMessage(), "Inicio", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
        //retorna la cantidad
        return totalProveedor;
    }

    //obtener informacion de un proveedor en especifico mediante su cedula
    public Object[] get_provee(int cod) {
        String query = "SELECT * FROM proveedor WHERE codigo=?";
        Connection conex = null;
        Object[] datosProvee = null;

        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                return new Object[]{"Error: No se pudo conectar a la base de datos"};
            }
            try (PreparedStatement solicitud = conex.prepareStatement(query)) {
                solicitud.setInt(1, cod);

                try (ResultSet respuesta = solicitud.executeQuery()) {
                    if (respuesta.next()) {
                        datosProvee = new Object[]{
                            respuesta.getInt("codigo"),
                            respuesta.getString("nombre"),
                            respuesta.getString("telefono"),
                            respuesta.getString("direccion"),
                            respuesta.getBoolean("estado"),};
                    } else {
                        datosProvee = new Object[]{"No se encontró el proveedor con Codgio: " + cod};
                        JOptionPane.showMessageDialog(null, datosProvee[0], "Actualización", 0);
                    }
                }
            }
        } catch (SQLException e) {
            datosProvee = new Object[]{"Error al buscar el proveedor: " + e.getMessage()};
            JOptionPane.showMessageDialog(null, datosProvee[0], "Actualización", 0);

        } finally {
            Conexion.cerrarConexion(conex);
        }
        return datosProvee;
    }//fin

    //obtener informacion de todos los clientes e insertarlos en la jtable
    public void get_cliente(DefaultTableModel modeloTabla) {
        String querySelect = "SELECT * FROM cliente ORDER BY nombre ASC";
        Connection conex = null;
        int id = 0;

        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return;
            }

            try (PreparedStatement solicitud = conex.prepareStatement(querySelect); ResultSet respuesta = solicitud.executeQuery()) {
                while (respuesta.next()) {
                    id++;
                    int cedula = respuesta.getInt("cedula");
                    String nombre = respuesta.getString("nombre");
                    String telefono = respuesta.getString("telefono");
                    String direccion = respuesta.getString("direccion");
                    modeloTabla.addRow(new Object[]{id, cedula, nombre, telefono, direccion});
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener cliente: " + e.getMessage(), "Inicio", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
    }//FIN
    
    //contar cantidad de clientes en el sistema
    public int contarClientes() {
        int totalClientes = 0;
        String queryCount = "SELECT COUNT(*) FROM cliente";
        Connection conex = null;

        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return 0;
            }

            try (PreparedStatement solicitud = conex.prepareStatement(queryCount); ResultSet respuesta = solicitud.executeQuery()) {
                if (respuesta.next()) {
                    totalClientes = respuesta.getInt(1);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al contar clientes: " + e.getMessage(), "Inicio", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
        //retorna la cantidad
        return totalClientes;
    }

    //obtener informacion de un cliente en especifico mediante su cedula
    public Object[] get_cliente(int cod) {
        String query = "SELECT * FROM cliente WHERE cedula=?";
        Connection conex = null;
        Object[] datosCliente = null;

        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                return new Object[]{"Error: No se pudo conectar a la base de datos"};
            }
            try (PreparedStatement solicitud = conex.prepareStatement(query)) {
                solicitud.setInt(1, cod);

                try (ResultSet respuesta = solicitud.executeQuery()) {
                    if (respuesta.next()) {
                        datosCliente = new Object[]{
                            respuesta.getInt("cedula"),
                            respuesta.getString("nombre"),
                            respuesta.getString("telefono"),
                            respuesta.getString("direccion"),};
                    } else {
                        datosCliente = new Object[]{"No se encontró el cliente con Cedula: " + cod};
                        JOptionPane.showMessageDialog(null, datosCliente[0], "Actualización", 0);
                    }
                }
            }
        } catch (SQLException e) {
            datosCliente = new Object[]{"Error al buscar el cliente: " + e.getMessage()};
            JOptionPane.showMessageDialog(null, datosCliente[0], "Actualización", 0);

        } finally {
            Conexion.cerrarConexion(conex);
        }
        //retorna la info del cliente
        return datosCliente;
    }//fin

    //obtener el id de la factura de salida, esto es para saber la secuencia y saber cual es el id de la factura siguiente
    public int obtenerID_salida(String query) {
        int valorMaximo = 0;
        String queryMax = "SELECT MAX(id) FROM " + query;
        Connection conex = null;
        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return 0;
            }
            try (PreparedStatement solicitud = conex.prepareStatement(queryMax); ResultSet respuesta = solicitud.executeQuery()) {
                if (respuesta.next()) {
                    valorMaximo = respuesta.getInt(1);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el ID factura: " + e.getMessage(), "Inicio", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
        return valorMaximo;
    }

    //obtener informacion de la cabecera de factura, sirve para factura de entrada o salida, eso se recibe por parametro en query
    //esto es para los reportes, recibe el numero de mes, y obtiene la facturas de ese mes
    public void get_cab_factura(int num_mes, DefaultTableModel modeloTabla, String query) {
        String querySelect = "SELECT * FROM " + query + " WHERE MONTH(fecha) = ? ORDER BY id DESC"; // La columna "fecha" debe ser de tipo DATE
        Connection conex = null;
        int num = 0;
        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return;
            }

            try (PreparedStatement solicitud = conex.prepareStatement(querySelect)) {
                solicitud.setInt(1, num_mes); // Establecer el parámetro del mes

                try (ResultSet respuesta = solicitud.executeQuery()) {
                    while (respuesta.next()) {
                        int id = respuesta.getInt("id");
                        int cod = respuesta.getInt("cedula");
                        String fecha = respuesta.getString("fecha"); // Cambié a Date para que coincida con el tipo de dato
                        String hora = respuesta.getString("hora");
                        float monto = respuesta.getFloat("monto");
                        num++;
                        modeloTabla.addRow(new Object[]{num, id, cod, fecha, hora, monto, "Ver Detalles"});
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener facturas: " + e.getMessage(), "Inicio", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
    }

    //obtener las cabecera de las facuras, entradas o salidas, eso se recibe por parametro
    //esto es para los reportes quincenales, solo hace la consulta, y la divide en 2, tambien recibe 2 modelos de tabla
    //en los modelos de tabla inserta la informacion correspondiente a cada quincena
    public void get_quincena(int num_mes, DefaultTableModel modeloQuincena1, DefaultTableModel modeloQuincena2, String query1) {
        String query = "SELECT *, "
                + "CASE WHEN DAY(fecha) BETWEEN 1 AND 15 THEN 'Primera Quincena' "
                + "ELSE 'Segunda Quincena' END AS quincena "
                + "FROM " + query1 + " WHERE MONTH(fecha) = ?";

        Connection conex = null;
        int num1 = 0, num2 = 0;
        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return;
            }

            try (PreparedStatement solicitud = conex.prepareStatement(query)) {
                solicitud.setInt(1, num_mes);

                try (ResultSet respuesta = solicitud.executeQuery()) {
                    while (respuesta.next()) {
                        int id = respuesta.getInt("id");
                        int cod = respuesta.getInt("cedula");
                        String fecha = respuesta.getString("fecha");
                        String hora = respuesta.getString("hora");
                        float monto = respuesta.getFloat("monto");
                        String quincena = respuesta.getString("quincena");
                        if (quincena.equals("Primera Quincena")) {
                            num1++;
                            Object[] fila = {num1, id, cod, fecha, hora, monto, "Ver Detalles"};
                            modeloQuincena1.addRow(fila);
                        } else {
                            num2++;
                            Object[] fila = {num2, id, cod, fecha, hora, monto, "Ver Detalles"};
                            modeloQuincena2.addRow(fila);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener facturas: " + e.getMessage(), "Inicio", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
    }

    //obtener facturas de las semanas, facturas de entrada o salida, tambien recibe 4 modelos de tabla en donde
    // se va INGRESAR la informacion correspondiente a cada semana, la consulta divide los datos en cada semana
    public void get_semanas(int num_mes, DefaultTableModel modeloSemana1, DefaultTableModel modeloSemana2,
            DefaultTableModel modeloSemana3, DefaultTableModel modeloSemana4, String query1) {
        String query = "SELECT *, "
                + "CASE "
                + "WHEN WEEK(fecha, 1) - WEEK(DATE_FORMAT(fecha, '%Y-%m-01'), 1) + 1 = 1 THEN 1 "
                + "WHEN WEEK(fecha, 1) - WEEK(DATE_FORMAT(fecha, '%Y-%m-01'), 1) + 1 = 2 THEN 2 "
                + "WHEN WEEK(fecha, 1) - WEEK(DATE_FORMAT(fecha, '%Y-%m-01'), 1) + 1 = 3 THEN 3 "
                + "ELSE 4 "
                + "END AS semana_mes "
                + "FROM " + query1 + " WHERE MONTH(fecha) = ? ORDER BY id DESC";

        Connection conex = null;
        int num1 = 0, num2 = 0, num3 = 0, num4 = 0;
        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return;
            }

            try (PreparedStatement solicitud = conex.prepareStatement(query)) {
                solicitud.setInt(1, num_mes);

                try (ResultSet respuesta = solicitud.executeQuery()) {
                    while (respuesta.next()) {
                        int id = respuesta.getInt("id");
                        int cod = respuesta.getInt("cedula");
                        String fecha = respuesta.getString("fecha");
                        String hora = respuesta.getString("hora");
                        float monto = respuesta.getFloat("monto");
                        int semana = respuesta.getInt("semana_mes");

                        switch (semana) {
                            case 1 -> {
                                num1++;
                                Object[] fila = {num1, id, cod, fecha, hora, monto, "Ver Detalles"};
                                modeloSemana1.addRow(fila);
                            }
                            case 2 -> {
                                num2++;
                                Object[] fila = {num2, id, cod, fecha, hora, monto, "Ver Detalles"};
                                modeloSemana2.addRow(fila);
                            }
                            case 3 -> {
                                num3++;
                                Object[] fila = {num3, id, cod, fecha, hora, monto, "Ver Detalles"};
                                modeloSemana3.addRow(fila);
                            }
                            case 4 -> {
                                num4++;
                                Object[] fila = {num4, id, cod, fecha, hora, monto, "Ver Detalles"};
                                modeloSemana4.addRow(fila);
                            }
                            default ->
                                JOptionPane.showMessageDialog(null, "Factura fuera de rango de semanas.", "Inicio", 0);
                        }
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener facturas: " + e.getMessage(), "Inicio", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
    }

    //obtener detalles de una factura en especifico y los INGRESAAR en una tabla
    //recibe el modelo de tabla, id de factura y query es el tipo de tabla, ya que es para factura de entrada o salida
    public void get_det_factura(int id, DefaultTableModel modeloTabla, String query) {
        String querySelect = "SELECT * FROM " + query + " WHERE id = ?";
        Connection conex = null;
        int num = 0;

        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return;
            }

            try (PreparedStatement solicitud = conex.prepareStatement(querySelect)) {
                solicitud.setInt(1, id);

                try (ResultSet respuesta = solicitud.executeQuery()) {
                    while (respuesta.next()) {
                        int cod = respuesta.getInt("codigo_producto");
                        String nombre = respuesta.getString("nombre");
                        float precio = respuesta.getFloat("precio");
                        float iva = respuesta.getFloat("iva");
                        int cant = respuesta.getInt("cantidad");
                        num++;
                        modeloTabla.addRow(new Object[]{num, cod, nombre, precio, iva, cant});
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener detalles: " + e.getMessage(), "Inicio", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
    }

    //obtener infomacionde de todas las facturas, esto es para el historial, recibe por parametro el modelo de la tabla y el tipo de tala
    //sirve para historial de facturas de entrada o salida
    public void get_cab_factura(DefaultTableModel modeloTabla, String query) {
        String querySelect = "SELECT * FROM " + query + " ORDER BY id DESC";
        Connection conex = null;
        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return;
            }

            try (PreparedStatement solicitud = conex.prepareStatement(querySelect)) {

                try (ResultSet respuesta = solicitud.executeQuery()) {
                    while (respuesta.next()) {
                        int id = respuesta.getInt("id");
                        int cod = respuesta.getInt("cedula");
                        String fecha = respuesta.getString("fecha");
                        String hora = respuesta.getString("hora");
                        float monto = respuesta.getFloat("monto");
                        modeloTabla.addRow(new Object[]{id, cod, fecha, hora, monto, "Ver Detalles"});
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener facturas: " + e.getMessage(), "Inicio", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
    }

    //obtener informacion de la bitacora, recibe la tabla u tambien la condicion para el filtrado de busqueda
    public void get_bitacora(DefaultTableModel modeloTabla, String query) {
        String querySelect = "SELECT * FROM bitacora " + query + " ORDER BY id DESC";
        Connection conex = null;
        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return;
            }

            try (PreparedStatement solicitud = conex.prepareStatement(querySelect); ResultSet respuesta = solicitud.executeQuery()) {
                while (respuesta.next()) {
                    int id = respuesta.getInt("id");
                    int cedula = respuesta.getInt("cedula");
                    String nombre = respuesta.getString("nombre");
                    String fecha = respuesta.getString("fecha");
                    String hora = respuesta.getString("hora");
                    String accion = respuesta.getString("accion");
                    modeloTabla.addRow(new Object[]{id, cedula, nombre, fecha, hora, accion});
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener cliente: " + e.getMessage(), "Inicio", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
    }//FIN

    //VALIDA LAS CANTIDADES DEL PRODUCTO, ESTO SOLO SI EL PRODUCTO SE ENCUENTRA ACTIVO
    //esta funcion se usa para devolver la cantidad actual, minima o maximo de un producto dependiendo del parametro recibido
    public int obtener_infstock(int cod, String query) {
        String querySelect = "SELECT " + query + ", estado FROM producto WHERE codigo=?";
        Connection conex = Conexion.Conectar();
        int cantidadActual = -1; // Valor por defecto en caso de error
        if (conex == null) {
            JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
            return cantidadActual;
        }
        try (PreparedStatement solicitudSelect = conex.prepareStatement(querySelect)) {
            solicitudSelect.setInt(1, cod);
            try (ResultSet resultado = solicitudSelect.executeQuery()) {
                if (resultado.next()) {
                    cantidadActual = resultado.getInt(query);
                    int estado = resultado.getInt("estado");
                    if (estado == 0) {
                        JOptionPane.showMessageDialog(null, "Este Producto se Encuentra Eliminado.", "Error", 0);
                        return -1;
                    }
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el stock: " + e.getMessage(), "Error", 0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error inesperado: " + ex.getMessage(), "Error", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
        return cantidadActual;
    }

    //obtener informacion de una cabecera de factura en especifo, query es el tipo de tabla y el id es el numero de factura
    public Object[] get_cabecera(int idf, String quer) {
        String query = "SELECT * FROM " + quer + " WHERE id=?";
        Connection conex = null;
        Object[] datosFac = null;
        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                return new Object[]{"Error: No se pudo conectar a la base de datos"};
            }

            try (PreparedStatement solicitud = conex.prepareStatement(query)) {
                solicitud.setInt(1, idf);

                try (ResultSet respuesta = solicitud.executeQuery()) {
                    if (respuesta.next()) {
                        datosFac = new Object[]{
                            respuesta.getInt("id"),
                            respuesta.getInt("cedula"),
                            respuesta.getString("fecha"),
                            respuesta.getString("hora"),
                            respuesta.getFloat("monto"),};
                    } else {
                        datosFac = new Object[]{"No se encontró la factura con ID: " + idf};
                        JOptionPane.showMessageDialog(null, datosFac[0], "Actualización", 0);
                    }
                }
            }
        } catch (SQLException e) {
            datosFac = new Object[]{"Error al buscar la factura: " + e.getMessage()};
            JOptionPane.showMessageDialog(null, datosFac[0], "Actualización", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
        return datosFac;
    }

    //OBTENER CANTIDAD DE FACTURAS, RECIBE POR PARAMETRO EL TIPO DE TABLA A OCNSULTAR SI DE ENTRADA O SALIDA
    public int contarFactura(String query) {
        int totalEntrada = 0;
        String queryCount = "SELECT COUNT(*) FROM " + query;
        Connection conex = null;

        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return 0;
            }

            try (PreparedStatement solicitud = conex.prepareStatement(queryCount); ResultSet respuesta = solicitud.executeQuery()) {
                if (respuesta.next()) {
                    totalEntrada = respuesta.getInt(1);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al contar Entradas: " + e.getMessage(), "Inicio", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
        return totalEntrada;
    }

}
