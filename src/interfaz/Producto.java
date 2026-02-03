package interfaz;

import database.Metodos_Select;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import object.User_sesion;
import style.Style;
import principal.Validacion;

public class Producto extends javax.swing.JPanel {

    Metodos_Select metodosDB = new Metodos_Select();
    Modal modal = new Modal();
    Validacion validar = new Validacion();
    User_sesion user = null;
    
    //CONSTRUCTOR
    public Producto(User_sesion user) {
        this.user=user;
        Style look = new Style();
        look.Style();//APLICA EL LOOK AND FEEL A LA INTERFAZ
        initComponents();
        ocultar_btn();//OCULTAR BTN PARA USUARIOS COMUNES
        cargarProductosEnTabla();//CARGAR PRODUCTOS EN LA TABLA
        alinearColumnas(jTable1);//ALINEAR TEXTO DE TABLA PARA MEJOR APARIENCIA
    }

    //OCULTAR BTN SI ES USUARIO COMUN
    public void ocultar_btn() {
        if (!user.getRol().equals("Administrador")) {//SI ES DISTINTO DE ADMIN OCULTA BTN
            jButton4.setVisible(false);
            jButton1.setVisible(false);
            DefaultComboBoxModel<String> modelo = (DefaultComboBoxModel<String>) filtrado.getModel();
            modelo.removeElement("Inactivos");//QUITA OPCION DE FILTRADO DE BUSQUEDA PARA NO VER INACTIVOS
            modelo.removeElement("Activos"); //QUITA ACTIVOS Y SOLO SE MUESTRAN EN OPCION DE TODOS
        }

    }

