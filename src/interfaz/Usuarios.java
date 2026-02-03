package interfaz;

import database.Metodos_Select;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import style.Style;

public class Usuarios extends javax.swing.JPanel {

    //CONSTRUCTOR
    public Usuarios() {
        Style look = new Style();
        look.Style();//APLICAR LOOK AND FEEL A LA INTERFAZ
        initComponents();
        cargarUsuariosEnTabla();//CARGAR TABLA DE USUARIOS
        alinearColumnas(tabla);
    }

    //DAR MODELO DE TABLAS PARA QUE LA BASE DE DATOS INSERTE LOS USUARIOS
    public void cargarUsuariosEnTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        Metodos_Select metodosDB = new Metodos_Select();
        metodosDB.get_usuarios(modelo);
    }

    //ALINEAR EL TEXTO DE LAS TABLAS PARA MEJOR APARIENCIA VISUAL
    public void alinearColumnas(JTable tabla) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.LEFT);
        for (int i = 0; i < tabla.getColumnModel().getColumnCount(); i++) {
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
                "#", "Cedula", "Nombre", "Telefono", "Clave", "Rol"
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
        jLabel4.setText("USUARIOS DEL SISTEMA");

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
                        .addGap(15, 15, 15)))
                .addContainerGap())
        );
        JPanel4Layout.setVerticalGroup(
            JPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private interfaz.Redondear_bordes JPanel4;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
