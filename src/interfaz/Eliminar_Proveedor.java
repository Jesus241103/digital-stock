package interfaz;

import database.Metodos_Select;
import database.Metodos_Update;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import principal.Validacion;

public class Eliminar_Proveedor extends JDialog {

    private final Proveedor proveedor;
    Modal dialog = new Modal();
    Validacion validar = new Validacion();

    //constructor
    public Eliminar_Proveedor(JFrame parent, boolean modal, Proveedor proveedor) {
        super(parent, modal);
        this.proveedor = proveedor;
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));//FONDO TRANSPARTE PARA APRECIAR BORDES REDONDEADOS DEL PANEL
        initComponents();
        inicializar(parent);
        limpiar.setEnabled(false);//DESACTIVA ALGUNOS BTN
        actualizar.setEnabled(false);
    }

    //VALIDA CEDULA INGRESADA
    public boolean validacion() {
        if (!validar.validarCedula(cedula.getText().trim())) {
            return false;
        }
        return true;
    }

    //MUESTRA VENTANA EN EL CENTRO Y ELIMINA LOS BORDES DE LA VENTANA PARA QUE PAREZCA UN PANEL FLOTANTE
    public void inicializar(JFrame parent) {
        jPanel1.setBackground(new Color(0, 0, 0, 0));
        Point location = parent.getLocationOnScreen();
        int panelWidth = parent.getWidth();
        int panelHeight = parent.getHeight();
        int x = location.x + (panelWidth - getWidth()) / 2;
        int y = location.y + (panelHeight - getHeight()) / 2;
        setLocation(x, y);
    }

    //LIMPIAR O RESETEAR EL FORMULARIO
    public void limpiar() {
        //limpiar campos
        cedula.setText("");
        cedula.setEnabled(true);
        estado.setSelectedIndex(0);
        estado.setEnabled(false);
        limpiar.setEnabled(false);
        actualizar.setEnabled(false);
        buscar.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        redondear_bordes1 = new interfaz.Redondear_bordes();
        buscar = new javax.swing.JButton();
        cedula = new javax.swing.JTextField();
        modificar = new javax.swing.JLabel();
        limpiar = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        estado = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

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

        cedula.setBorder(javax.swing.BorderFactory.createTitledBorder("Cedula"));
        cedula.setPreferredSize(new java.awt.Dimension(320, 45));

        modificar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        modificar.setText("Eliminar Proveedor");

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

        estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inactivo" }));
        estado.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado"));
        estado.setEnabled(false);
        estado.setPreferredSize(new java.awt.Dimension(320, 45));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Cambiar Estado");

        javax.swing.GroupLayout redondear_bordes1Layout = new javax.swing.GroupLayout(redondear_bordes1);
        redondear_bordes1.setLayout(redondear_bordes1Layout);
        redondear_bordes1Layout.setHorizontalGroup(
            redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(redondear_bordes1Layout.createSequentialGroup()
                        .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(redondear_bordes1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, redondear_bordes1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
            .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(redondear_bordes1Layout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(modificar)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 304, Short.MAX_VALUE)
                    .addComponent(jButton1)
                    .addGap(18, 18, 18)))
        );
        redondear_bordes1Layout.setVerticalGroup(
            redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(redondear_bordes1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1))
                    .addContainerGap(356, Short.MAX_VALUE)))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //ACCION BTN CERRAR
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dialog.cerrarDialogo(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    //ACTUALIZAR ESTADO DE PROVEEDOR
    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        Metodos_Update met = new Metodos_Update();
        int cod = Integer.parseInt(cedula.getText().trim());
        String resp = estado.getSelectedItem().toString();
        if ("Inactivo".equals(resp)) {
            resp = "false";
        }
        //actualiza estado en la base de datos
        met.put_provee(cod, Boolean.parseBoolean(resp));
        limpiar();//limpia formulario
        dialog.cerrarDialogo(this);
        proveedor.cargarProveedorEnTabla();//RECARGA LA TABLA PARA VER LO CAMBIOS
    }//GEN-LAST:event_actualizarActionPerformed

    //BTN RESTABLECER EL FORMULARIO, LIMPIAR CAMPOS
    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_limpiarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        //buscar e insertar
        if (validacion()) {
            Metodos_Select met = new Metodos_Select();
            int cod = Integer.parseInt(cedula.getText().trim());
            Object[] datos = met.get_provee(cod);
            if (datos.length > 1) {
                int est;
                if ((boolean) datos[4]) {
                    est = 0;
                } else {
                    JOptionPane.showMessageDialog(null, "Este Proveedor ya se encuentra Eliminado", "Error", 0);
                    return;
                }
                //descartivar btn de busqueda y activar el de limpiar y actualizar
                estado.setSelectedIndex(est);
                cedula.setEnabled(false);
                estado.setEnabled(true);
                limpiar.setEnabled(true);
                actualizar.setEnabled(true);
                buscar.setEnabled(false);

            }
        }
    }//GEN-LAST:event_buscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JButton buscar;
    private javax.swing.JTextField cedula;
    private javax.swing.JComboBox<String> estado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton limpiar;
    private javax.swing.JLabel modificar;
    private interfaz.Redondear_bordes redondear_bordes1;
    // End of variables declaration//GEN-END:variables
}
