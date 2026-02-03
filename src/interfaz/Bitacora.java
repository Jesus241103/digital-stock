package interfaz;

import database.Metodos_Select;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import style.Style;

public class Bitacora extends javax.swing.JPanel {

    //constructor   
    public Bitacora() {
        Style look = new Style(); //INICIALIZA EL LOOK AND FEEL A ESTA INTERFAZ
        look.Style();
        initComponents();
        cargarBitacoraEnTabla(); //CARGAR INFO EN LA TABLA
        alinearColumnas(tabla); //ALINEAR TEXTO PARA MAS ORDEN
    }

    //CARGAR INFORMACION DE LA BASE DE DATOS EN LA TABLA BITACORA
    public void cargarBitacoraEnTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel(); //MODELO DE LA TABLA
        modelo.setRowCount(0); //LIMPIA DATOS DE LA TABLA ACTUAL
        new Metodos_Select().get_bitacora(modelo, ""); //CARGA INFORMACION
    }

    //ALINEA EL TEXTO DE TODAS LAS COLUMNAS A LA DERECHA, PARA QUE SE VEA MAS ORDENADO
    public void alinearColumnas(JTable tabla) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.LEFT);
        for (int i = 0; i < tabla.getColumnModel().getColumnCount(); i++) { //ALINEAR TEXTO DE TODAS LAS COLUMNAS A LA DERECHA
            tabla.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanel4 = new interfaz.Redondear_bordes();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        filtrado = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        JPanel4.setBackground(new java.awt.Color(255, 255, 255));
        JPanel4.setRoundBottomLeft(50);
        JPanel4.setRoundBottomRight(50);
        JPanel4.setRoundTopLeft(50);
        JPanel4.setRoundTopRight(50);

        tabla.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Cedula", "Nombre", "Fecha", "Hora", "Accion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setRowHeight(25);
        tabla.setSelectionBackground(new java.awt.Color(0, 0, 153));
        tabla.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setViewportView(tabla);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("BITACORA DEL SISTEMA");

        filtrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Registros de Compras", "Registros de Ventas", "Nuevos Proveedores", "Nuevos Clientes", "Nuevos Productos" }));

        jButton1.setBackground(new java.awt.Color(40, 167, 69));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Filtrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPanel4Layout = new javax.swing.GroupLayout(JPanel4);
        JPanel4.setLayout(JPanel4Layout);
        JPanel4Layout.setHorizontalGroup(
            JPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(JPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
                        .addGap(15, 15, 15))
                    .addGroup(JPanel4Layout.createSequentialGroup()
                        .addComponent(filtrado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JPanel4Layout.setVerticalGroup(
            JPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addGap(30, 30, 30)
                .addGroup(JPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(JPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(JPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    //FILTRADO DE BUSQUEDA DE LA BITACORA, CADA OPCION ES UNA CONSULTA DISTINTA
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String tipo = filtrado.getSelectedItem().toString();
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        if (tipo.equals("Todos")) {
            new Metodos_Select().get_bitacora(modelo, ""); //TODAS LOS REGISTROS
        } else if (tipo.equals("Registros de Compras")) {
            new Metodos_Select().get_bitacora(modelo, "WHERE accion = 'Registro una Entrada.'"); // VER SOLO ENTRADAS
        } else if (tipo.equals("Registros de Ventas")) {
            new Metodos_Select().get_bitacora(modelo, "WHERE accion = 'Registro una Salida.'"); //VER SOLO SALIDAS
        } else if (tipo.equals("Nuevos Proveedores")) {
            new Metodos_Select().get_bitacora(modelo, "WHERE accion = 'Agrego un Nuevo Proveedor.'"); //VER REGISTROS DE PROVEEDORES
        } else if (tipo.equals("Nuevos Clientes")) {
            new Metodos_Select().get_bitacora(modelo, "WHERE accion = 'Agrego un Nuevo Cliente.'");//VER RESGISTROS DE CLIENTES
        } else if (tipo.equals("Nuevos Productos")) {
            new Metodos_Select().get_bitacora(modelo, "WHERE accion = 'Agrego un Nuevo Producto.'"); // VER REGISTROS DE PRODUCTOS
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private interfaz.Redondear_bordes JPanel4;
    private javax.swing.JComboBox<String> filtrado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
