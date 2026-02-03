package interfaz;

import database.Metodos_Select;
import java.awt.Color;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import style.Style;

public class Detalles extends javax.swing.JDialog {

    Modal classmodal = new Modal();
    public int id;
    public String cabecera, detalle;
    public boolean estado = false;

    //COSNTRUCTOR
    public Detalles(JFrame parent, boolean modal, int id, String cabecera, String detalle) {
        super(parent, modal);
        this.cabecera = cabecera;//TIPO DE FACTURA A MOSTRAR, DE ENTRADA O SALIDA
        this.detalle = detalle;
        this.id = id;
        cargarStyle();//CARGAR LOOK AND FEEL A LA INTERFAZ
        initComponents();
        inicializar(parent);
        llenar_cab();//LLENAR INFO EN LABEL SOBRE LA CABECERA DE LA FACTURA
        llenar_detalle();//CARGAR TABLA DE DETALLES DE LOS PRODUCTOS
        alinearColumnas(detalle_tabla);
    }

    //SE LLAMA DESDE REPORTES, ES PARA SABER SI LOS DETALLES SE MUESTRAN DESDE EL HISTORIAL O COMO VISTA PREVIA DESPUES DE UNA COMPRA 0 VENTA
    public void estadoC(boolean x) {
        estado = x;
    }

    //aplicar look and feel y fondo transparente para resaltar los bordes redondeados del panel
    public void cargarStyle() {
        Style look = new Style();
        look.Style();
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
    }

    //HACE CONSULTA A LA DB Y CARGAR INFO EN LA TABLA DE DETALLES
    public void llenar_detalle() {
        Metodos_Select met = new Metodos_Select();
        DefaultTableModel modelo = (DefaultTableModel) detalle_tabla.getModel();
        met.get_det_factura(id, modelo, detalle);
    }

    //ALINEAR TEXTO DE LA TABLA PARA MEJOR APARIENCIA VISUAL
    public void alinearColumnas(JTable x) {
        TableColumnModel columnModel = x.getColumnModel(); // Obtener el modelo de columnas
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.LEFT);

        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setCellRenderer(renderer);
        }
    }

    //MOSTRAR LAS VARIABLES EN LOS LABEL, ESTAS VIENEN DESDE PARAMETROS
    public void llenar_cab() {
        Object[] datos = new Metodos_Select().get_cabecera(id, cabecera);
        id_fact.setText("Id Factura: " + id);
        id_provee.setText("Cedula: " + Integer.valueOf(String.valueOf(datos[1])));
        lfecha.setText("Fecha: " + (String) datos[2]);
        lhora.setText("Hora: " + (String) datos[3]);
        lmonto.setText("Importe Total $: " + Float.valueOf(String.valueOf(datos[4])));
    }

    //UBICAR VENTANA EN EL CENTRO
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
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        id_fact = new javax.swing.JLabel();
        id_provee = new javax.swing.JLabel();
        lfecha = new javax.swing.JLabel();
        lhora = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detalle_tabla = new javax.swing.JTable();
        lmonto = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        redondear_bordes1.setBackground(new java.awt.Color(255, 255, 255));
        redondear_bordes1.setRoundBottomLeft(50);
        redondear_bordes1.setRoundBottomRight(50);
        redondear_bordes1.setRoundTopLeft(50);
        redondear_bordes1.setRoundTopRight(50);

        jButton1.setBackground(new java.awt.Color(220, 53, 69));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("x");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Detalles de Factura");

        id_fact.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        id_fact.setText("Id Factura:");

        id_provee.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        id_provee.setText("Cedula:");

        lfecha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lfecha.setText("Fecha:");

        lhora.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lhora.setText("Hora:");

        detalle_tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Codigo", "Nombre", "Precio", "Iva %", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Object.class, java.lang.Integer.class
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
        detalle_tabla.setSelectionBackground(new java.awt.Color(0, 0, 153));
        detalle_tabla.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(detalle_tabla);

        lmonto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lmonto.setText("Importe Total:");

        javax.swing.GroupLayout redondear_bordes1Layout = new javax.swing.GroupLayout(redondear_bordes1);
        redondear_bordes1.setLayout(redondear_bordes1Layout);
        redondear_bordes1Layout.setHorizontalGroup(
            redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, redondear_bordes1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id_provee)
                    .addComponent(id_fact))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lhora, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lfecha, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(190, 190, 190))
            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addGroup(redondear_bordes1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, redondear_bordes1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, redondear_bordes1Layout.createSequentialGroup()
                        .addComponent(lmonto)
                        .addGap(116, 116, 116))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, redondear_bordes1Layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        redondear_bordes1Layout.setVerticalGroup(
            redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_fact)
                    .addComponent(lfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_provee)
                    .addComponent(lhora))
                .addGap(41, 41, 41)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lmonto)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(redondear_bordes1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //ACCION DE CERRAR JDIALOG
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (estado) //SI ESTO ES TRU ES PORQUE SE ABRIO LOS DETALLES DESDE HISTORIAL Y ALLI NO SE APLICA FONDO OPACO
        {
            this.dispose();
        } else if (!estado)//SI ES FALSE SE ABRIO DETALLES DESDE OTRA INTERFAZ Y ALLI SE QUITA EL FONDO OPACO
        {
            classmodal.cerrarDialogo(this);
        }


    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable detalle_tabla;
    private javax.swing.JLabel id_fact;
    private javax.swing.JLabel id_provee;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lfecha;
    private javax.swing.JLabel lhora;
    private javax.swing.JLabel lmonto;
    private interfaz.Redondear_bordes redondear_bordes1;
    // End of variables declaration//GEN-END:variables
}
