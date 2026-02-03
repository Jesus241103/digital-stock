package interfaz;

import database.Metodos_Select;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Historial extends javax.swing.JDialog {

    public Reporte_entrada reporte;
    Modal modal = new Modal();
    Metodos_Select met = new Metodos_Select();
    String tipo_detalle;
    int valor = 0;
    String query = "", titulo = "", label = "";

    //constructor
    public Historial(JFrame parent, boolean modal, Reporte_entrada reporte, int num) {
        super(parent, modal);
        valor = num;
        this.reporte = reporte;
        setUndecorated(true); //FONDO TRASNPARENTE PARA VISUALIZAR BORDES REDONDEADOS DEL PANEL
        setBackground(new Color(0, 0, 0, 0));
        initComponents();
        inicializar(parent);
        llenar_tabla();//CARGAR TABLA DE FACTURAS
        alinearColumnas(tabla);//ALINEAR TEXTO DE LA TABLA AL LA IZQUIERDA
        cargar_label();//CARGAR LABEL CON INFO DEL HISTORIAL
        aplicarEstilo(tabla);
        funcion_btn(tabla, this);
    }

    //IDENTIFICA EL TIPO DE CONSULTA, YA QUE HAY FACTURAS DE ENTRADA Y DE SALIDA, ESE VALOR DEPENDE DEL RECIBIDO POR PARAMETRO
    public void identificar() {
        if (valor == 1) {
            query += "cab_factura";
            tipo_detalle = "detalle_fac";
            titulo += "Historial de Entradas";
            label += "Monto Total de Gastos";
        } else if (valor == 2) {
            query += "cab_salida";
            tipo_detalle = "detalle_salida";
            titulo += "Historial de Salidas";
            label += "Monto Total de Ganancias";
        }
    }

    //CARGAR TABLA, HACE LA CONSULTA A LA BASE DE DATOS Y LAS LLENAS CON LAS CABECERA DE FACTURAS
    public void llenar_tabla() {
        identificar();
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        met.get_cab_factura(modelo, query);
    }

    //MUESTRAR CANTIDAD DE FACTURAS Y VALOR TOTAL EN LABEL
    public void cargar_label() {
        int nume = met.contarFactura(query);
        cantidad.setText("Total de Facturas: " + nume);
        monto.setText(label + ": " + calculo_ing());
        titulo1.setText(titulo);
    }

    //CALCULO EL INGRESO TOTAL POR TODAS LAS FACTURAS QUE HAY EN LA TABLA
    public float calculo_ing() {
        float total = 0;
        int totalFilas = tabla.getRowCount();

        for (int i = 0; i < totalFilas; i++) {
            total += Float.parseFloat(tabla.getValueAt(i, 4).toString());
        }
        return total;//RETORNA VALOR PARA MOSTRAR EN LABEL
    }

    //ALINEAR TEXTO DE LA TABLA
    public void alinearColumnas(JTable x) {
        TableColumnModel columnModel = x.getColumnModel(); // Obtener el modelo de columnas
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.LEFT);

        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setCellRenderer(renderer);
        }
    }

    //MOSTRAR VENTANA AL CENTRO Y QUITAR BORDES PARA SIMULAR UN JPANEL FLOTANTE
    public void inicializar(JFrame parent) {
        jPanel1.setBackground(new Color(0, 0, 0, 0));
        Point location = parent.getLocationOnScreen();
        int panelWidth = parent.getWidth();
        int panelHeight = parent.getHeight();
        int x = location.x + (panelWidth - getWidth()) / 2;
        int y = location.y + (panelHeight - getHeight()) / 2;
        setLocation(x, y);
    }

    //APLICAR ESTILO DE ENLACE O LINK A LA COLUMNA DE VER DETALLES DE LA TABLA
    public void aplicarEstilo(JTable tabla) {
        int ultimaColumna = tabla.getColumnCount() - 1;
        tabla.getColumnModel().getColumn(ultimaColumna).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus,
                    int row, int column) {
                JLabel label = new JLabel("<html><a style='color: blue; text-decoration: underline;'>" + value + "</a></html>");
                label.setCursor(new Cursor(Cursor.HAND_CURSOR));
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setOpaque(true);

                if (isSelected) {
                    label.setBackground(table.getSelectionBackground());
                    label.setForeground(table.getSelectionForeground());
                } else {
                    label.setBackground(table.getBackground());
                    label.setForeground(table.getForeground());
                }

                return label;
            }
        });
    }

    //EVENTO AL PRECIONAR EL LABEL DE VER DETALLES, ESTO HABRE UNA VENTANA EMERGENTE CON LOS DETALLES DE LA FACTURA SELECCIONADA
    public static void funcion_btn(JTable tabla, Historial instancia) {
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int fila = tabla.rowAtPoint(e.getPoint());
                int columna = tabla.columnAtPoint(e.getPoint());
                int ultima = tabla.getColumnCount() - 1;

                if (columna == ultima && fila >= 0) {
                    int id = ((Number) tabla.getValueAt(fila, 0)).intValue();
                    instancia.cargar_modal(id);
                }
            }
        });
    }

    //CARGAR VENTANA EMERGENTE CON LOS DETALLES DE LA FACTURA
    public void cargar_modal(int id) {
        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
        Detalles dialog = new Detalles(parent, true, id, query, tipo_detalle);
        dialog.estadoC(true);
        dialog.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        redondear_bordes1 = new interfaz.Redondear_bordes();
        titulo1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        t_mes = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        cantidad = new javax.swing.JLabel();
        monto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(240, 240, 240));

        redondear_bordes1.setBackground(new java.awt.Color(242, 242, 242));
        redondear_bordes1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        redondear_bordes1.setRoundBottomLeft(50);
        redondear_bordes1.setRoundBottomRight(50);
        redondear_bordes1.setRoundTopLeft(50);
        redondear_bordes1.setRoundTopRight(50);

        titulo1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titulo1.setText("Historial de Entradas");

        jButton1.setBackground(new java.awt.Color(220, 53, 69));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("x");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PROVEEDOR", "FECHA", "HORA", "MONTO", "DETALLES"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
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
        t_mes.setViewportView(tabla);

        cantidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cantidad.setText("Total de Entradas:");

        monto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        monto.setText("Monto Total:");

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
                .addComponent(titulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, redondear_bordes1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(t_mes, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(redondear_bordes1Layout.createSequentialGroup()
                        .addComponent(cantidad)
                        .addGap(196, 196, 196)
                        .addComponent(monto)))
                .addGap(23, 23, 23))
        );
        redondear_bordes1Layout.setVerticalGroup(
            redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(t_mes, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidad)
                    .addComponent(monto))
                .addContainerGap(43, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        modal.cerrarDialogo(this);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cantidad;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel monto;
    private interfaz.Redondear_bordes redondear_bordes1;
    private javax.swing.JScrollPane t_mes;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel titulo1;
    // End of variables declaration//GEN-END:variables
}