    //HACER CONSULTA Y LLENAR TABLA
    public void cargarProductosEnTabla() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);
        if (!user.getRol().equals("Administrador")) { //SI NO ES ADMIN SOLO MUESTRA ACTIVOS
            metodosDB.get_productos(modelo, "WHERE estado = true");
        } else {//SI ES ADMIN MUESTRA TODOS INCLUSO ELIMINADOS
            metodosDB.get_productos(modelo, "");
        }
        filtrado.setSelectedIndex(0);//OPCION DE COMBOBOX POR DEFECTO "TODOS"
    }

    //ALINEAR TEXTO DE LA TABLA PARA MEJOR APARIENCIA
    public void alinearColumnas(JTable tabla) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.LEFT);
        for (int i = 0; i < tabla.getColumnModel().getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }

    //VALIDA LA BUSQUEDA DE PRODUCTO POR CODIGO
    public boolean validar() {
        if (!validar.validarCodigoProducto(codigo1.getText().trim())) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new interfaz.Redondear_bordes();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        filtrado = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        codigo1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(240, 240, 240));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setRoundBottomLeft(50);
        jPanel1.setRoundBottomRight(50);
        jPanel1.setRoundTopLeft(50);
        jPanel1.setRoundTopRight(50);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRODUCTOS REGISTRADOS EN EL SISTEMA");

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Codigo", "Nombre", "Precio", "Iva %", "Cantidad", "MIN", "MAX", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(0, 0, 153));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(20);
        }

        filtrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Activos", "Inactivos", "Bajo Stock", "Agotados" }));
        filtrado.setName(""); // NOI18N

        jButton3.setBackground(new java.awt.Color(40, 167, 69));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Filtrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 0, 153));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Buscar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        codigo1.setBorder(javax.swing.BorderFactory.createTitledBorder("Codigo"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(filtrado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(codigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton5)
                        .addGap(35, 35, 35))
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton5)
                    .addComponent(codigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        jLabel1.getAccessibleContext().setAccessibleDescription("");

        jButton1.setBackground(new java.awt.Color(0, 0, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(40, 167, 69));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("NUEVO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(220, 53, 69));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        modal.agregarFondoOpaco(this); //AGREGA FONDO OPACO PARA EFECTO DE PROFUNDIDAD
        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
        Modificar_Producto dialogo = new Modificar_Producto(parent, true, this);//CARGAR VENTANA DE MODIFICAR PRODUCTO
        dialogo.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        modal.agregarFondoOpaco(this);//AGREGA FONDO OPACO PARA EFECTO DE PROFUNDIDAD
        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
        Nuevo_Producto dialogo = new Nuevo_Producto(parent, true, this, user);
        dialogo.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    //ACCIN BTN DE FILTRADO DE BUSQUEDA
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String tipo_con = filtrado.getSelectedItem().toString();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        if (tipo_con.equalsIgnoreCase("todos")) {//TODOS LOS PRODUCTOS SIN CONDICION
            modelo.setRowCount(0);
            modelo.setRowCount(0);
            if (!user.getRol().equals("Administrador")) {
                metodosDB.get_productos(modelo, "WHERE estado = true");//SI NO ES ADMIN ACTIVOS
            } else {
                metodosDB.get_productos(modelo, "");//SI ES ADMIN TODOS
            }
        } else if (tipo_con.equalsIgnoreCase("activos")) {
            modelo.setRowCount(0);
            metodosDB.get_productos(modelo, "WHERE estado = true");//SOLO ACTIVOS
        } else if (tipo_con.equalsIgnoreCase("inactivos")) {
            modelo.setRowCount(0);
            metodosDB.get_productos(modelo, "WHERE estado = false");//SOLO INACTIVOS
        } else if (tipo_con.equalsIgnoreCase("agotados")) {
            modelo.setRowCount(0);
            metodosDB.get_productos(modelo, "WHERE cantidad = 0 AND estado = true");//AGOTADOS Y ACTIVOS
        } else if (tipo_con.equalsIgnoreCase("bajo stock")) {
            modelo.setRowCount(0);
            metodosDB.get_productos(modelo, "WHERE cantidad < min AND estado = true");//CANTIDAD ACTUAL POR DEBAJO DE MINIMO Y ACTIVOS
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    //ELIMINAR PRODUCTO
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        modal.agregarFondoOpaco(this);//AGREGA FONDO OPACO PARA EFECTO DE PROFUNDIDAD
        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
        Eliminar_Producto dialogo = new Eliminar_Producto(parent, true, this);//CARGAR VENTANA DE ELIMINAR PRODUCTO
        dialogo.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    //BUSCAR PRODUCTO
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (validar()) {
            Metodos_Select met = new Metodos_Select();
            int cod = Integer.parseInt(codigo1.getText().trim());
            Object[] datos = met.get_prod(cod);
            if (datos.length > 1) {//si el array esta vacio, es porque no se encontro
                //SI EL ARRAY NO ESTA VACIO, LA CONSULTA FUE EXITOSA
                if (!(Boolean) datos[7]) {//SI EL ESTADO ES FALSE ENTONCES NO SE PUEDE BUSCAR
                    JOptionPane.showMessageDialog(null, "Este Producto se encuentra Eliminado", "Error", 0);
                    return;
                }
                if (datos.length > 1) {
                    String nombre_b = (String) datos[1]; //GUARDAR INFO PARA MOSTRARLA EN EL PANEL DE DETALLES DEL PRODUCTO
                    float precio_b = Float.parseFloat(String.valueOf(datos[2]));
                    float iva_b = Float.parseFloat(String.valueOf(datos[3]));
                    int min = Integer.parseInt(String.valueOf(datos[4]));
                    int max = Integer.parseInt(String.valueOf(datos[5]));
                    int stock_b = Integer.parseInt(String.valueOf(datos[6]));
                    String est = "Inactivo";
                    if ((boolean) datos[7]) {//SI ES TRUE, MUETRA ACTIVO Y NO UN 1
                        est = "Activo";
                    }
                    modal.agregarFondoOpaco(this);//FONDO OPACO EFECTO DE PROFUNDIDAD
                    JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
                    Vista_Producto dialogo = new Vista_Producto(parent, true, this, cod, nombre_b, precio_b, iva_b, min, max, stock_b, est);
                    dialogo.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    //LIMPIAR INPUT DESPUES DE VER EL PANEL DE DETALLES
    public void borrar_busqueda() {
        codigo1.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField codigo1;
    private javax.swing.JComboBox<String> filtrado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private interfaz.Redondear_bordes jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
