package interfaz;

import database.Metodos_Select;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import object.User_sesion;
import principal.Validacion;
import style.Style;

public class Cliente extends javax.swing.JPanel {

    
    Modal modal = new Modal();
    //METODO DE VALIDACION (OTRA CLASE)
    Validacion validar = new Validacion();
    User_sesion user = null;
    
    //CONSTRUCTOR
    public Cliente(User_sesion user) {
        this.user=user;
        Style look = new Style(); //APLICAR LOOK AND FEEL A ESTA INTERFAZ
        look.Style();
        initComponents();
        ocultar_btn(); //AQUI SE OCULTAN LOS BTN SI ES NECESARIO, EXCEPTO PARA EL ADMIN
        cargarClientesEnTabla(); //CARGAR TABLA DE CLIENTES
        alinearColumnas(jTable1); //ALINEAR TEXTO DE LA TABLA
    }

    //VALIDA INFORMACION ANTES DE BUSCAR UN CLIENTE EN ESPECIFICO
    public boolean validar() {
        if (!validar.validarCedula(cedula.getText().trim())) {
            return false;
        }
        return true; //SI RETORNA TRUE, LA VALIDACION ES EXITOSA
    }

    //OCULTA LOS BTN SI ES NECESARIO, SOLO PARA ROL DE USUARIO COMUN
    public void ocultar_btn() {
        if (!user.getRol().equals("Administrador")) {
            jButton1.setVisible(false); //OCULTA BTN DE MODIFICAR
        }
    }

    //HACER CONSULTA Y MOSTRAR CLIENTES EN LA TABLA
    public void cargarClientesEnTabla() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel(); //MODELO DE LA TABLA A CARGAR
        modelo.setRowCount(0);
        Metodos_Select metodosDB = new Metodos_Select();
        metodosDB.get_cliente(modelo); //LA FUNCION DE LA CONSULTA ME CARGAR EL MODELO DE LA TABLA CON LA INFO DE LOS CLIENTES
    }

    //ALINEAR EL TEXTO DE LAS COLUMNAS DE LA TABLA, PARA MAS ORDEN VISUAL
    public void alinearColumnas(JTable tabla) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.LEFT);
        for (int i = 0; i < tabla.getColumnModel().getColumnCount(); i++) { //TEXTO DE TODAS LAS COLUMNAS A LA IZQUIERDA
            tabla.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanel1 = new interfaz.Redondear_bordes();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cedula = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(240, 240, 240));

        JPanel1.setBackground(new java.awt.Color(255, 255, 255));
        JPanel1.setRoundBottomLeft(50);
        JPanel1.setRoundBottomRight(50);
        JPanel1.setRoundTopLeft(50);
        JPanel1.setRoundTopRight(50);

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
        jLabel1.setText("CLIENTES REGISTRADOS EN EL SISTEMA");

        cedula.setBorder(javax.swing.BorderFactory.createTitledBorder("Cedula"));

        jButton5.setBackground(new java.awt.Color(0, 0, 153));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Buscar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPanel1Layout = new javax.swing.GroupLayout(JPanel1);
        JPanel1.setLayout(JPanel1Layout);
        JPanel1Layout.setHorizontalGroup(
            JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanel1Layout.createSequentialGroup()
                        .addGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JPanel1Layout.createSequentialGroup()
                                .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButton5)
                                .addGap(35, 35, 35))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE))
                        .addGap(15, 15, 15)))
                .addContainerGap())
        );
        JPanel1Layout.setVerticalGroup(
            JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(JPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(JPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    //BTN ACCION DE MODIFICAR CLIENTE
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        modal.agregarFondoOpaco(this); //FONDO OPACO A LA PANTALLA EXCEPTO A LA VENTANA EMERGENTE
        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
        Modificar_Cliente dialogo = new Modificar_Cliente(parent, true, this);
        dialogo.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    //AGREGAR UN NUEVO CLIENTE
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        modal.agregarFondoOpaco(this); //FONDO OPACO PARA LA INTERFAZ EXCEPTO APARA LA VENTANA EMERGENTE
        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
        Nuevo_Cliente dialogo = new Nuevo_Cliente(parent, true, this, user);
        dialogo.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
    //BTN ACCION BUSCAR UN CLIENTE EN ESPECIFICO
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (validar()) { //VALIDA EL CAMPO CEDULA
            int cod = Integer.parseInt(cedula.getText().trim());
            Object[] datos = new Metodos_Select().get_cliente(cod); //consulta
            if (datos.length > 1) { //SI EL ARREGLO ESTA CARGADO, SIGNIFICA QUE ENCONTRO LA INFO
                String nombre_b = (String) datos[1];
                String telefono_b = (String) datos[2];
                String direccion_b = (String) datos[3];
                modal.agregarFondoOpaco(this);  //AGREGA EFECTO DE FONDO OPACO AL RESTO DE LA INERFAZ
                JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
                Vista_Cliente dialogo = new Vista_Cliente(parent, true, this, cod, nombre_b, telefono_b, direccion_b); //MOSTRAR JDIALOG
                dialogo.setVisible(true);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed
    //LIMPIA EL CAMPO DE BUSQUEDA, ESTO ES CUANDO SE CIERRA EL JDIALOG
    public void borrar_busqueda() {
        cedula.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private interfaz.Redondear_bordes JPanel1;
    public javax.swing.JTextField cedula;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
