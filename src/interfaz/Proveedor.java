package interfaz;

import database.Metodos_Select;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import principal.Validacion;
import style.Style;
import object.User_sesion;


public class Proveedor extends javax.swing.JPanel {

    Modal modal = new Modal();
    Metodos_Select metodosDB = new Metodos_Select();
    Validacion validar = new Validacion();
    User_sesion user = null;
    
    //COSNTRUCTOR
    public Proveedor(User_sesion user) {
        this.user=user;
        Style look = new Style();
        look.Style(); //APLICAR LOOK AND FEEL A LA INTERFAZ
        initComponents();
        ocultar_btn();//OCULTAR BTN DEPENDIENDO DEL ROL DE ACCESO
        cargarProveedorEnTabla();//CARGAR TABLA CON LOS PROVEEDORES
        alinearColumnas(jTable1);//ALINERA TEXTO DE LA TABLA PARA MEJOR APARIENCIA
    }

    //OCULTAR BTN
    public void ocultar_btn() {
        if (!user.getRol().equals("Administrador")) {//SI NO ES ADMINISTRADAOR, OCULTA LOS BTN
            jButton4.setVisible(false);
            jButton1.setVisible(false);
            filtrado.setVisible(false);
            jButton3.setVisible(false);
        }

    }

    //VALIDA LA CEDULA INGRSADA PARA BUSCAR UN PROVEEDOR
    public boolean validacion() {
        if (!validar.validarCedula(codigo1.getText().trim())) {
            return false;
        }
        return true;
    }

    //HACER LA CONSULTA Y CARGA TODOS LOS PROVEEDORES EN LA TABLA
    public void cargarProveedorEnTabla() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);
        metodosDB.get_provee(modelo, "");
        filtrado.setSelectedIndex(0);
    }

    //ALINEAR LOS TEXTOS DE LA TABLA PARA MEJOR APARIENCIA ALINE A LA IZQUIERDA
    public void alinearColumnas(JTable tabla) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.LEFT);
        for (int i = 0; i < tabla.getColumnModel().getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new interfaz.Redondear_bordes();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        filtrado = new javax.swing.JComboBox<>();
        codigo1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setRoundBottomLeft(50);
        jPanel1.setRoundBottomRight(50);
        jPanel1.setRoundTopLeft(50);
        jPanel1.setRoundTopRight(50);

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Cedula", "Nombre", "Telefono", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(0, 0, 153));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PROVEEDORES REGISTRADOS EN EL SISTEMA");

        jButton3.setBackground(new java.awt.Color(40, 167, 69));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Filtrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        filtrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Activos", "Inactivos" }));

        codigo1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cedula"));

        jButton5.setBackground(new java.awt.Color(0, 0, 153));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Buscar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

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
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(codigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton5)
                        .addGap(35, 35, 35))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5)
                        .addComponent(codigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(filtrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3)))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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

    //ACCION BTN DE MODIFICAR
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        modal.agregarFondoOpaco(this);//FONDO OPACO PARA EFECTO DE PROFUNDIDAD
        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
        Modificar_Proveedor dialogo = new Modificar_Proveedor(parent, true, this);//MOSTRAR JDIALOG MODIFICAR
        dialogo.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    //ACCION NUEVO PROVEEDOR BTN
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        modal.agregarFondoOpaco(this);//FONDO OPACO PARA EFECTO DE PROFUNDIDAD
        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
        Nuevo_Proveedor dialogo = new Nuevo_Proveedor(parent, true, this, user);//MOSTRAR JDIALGO DE NUEVO PROVEEDOR
        dialogo.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    //ACCION BTN ELIMINAR PROVEEDOR
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        modal.agregarFondoOpaco(this);//FONDO OPACO PARA EFECTO DE PROFUNDIDAD
        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
        Eliminar_Proveedor dialog = new Eliminar_Proveedor(parent, true, this);//MOSTRAR JDIALOG DE ELIMINAR PROVEEDOR
        dialog.setVisible(true);

    }//GEN-LAST:event_jButton4ActionPerformed

    //FILTRADO DE BUSQUEDA
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String tipo_con = filtrado.getSelectedItem().toString();
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        if (tipo_con.equalsIgnoreCase("todos")) {
            modelo.setRowCount(0);
            metodosDB.get_provee(modelo, "");//CONSULTA SIN CONDICION
        } else if (tipo_con.equalsIgnoreCase("activos")) {
            modelo.setRowCount(0);
            metodosDB.get_provee(modelo, "WHERE estado = true");//CONSULTA SOLO ACTIVOS
        } else if (tipo_con.equalsIgnoreCase("inactivos")) {
            modelo.setRowCount(0);
            metodosDB.get_provee(modelo, "WHERE estado = false");//CONSULTA SOLO ELIMINADOS
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    //ACCION BTN DE BUSQUEDA
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (validacion()) {
            Metodos_Select met = new Metodos_Select();
            int cod = Integer.parseInt(codigo1.getText().trim());
            Object[] datos = met.get_provee(cod);
            if (datos.length > 1) {//SI EL ARRAY NO ESTA VACIO LA CONSULTA FUE EXITOSA
                if (!(Boolean) datos[4]) {//SI ESTA ELIMINADO NO SE TOMA EN CUENTA
                    JOptionPane.showMessageDialog(null, "No se Encontro el Proveedor con CI: " + datos[0], "Error", 0);
                    return;
                }//GUARDA LOS DATOS PARA MOSTRARLOS EN LA INTERFAZ DE DETALLES
                String nombre_b = (String) datos[1];
                String telefono_b = (String) datos[2];
                String direccion_b = (String) datos[3];
                String est = "Inactivo";
                if ((boolean) datos[4]) {
                    est = "Activo";
                }
                modal.agregarFondoOpaco(this);//FONDO OPACO PARA EFECTO DE PROFUNDIDAD
                JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
                Vista_Proveedor dialogo = new Vista_Proveedor(parent, true, this, cod, nombre_b, telefono_b, direccion_b, est);//OSTRAR PANEL DETALLES
                dialogo.setVisible(true);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    //LIMPIA EL CAMPO DE BUSQUEDA, ESTA SE LLAMA DESPUES DE EJECUTAR UNA BUSQUEDA
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
