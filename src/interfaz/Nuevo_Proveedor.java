package interfaz;

import database.Metodos_Insert;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JFrame;
import object.User_sesion;
import principal.Validacion;

public class Nuevo_Proveedor extends javax.swing.JDialog {

    User_sesion user = null;
    Modal classmodal = new Modal();
    private final Proveedor proveedor;
    private final Compra_Proveedor entrada;
    public String salida_nom, salida_tlfn, salida_direc;
    public int salida_ced;
    Validacion validar = new Validacion();

    //CONSTRUCTOR
    public Nuevo_Proveedor(JFrame parent, boolean modal, Proveedor proveedor, User_sesion user) {
        //ESTE CONSTRUCTOR SE LLAMA SI SE AGREGA DESDE MODULO DE PROVEEDORES
        super(parent, modal);
        this.user = user;
        this.entrada = null;
        this.proveedor = proveedor;
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));//FONDO TRANSPARENTE PARA VER PANEL CON BORDES REDONDEADOS
        initComponents();
        inicializar(parent);
    }

    //CONSTRUCTOR 2
    public Nuevo_Proveedor(JFrame parent, boolean modal, Compra_Proveedor entrada, User_sesion user) {
        //ESTE CONSTRUCTOR SE LLAMA SI SE AGREGA PROVEEDOR DESDE MODULO DE FACTURACION DE COMPRA O ENTRADA
        super(parent, modal);
        this.user = user;
        this.entrada = entrada;
        this.proveedor = null;
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));//FONDO TRANSPARENTE PARA VER PANEL CON BORDES REDONDEADOS
        initComponents();
        inicializar(parent);
    }

    //VALIDAR EL FORMULARIO DE UN NUEVO PROVEEDOR
    public boolean validar() {
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

    //ESTO ES PARA MOSTRAR LA INFO INGRESADA EN EL LABEL DE FACTURACION, SI SE AGREGO DESDE ESE MODULO
    public Object[] obtener_datos() {
        Object[] datos = new Object[]{this.salida_ced, this.salida_nom, this.salida_tlfn, this.salida_direc};
        return datos;
    }

    //INICIAR VENTANA AL CENTRO Y SIN BORDES PARA SIMULAR UN PANEL FLOTANTE
    public void inicializar(JFrame parent) {
        jPanel3.setBackground(new Color(0, 0, 0, 0));
        Point location = parent.getLocationOnScreen();
        int panelWidth = parent.getWidth();
        int panelHeight = parent.getHeight();
        int x = location.x + (panelWidth - getWidth()) / 2;
        int y = location.y + (panelHeight - getHeight()) / 2;
        setLocation(x, y);
    }

    //GUARDA ACCION EN LA BITACORA
    public void cargar_bitacora() {
        Validacion fech = new Validacion();
        String accion = "Agrego un Nuevo Proveedor."; //TIPO DE ACCION
        new Metodos_Insert().post_bitacora(user.getCedula(), user.getNombre(), fech.crear_fecha(), fech.hora(), accion);
    }

    //LIMPIA EL FOMRULARIO
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

        jPanel3 = new javax.swing.JPanel();
        redondear_bordes3 = new interfaz.Redondear_bordes();
        agregar2 = new javax.swing.JButton();
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

        redondear_bordes3.setBackground(new java.awt.Color(255, 255, 255));
        redondear_bordes3.setRoundBottomLeft(50);
        redondear_bordes3.setRoundBottomRight(50);
        redondear_bordes3.setRoundTopLeft(50);
        redondear_bordes3.setRoundTopRight(50);

        agregar2.setBackground(new java.awt.Color(40, 167, 69));
        agregar2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        agregar2.setForeground(new java.awt.Color(255, 255, 255));
        agregar2.setText("Añadir");
        agregar2.setVerifyInputWhenFocusTarget(false);
        agregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar2ActionPerformed(evt);
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
        jLabel1.setText("Nuevo Proveedor");

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

        javax.swing.GroupLayout redondear_bordes3Layout = new javax.swing.GroupLayout(redondear_bordes3);
        redondear_bordes3.setLayout(redondear_bordes3Layout);
        redondear_bordes3Layout.setHorizontalGroup(
            redondear_bordes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, redondear_bordes3Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(agregar2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(redondear_bordes3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(17, 17, 17))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, redondear_bordes3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(redondear_bordes3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, redondear_bordes3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(redondear_bordes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cedula, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addComponent(nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(direccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(telefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );
        redondear_bordes3Layout.setVerticalGroup(
            redondear_bordes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redondear_bordes3Layout.createSequentialGroup()
                .addGroup(redondear_bordes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(redondear_bordes3Layout.createSequentialGroup()
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
                .addGroup(redondear_bordes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(redondear_bordes3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(redondear_bordes3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //ACCION BTN AGREGAR
    private void agregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar2ActionPerformed
        if (validar()) {
            this.salida_ced = Integer.parseInt(cedula.getText().trim());
            this.salida_nom = nombre.getText().trim();
            this.salida_tlfn = telefono.getText().trim();
            this.salida_direc = direccion.getText().trim();//GUARDA EN VARIABLES GLOBALES PARA MOSTRAR EN LABEL DE FACTUACION SI ES NECESARIO
            if (new Metodos_Insert().post_provee(this.salida_ced, this.salida_nom, this.salida_tlfn, this.salida_direc, true)) {
                cargar_bitacora();//GUARDAR ACCION DE REGISTRO
            }
            limpiar();//LIMPIA FORMULARIO
            classmodal.cerrarDialogo(this);
            if (proveedor != null) {
                proveedor.cargarProveedorEnTabla();// RECARGAR LA TABLA SI SE AGREGO DESDE MODULO DE PROVEEDORES
            }
            if (entrada != null) {
                Object[] datos = obtener_datos();//MUESTRA LOS DATOS EN EL MODAL SI SE AGREGO DESDE MODULO DE FACTURACION
                entrada.preparar(datos, true);
            }
        }
    }//GEN-LAST:event_agregar2ActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_limpiarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        classmodal.cerrarDialogo(this);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar2;
    private javax.swing.JTextField cedula;
    private javax.swing.JTextField direccion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton limpiar;
    private javax.swing.JTextField nombre;
    private interfaz.Redondear_bordes redondear_bordes3;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
