//LISTO
package interfaz;

import database.Metodos_Select;
import database.Metodos_Update;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import principal.Validacion;

public class Modificar_Producto extends JDialog {

    private final Producto nuevo;
    Modal dialog = new Modal();
    Validacion validar = new Validacion();

    //CONSTRUCTOR
    public Modificar_Producto(JFrame parent, boolean modal, Producto nuevo) {
        super(parent, modal);
        this.nuevo = nuevo;
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));//FONDO TRANSPARENTE PARA VER PANEL CON BORDES REDONDEADOS
        initComponents();
        inicializar(parent);
        limpiar.setEnabled(false);//DESACTIVA BTN INNECESARIOS
        actualizar.setEnabled(false);
    }

    //VALIDA EL CODIGO DEL PRODUCTO
    public boolean validacioncod() {
        if (!validar.validarCodigoProducto(codigo5.getText().trim())) {
            return false;
        }
        return true;
    }

    //VALIDA TODO EL FORMULARIO, TODA LA INFORMACION DEL PRODUCTO QUE SE DESEA MODIFICAR
    public boolean validar() {
        if (!validar.validarNombre(name5.getText().trim())) {
            return false;
        }
        if (!validar.validarPrecioProducto(precio5.getText().trim())) {
            return false;
        }
        if (!validar.validarIvaProducto(iva5.getText().trim())) {
            return false;
        }
        if (!validar.validarStockMin(min.getText().trim())) {
            return false;
        }
        if (!validar.validarStockMax(max.getText().trim())) {
            return false;
        }
        if (!validar.validarCantidadProducto(stock5.getText().trim())) {
            return false;
        }
        return true;//TRUE SI LA VALIDACION ES CORRECTA
    }

    //INICIAR PANEL AL CENTRO Y QUITAR BORDES, PARA SIMULAR UN PANEL FLOTANTE
    public void inicializar(JFrame parent) {
        jPanel1.setBackground(new Color(0, 0, 0, 0));
        Point location = parent.getLocationOnScreen();
        int panelWidth = parent.getWidth();
        int panelHeight = parent.getHeight();
        int x = location.x + (panelWidth - getWidth()) / 2;
        int y = location.y + (panelHeight - getHeight()) / 2;
        setLocation(x, y);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        redondear_bordes1 = new interfaz.Redondear_bordes();
        buscar = new javax.swing.JButton();
        codigo5 = new javax.swing.JTextField();
        name5 = new javax.swing.JTextField();
        iva5 = new javax.swing.JTextField();
        modificar = new javax.swing.JLabel();
        precio5 = new javax.swing.JTextField();
        stock5 = new javax.swing.JTextField();
        limpiar = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        estado = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        min = new javax.swing.JTextField();
        max = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(240, 240, 240));

        redondear_bordes1.setBackground(new java.awt.Color(255, 255, 255));
        redondear_bordes1.setRoundBottomLeft(50);
        redondear_bordes1.setRoundBottomRight(50);
        redondear_bordes1.setRoundTopLeft(50);
        redondear_bordes1.setRoundTopRight(50);

        buscar.setBackground(new java.awt.Color(0, 0, 153));
        buscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buscar.setForeground(new java.awt.Color(255, 255, 255));
        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        codigo5.setBorder(javax.swing.BorderFactory.createTitledBorder("Codigo"));
        codigo5.setPreferredSize(new java.awt.Dimension(320, 45));

        name5.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre"));
        name5.setEnabled(false);
        name5.setPreferredSize(new java.awt.Dimension(320, 45));

        iva5.setBorder(javax.swing.BorderFactory.createTitledBorder("Iva"));
        iva5.setEnabled(false);
        iva5.setPreferredSize(new java.awt.Dimension(320, 45));

        modificar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        modificar.setText("Modificar Producto");

        precio5.setBorder(javax.swing.BorderFactory.createTitledBorder("Precio"));
        precio5.setEnabled(false);
        precio5.setPreferredSize(new java.awt.Dimension(320, 45));

        stock5.setBorder(javax.swing.BorderFactory.createTitledBorder("Stock"));
        stock5.setEnabled(false);
        stock5.setPreferredSize(new java.awt.Dimension(320, 45));

        limpiar.setBackground(new java.awt.Color(220, 53, 69));
        limpiar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        limpiar.setForeground(new java.awt.Color(255, 255, 255));
        limpiar.setText("Limpiar");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        actualizar.setBackground(new java.awt.Color(40, 167, 69));
        actualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        actualizar.setForeground(new java.awt.Color(255, 255, 255));
        actualizar.setText("Actualizar");
        actualizar.setVerifyInputWhenFocusTarget(false);
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
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

        estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        estado.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado"));
        estado.setEnabled(false);
        estado.setPreferredSize(new java.awt.Dimension(320, 45));

        min.setBorder(javax.swing.BorderFactory.createTitledBorder("Stock Minimo"));
        min.setEnabled(false);
        min.setPreferredSize(new java.awt.Dimension(320, 45));

        max.setBorder(javax.swing.BorderFactory.createTitledBorder("Stock Maximo"));
        max.setEnabled(false);
        max.setPreferredSize(new java.awt.Dimension(320, 45));

        javax.swing.GroupLayout redondear_bordes1Layout = new javax.swing.GroupLayout(redondear_bordes1);
        redondear_bordes1.setLayout(redondear_bordes1Layout);
        redondear_bordes1Layout.setHorizontalGroup(
            redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(modificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18))
            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(name5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                        .addComponent(codigo5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addComponent(precio5, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addComponent(stock5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(min, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addComponent(limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(redondear_bordes1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(redondear_bordes1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(estado, 0, 0, Short.MAX_VALUE)
                            .addComponent(iva5, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(max, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(redondear_bordes1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 34, Short.MAX_VALUE))
            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
        );
        redondear_bordes1Layout.setVerticalGroup(
            redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigo5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(name5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precio5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iva5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(max, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stock5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(redondear_bordes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(redondear_bordes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        //buscar e insertar
        if (validacioncod()) {
            Metodos_Select met = new Metodos_Select();
            int cod = Integer.parseInt(codigo5.getText().trim());
            Object[] datos = met.get_prod(cod);
            if (datos.length > 1) {//SI EL ARRAY NO ESTA VACIO ES PORQUE SE ENCONTRO LA INFO CORRECTAMENTE
                name5.setText((String) datos[1]);//CARGAR INFO EN LOS INPUT
                precio5.setText(String.valueOf(datos[2]));
                iva5.setText(String.valueOf(datos[3]));
                min.setText(String.valueOf(datos[4]));
                max.setText(String.valueOf(datos[5]));
                stock5.setText(String.valueOf(datos[6]));
                int est = 1;//SI EL ESTADO ES TRUE MUESTRA ACTIVO EN EL COMBOBOX, DE LO CONTRARIO MUESTRA INACTIVO
                if ((boolean) datos[7]) {
                    est = 0;
                }
                estado.setSelectedIndex(est);
                codigo5.setEnabled(false);
                name5.setEnabled(true);//PERMITE ESCRIBIR EN LOS INPUT
                precio5.setEnabled(true);
                iva5.setEnabled(true);
                stock5.setEnabled(true);
                min.setEnabled(true);
                max.setEnabled(true);
                estado.setEnabled(true);
                limpiar.setEnabled(true);
                actualizar.setEnabled(true);
                buscar.setEnabled(false);
            }
        }
    }//GEN-LAST:event_buscarActionPerformed

    //BTN LIMPIAR EL FORMULARIO
    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_limpiarActionPerformed

    //ACTUALIZAR DATOS
    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        if (validar()) {//VALIDA
            Metodos_Update met = new Metodos_Update();
            int cod = Integer.parseInt(codigo5.getText().trim());
            String nombre = name5.getText().trim();
            float pre = Float.parseFloat(precio5.getText().trim());
            float iv = Float.parseFloat(iva5.getText().trim());
            int mini = Integer.parseInt(min.getText().trim());
            int maxi = Integer.parseInt(max.getText().trim());
            int sto = Integer.parseInt(stock5.getText().trim());
            String resp = estado.getSelectedItem().toString();
            if ("Activo".equals(resp)) {//SI ES ACTIVO EL COMBOBOX, SE MANDA TRUE SI NO SE MANDA FALSE
                resp = "true";
            } else {
                resp = "false";
            }
            if (maxi <= mini) {//CANTIDAD MAX NO PUEDE SER MENOR A MIN
                JOptionPane.showMessageDialog(null, "EL STOCK MAXIMO DEBE SER MAYOR AL STOCK MINIMO", "ERROR", 0);
                return;
            }
            if (sto > maxi) {//STOCK ACTUALO NO PUEDE SER MAYOR A MAX
                JOptionPane.showMessageDialog(null, "LA CANTIDAD INGRESADA DEBE SER MENOR AL STOCK MAXIMO", "ERROR", 0);
                return;
            }
            met.put_prod(cod, nombre, pre, iv, mini, maxi, sto, Boolean.parseBoolean(resp));//EJECUTA ACTUALIZACION
            limpiar();//LIMPIA FORMULARIO
            dialog.cerrarDialogo(this);
            nuevo.cargarProductosEnTabla();//RECARGA LA TABLA DE PRODUCTOS
        }
    }//GEN-LAST:event_actualizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dialog.cerrarDialogo(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    //LIMPIA TODO EL FORMULARIO
    public void limpiar() {
        //limpiar campos
        codigo5.setText("");
        codigo5.setEnabled(true);
        name5.setText("");
        name5.setEnabled(false);
        precio5.setText("");
        precio5.setEnabled(false);
        iva5.setText("");
        iva5.setEnabled(false);
        stock5.setText("");
        min.setText("");
        max.setText("");
        stock5.setEnabled(false);
        estado.setSelectedItem(0);
        estado.setEnabled(false);
        limpiar.setEnabled(false);
        actualizar.setEnabled(false);
        buscar.setEnabled(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JButton buscar;
    private javax.swing.JTextField codigo5;
    private javax.swing.JComboBox<String> estado;
    private javax.swing.JTextField iva5;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton limpiar;
    private javax.swing.JTextField max;
    private javax.swing.JTextField min;
    private javax.swing.JLabel modificar;
    private javax.swing.JTextField name5;
    private javax.swing.JTextField precio5;
    private interfaz.Redondear_bordes redondear_bordes1;
    private javax.swing.JTextField stock5;
    // End of variables declaration//GEN-END:variables
}
