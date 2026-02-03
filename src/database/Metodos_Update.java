package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

//FUNCIONES:
//ACTUALIZAR INFO DE PRODUCTOS
//CAMBIAR ESTADO DE PRODUCTOS
//ACTUALIZAR INFO DE PROVEEDOR
//CAMBIAR ESTADO DE PROVEEDOR 
//ACTUALIZAR INFO DE CLIENTE
//ACTUALIZA LA CANTIDAD DEL STOCK DE UN PRODUCTO

public class Metodos_Update {
    //modificar informacion de un producto
    public void put_prod(int cod, String nombre, float precio, float iva, int min, int max, int cantidad, boolean estado) {
        String query = "UPDATE producto SET nombre=?, precio=?, iva=?, min=?, max=?, cantidad=?, estado=? WHERE codigo=?";
        Connection conex = null;
        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return;
            }
            try (PreparedStatement solicitud = conex.prepareStatement(query)) {
                solicitud.setString(1, nombre);
                solicitud.setFloat(2, precio);
                solicitud.setFloat(3, iva);
                solicitud.setInt(4, min);
                solicitud.setInt(5, max);
                solicitud.setInt(6, cantidad);
                solicitud.setBoolean(7, estado);
                solicitud.setInt(8, cod); // Actualiza el producto con ID específico
                solicitud.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos del Producto actualizado correctamente.", "Actualización", 1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el producto: " + e.getMessage(), "Error", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
    }//fin

    //cambiar el estado de un producto, eliminacion logica
    public void put_prod(int cod, boolean estado) {
        String query = "UPDATE producto SET estado=? WHERE codigo=?";
        Connection conex = null;
        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return;
            }
            try (PreparedStatement solicitud = conex.prepareStatement(query)) {
                solicitud.setBoolean(1, estado);
                solicitud.setInt(2, cod); // Actualiza el producto con ID específico
                solicitud.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos del Producto actualizado correctamente.", "Actualización", 1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el producto: " + e.getMessage(), "Error", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
    }//fin

    //actualizar informacion de un proveedor en especifico
    public void put_provee(int cod, String nombre, String telefono, String direccion, boolean est) {
        String query = "UPDATE proveedor SET nombre=?, telefono=?, direccion=?, estado = ? WHERE codigo=?";
        Connection conex = null;
        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return;
            }
            try (PreparedStatement solicitud = conex.prepareStatement(query)) {
                solicitud.setString(1, nombre);
                solicitud.setString(2, telefono);
                solicitud.setString(3, direccion);
                solicitud.setBoolean(4, est);
                solicitud.setInt(5, cod);
                solicitud.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos del Proveedor actualizado correctamente.", "Actualización", 1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el proveedor: " + e.getMessage(), "Error", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
    }//fin

    //cambiar estado de un proveedor, eliminacion logica
    public void put_provee(int cod, boolean est) {
        String query = "UPDATE proveedor SET estado = ? WHERE codigo=?";
        Connection conex = null;
        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return;
            }
            try (PreparedStatement solicitud = conex.prepareStatement(query)) {
                solicitud.setBoolean(1, est);
                solicitud.setInt(2, cod);
                solicitud.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos del Proveedor actualizado correctamente.", "Actualización", 1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el proveedor: " + e.getMessage(), "Error", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
    }//fin

    //actualizar informacion de un cliente en especifico
    public void put_cliente(int ced, String nombre, String telefono, String direccion) {
        String query = "UPDATE cliente SET nombre=?, telefono=?, direccion=? WHERE cedula=?";
        Connection conex = null;
        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return;
            }
            try (PreparedStatement solicitud = conex.prepareStatement(query)) {
                solicitud.setString(1, nombre);
                solicitud.setString(2, telefono);
                solicitud.setString(3, direccion);
                solicitud.setInt(4, ced);
                solicitud.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos del Cliente actualizado correctamente.", "Actualización", 1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el Cliente: " + e.getMessage(), "Error", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
    }//fin

    //ACTUALIZA EL STOCK DE UN PRODUCTO
    public void actualizar_stock(int cantidad, int cod) {
        String querySelect = "SELECT cantidad FROM producto WHERE codigo=?";
        String queryUpdate = "UPDATE producto SET cantidad=? WHERE codigo=?";
        Connection conex = null;
        try {
            conex = Conexion.Conectar();
            if (conex == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos.", "Inicio", 0);
                return;
            }
            int cantidadActual = 0;
            try (PreparedStatement solicitudSelect = conex.prepareStatement(querySelect)) {
                solicitudSelect.setInt(1, cod);
                ResultSet resultado = solicitudSelect.executeQuery();
                if (resultado.next()) {
                    cantidadActual = resultado.getInt("cantidad");
                }
            }
            int nuevaCantidad = cantidadActual + cantidad; // Sumar la cantidad actual con la nueva

            try (PreparedStatement solicitudUpdate = conex.prepareStatement(queryUpdate)) {
                solicitudUpdate.setInt(1, nuevaCantidad);
                solicitudUpdate.setInt(2, cod);
                solicitudUpdate.executeUpdate();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el Stock: " + e.getMessage(), "Error", 0);
        } finally {
            Conexion.cerrarConexion(conex);
        }
    }//fin

}
