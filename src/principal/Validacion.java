package principal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Validacion {

    //OBTENER FECHA ACTUAL
    public String crear_fecha() {
        Date actual = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        return formateador.format(actual);
    }

    //OBTENER HORA ACTUAL 
    public String hora() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        String valorFormateado = dateFormat.format(date);
        return valorFormateado;
    }

    //VALIDACION DE CEDULA
    public boolean validarCedula(String input) {
        // Verificar si está vacío
        if (input == null || input.isEmpty()) {
            JOptionPane.showMessageDialog(null, "EL CAMPO CEDULA NO PUEDE ESTAR VACIO", "ERROR DE ENTRADA", 0);
            return false;
        }
        // Verificar la longitud (entre 7 y 9 caracteres)
        if (input.length() < 7 || input.length() > 9) {
            JOptionPane.showMessageDialog(null, "LA LONGITUD DE LA CEDULA DEBE ESTAR ENTRE 7 Y 9 DIGITOS", "ERROR DE ENTRADA", 0);
            return false;
        }
        // Verificar si son solo números enteros
        if (!input.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "EL CAMPO CEDULA SOLO PUEDE TENER NUMEROS ENTEROS POSITIVOS", "ERROR DE ENTRADA", 0);
            return false;
        }
        // Si pasa todas las validaciones, retorna true
        return true;
    }

    //VALIDACION DE NOMBRE
    public boolean validarNombre(String nombre) {
        // Verificar si está vacío o es null
        if (nombre == null || nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "EL CAMPO NOMBRE NO PUEDE ESTAR VACIO", "ERROR DE ENTRADA", 0);
            return false;
        }
        // Verificar la longitud (mínimo 3 y máximo 30 caracteres)
        if (nombre.length() < 3 || nombre.length() > 30) {
            JOptionPane.showMessageDialog(null, "LA LONGITUD DEL NOMBRE DEBE TENER ENTRE 3 Y 30 CARACTERES", "ERROR DE ENTRADA", 0);
            return false;
        }
        // Verificar que solo contenga letras sin caracteres especiales ni números
        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            JOptionPane.showMessageDialog(null, "EL NOMBRE NO PUEDE TENER CARACTERES ESPECIALES", "ERROR DE ENTRADA", 0);
            return false;
        }
        // Si pasa todas las validaciones, retorna true
        return true;
    }

    //VALIDACION DE NUMERO DE TELEFONO
    public boolean validarTLF(String input) {
        // Verificar si está vacío
        if (input == null || input.isEmpty()) {
            JOptionPane.showMessageDialog(null, "EL CAMPO TELEFONO NO PUEDE ESTAR VACIO", "ERROR DE ENTRADA", 0);
            return false;
        }
        // Verificar la longitud de 11 digitos
        if (input.length() != 11) {
            JOptionPane.showMessageDialog(null, "EL CAMPO TELEFONO DEBE TENER 11 DIGITOS", "ERROR DE ENTRADA", 0);
            return false;
        }
        // Verificar si son solo números enteros
        if (!input.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "EL CAMPO TELEFONO SOLO PUEDE CONTENER NUMEROS ENTEROS POSITIVOS", "ERROR DE ENTRADA", 0);
            return false;
        }
        // Si pasa todas las validaciones, retorna true
        return true;
    }

    //VALIDACION DE CONTRASEÑA
    public boolean validarClave(String clave) {
        // Verificar si está vacío o es null
        if (clave == null || clave.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "EL CAMPO CLAVE NO PUEDE ESTAR VACIO", "ERROR DE ENTRADA", 0);
            return false;
        }
        // Verificar la longitud (mínimo 5 y máximo 30 caracteres)
        if (clave.length() < 5 || clave.length() > 30) {
            JOptionPane.showMessageDialog(null, "LA LONGITUD DE LA CLAVE TIENE QUE ESTAR ENTRE 5 Y 30 CARACTERES", "ERROR DE ENTRADA", 0);
            return false;
        }
        // Si pasa todas las validaciones, retorna true
        return true;
    }

    //VALIDACION DEL CODIGO DE PRODUCTOS
    public boolean validarCodigoProducto(String input) {
        // Verificar si está vacío
        if (input == null || input.isEmpty()) {
            JOptionPane.showMessageDialog(null, "EL CAMPO CODIGO PRODUCTO NO PUEDE ESTAR VACIO", "ERROR DE ENTRADA", 0);
            return false;
        }
        // Verificar la longitud (entre 6 y 9 caracteres)
        if (input.length() < 6 || input.length() > 9) {
            JOptionPane.showMessageDialog(null, "LA LONGITUD DEL CODIGO DEBE ESTAR ENTRE 6 Y 9 DIGITOS", "ERROR DE ENTRADA", 0);
            return false;
        }
        // Verificar si son solo números enteros
        if (!input.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "EL CAMPO CODIGO PRODUCTO SOLO PUEDE TENER NUMEROS ENTEROS POSITIVOS", "ERROR DE ENTRADA", 0);
            return false;
        }
        // Si pasa todas las validaciones, retorna true
        return true;
    }

    //VALIDACION DE CANTIDAD DE PRODUCTOS
    public boolean validarCantidadProducto(String input) {
        // Verificar si está vacío
        if (input == null || input.isEmpty()) {
            JOptionPane.showMessageDialog(null, "EL CAMPO CANTIDAD PRODUCTO NO PUEDE ESTAR VACIO", "ERROR DE ENTRADA", 0);
            return false;
        }
        // Verificar si son solo números enteros
        if (!input.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "EL CAMPO CANTIDAD PRODUCTO SOLO PUEDE TENER NUMEROS ENTEROS POSITIVOS", "ERROR DE ENTRADA", 0);
            return false;
        }
        //VERIFICA LA CANTIDAD DE CARACTERES MAXIMO 6, EL INVENTARIO TRABAJA CON CANTIDADES MENORES A 1M = 1.000.000
        if (input.length() > 6) {
            JOptionPane.showMessageDialog(null, "LA CANTIDAD DE DIGITOS NO PUEDE SER MAYOR A 6 DIGITOS", "ERROR DE ENTRADA", 0);
            return false;
        }
        if (Integer.parseInt(input) == 0) {
            JOptionPane.showMessageDialog(null, "EL CAMPO CANTIDAD PRODUCTO NO PUEDE SER 0", "ERROR DE ENTRADA", 0);
            return false;
        }
        // Si pasa todas las validaciones, retorna true
        return true;
    }

    //VALIDACION DEL PRECIO DE PRODUCTOS
    public boolean validarPrecioProducto(String input) {
        // Verificar si está vacío
        if (input == null || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "EL CAMPO PRECIO NO PUEDE ESTAR VACÍO", "ERROR DE ENTRADA", 0);
            return false;
        }
        // Verificar si el formato es válido (solo números positivos, con o sin decimales)
        if (!input.matches("^\\d+(\\.\\d{1,2})?$")) {
            JOptionPane.showMessageDialog(null, "EL CAMPO PRECIO SOLO PUEDE CONTENER NÚMEROS POSITIVOS", "ERROR DE ENTRADA", 0);
            return false;
        }
        //VERIFICA QUE NO SEA 0
        if (Double.parseDouble(input) <= 0) {
            JOptionPane.showMessageDialog(null, "EL CAMPO PRECIO NO PUEDE SER 0", "ERROR DE ENTRADA", 0);
            return false;
        }
        // Si pasa todas las validaciones, retorna true
        return true;
    }

    //VALIDACION DE IVA DE PRODUCTOS
    public boolean validarIvaProducto(String input) {
        // Verificar si está vacío
        if (input == null || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "EL CAMPO IVA NO PUEDE ESTAR VACÍO", "ERROR DE ENTRADA", 0);
            return false;
        }
        // Verificar si el formato es válido (solo números positivos, con o sin decimales)
        if (!input.matches("^\\d+(\\.\\d{1,2})?$")) {
            JOptionPane.showMessageDialog(null, "EL CAMPO IVA SOLO PUEDE CONTENER NÚMEROS POSITIVOS", "ERROR DE ENTRADA", 0);
            return false;
        }
        //VERIFICA QUE NO SEA 0
        if (Double.parseDouble(input) <= 0) {
            JOptionPane.showMessageDialog(null, "EL CAMPO IVA NO PUEDE SER 0", "ERROR DE ENTRADA", 0);
            return false;
        }
        //VERIFICA QUE NO SEA EL IVA MAYOR A 20%
        if (Double.parseDouble(input) > 20) {
            JOptionPane.showMessageDialog(null, "EL IVA NO PUEDE SER MAYOR A 20%", "ERROR DE ENTRADA", 0);
            return false;
        }
        // Si pasa todas las validaciones, retorna true
        return true;
    }
    //VALIDACION DE STOCK MINIMO

    public boolean validarStockMin(String input) {
        // Verificar si está vacío
        if (input == null || input.isEmpty()) {
            JOptionPane.showMessageDialog(null, "EL CAMPO STOCK MINIMO DE PRODUCTO NO PUEDE ESTAR VACIO", "ERROR DE ENTRADA", 0);
            return false;
        }
        // Verificar si son solo números enteros
        if (!input.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "EL CAMPO STOCK MINIMO DE PRODUCTO SOLO PUEDE TENER NUMEROS ENTEROS POSITIVOS", "ERROR DE ENTRADA", 0);
            return false;
        }
        //VERIFICA QUE EL STOCK MINIMO NO SEA MAYOR A 6 DIGITOS, EL INVENTARIO TRABAJA CON CANTIDADES MENORES A 1M = 1.000.000
        if (input.length() > 6) {
            JOptionPane.showMessageDialog(null, "EL STOKC MIN NO PUEDE TENER MAS DE 6 DIGITOS", "ERROR DE ENTRADA", 0);
            return false;
        }
        //VERIFICA QUE NO SEA 0
        if (Integer.parseInt(input) == 0) {
            JOptionPane.showMessageDialog(null, "EL CAMPO STOCK MINIMO DE PRODUCTO NO PUEDE SER 0", "ERROR DE ENTRADA", 0);
            return false;
        }
        // Si pasa todas las validaciones, retorna true
        return true;
    }
    //VALIDACION DE STOCK MAXIMO

    public boolean validarStockMax(String input) {
        // Verificar si está vacío
        if (input == null || input.isEmpty()) {
            JOptionPane.showMessageDialog(null, "EL CAMPO STOCK MAXIMO DE PRODUCTO NO PUEDE ESTAR VACIO", "ERROR DE ENTRADA", 0);
            return false;
        }
        // Verificar si son solo números enteros
        if (!input.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "EL CAMPO STOCK MAXIMO DE PRODUCTO SOLO PUEDE TENER NUMEROS ENTEROS POSITIVOS", "ERROR DE ENTRADA", 0);
            return false;
        }
        //VERIFICA QUE EL STOCK MAXIMO NO SEA MAYOR A 6 DIGITOS, EL INVENTARIO TRABAJA CON CANTIDADES MENORES A 1M = 1.000.000
        if (input.length() > 6) {
            JOptionPane.showMessageDialog(null, "EL STOCK MAX NO PUEDE TENER MAS DE 6 DIGITOS", "ERROR DE ENTRADA", 0);
            return false;
        }
        //VERIFICA QUE NO SEA 0
        if (Integer.parseInt(input) == 0) {
            JOptionPane.showMessageDialog(null, "EL CAMPO STOCK MAXIMO DE PRODUCTO NO PUEDE SER 0", "ERROR DE ENTRADA", 0);
            return false;
        }
        if (Integer.parseInt(input) > 999999) {
            JOptionPane.showMessageDialog(null, "EL CAMPO STOCK MAXIMO DE PRODUCTO NO PUEDE SER MAYOR A 999.999", "ERROR DE ENTRADA", 0);
            return false;
        }
        // Si pasa todas las validaciones, retorna true
        return true;
    }
    //VALIDACION DE DIRECCION

    public boolean validarDireccion(String nombre) {
        // Verificar si está vacío o es null
        if (nombre == null || nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "EL CAMPO EMAIL NO PUEDE ESTAR VACIO", "ERROR DE ENTRADA", 0);
            return false;
        }
        // Verificar la longitud (mínimo 3 y máximo 30 caracteres)
        if (nombre.length() < 11 || nombre.length() > 30) {
            JOptionPane.showMessageDialog(null, "LA LONGITUD DEL EMAIL DEBE TENER ENTRE 11 Y 30 CARACTERES", "ERROR DE ENTRADA", 0);
            return false;
        }
        // Si pasa todas las validaciones, retorna true
        return true;
    }

}
