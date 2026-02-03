//LISTO
package interfaz;

import database.Metodos_Insert;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import object.User_sesion;
import principal.Validacion;

public class Nuevo_Producto extends JDialog {

    Modal classmodal = new Modal();
    User_sesion user = null;
    private final Producto nuevo;
    Validacion validar = new Validacion();

    //CONSTRUCTOR
    public Nuevo_Producto(JFrame parent, boolean modal, Producto nuevo, User_sesion user) {
        super(parent, modal);
        this.user=user;
        this.nuevo = nuevo;
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));//FONDO TRANSPARENTE PARA VER PANEL CON BORDES REDONDEADOS
        initComponents();
        inicializar(parent);
    }

    //REGISTRAR ACCION EN LA BITACORA
    public void cargar_bitacora() {
        Validacion fech = new Validacion();
        String accion = "Agrego un Nuevo Producto.";//TIPO DE ACCION
        System.out.println("Nombre " + user.getNombre());

        new Metodos_Insert().post_bitacora(user.getCedula(), user.getNombre(), fech.crear_fecha(), fech.hora(), accion);
    }

    //VALIDA TODO EL FORMULARIO DE UN NUEVO PRODUTO
    public boolean validacion() {
        if (!validar.validarCodigoProducto(codigo.getText().trim())) {
            return false;
        }
        if (!validar.validarNombre(name_product.getText().trim())) {
            return false;
        }
        if (!validar.validarPrecioProducto(precio.getText().trim())) {
            return false;
        }
        if (!validar.validarIvaProducto(iva.getText().trim())) {
            return false;
        }
        if (!validar.validarStockMin(min.getText().trim())) {
            return false;
        }
        if (!validar.validarStockMax(max.getText().trim())) {
            return false;
        }
        if (!validar.validarCantidadProducto(stock.getText().trim())) {
            return false;
        }
        return true;//TRUE SI PASA TODAS LAS VALIDACIONES
    }

    //INICIA EL PANEL AL CENTRO Y  SIN BORDESD PARA SIMULAR UN PANEL FLOTANTE
    public void inicializar(JFrame parent) {
        jPanel1.setBackground(new Color(0, 0, 0, 0));
        Point location = parent.getLocationOnScreen();
        int panelWidth = parent.getWidth();
        int panelHeight = parent.getHeight();
        int x = location.x + (panelWidth - getWidth()) / 2;
        int y = location.y + (panelHeight - getHeight()) / 2;
        setLocation(x, y);
    }

    //LIMPIA TODO EL FORMUALRIO
    public void limpiar() {
        //limpiar campos
        codigo.setText("");
        name_product.setText("");
        precio.setText("");
        iva.setText("");
        stock.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        redondear_bordes1 = new interfaz.Redondear_bordes();
        codigo = new javax.swing.JTextField();
        name_product = new javax.swing.JTextField();
        precio = new javax.swing.JTextField();
        iva = new javax.swing.JTextField();
        stock = new javax.swing.JTextField();
        agregar = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        min = new javax.swing.JTextField();
        max = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        redondear_bordes1.setBackground(new java.awt.Color(255, 255, 255));
        redondear_bordes1.setRoundBottomLeft(50);
        redondear_bordes1.setRoundBottomRight(50);
        redondear_bordes1.setRoundTopLeft(50);
        redondear_bordes1.setRoundTopRight(50);

        codigo.setBorder(javax.swing.BorderFactory.createTitledBorder("Codigo"));
        codigo.setMinimumSize(new java.awt.Dimension(200, 30));
        codigo.setPreferredSize(new java.awt.Dimension(200, 45));

        name_product.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre"));
        name_product.setMinimumSize(new java.awt.Dimension(200, 30));
        name_product.setPreferredSize(new java.awt.Dimension(200, 45));

        precio.setBorder(javax.swing.BorderFactory.createTitledBorder("Precio"));
        precio.setMinimumSize(new java.awt.Dimension(200, 30));
        precio.setPreferredSize(new java.awt.Dimension(200, 45));

        iva.setBorder(javax.swing.BorderFactory.createTitledBorder("Iva"));
        iva.setMinimumSize(new java.awt.Dimension(200, 30));
        iva.setPreferredSize(new java.awt.Dimension(200, 45));

        stock.setBorder(javax.swing.BorderFactory.createTitledBorder("Cantidad"));
        stock.setMinimumSize(new java.awt.Dimension(200, 30));
        stock.setPreferredSize(new java.awt.Dimension(200, 45));

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
        jLabel1.setText("Nuevo Producto");

        min.setBorder(javax.swing.BorderFactory.createTitledBorder("Stock Minimo"));

        max.setBorder(javax.swing.BorderFactory.createTitledBorder("Stock Maximo"));

        javax.swing.GroupLayout redondear_bordes1Layout = new javax.swing.GroupLayout(redondear_bordes1);
        redondear_bordes1.setLayout(redondear_bordes1Layout);
        redondear_bordes1Layout.setHorizontalGroup(
            redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, redondear_bordes1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
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
            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(iva, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addComponent(name_product, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(precio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(codigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(redondear_bordes1Layout.createSequentialGroup()
                        .addComponent(min, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(max, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(name_product, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(iva, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(min, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(max))
                .addGap(20, 20, 20)
                .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //ACCION BTN AGREGAR
    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        if (validacion()) {
            int cod = Integer.parseInt(codigo.getText().trim());
            String nombre_product = name_product.getText().trim();
            float pre = Float.parseFloat(precio.getText().trim());
            float iv = Integer.parseInt(iva.getText().trim());
            int sto = Integer.parseInt(stock.getText().trim());
            int mini = Integer.parseInt(min.getText().trim());
            int maxi = Integer.parseInt(max.getText().trim());
            if (maxi <= mini) {//MAX NO PUEDE SER MENOR A MINIMO
                JOptionPane.showMessageDialog(null, "EL STOCK MAXIMO DEBE SER MAYOR AL STOCK MINIMO", "ERROR", 0);
                return;
            }
            if (sto > maxi) {//ESOCK ACTUAL NO PUEDE SER MAYOR A MAXIMO
                JOptionPane.showMessageDialog(null, "LA CANTIDAD INGRESADA DEBE SER MENOR AL STOCK MAXIMO", "ERROR", 0);
                return;
            }
            if (new Metodos_Insert().post_prod(cod, nombre_product, pre, iv, mini, maxi, sto, true)) {//ACTUALIZA LA DB
                cargar_bitacora();//REGISTRA EN BITACORA
            }
            limpiar();//LIMPI FORMULARIO
            classmodal.cerrarDialogo(this);
            nuevo.cargarProductosEnTabla();//RECARGA LA TABLA
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
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField iva;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton limpiar;
    private javax.swing.JTextField max;
    private javax.swing.JTextField min;
    private javax.swing.JTextField name_product;
    private javax.swing.JTextField precio;
    private interfaz.Redondear_bordes redondear_bordes1;
    private javax.swing.JTextField stock;
    // End of variables declaration//GEN-END:variables
}
