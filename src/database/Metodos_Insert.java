package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

//FUNCIONES:
//REGISTRO DE UN NUEVO USUARIO
//NUEVO PRODUCTO
//NUEVO PROVEEDOR
//NUEVO CLIENTE
//CABECERA DE FACTURA DE ENTRADA
//DETALLES DE FACTURA DE ENTRADA
//CABECERA DE FACTURA DE SALIDA
//DETALLES DE FACTURA DE SALIDA
//ACCION DE LA BITACORA

public class Metodos_Insert {

    //insertar un nuevo usuario en la base de datos, rol predeterminado usuario
    public void post(int cedula, String nombre, String tlfn, String clave) {
        String query = "INSERT INTO usuario (cedula, nombre, tlfn, clave, rol) VALUES (?, ?, ?, ?, 'user')";

        try (Connection conex = Conexion.Conectar(); PreparedStatement solicitud = conex.prepareStatement(query)) {

            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", JOptionPane.ERROR_MESSAGE);
                return;
            }

            solicitud.setInt(1, cedula);
            solicitud.setString(2, nombre);
            solicitud.setString(3, tlfn);
            solicitud.setString(4, clave);
            solicitud.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro realizado exitosamente.", "Registro", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//FIN

    // Insertar nuevo producto
    public boolean post_prod(int cod, String nombre, float precio, float iva, int min, int max, int stock, boolean estado) {
        String query = "INSERT INTO producto ( codigo, nombre, precio, iva, min, max, cantidad, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conex = null;

        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return false;
            }

            try (PreparedStatement solicitud = conex.prepareStatement(query)) {
                solicitud.setInt(1, cod);
                solicitud.setString(2, nombre);
                solicitud.setFloat(3, precio);
                solicitud.setFloat(4, iva);
                solicitud.setInt(5, min);
                solicitud.setInt(6, max);
                solicitud.setInt(7, stock);
                solicitud.setBoolean(8, estado);
                solicitud.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro realizado exitosamente.", "Registro", 1);
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error en la inserción a la base de datos: " + e.getMessage(), "Error", 0);
            return false;
        } finally {
            Conexion.cerrarConexion(conex);
        }
    }//fin

    //insertar un nuevo proveedor en la base de datos
    public boolean post_provee(int cod, String nombre, String telefono, String direccion, boolean estado) {
        String query = "INSERT INTO proveedor ( codigo, nombre, telefono, direccion, estado) VALUES (?, ?, ?, ?, ?)";
        Connection conex = null;
        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return false;
            }
            try (PreparedStatement solicitud = conex.prepareStatement(query)) {
                solicitud.setInt(1, cod);
                solicitud.setString(2, nombre);
                solicitud.setString(3, telefono);
                solicitud.setString(4, direccion);
                solicitud.setBoolean(5, estado);
                solicitud.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro realizado exitosamente.", "Registro", 1);
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error en la inserción a la base de datos: " + e.getMessage(), "Error", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
        //si retorna falso, no se inserto correctamente
        return false;
    }//fin

    //insertar un nuevo cliente en la base de datos
    public boolean post_cliente(int ced, String nombre, String telefono, String direccion) {
        String query = "INSERT INTO cliente ( cedula, nombre, telefono, direccion) VALUES (?, ?, ?, ?)";
        Connection conex = null;
        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return false;
            }

            try (PreparedStatement solicitud = conex.prepareStatement(query)) {
                solicitud.setInt(1, ced);
                solicitud.setString(2, nombre);
                solicitud.setString(3, telefono);
                solicitud.setString(4, direccion);
                solicitud.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registro realizado exitosamente.", "Registro", 1);
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error en la inserción a la base de datos: " + e.getMessage(), "Error", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
        return false;
    }//fin

    //insertar la cabecera de la factura de entrada
    public void post_cab_factura(int cod, String fecha, String hora, float monto) {
        String query = "INSERT INTO cab_factura ( cedula, fecha,hora, monto) VALUES (?, ?, ?,?)";
        Connection conex = null;

        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return;
            }

            try (PreparedStatement solicitud = conex.prepareStatement(query)) {
                solicitud.setInt(1, cod);
                solicitud.setString(2, fecha);
                solicitud.setString(3, hora);
                solicitud.setFloat(4, monto);
                solicitud.executeUpdate();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error en la inserción a la base de datos: " + e.getMessage(), "Error", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
    }//fin

    //inserta informacion de los detalles de la factura de entrada
    public void post_det_factura(int id, int codigo_p, String nombre, float precio, float iva, int cantidad) {
        String query = "INSERT INTO detalle_fac ( id, codigo_producto, nombre, precio, iva, cantidad) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conex = null;

        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return;
            }
            try (PreparedStatement solicitud = conex.prepareStatement(query)) {
                solicitud.setInt(1, id);
                solicitud.setInt(2, codigo_p);
                solicitud.setString(3, nombre);
                solicitud.setFloat(4, precio);
                solicitud.setFloat(5, iva);
                solicitud.setInt(6, cantidad);
                solicitud.executeUpdate();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error en la inserción a la base de datos: " + e.getMessage(), "Error", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
    }//fin

    //inserta informacion de la cabecera de la factura de salida
    public void post_cab_salida(int ced, String fecha, String hora, float monto) {
        String query = "INSERT INTO cab_salida ( cedula, fecha, hora,  monto) VALUES (?, ?, ?, ?)";
        Connection conex = null;

        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return;
            }
            try (PreparedStatement solicitud = conex.prepareStatement(query)) {
                solicitud.setInt(1, ced);
                solicitud.setString(2, fecha);
                solicitud.setString(3, hora);
                solicitud.setFloat(4, monto);
                solicitud.executeUpdate();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error en la inserción a la base de datos: " + e.getMessage(), "Error", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
    }//fin

    //inserta informacion de detalles de factura de salida
    public void post_det_salida(int id, int codigo_p, String nombre, float precio, float iva, int cantidad) {
        String query = "INSERT INTO detalle_salida ( id, codigo_producto, nombre, precio, iva, cantidad) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conex = null;

        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return;
            }

            try (PreparedStatement solicitud = conex.prepareStatement(query)) {
                solicitud.setInt(1, id);
                solicitud.setInt(2, codigo_p);
                solicitud.setString(3, nombre);
                solicitud.setFloat(4, precio);
                solicitud.setFloat(5, iva);
                solicitud.setInt(6, cantidad);
                solicitud.executeUpdate();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error en la inserción a la base de datos: " + e.getMessage(), "Error", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
    }//fin

    //inserta la accion en la bitacora
    public void post_bitacora(int cedula, String nombre, String fecha, String hora, String accion) {
        String query = "INSERT INTO bitacora (cedula, nombre, fecha, hora, accion) VALUES (?, ?, ?, ?, ?)";
        Connection conex = null;

        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return;
            }

            try (PreparedStatement solicitud = conex.prepareStatement(query)) {
                solicitud.setInt(1, cedula);
                solicitud.setString(2, nombre);
                solicitud.setString(3, fecha);
                solicitud.setString(4, hora);
                solicitud.setString(5, accion);
                solicitud.executeUpdate();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error en la inserción a la base de datos: " + e.getMessage(), "Error", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
    }

}
