package interfaz;

import database.Metodos_Insert;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JFrame;
import principal.Validacion;
import object.User_sesion;

public class Nuevo_Cliente extends javax.swing.JDialog {

    User_sesion user = null;
    Modal classmodal = new Modal();
    private final Cliente cliente;
    private final Venta_Cliente salida;
    public String salida_nom, salida_tlfn, salida_direc;
    public int salida_ced;
    Validacion validar = new Validacion();

    //COSNTRUCTOR
    public Nuevo_Cliente(JFrame parent, boolean modal, Cliente cliente, User_sesion user) {
        //ESTE CONSTRUCTOR SE LLAMA SI SE AGREGA UN NUEVO CLIENTE DESDE EL MODULO DE CLIENTE
        super(parent, modal);
        this.user = user;
        this.cliente = cliente;
        this.salida = null;
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));//FONDO TRANSPARENTE PARA VER PANEL CON BORDES REDONDEADOS
        initComponents();
        inicializar(parent);
    }

    //CONSTRUCTOR NUMERO 2
    public Nuevo_Cliente(JFrame parent, boolean modal, Venta_Cliente salida, User_sesion user) {
        //ESTE CONSSTRUCTOR SE LLAMA SI SE AGREGA UN NUEVO CLIENTE DESDE EL MODULO DE FACTURACION DE VENTA
        super(parent, modal);
        this.user = user;
        this.salida = salida;
        this.cliente = null;
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));//FONDO TRANSPARENTE PARA VER PANEL CON BORDES REDONDEADOS
        initComponents();
        inicializar(parent);
    }

    //ESTOS DATOS IRAN AL PANEL DE FACTRACION, SE INSERTAN EN LOS LABEL PARA VER LA INFO DEL CLIENTE A FACTURAR
    public Object[] obtener_datos() {
        Object[] datos = new Object[]{this.salida_ced, this.salida_nom, this.salida_tlfn, this.salida_direc};
        return datos;
    }

    //VALIDA TODO EL FORMULARIO DE NUEVO CLIENTE
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
        if (!validar.validarDireccion(direccion.getText().trim())) {
            return false;
        }
        return true;//TRUE SI PASA TODAS LAS VALIDACIONES
    }

    //GUARDA LA CCION EN LA BITACORA
    public void cargar_bitacora() {
        Validacion fech = new Validacion();
        String accion = "Agrego un Nuevo Cliente.";//TIPO DE ACCION
        new Metodos_Insert().post_bitacora(user.getCedula(), user.getNombre(), fech.crear_fecha(), fech.hora(), accion);
    }

    //INICIALIZA EL PANEL AL CENTRO Y SIN BORDES PARA SIMULAR UN PANEL FLOTANTE
    public void inicializar(JFrame parent) {
        jPanel1.setBackground(new Color(0, 0, 0, 0));
        Point location = parent.getLocationOnScreen();
        int panelWidth = parent.getWidth();
        int panelHeight = parent.getHeight();
        int x = location.x + (panelWidth - getWidth()) / 2;
        int y = location.y + (panelHeight - getHeight()) / 2;
        setLocation(x, y);
    }

    //RESETEA O LIMPIA EL FORMULARIO
    public void limpiar() {
        //limpiar campos
        cedula.setText("");
        nombre.setText("");
        telefono.setText("");
        direccion.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        redondear_bordes1 = new interfaz.Redondear_bordes();
        agregar = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        direccion = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        cedula = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        redondear_bordes1.setBackground(new java.awt.Color(255, 255, 255));
        redondear_bordes1.setRoundBottomLeft(50);
        redondear_bordes1.setRoundBottomRight(50);
        redondear_bordes1.setRoundTopLeft(50);
        redondear_bordes1.setRoundTopRight(50);

        agregar.setBackground(new java.awt.Color(40, 167, 69));
        agregar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        agregar.setForeground(new java.awt.Color(255, 255, 255));
        agregar.setText("Añadir");
        agregar.setVerifyInputWhenFocusTarget(false);
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        limpiar.setBackground(new java.awt.Color(220, 53, 69));
        limpiar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        limpiar.setForeground(new java.awt.Color(255, 255, 255));
        limpiar.setText("Limpiar");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(220, 53, 69));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("x");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Nuevo Cliente");

        direccion.setBorder(javax.swing.BorderFactory.createTitledBorder("Email"));
        direccion.setMinimumSize(new java.awt.Dimension(200, 50));
        direccion.setPreferredSize(new java.awt.Dimension(200, 50));

        telefono.setBorder(javax.swing.BorderFactory.createTitledBorder("Telefono"));
        telefono.setMinimumSize(new java.awt.Dimension(200, 50));
        telefono.setPreferredSize(new java.awt.Dimension(200, 50));

        nombre.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre"));
        nombre.setMinimumSize(new java.awt.Dimension(200, 50));
        nombre.setPreferredSize(new java.awt.Dimension(200, 50));

        cedula.setBorder(javax.swing.BorderFactory.createTitledBorder("Cedula"));
        cedula.setMinimumSize(new java.awt.Dimension(200, 50));
        cedula.setPreferredSize(new java.awt.Dimension(200, 50));

        javax.swing.GroupLayout redondear_bordes1Layout = new javax.swing.GroupLayout(redondear_bordes1);
        redondear_bordes1.setLayout(redondear_bordes1Layout);
        redondear_bordes1Layout.setHorizontalGroup(
            redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, redondear_bordes1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(17, 17, 17))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, redondear_bordes1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, redondear_bordes1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cedula, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addComponent(nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(direccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(telefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );
        redondear_bordes1Layout.setVerticalGroup(
            redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(redondear_bordes1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(redondear_bordes1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(redondear_bordes1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //ACCION DE BTN AGREGAR
    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        if (validacion()) {
            this.salida_ced = Integer.parseInt(cedula.getText().trim());
            this.salida_nom = nombre.getText().trim();
            this.salida_tlfn = telefono.getText().trim();
            this.salida_direc = direccion.getText().trim();//ALMACENA TODA LA INFO EN VARIABLES PARA VER EN LABEL DE FACTURACION SI SE NECESITA
            if (new Metodos_Insert().post_cliente(this.salida_ced, this.salida_nom, this.salida_tlfn, this.salida_direc)) {
                cargar_bitacora();//GUARDA LA ACCION EN BITACORA
            }
            limpiar();//LIMPIA EL FORMULARIO
            classmodal.cerrarDialogo(this);
            if (cliente != null) {
                cliente.cargarClientesEnTabla();//RECARGA LA TABLA SI SE AGREGO DESDE MODULO DE CLIENTES
            }
            if (salida != null) {
                Object[] datos = obtener_datos();//INSERTA EN LABEL SI SE AGREGO DESDE MODULO DE FACTURACION
                salida.preparar(datos, true);//CARGAR DATOS EN EL LABEL
            }

        }
    }//GEN-LAST:event_agregarActionPerformed


    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_limpiarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        classmodal.cerrarDialogo(this);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JTextField cedula;
    private javax.swing.JTextField direccion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton limpiar;
    private javax.swing.JTextField nombre;
    private interfaz.Redondear_bordes redondear_bordes1;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
