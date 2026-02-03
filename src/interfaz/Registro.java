
package interfaz;
import database.Metodos_Insert;
import principal.Validacion;
import style.Style;


public class Registro extends javax.swing.JFrame {

    public int ced;
    public String nom, clave, tlfn;
    Validacion validar = new Validacion();
    //constructor
    public Registro(){
        Style look = new Style(); //aplicar look and feel a la interfaz
        look.Style();
        initComponents();  
        this.setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradiente1 = new interfaz.Gradiente();
        panel_registro = new interfaz.Redondear_bordes();
        telefono = new javax.swing.JTextField();
        letras_rol = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        letras_nombre = new javax.swing.JLabel();
        clave_usuario = new javax.swing.JPasswordField();
        letras_contraseña = new javax.swing.JLabel();
        LETRA_INICIO_SECION = new javax.swing.JLabel();
        CEDULA_L = new javax.swing.JLabel();
        cedula = new javax.swing.JTextField();
        aceptar = new javax.swing.JButton();
        atras = new javax.swing.JButton();
        header = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 100));
        setMaximumSize(null);
        setMinimumSize(null);
        setResizable(false);

        gradiente1.setkEndColor(new java.awt.Color(0, 0, 153));
        gradiente1.setkStartColor(new java.awt.Color(0, 153, 153));

        panel_registro.setBackground(new java.awt.Color(255, 255, 255));
        panel_registro.setRoundBottomLeft(50);
        panel_registro.setRoundBottomRight(50);
        panel_registro.setRoundTopLeft(50);
        panel_registro.setRoundTopRight(50);

        telefono.setFont(new java.awt.Font("Roboto SemiBold", 0, 12)); // NOI18N
        telefono.setForeground(new java.awt.Color(0, 0, 0));
        telefono.setToolTipText("");
        telefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        letras_rol.setFont(new java.awt.Font("Roboto SemiBold", 3, 14)); // NOI18N
        letras_rol.setText("Telefono");

        nombre.setFont(new java.awt.Font("Roboto SemiBold", 0, 12)); // NOI18N
        nombre.setForeground(new java.awt.Color(0, 0, 0));
        nombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        letras_nombre.setFont(new java.awt.Font("Roboto SemiBold", 3, 14)); // NOI18N
        letras_nombre.setText("Nombre y Apellido");

        clave_usuario.setFont(new java.awt.Font("Roboto SemiBold", 0, 12)); // NOI18N
        clave_usuario.setForeground(new java.awt.Color(0, 0, 0));
        clave_usuario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        letras_contraseña.setFont(new java.awt.Font("Roboto SemiBold", 3, 14)); // NOI18N
        letras_contraseña.setText("Contraseña");

        LETRA_INICIO_SECION.setFont(new java.awt.Font("Roboto SemiBold", 3, 24)); // NOI18N
        LETRA_INICIO_SECION.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LETRA_INICIO_SECION.setText("Crear Cuenta");

        CEDULA_L.setFont(new java.awt.Font("Roboto SemiBold", 3, 14)); // NOI18N
        CEDULA_L.setText("Cedula");

        cedula.setFont(new java.awt.Font("Roboto SemiBold", 0, 12)); // NOI18N
        cedula.setForeground(new java.awt.Color(0, 0, 0));
        cedula.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        aceptar.setBackground(new java.awt.Color(40, 167, 69));
        aceptar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        aceptar.setForeground(new java.awt.Color(255, 255, 255));
        aceptar.setText("Aceptar");
        aceptar.setToolTipText("");
        aceptar.setAutoscrolls(true);
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        atras.setBackground(new java.awt.Color(0, 0, 153));
        atras.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        atras.setForeground(new java.awt.Color(255, 255, 255));
        atras.setText("Volver");
        atras.setToolTipText("");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_registroLayout = new javax.swing.GroupLayout(panel_registro);
        panel_registro.setLayout(panel_registroLayout);
        panel_registroLayout.setHorizontalGroup(
            panel_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_registroLayout.createSequentialGroup()
                .addGroup(panel_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_registroLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(panel_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(letras_contraseña)
                            .addGroup(panel_registroLayout.createSequentialGroup()
                                .addGroup(panel_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(atras, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(clave_usuario, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(CEDULA_L, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(letras_nombre, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                        .addComponent(cedula, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(60, 60, 60)
                                .addGroup(panel_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(letras_rol)
                                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 50, Short.MAX_VALUE))
                    .addComponent(LETRA_INICIO_SECION, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_registroLayout.setVerticalGroup(
            panel_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_registroLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(LETRA_INICIO_SECION, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(CEDULA_L)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(panel_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(letras_nombre)
                    .addComponent(letras_rol))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(letras_contraseña)
                .addGap(18, 18, 18)
                .addComponent(clave_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(panel_registroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(atras, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        header.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        header.setForeground(new java.awt.Color(255, 255, 255));
        header.setText("Sistema de Facturación y");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Gestión de Inventario.");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/huawei.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DIGITAL");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("STOCK");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/walmart.png"))); // NOI18N

        jSeparator1.setBackground(new java.awt.Color(255, 204, 0));
        jSeparator1.setForeground(new java.awt.Color(255, 204, 0));

        javax.swing.GroupLayout gradiente1Layout = new javax.swing.GroupLayout(gradiente1);
        gradiente1.setLayout(gradiente1Layout);
        gradiente1Layout.setHorizontalGroup(
            gradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradiente1Layout.createSequentialGroup()
                .addGroup(gradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradiente1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(gradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(gradiente1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGroup(gradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(gradiente1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(gradiente1Layout.createSequentialGroup()
                                        .addGap(72, 72, 72)
                                        .addComponent(jLabel5))))))
                    .addGroup(gradiente1Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(panel_registro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 145, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradiente1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(gradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(header))
                .addGap(25, 25, 25))
        );
        gradiente1Layout.setVerticalGroup(
            gradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradiente1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(gradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(gradiente1Layout.createSequentialGroup()
                        .addGroup(gradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(0, 0, 0)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(panel_registro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(header)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradiente1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradiente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //VALIDACION DE TODOS LOS CAMPOS
    public boolean validacion() {
        if (!validar.validarCedula(cedula.getText().trim())) {
            return false;
        }
        if (!validar.validarNombre(nombre.getText().trim())) {
            return false;
        }
        if (!validar.validarTLF(telefono.getText().trim())) {
            return false;
        }
        if (!validar.validarClave(String.valueOf(clave_usuario.getPassword()))) {
            return false;
        }
        return true;
    }

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        // Llamar al método post para registrar
        if ( validacion()) { //SI PASA TODA LA VALIDACION
            ced = Integer.parseInt(cedula.getText().trim());
            nom = nombre.getText().trim();
            tlfn = telefono.getText().trim();
            clave = String.valueOf(clave_usuario.getPassword());
            new Metodos_Insert().post(ced, nom, tlfn, clave);//INSERTAR DATOS EN LA BASE DE DATOS
            //VOLVER AL LOGIN
            this.setVisible(false);//CERRAR CLASE DE LOGIN
            Login obj2 = new Login();
            obj2.setVisible(true);//CARGAR EL LOGIN
        }//FIN IF DE INSERCION
    }//GEN-LAST:event_aceptarActionPerformed

    //ACCIO BTN ATRAS IR A LOGIN
    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        this.setVisible(false);
        Login obj = new Login();
        obj.setVisible(true);
    }//GEN-LAST:event_atrasActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CEDULA_L;
    private javax.swing.JLabel LETRA_INICIO_SECION;
    private javax.swing.JButton aceptar;
    private javax.swing.JButton atras;
    private javax.swing.JTextField cedula;
    private javax.swing.JPasswordField clave_usuario;
    private interfaz.Gradiente gradiente1;
    private javax.swing.JLabel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel letras_contraseña;
    private javax.swing.JLabel letras_nombre;
    private javax.swing.JLabel letras_rol;
    private javax.swing.JTextField nombre;
    public interfaz.Redondear_bordes panel_registro;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
