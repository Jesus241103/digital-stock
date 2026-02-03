package interfaz;

import database.Metodos_Select;
import database.Metodos_Update;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JFrame;
import principal.Validacion;

public class Modificar_Proveedor extends javax.swing.JDialog {

    private final Proveedor proveedor;
    Modal dialog = new Modal();
    Validacion validar = new Validacion();

    //CONSTRUCTOR
    public Modificar_Proveedor(JFrame parent, boolean modal, Proveedor proveedor) {
        super(parent, modal);
        this.proveedor = proveedor;
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));//FONDO TRASNPARENTE PARA VER PANEL CON BORDES REDONDEADOS
        initComponents();
        inicializar(parent);
        limpiar.setEnabled(false);//DESCATIVA BTN INNECEARIOS
        actualizar.setEnabled(false);
    }

    //INICIAR PANEL AL CENTRO Y SIN BORDES PARA SIMULAR PANEL FLOATANTE
    public void inicializar(JFrame parent) {
        jPanel1.setBackground(new Color(0, 0, 0, 0));
        Point location = parent.getLocationOnScreen();
        int panelWidth = parent.getWidth();
        int panelHeight = parent.getHeight();
        int x = location.x + (panelWidth - getWidth()) / 2;
        int y = location.y + (panelHeight - getHeight()) / 2;
        setLocation(x, y);
    }

    //VALIDACION DE CEDULA
    public boolean validacion() {
        if (!validar.validarCedula(cedula.getText().trim())) {
            return false;
        }
        return true;
    }

    //VALIDA TODO EL FORMULARIO CON INFO DEL PROVEEDOR
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
        return true;//TRUE SI PASA LA VALIDACION
    }

    //RESETEA TODO EL FORMULARIO
    public void limpiar() {
        //limpiar campos
        cedula.setText("");
        cedula.setEnabled(true);
        buscar.setEnabled(true);
        nombre.setText("");
        nombre.setEnabled(false);
        direccion.setText("");
        direccion.setEnabled(false);
        telefono.setText("");
        telefono.setEnabled(false);
        estado.setSelectedItem(0);
        estado.setEnabled(false);
        limpiar.setEnabled(false);
        actualizar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        redondear_bordes1 = new interfaz.Redondear_bordes();
        buscar = new javax.swing.JButton();
        modificar = new javax.swing.JLabel();
        limpiar = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        cedula = new javax.swing.JTextField();
        nombre = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        direccion = new javax.swing.JTextField();
        estado = new javax.swing.JComboBox<>();

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

        modificar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        modificar.setText("Modificar Proveedor");

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

        cedula.setBorder(javax.swing.BorderFactory.createTitledBorder("Cedula"));
        cedula.setMinimumSize(new java.awt.Dimension(200, 50));
        cedula.setPreferredSize(new java.awt.Dimension(200, 50));

        nombre.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre"));
        nombre.setEnabled(false);
        nombre.setMinimumSize(new java.awt.Dimension(200, 50));
        nombre.setPreferredSize(new java.awt.Dimension(200, 50));

        telefono.setBorder(javax.swing.BorderFactory.createTitledBorder("Telefono"));
        telefono.setEnabled(false);
        telefono.setMinimumSize(new java.awt.Dimension(200, 50));
        telefono.setPreferredSize(new java.awt.Dimension(200, 50));

        direccion.setBorder(javax.swing.BorderFactory.createTitledBorder("Email"));
        direccion.setEnabled(false);
        direccion.setMinimumSize(new java.awt.Dimension(200, 50));
        direccion.setPreferredSize(new java.awt.Dimension(200, 50));

        estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        estado.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado"));
        estado.setEnabled(false);
        estado.setPreferredSize(new java.awt.Dimension(320, 45));

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
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(redondear_bordes1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, redondear_bordes1Layout.createSequentialGroup()
                            .addGap(129, 129, 129)
                            .addComponent(limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(redondear_bordes1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(redondear_bordes1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(redondear_bordes1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        redondear_bordes1Layout.setVerticalGroup(
            redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(telefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(estado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(direccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
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
        if (validacion()) {
            //buscar e insertar
            Metodos_Select met = new Metodos_Select();
            int cod = Integer.parseInt(cedula.getText().trim());
            Object[] datos = met.get_provee(cod);
            if (datos.length > 1) {//SI EL ARRAY NO ESTA VACI, SE ENCONTRO LA INFO DEL PRODUCTO CORRECTAMENTE
                buscar.setEnabled(false);//CARGA INFO EN LOS INPUT
                cedula.setEnabled(false);
                nombre.setText((String) datos[1]);
                telefono.setText((String) datos[2]);
                direccion.setText((String) datos[3]);
                int est = 1;
                if ((boolean) datos[4]) {//SI EL ESTADO ES TRUE, MUESTRA ACTIVO EN EL COMBOBOX
                    est = 0;
                }
                estado.setSelectedIndex(est);
                nombre.setEnabled(true); //PERMITE ESCRIBIR EN LOS INPUT
                direccion.setEnabled(true);
                telefono.setEnabled(true);
                estado.setEnabled(true);
                limpiar.setEnabled(true);
                actualizar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_limpiarActionPerformed

    //ACCION BTNA ACTUALIZAR
    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        if (validar()) {
            Metodos_Update met = new Metodos_Update();
            int cod = Integer.parseInt(cedula.getText().trim());
            String nomb = nombre.getText().trim();
            String telf = telefono.getText().trim();
            String direc = direccion.getText().trim();
            String resp = estado.getSelectedItem().toString();
            if ("Activo".equals(resp)) {//SI EL COMBOBOX ES ACTIVO SE MANDA TRUE, SI NO FALSE
                resp = "true";
            } else {
                resp = "false";
            }
            met.put_provee(cod, nomb, telf, direc, Boolean.parseBoolean(resp));//EJECUTA ACTUALIZACION
            limpiar();
            dialog.cerrarDialogo(this);//CIERRA VENTANA
            proveedor.cargarProveedorEnTabla();//RECARGA LA TABLA
        }
    }//GEN-LAST:event_actualizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dialog.cerrarDialogo(this);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JButton buscar;
    private javax.swing.JTextField cedula;
    private javax.swing.JTextField direccion;
    private javax.swing.JComboBox<String> estado;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton limpiar;
    private javax.swing.JLabel modificar;
    private javax.swing.JTextField nombre;
    private interfaz.Redondear_bordes redondear_bordes1;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
