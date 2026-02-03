package interfaz;

import database.Metodos_Select;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import style.Style;

public class Reporte_entrada extends javax.swing.JPanel {

    public float totalm, total_q1, total_q2, totals1, totals2, totals3, totals4;
    public int cantm, cantq1, cantq2, cants1, cants2, cants3, cants4;

    Modal modal = new Modal();
    Metodos_Select met = new Metodos_Select();
    JTable[] tablas;
    int posicion_semana_actual = 1;
    String seleccionado, tipo_consulta, tipo_detalle;

    //CONSTRUCTOR
    public Reporte_entrada() {
        Style look = new Style();
        look.Style();//APLICAR LOOK AND FEEL A LA CLASE
        initComponents();
        this.tablas = new JTable[]{tabla_reporte, quincena1, quincena2, sem1, sem2, sem3, sem4};//OCULTAR TABLAS DE REPORTES
        inicializar();
        cargarProductosEnTabla();//CARGAR PRODUCTOS EN LA TABLA
        calculo_total(); //CALCULOS EN LABEL
    }

    //CARGAR TODOS LOS PRODUCTOS EN LA TABLA DE REPORTES DE PRODUCTOS
    public void cargarProductosEnTabla() {
        DefaultTableModel modelo = (DefaultTableModel) t_producto.getModel();
        modelo.setRowCount(0);
        met.get_productos(modelo, "WHERE estado = true");//CONSULTA E INSECION EN LA TABLA
        alinearColumnas(t_producto);
    }

    //MOSTRAR CALCULO REFERENTE A LA TABAL EN LABEL
    public void calculo_total() {
        int totalFilas = t_producto.getRowCount();
        float monto = 0;
        int contador = 0;
        for (int i = 0; i < totalFilas; i++) {//RECORRER TODOS LO PREODUCTOS PARA OBTENER PRECIO, IVA Y CANTIDAD
            try {
                float prec = Float.parseFloat(t_producto.getValueAt(i, 3).toString());
                int canti = Integer.parseInt(t_producto.getValueAt(i, 5).toString());
                monto += prec * canti;//MONTO DEL INVETNARIO
                contador += canti;//CANTIDAD DE PRODUCTOS
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error al Generar Factura", "Error", 0);
            }
        }
        //
        l_valor.setText(String.format("Valor del Inventario: %.2f", monto));//MOSTRAR VALORES EN LOS LABEL
        l_cantidad.setText("Cantidad de Productos en Inventario: " + contador);

    }

    //INICIALIZAR LA INTERFAZ
    public void inicializar() {//OCULTA LAS TABLAS DE REPORTES
        atras_quincena.setVisible(false);
        atras_semana.setVisible(false);
        tquince2.setVisible(false);
        tsemana2.setVisible(false);
        tsemana3.setVisible(false);
        tsemana4.setVisible(false);

        funcion_btn(tabla_reporte, this);//DAR FUNCION DE EVENTO AL LABEL DE TODAS LAS TABLAS
        funcion_btn(quincena1, this);
        funcion_btn(quincena2, this);
        funcion_btn(sem1, this);
        funcion_btn(sem2, this);
        funcion_btn(sem3, this);
        funcion_btn(sem4, this);

        num_mes.setEnabled(false);
        buscar.setEnabled(false);
    }

