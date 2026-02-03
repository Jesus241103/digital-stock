package interfaz;

import database.Metodos_Select;
import javax.swing.JOptionPane;
import principal.Validacion;
import style.Style;
import object.User_sesion;

public class Login extends javax.swing.JFrame {

    Validacion validar = new Validacion();
    public int cedula;
    public String clave;

    //CONSTRUCTOR
    public Login() {
        Style look = new Style();//APLICAR LOOK AND FEEL
        look.Style();
        initComponents();
        this.setLocationRelativeTo(null);//VER EN EL CENTRO DE LA PANTALLA
    }

    //VALIDAR CAMPOS DE ENTRADA CEDULA Y CLAVE
    public boolean validacion() {
        if (!validar.validarCedula(leer_cedula.getText().trim())) {
            return false;
        }
        if (!validar.validarClave(String.valueOf(leer_clave.getPassword()))) {
            return false;
        }
        return true;//SI DEVUELVE TRUE LA VALIDACION FUE CORRECTA
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradiente1 = new interfaz.Gradiente();
        panel_login = new interfaz.Redondear_bordes();
        leer_cedula = new javax.swing.JTextField();
        LETRA_INICIO_SECION = new javax.swing.JLabel();
        CEDULA = new javax.swing.JLabel();
        leer_clave = new javax.swing.JPasswordField();
        entrar = new javax.swing.JButton();
        CONTRASEÑA = new javax.swing.JLabel();
        pregunta = new javax.swing.JLabel();
        header = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 200));
        setResizable(false);

        gradiente1.setkEndColor(new java.awt.Color(0, 0, 153));
        gradiente1.setkStartColor(new java.awt.Color(0, 153, 153));

        panel_login.setBackground(new java.awt.Color(255, 255, 255));
        panel_login.setRoundBottomLeft(50);
        panel_login.setRoundBottomRight(50);
        panel_login.setRoundTopLeft(50);
        panel_login.setRoundTopRight(50);

        leer_cedula.setFont(new java.awt.Font("Roboto SemiBold", 0, 14)); // NOI18N
        leer_cedula.setForeground(new java.awt.Color(0, 0, 0));
        leer_cedula.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        LETRA_INICIO_SECION.setFont(new java.awt.Font("Roboto SemiBold", 3, 24)); // NOI18N
        LETRA_INICIO_SECION.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LETRA_INICIO_SECION.setText("Iniciar sesión");

        CEDULA.setFont(new java.awt.Font("Roboto SemiBold", 3, 14)); // NOI18N
        CEDULA.setText("Cedula");

        leer_clave.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        leer_clave.setForeground(new java.awt.Color(0, 0, 0));
        leer_clave.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        entrar.setBackground(new java.awt.Color(40, 167, 69));
        entrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        entrar.setForeground(new java.awt.Color(255, 255, 255));
        entrar.setText("ENTRAR");
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });

        CONTRASEÑA.setFont(new java.awt.Font("Roboto SemiBold", 3, 14)); // NOI18N
        CONTRASEÑA.setText("Contraseña");

        pregunta.setFont(new java.awt.Font("Roboto SemiBold", 0, 14)); // NOI18N
        pregunta.setForeground(new java.awt.Color(51, 153, 255));
        pregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pregunta.setText("¿Aún no estas registrado en el sistema?");
        pregunta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pregunta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registrar(evt);
            }
        });

        javax.swing.GroupLayout panel_loginLayout = new javax.swing.GroupLayout(panel_login);
        panel_login.setLayout(panel_loginLayout);
        panel_loginLayout.setHorizontalGroup(
            panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_loginLayout.createSequentialGroup()
                .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_loginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LETRA_INICIO_SECION, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pregunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panel_loginLayout.createSequentialGroup()
                        .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_loginLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CONTRASEÑA, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CEDULA, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(leer_cedula)
                                    .addComponent(leer_clave, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)))
                            .addGroup(panel_loginLayout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 98, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel_loginLayout.setVerticalGroup(
            panel_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_loginLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(LETRA_INICIO_SECION, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(CEDULA, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(leer_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(CONTRASEÑA, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(leer_clave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(pregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradiente1Layout.createSequentialGroup()
                .addGroup(gradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(gradiente1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(header))
                    .addGroup(gradiente1Layout.createSequentialGroup()
                        .addGap(21, 596, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addGap(25, 25, 25))
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
                                .addComponent(jLabel5)))))
                .addContainerGap(537, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradiente1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200))
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
                .addComponent(panel_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(header)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(28, 28, 28))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //ACCION BTN PARA REGISTRAR NUEVO USER
    private void registrar(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrar
        Registro reg = new Registro();
        this.setVisible(false);//CARGAR PANEL DE REGISTRO
        reg.setVisible(true);
    }//GEN-LAST:event_registrar

    //BTN DE INGRESAR AL SISTEMA
    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed
        if (validacion()) {//VALIDA LAS ENTRADAS
            this.cedula = Integer.parseInt(leer_cedula.getText().trim());
            this.clave = new String(leer_clave.getPassword()).trim();
            //HACE LA CONSULTA A LA BASE DE DATOS
            Object[] respuesta = new Metodos_Select().get_login(this.cedula, this.clave);
            if ((int) respuesta[1] == 1) {//SI LA REPUESTA ES CORRECTA ENTONCES ACCEDE
                JOptionPane.showMessageDialog(this, "ACCEDIENDO AL SISTEMA", "ACCEDER", JOptionPane.INFORMATION_MESSAGE);
                int ced = (int) respuesta[2];//MANDAR VALORES DEL USUARIO AL SISTEMA PARA SABER QUIEN INGRESO
                String nombre = String.valueOf((String) respuesta[3]);
                String rol = "Usuario"; // Valor predeterminado
                if ("admin".equals(respuesta[0])) {
                    rol = "Administrador"; // Solo cambia el rol si es admin
                }
                User_sesion user = new User_sesion(nombre, ced, rol);
                Inicio x = new Inicio(user);//MOSTRAR PANEL INICIAL DEL SISTEMA, LA INFO DEL USUARIO ES PARA IDENTIFICAR EL USUARIO
                this.setVisible(false);
                x.setVisible(true);
            } else { //CREDENCIALES INVALIDAS
                JOptionPane.showMessageDialog(this, "USUARIO O CONTRASEÑA INCONRRECTOS", "ERROR AL ACCEDER", 1);
            }
        }
    }//GEN-LAST:event_entrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CEDULA;
    private javax.swing.JLabel CONTRASEÑA;
    private javax.swing.JLabel LETRA_INICIO_SECION;
    private javax.swing.JButton entrar;
    private interfaz.Gradiente gradiente1;
    private javax.swing.JLabel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField leer_cedula;
    private javax.swing.JPasswordField leer_clave;
    private interfaz.Redondear_bordes panel_login;
    private javax.swing.JLabel pregunta;
    // End of variables declaration//GEN-END:variables
}
