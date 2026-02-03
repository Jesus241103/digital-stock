package interfaz;

import java.awt.Color;
import java.awt.Point;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class Vista_Cliente extends JDialog {

    private final Cliente cliente;
    Modal dialog = new Modal();

    //CONSTRUCTOR
    public Vista_Cliente(JFrame parent, boolean modal, Cliente cliente, int c, String n, String t, String d) {
        super(parent, modal);
        this.cliente = cliente;
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));//FONDO TRANSPARENTE PARA NO VER EL BORDE DE LA VENTANA
        initComponents();
        inicializar(parent);
        llenar(c, n, t, d);
    }

    //CARGGAR INFO DEL CLIENTE EN LABEL
    public void llenar(int c, String n, String t, String d) {
        cl.setText("Cedula " + c);
        nl.setText("Nombre: " + n);
        pl.setText("Telefono: " + t);
        il.setText("Email: " + d);
    }

    //QUITAR LOS BORDES DE LA VENTANA PARA QUE SE VEA COMO UN PANEL FLOTANTE
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
        redondear_bordes3 = new interfaz.Redondear_bordes();
        modificar2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        cl = new javax.swing.JLabel();
        pl = new javax.swing.JLabel();
        nl = new javax.swing.JLabel();
        il = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(240, 240, 240));

        redondear_bordes3.setBackground(new java.awt.Color(255, 255, 255));
        redondear_bordes3.setRoundBottomLeft(50);
        redondear_bordes3.setRoundBottomRight(50);
        redondear_bordes3.setRoundTopLeft(50);
        redondear_bordes3.setRoundTopRight(50);

        modificar2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        modificar2.setText("Detalles del Cliente");

        jButton3.setBackground(new java.awt.Color(220, 53, 69));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("x");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        cl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cl.setText("Cedula:");

        pl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pl.setText("Telefono:");

        nl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nl.setText("Nombre:");

        il.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        il.setText("Email:");

        javax.swing.GroupLayout redondear_bordes3Layout = new javax.swing.GroupLayout(redondear_bordes3);
        redondear_bordes3.setLayout(redondear_bordes3Layout);
        redondear_bordes3Layout.setHorizontalGroup(
            redondear_bordes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redondear_bordes3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator5)
                .addContainerGap())
            .addGroup(redondear_bordes3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(modificar2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(18, 18, 18))
            .addGroup(redondear_bordes3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator6)
                .addContainerGap())
            .addGroup(redondear_bordes3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(redondear_bordes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(il)
                    .addComponent(pl)
                    .addComponent(cl)
                    .addComponent(nl))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        redondear_bordes3Layout.setVerticalGroup(
            redondear_bordes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redondear_bordes3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(redondear_bordes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificar2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cl)
                .addGap(40, 40, 40)
                .addComponent(nl)
                .addGap(40, 40, 40)
                .addComponent(pl)
                .addGap(40, 40, 40)
                .addComponent(il, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(redondear_bordes3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(redondear_bordes3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //ACCION CERRAR PANEL
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dialog.cerrarDialogo(this);
        cliente.borrar_busqueda();//LIMPIAR INPUT
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cl;
    private javax.swing.JLabel il;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel modificar2;
    private javax.swing.JLabel nl;
    private javax.swing.JLabel pl;
    private interfaz.Redondear_bordes redondear_bordes3;
    // End of variables declaration//GEN-END:variables
}