    public void alinearColumnas(JTable x) {//ALINEAR EL TEXTO DE TODAS LAS COLUMNAS DE TODAS LAS TABLAS
        TableColumnModel columnModel = x.getColumnModel(); // Obtener el modelo de columnas
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.LEFT);

        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            columnModel.getColumn(i).setCellRenderer(renderer);
        }
    }

    //CALCULO PARA MOSTRAR EN EL LABEL DE LOS REPORTES
    public float calculo_ing(JTable tablas) {
        float total = 0;
        int totalFilas = tablas.getRowCount();

        for (int i = 0; i < totalFilas; i++) {
            float valor = Float.parseFloat(tablas.getValueAt(i, 5).toString());
            total += valor;
        }
        return total;
    }

    //INICIAR TODOS LOS LABEL DE LOS PANELES DE LOS REPORTES
    public void llenar_label() {
        totalm = calculo_ing(tabla_reporte);//HACER EL CALCULO PARA TODAS LAS TABLAS, MES, QUINCENA, SEMANA
        cantm = tabla_reporte.getRowCount();
        total_q1 = calculo_ing(quincena1);
        cantq1 = quincena1.getRowCount();
        total_q2 = calculo_ing(quincena2);
        cantq2 = quincena2.getRowCount();
        totals1 = calculo_ing(sem1);
        cants1 = sem1.getRowCount();
        totals2 = calculo_ing(sem2);
        cants2 = sem2.getRowCount();
        totals3 = calculo_ing(sem3);
        cants3 = sem3.getRowCount();
        totals4 = calculo_ing(sem4);
        cants4 = sem4.getRowCount();
        m_total.setText(String.format("Importe Total: %.2f", totalm));//INSERTAR EL CALCULO EN LOS LABELS
        cant.setText("Cantidad de Entradas: " + (cantm));
        q_total1.setText(String.format("Importe Total: %.2f", total_q1));
        cant_q1.setText("Cantidad de Entradas: " + (cantq1));
        label_ts.setText(String.format("Importe Total: %.2f", totals1));
        label_cs.setText("Cantidad de Entradas: " + (cants1));
        num_quincena.setText(seleccionado + ": Quincena 1 / 2");
        posicion_sem.setText(seleccionado + ": Semana 1 / 4");
        mes_select.setText(seleccionado);
    }

    //APLICAR ESTILO DE LINK AL LABEL DE LAS TABLAS
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

    //APLICAR EVENTO AL LABEL DE LINKS DE LAS TABLAS
    public static void funcion_btn(JTable tabla_reporte, Reporte_entrada instancia) {
        tabla_reporte.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int fila = tabla_reporte.rowAtPoint(e.getPoint());
                int columna = tabla_reporte.columnAtPoint(e.getPoint());
                int ultima = tabla_reporte.getColumnCount() - 1;

                if (columna == ultima && fila >= 0) {
                    int id = ((Number) tabla_reporte.getValueAt(fila, 1)).intValue();
                    instancia.cargar_modal(id);

                }
            }
        });
    }

    //ABRIR EL PANEL CUANDO SE PRECIONA EL LABEL DE DETALLES, ESTE PANEL MUESTRA LOS DETALLES DE LA FACTURA
    public void cargar_modal(int id) {
        modal.agregarFondoOpaco(this);
        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
        Detalles dialog = new Detalles(parent, true, id, tipo_consulta, tipo_detalle);
        dialog.setVisible(true);
    }

    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor = new javax.swing.JPanel();
        general = new interfaz.Redondear_bordes();
        jLabel1 = new javax.swing.JLabel();
        l_cantidad = new javax.swing.JLabel();
        l_valor = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_producto = new javax.swing.JTable();
        reportes_mes = new interfaz.Redondear_bordes();
        titulo_m = new javax.swing.JLabel();
        t_mes = new javax.swing.JScrollPane();
        tabla_reporte = new javax.swing.JTable();
        cant = new javax.swing.JLabel();
        m_total = new javax.swing.JLabel();
        mes_select = new javax.swing.JLabel();
        quincena_1 = new interfaz.Redondear_bordes();
        titulo_q = new javax.swing.JLabel();
        tquince1 = new javax.swing.JScrollPane();
        quincena1 = new javax.swing.JTable();
        tquince2 = new javax.swing.JScrollPane();
        quincena2 = new javax.swing.JTable();
        num_quincena = new javax.swing.JLabel();
        adelante_quincena = new javax.swing.JButton();
        atras_quincena = new javax.swing.JButton();
        cant_q1 = new javax.swing.JLabel();
        q_total1 = new javax.swing.JLabel();
        semanal = new interfaz.Redondear_bordes();
        titulo_sem = new javax.swing.JLabel();
        atras_semana = new javax.swing.JButton();
        avanzar_semana = new javax.swing.JButton();
        posicion_sem = new javax.swing.JLabel();
        label_cs = new javax.swing.JLabel();
        label_ts = new javax.swing.JLabel();
        tsemana4 = new javax.swing.JScrollPane();
        sem4 = new javax.swing.JTable();
        tsemana3 = new javax.swing.JScrollPane();
        sem3 = new javax.swing.JTable();
        tsemana2 = new javax.swing.JScrollPane();
        sem2 = new javax.swing.JTable();
        tsemana1 = new javax.swing.JScrollPane();
        sem1 = new javax.swing.JTable();
        redondear_bordes1 = new interfaz.Redondear_bordes();
        tipo_c = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        num_mes = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(240, 240, 240));

        general.setBackground(new java.awt.Color(255, 255, 255));
        general.setRoundBottomLeft(50);
        general.setRoundBottomRight(50);
        general.setRoundTopLeft(50);
        general.setRoundTopRight(50);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Reportes Generales");

        l_cantidad.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        l_cantidad.setText("Cantidad de Productos en Inventario:");

        l_valor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        l_valor.setText("Valor de Inventario:");

        jButton1.setBackground(new java.awt.Color(220, 53, 69));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Historial de Salidas");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(40, 167, 69));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Historial de Entradas");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        t_producto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        t_producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Codigo", "Nombre", "Precio", "Iva", "Cantidad", "MIN", "MAX"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(t_producto);
        if (t_producto.getColumnModel().getColumnCount() > 0) {
            t_producto.getColumnModel().getColumn(6).setPreferredWidth(15);
            t_producto.getColumnModel().getColumn(7).setPreferredWidth(15);
        }

        javax.swing.GroupLayout generalLayout = new javax.swing.GroupLayout(general);
        general.setLayout(generalLayout);
        generalLayout.setHorizontalGroup(
            generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(generalLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(generalLayout.createSequentialGroup()
                        .addGroup(generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_cantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                            .addComponent(l_valor))
                        .addGap(110, 110, 110)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(50, 50, 50)))
                .addGap(16, 16, 16))
        );
        generalLayout.setVerticalGroup(
            generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addGroup(generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(generalLayout.createSequentialGroup()
                        .addComponent(l_cantidad)
                        .addGap(18, 18, 18)
                        .addComponent(l_valor))
                    .addGroup(generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(79, 79, 79))
        );

        reportes_mes.setBackground(new java.awt.Color(255, 255, 255));
        reportes_mes.setRoundBottomLeft(50);
        reportes_mes.setRoundBottomRight(50);
        reportes_mes.setRoundTopLeft(50);
        reportes_mes.setRoundTopRight(50);

        titulo_m.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titulo_m.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo_m.setText("REPORTES MENSUALES");

        tabla_reporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "ID", "PROVEEDOR", "FECHA", "HORA", "MONTO", "DETALLES"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_reporte.setRowHeight(25);
        tabla_reporte.setSelectionBackground(new java.awt.Color(0, 0, 153));
        tabla_reporte.setSelectionForeground(new java.awt.Color(255, 255, 255));
        t_mes.setViewportView(tabla_reporte);
        if (tabla_reporte.getColumnModel().getColumnCount() > 0) {
            tabla_reporte.getColumnModel().getColumn(1).setPreferredWidth(50);
            tabla_reporte.getColumnModel().getColumn(2).setPreferredWidth(120);
            tabla_reporte.getColumnModel().getColumn(3).setPreferredWidth(110);
            tabla_reporte.getColumnModel().getColumn(4).setPreferredWidth(100);
            tabla_reporte.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        cant.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cant.setText("Numero de Entradas:");

        m_total.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        m_total.setText("Importe Total:");

        mes_select.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        mes_select.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mes_select.setText("Mes");

        javax.swing.GroupLayout reportes_mesLayout = new javax.swing.GroupLayout(reportes_mes);
        reportes_mes.setLayout(reportes_mesLayout);
        reportes_mesLayout.setHorizontalGroup(
            reportes_mesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titulo_m, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reportes_mesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(reportes_mesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cant)
                    .addComponent(m_total))
                .addGap(240, 240, 240))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reportes_mesLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(reportes_mesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mes_select, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_mes))
                .addGap(30, 30, 30))
        );
        reportes_mesLayout.setVerticalGroup(
            reportes_mesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportes_mesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(titulo_m, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(t_mes, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(cant)
                .addGap(18, 18, 18)
                .addComponent(m_total)
                .addGap(18, 18, 18)
                .addComponent(mes_select)
                .addGap(20, 20, 20))
        );

        quincena_1.setBackground(new java.awt.Color(255, 255, 255));
        quincena_1.setRoundBottomLeft(50);
        quincena_1.setRoundBottomRight(50);
        quincena_1.setRoundTopLeft(50);
        quincena_1.setRoundTopRight(50);

        titulo_q.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titulo_q.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo_q.setText("REPORTES QUINCENAL");

        tquince1.setPreferredSize(new java.awt.Dimension(486, 406));

        quincena1.setAutoCreateRowSorter(true);
        quincena1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "ID", "PROVEEDOR", "FECHA", "HORA", "MONTO", "Ver Detalles"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        quincena1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        quincena1.setRowHeight(25);
        tquince1.setViewportView(quincena1);
        if (quincena1.getColumnModel().getColumnCount() > 0) {
            quincena1.getColumnModel().getColumn(1).setPreferredWidth(50);
            quincena1.getColumnModel().getColumn(2).setPreferredWidth(120);
            quincena1.getColumnModel().getColumn(3).setPreferredWidth(110);
            quincena1.getColumnModel().getColumn(4).setPreferredWidth(100);
            quincena1.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        tquince2.setPreferredSize(new java.awt.Dimension(486, 406));

        quincena2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "ID", "PROVEEDOR", "FECHA", "HORA", "MONTO", "Ver Detalles"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        quincena2.setRowHeight(25);
        tquince2.setViewportView(quincena2);
        if (quincena2.getColumnModel().getColumnCount() > 0) {
            quincena2.getColumnModel().getColumn(1).setPreferredWidth(50);
            quincena2.getColumnModel().getColumn(2).setPreferredWidth(120);
            quincena2.getColumnModel().getColumn(3).setPreferredWidth(110);
            quincena2.getColumnModel().getColumn(4).setPreferredWidth(100);
            quincena2.getColumnModel().getColumn(5).setPreferredWidth(100);
        }

        num_quincena.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        num_quincena.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        num_quincena.setText("Quincena 1 / 2");

        adelante_quincena.setBackground(new java.awt.Color(0, 0, 153));
        adelante_quincena.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        adelante_quincena.setForeground(new java.awt.Color(255, 255, 255));
        adelante_quincena.setText(">");
        adelante_quincena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adelante_quincenaActionPerformed(evt);
            }
        });

        atras_quincena.setBackground(new java.awt.Color(0, 0, 153));
        atras_quincena.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        atras_quincena.setForeground(new java.awt.Color(255, 255, 255));
        atras_quincena.setText("<");
        atras_quincena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atras_quincenaActionPerformed(evt);
            }
        });

        cant_q1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cant_q1.setText("Numero de Entradas:");

        q_total1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        q_total1.setText("Importe Total:");
        q_total1.setRequestFocusEnabled(false);

        javax.swing.GroupLayout quincena_1Layout = new javax.swing.GroupLayout(quincena_1);
        quincena_1.setLayout(quincena_1Layout);
        quincena_1Layout.setHorizontalGroup(
            quincena_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quincena_1Layout.createSequentialGroup()
                .addComponent(titulo_q, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quincena_1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(quincena_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(q_total1)
                    .addComponent(cant_q1))
                .addGap(240, 240, 240))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quincena_1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(atras_quincena)
                .addGap(30, 30, 30)
                .addGroup(quincena_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(num_quincena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tquince2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tquince1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(adelante_quincena)
                .addGap(25, 25, 25))
        );
        quincena_1Layout.setVerticalGroup(
            quincena_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quincena_1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(titulo_q)
                .addGroup(quincena_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(quincena_1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(quincena_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tquince2, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(tquince1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)))
                    .addGroup(quincena_1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(quincena_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adelante_quincena, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(atras_quincena, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(cant_q1)
                .addGap(18, 18, 18)
                .addComponent(q_total1)
                .addGap(18, 18, 18)
                .addComponent(num_quincena)
                .addGap(20, 20, 20))
        );

        semanal.setBackground(new java.awt.Color(255, 255, 255));
        semanal.setRoundBottomLeft(50);
        semanal.setRoundBottomRight(50);
        semanal.setRoundTopLeft(50);
        semanal.setRoundTopRight(50);

        titulo_sem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titulo_sem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo_sem.setText("REPORTES SEMANALES");

        atras_semana.setBackground(new java.awt.Color(0, 0, 153));
        atras_semana.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        atras_semana.setForeground(new java.awt.Color(255, 255, 255));
        atras_semana.setText("<");
        atras_semana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atras_semanaActionPerformed(evt);
            }
        });

        avanzar_semana.setBackground(new java.awt.Color(0, 0, 153));
        avanzar_semana.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        avanzar_semana.setForeground(new java.awt.Color(255, 255, 255));
        avanzar_semana.setText(">");
        avanzar_semana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avanzar_semanaActionPerformed(evt);
            }
        });

        posicion_sem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        posicion_sem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posicion_sem.setText("Semana 1 / 4");

        label_cs.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label_cs.setText("Numero de Entradas:");

        label_ts.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        label_ts.setText("Importe Total:");

        sem4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "ID", "PROVEEDOR", "FECHA", "HORA", "MONTO", "Ver Detalles"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sem4.setRowHeight(25);
        tsemana4.setViewportView(sem4);

        sem3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "ID", "PROVEEDOR", "FECHA", "HORA", "MONTO", "Ver Detalles"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sem3.setRowHeight(25);
        tsemana3.setViewportView(sem3);

        sem2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "ID", "PROVEEDOR", "FECHA", "HORA", "MONTO", "Ver Detalles"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sem2.setRowHeight(25);
        tsemana2.setViewportView(sem2);

        sem1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "ID", "PROVEEDOR", "FECHA", "HORA", "MONTO", "Ver Detalles"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sem1.setRowHeight(25);
        tsemana1.setViewportView(sem1);

        javax.swing.GroupLayout semanalLayout = new javax.swing.GroupLayout(semanal);
        semanal.setLayout(semanalLayout);
        semanalLayout.setHorizontalGroup(
            semanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titulo_sem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(semanalLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(atras_semana)
                .addGap(30, 30, 30)
                .addGroup(semanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(semanalLayout.createSequentialGroup()
                        .addComponent(posicion_sem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(97, 97, 97))
                    .addGroup(semanalLayout.createSequentialGroup()
                        .addGroup(semanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tsemana1)
                            .addComponent(tsemana2)
                            .addComponent(tsemana3)
                            .addComponent(tsemana4))
                        .addGap(30, 30, 30)
                        .addComponent(avanzar_semana)
                        .addGap(25, 25, 25))))
            .addGroup(semanalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(semanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_cs, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label_ts, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(240, 240, 240))
        );
        semanalLayout.setVerticalGroup(
            semanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(semanalLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(titulo_sem)
                .addGap(20, 20, 20)
                .addGroup(semanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tsemana2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(tsemana3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(tsemana4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(tsemana1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(semanalLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(semanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(avanzar_semana, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(atras_semana, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 91, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(label_cs)
                .addGap(18, 18, 18)
                .addComponent(label_ts)
                .addGap(18, 18, 18)
                .addComponent(posicion_sem, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        redondear_bordes1.setBackground(new java.awt.Color(255, 255, 255));
        redondear_bordes1.setRoundBottomLeft(50);
        redondear_bordes1.setRoundBottomRight(50);
        redondear_bordes1.setRoundTopLeft(50);
        redondear_bordes1.setRoundTopRight(50);

        tipo_c.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Entradas", "Salidas" }));
        tipo_c.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton2.setBackground(new java.awt.Color(40, 167, 69));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Consultar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buscar.setBackground(new java.awt.Color(0, 0, 153));
        buscar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buscar.setForeground(new java.awt.Color(255, 255, 255));
        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        num_mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        num_mes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CONSULTAR FACTURAS");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tipo de Factura:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Mes de Consulta:");

        javax.swing.GroupLayout redondear_bordes1Layout = new javax.swing.GroupLayout(redondear_bordes1);
        redondear_bordes1.setLayout(redondear_bordes1Layout);
        redondear_bordes1Layout.setHorizontalGroup(
            redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(redondear_bordes1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(redondear_bordes1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                                .addComponent(tipo_c, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                                .addComponent(num_mes, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        redondear_bordes1Layout.setVerticalGroup(
            redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, redondear_bordes1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipo_c, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(num_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(redondear_bordes1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(general, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(semanal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quincena_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reportes_mes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(general, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(redondear_bordes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(reportes_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(quincena_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(semanal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        //EVENTO PARA SELECCIONAR EL MES DE LA CONSULTA DE LOS REPORTES
        seleccionado = num_mes.getSelectedItem().toString();
        int numMes = num_mes(seleccionado);
        if (numMes >= 1 && numMes <= 12) {
            orgarnizar_tablas(numMes);
            llenar_label();
            aplicarEstilo(tabla_reporte);//APLICAR ESTILO DE LINK A TODAS LAS TABLAS
            aplicarEstilo(quincena1);
            aplicarEstilo(quincena2);
            aplicarEstilo(sem1);
            aplicarEstilo(sem2);
            aplicarEstilo(sem3);
            aplicarEstilo(sem4);
        }
    }//GEN-LAST:event_buscarActionPerformed

    //ACCION BTN DE ADELANTE, PARA MOSTRAR LA SIGUIENTE TABLA DE QUINCENA
    private void adelante_quincenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adelante_quincenaActionPerformed
        tquince1.setVisible(false);
        tquince2.setVisible(true);
        //habilitar btn
        atras_quincena.setVisible(true);
        adelante_quincena.setVisible(false);
        num_quincena.setText(seleccionado + ": Quincena 2 / 2");
        q_total1.setText(String.format("Importe Total: %.2f", total_q2));
        cant_q1.setText("Cantidad de Entradas: " + (cantq2));

    }//GEN-LAST:event_adelante_quincenaActionPerformed

    //ACCION BTN PARA MOSTRAR LA TABLA DE QUINCENA ANTERIOR
    private void atras_quincenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atras_quincenaActionPerformed
        tquince2.setVisible(false);
        tquince1.setVisible(true);
        //habilitar btn
        adelante_quincena.setVisible(true);
        atras_quincena.setVisible(false);
        num_quincena.setText(seleccionado + ": Quincena 1 / 2");
        q_total1.setText(String.format("Importe Total: %.2f", total_q1));
        cant_q1.setText("Cantidad de Entradas: " + (cantq1));
    }//GEN-LAST:event_atras_quincenaActionPerformed

    //ACCION BTN DE CARGAR SIGUIENTE TABLA DE LA SEMANA
    private void avanzar_semanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avanzar_semanaActionPerformed
        if (posicion_semana_actual >= 1 && posicion_semana_actual <= 4) {
            switch (posicion_semana_actual) {
                case 1 -> {//SI EL BTN ES 1 SE MUESTRA TABLA 2 Y SE OCULTA 1
                    tsemana1.setVisible(false);
                    tsemana2.setVisible(true);
                    atras_semana.setVisible(true);
                    posicion_sem.setText(seleccionado + ": Semana 2 / 4");
                    label_ts.setText(String.format("Importe Total: %.2f", totals2));
                    label_cs.setText("Cantidad de Entradas: " + (cants2));
                }
                case 2 -> {//SI EL BTN ES 2 SE MUESTRA TABLA 3 Y SE OCULTA 2
                    tsemana2.setVisible(false);
                    tsemana3.setVisible(true);
                    posicion_sem.setText(seleccionado + ": Semana 3 / 4");
                    label_ts.setText(String.format("Importe Total: %.2f", totals3));
                    label_cs.setText("Cantidad de Entradas: " + (cants3));
                }
                case 3 -> {//SI EL BTN ES 3 SE MUESTRA TABLA 4 Y SE OCULTA 3
                    tsemana3.setVisible(false);
                    tsemana4.setVisible(true);
                    posicion_sem.setText(seleccionado + ": Semana 4 / 4");
                    avanzar_semana.setVisible(false);
                    label_ts.setText(String.format("Importe Total: %.2f", totals4));
                    label_cs.setText("Cantidad de Entradas: " + (cants4));
                }
            }
            if (posicion_semana_actual < 4) {
                posicion_semana_actual++;
            }
        }
    }//GEN-LAST:event_avanzar_semanaActionPerformed

    //ACCION BTN DE CARGAR ANTERIOR TABLA DE LA SEMANA
    private void atras_semanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atras_semanaActionPerformed
        if (posicion_semana_actual >= 2 && posicion_semana_actual <= 4) {
            switch (posicion_semana_actual) {
                case 2 -> {// SI EL BTN ES 2 OCULTA TABLA 2 Y MUESTRA TABLA 1
                    tsemana2.setVisible(false);
                    tsemana1.setVisible(true);
                    posicion_sem.setText(seleccionado + ": Semana 1 / 4");
                    atras_semana.setVisible(false);
                    label_ts.setText(String.format("Importe Total: %.2f", totals1));
                    label_cs.setText("Cantidad de Entradas: " + (cants1));
                }
                case 3 -> {// SI EL BTN ES 3 OCULTA TABLA 3 Y MUESTRA TABLA 2
                    tsemana3.setVisible(false);
                    tsemana2.setVisible(true);
                    posicion_sem.setText(seleccionado + ": Semana 2 / 4");
                    label_ts.setText(String.format("Importe Total: %.2f", totals2));
                    label_cs.setText("Cantidad de Entradas: " + (cants2));
                }
                case 4 -> {// SI EL BTN ES 4 OCULTA TABLA 4 Y MUESTRA TABLA 3
                    tsemana4.setVisible(false);
                    tsemana3.setVisible(true);
                    posicion_sem.setText(seleccionado + ": Semana 3 / 4");
                    avanzar_semana.setVisible(true);
                    label_ts.setText(String.format("Importe Total: %.2f", totals3));
                    label_cs.setText("Cantidad de Entradas: " + (cants3));
                }
            }
            posicion_semana_actual--;
        }
    }//GEN-LAST:event_atras_semanaActionPerformed

    //ACCION LISTA PARA SELECCIONAR SI ES FACTURA DE ENTRADA O  SALIDA
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String tipo_con = tipo_c.getSelectedItem().toString();
        if (tipo_con.equalsIgnoreCase("entradas")) {//SI ES ENTRADA CONSULTA TABLA DE ENTRADAS
            tipo_consulta = "cab_factura";
            tipo_detalle = "detalle_fac";
            num_mes.setEnabled(true);
            buscar.setEnabled(true);
        } else if (tipo_con.equalsIgnoreCase("salidas")) {//SI ES SALIDA CONSULTA TABLA SALIDAS
            tipo_consulta = "cab_salida";
            tipo_detalle = "detalle_salida";
            num_mes.setEnabled(true);
            buscar.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un tipo de Consulta valido.", "Opcion Invalida", 0);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    //ACCION BTN ABRIR HISTORIAL DE FACTURAS ENTRADAS O SALIDAS
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        modal.agregarFondoOpaco(this);
        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
        Historial dialog = new Historial(parent, true, this, 1);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    //ACCION BTN ABRIR HISTORIAL DE FACTURAS ENTRADAS O SALIDAS
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        modal.agregarFondoOpaco(this);
        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
        Historial dialog = new Historial(parent, true, this, 2);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    //CAMBIAR MES A NUMERO, PARA CONSULTAR EL MES POR NUMERO
    public int num_mes(String seleccionado) {
        int numMes = 0;
        if (seleccionado.equalsIgnoreCase("enero")) {
            numMes = 1;
        } else if (seleccionado.equalsIgnoreCase("febrero")) {
            numMes = 2;
        } else if (seleccionado.equalsIgnoreCase("marzo")) {
            numMes = 3;
        } else if (seleccionado.equalsIgnoreCase("abril")) {
            numMes = 4;
        } else if (seleccionado.equalsIgnoreCase("mayo")) {
            numMes = 5;
        } else if (seleccionado.equalsIgnoreCase("junio")) {
            numMes = 6;
        } else if (seleccionado.equalsIgnoreCase("julio")) {
            numMes = 7;
        } else if (seleccionado.equalsIgnoreCase("agosto")) {
            numMes = 8;
        } else if (seleccionado.equalsIgnoreCase("septiembre")) {
            numMes = 9;
        } else if (seleccionado.equalsIgnoreCase("octubre")) {
            numMes = 10;
        } else if (seleccionado.equalsIgnoreCase("noviembre")) {
            numMes = 11;
        } else if (seleccionado.equalsIgnoreCase("diciembre")) {
            numMes = 12;
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un mes valido.", "Opcion Invalida", 0);
        }
        return numMes;
    }

    //EJECUTAR CONSULTA Y LLENAS LAS TABLAS, TODAS LAS TABLAS DE REPORTES
    public void orgarnizar_tablas(int numMes) {
        for (JTable tabla : tablas) {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            modelo.setRowCount(0);
        }
        met.get_cab_factura(numMes, (DefaultTableModel) tabla_reporte.getModel(), tipo_consulta);
        met.get_quincena(numMes, (DefaultTableModel) quincena1.getModel(), (DefaultTableModel) quincena2.getModel(), tipo_consulta);
        met.get_semanas(numMes, (DefaultTableModel) sem1.getModel(), (DefaultTableModel) sem2.getModel(),
                (DefaultTableModel) sem3.getModel(), (DefaultTableModel) sem4.getModel(), tipo_consulta);
        for (JTable tabla : tablas) {
            alinearColumnas(tabla);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adelante_quincena;
    private javax.swing.JButton atras_quincena;
    private javax.swing.JButton atras_semana;
    private javax.swing.JButton avanzar_semana;
    private javax.swing.JButton buscar;
    private javax.swing.JLabel cant;
    private javax.swing.JLabel cant_q1;
    public javax.swing.JPanel contenedor;
    private interfaz.Redondear_bordes general;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l_cantidad;
    private javax.swing.JLabel l_valor;
    private javax.swing.JLabel label_cs;
    private javax.swing.JLabel label_ts;
    private javax.swing.JLabel m_total;
    private javax.swing.JLabel mes_select;
    private javax.swing.JComboBox<String> num_mes;
    private javax.swing.JLabel num_quincena;
    private javax.swing.JLabel posicion_sem;
    private javax.swing.JLabel q_total1;
    private javax.swing.JTable quincena1;
    private javax.swing.JTable quincena2;
    private interfaz.Redondear_bordes quincena_1;
    private interfaz.Redondear_bordes redondear_bordes1;
    private interfaz.Redondear_bordes reportes_mes;
    private javax.swing.JTable sem1;
    private javax.swing.JTable sem2;
    private javax.swing.JTable sem3;
    private javax.swing.JTable sem4;
    private interfaz.Redondear_bordes semanal;
    private javax.swing.JScrollPane t_mes;
    private javax.swing.JTable t_producto;
    private javax.swing.JTable tabla_reporte;
    private javax.swing.JComboBox<String> tipo_c;
    private javax.swing.JLabel titulo_m;
    private javax.swing.JLabel titulo_q;
    private javax.swing.JLabel titulo_sem;
    private javax.swing.JScrollPane tquince1;
    private javax.swing.JScrollPane tquince2;
    private javax.swing.JScrollPane tsemana1;
    private javax.swing.JScrollPane tsemana2;
    private javax.swing.JScrollPane tsemana3;
    private javax.swing.JScrollPane tsemana4;
    // End of variables declaration//GEN-END:variables
}
