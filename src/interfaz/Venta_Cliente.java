package interfaz;

import database.Metodos_Select;
import database.Metodos_Insert;
import database.Metodos_Update;
import email.Email;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import object.User_sesion;
import principal.PDF;
import principal.Validacion;
import style.Style;

public class Venta_Cliente extends javax.swing.JPanel {

    private float acum_iva = 0, acum_sub = 0;
    Modal modal = new Modal();
    Validacion validar = new Validacion();
    User_sesion user = null;

    //COSTRUCTOR
    public Venta_Cliente(User_sesion user) {
        this.user = user;
        Style look = new Style();
        look.Style();//APLICAR LOOK AND FEEL A LA INTERFAZ
        initComponents();
        num.setText("ID: 000" + (new Metodos_Select().obtenerID_salida("cab_salida") + 1));//MOSTRAR EL NUMERO DE FACTURA SIGUIENTEE
        inicializar();
        alinearColumnas(tabla_entrada);//ALINEAR EL TEXTO

    }

    //REALIZAR ACCION PARA INSERTAR DATOS EN LA BITACORA
    public void cargar_bitacora() {
        Validacion fech = new Validacion();
        String accion = "Registro una Salida.";
        new Metodos_Insert().post_bitacora(user.getCedula(), user.getNombre(), fech.crear_fecha(), fech.hora(), accion);
    }

    //INICIALIZAR BTN, OCULTAR LOS BTN NECESARIOS
    public void inicializar() {
        limpiar_cliente.setEnabled(false);
        limpiar_factura.setEnabled(false);
        generar.setEnabled(false);
        insertar.setEnabled(false);
        cod_producto.setEnabled(false);
        cantidad.setEnabled(false);
    }

    //AL AGREGAR UN CLIENTE SE MUESTRAN LOS DATOS EN EL PANEL, ESTO SE LLAMA DESDE EL PANEL DE NUEVO CLIENTE DESPUES DE INSERTARLO
    public void preparar(Object[] datos, boolean x) {
        if (x) {
            cedula.setText(String.valueOf(datos[0]));
        }
        cedula_cliente.setText("Cédula: " + cedula.getText());
        cliente_nom.setText("Nombre: " + datos[1]);
        cliente_tlfn.setText("Telefono: " + datos[2]);
        cliente_direc.setText("Email: " + datos[3]);
        buscarc.setEnabled(false);//OCULTAR Y MOSTRAR LOS BTN CORRESPONDIENTES
        nuevo_c.setEnabled(false);
        limpiar_cliente.setEnabled(true);
        limpiar_factura.setEnabled(true);
        generar.setEnabled(true);
        insertar.setEnabled(true);
        cod_producto.setEnabled(true);
        cantidad.setEnabled(true);
        cedula.setEnabled(false);
    }

    //VALIDA LA CEDULA DEL CLIENTE
    public boolean validacion() {
        if (!validar.validarCedula(cedula.getText().trim())) {
            return false;
        }
        return true;
    }

    //VALIDA EL CODIGO Y LA CANTIDAD DEL PRODUCTO
    public boolean validacion2() {
        if (!validar.validarCodigoProducto(cod_producto.getText().trim())) {
            return false;
        }
        if (!validar.validarCantidadProducto(cantidad.getText().trim())) {
            return false;
        }
        return true;
    }

    //COMPROBAR LAS CANTIDADES
    public boolean validar_cantidades() {
        int cant_actual = new Metodos_Select().obtener_infstock(Integer.parseInt(cod_producto.getText().trim()), "cantidad");
        if (cant_actual == -1) {//SI ACTUAL ES -1 FALLO LA CONSULTA
            return false;
        }
        if (Integer.parseInt(cantidad.getText().trim()) > cant_actual) {//SI CANTIDAD ES MAYOR A ACTUAL NO SE PUEDE COMPRAR, FALTA STOCK
            JOptionPane.showMessageDialog(null, "LA CANTIDAD DE VENTA SUPERA LA CANTIDAD DEL STOCK DISPONIBLE DEL PRODUCTO", "ERROR DE ENTRADA", 0);
            return false;
        }
        return true;
    }

    //ALINEAR EL TEXTO DE LA TABLA PARA MEJOR APAIENCIA VISUAL
    public void alinearColumnas(JTable tabla) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.LEFT);
        for (int i = 0; i < tabla.getColumnModel().getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }

    //ABRIR PANTALLA PARA MOSTRAR LOS DETALLES DE LA FACTURA
    public void cargar_modal(int id) {
        modal.agregarFondoOpaco(this);
        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
        Detalles dialog = new Detalles(parent, true, id, "cab_salida", "detalle_salida");
        dialog.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        redondear_bordes2 = new interfaz.Redondear_bordes();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_entrada = new javax.swing.JTable();
        num = new javax.swing.JLabel();
        sub_total = new javax.swing.JLabel();
        iva = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        cod_producto = new javax.swing.JTextField();
        cantidad = new javax.swing.JTextField();
        insertar = new javax.swing.JButton();
        redondear_bordes1 = new interfaz.Redondear_bordes();
        cedula = new javax.swing.JTextField();
        buscarc = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cedula_cliente = new javax.swing.JLabel();
        cliente_nom = new javax.swing.JLabel();
        cliente_tlfn = new javax.swing.JLabel();
        cliente_direc = new javax.swing.JLabel();
        nuevo_c = new javax.swing.JButton();
        limpiar_cliente = new javax.swing.JButton();
        limpiar_factura = new javax.swing.JButton();
        generar = new javax.swing.JButton();

        redondear_bordes2.setBackground(new java.awt.Color(255, 255, 255));
        redondear_bordes2.setRoundBottomLeft(50);
        redondear_bordes2.setRoundBottomRight(50);
        redondear_bordes2.setRoundTopLeft(50);
        redondear_bordes2.setRoundTopRight(50);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Detalles de factura");

        tabla_entrada.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabla_entrada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Precio", "Iva %", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_entrada.setMaximumSize(new java.awt.Dimension(375, 0));
        tabla_entrada.setRowHeight(25);
        tabla_entrada.setSelectionBackground(new java.awt.Color(0, 0, 153));
        tabla_entrada.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tabla_entrada);

        num.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        num.setText("Id: ");

        sub_total.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sub_total.setText("Sub Total $:");

        iva.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        iva.setText("Iva $:");

        total.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        total.setText("Total $:");

        cod_producto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Código", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        cantidad.setBorder(javax.swing.BorderFactory.createTitledBorder("Cantidad"));

        insertar.setBackground(new java.awt.Color(0, 0, 153));
        insertar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        insertar.setForeground(new java.awt.Color(255, 255, 255));
        insertar.setText("Insertar");
        insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout redondear_bordes2Layout = new javax.swing.GroupLayout(redondear_bordes2);
        redondear_bordes2.setLayout(redondear_bordes2Layout);
        redondear_bordes2Layout.setHorizontalGroup(
            redondear_bordes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redondear_bordes2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(redondear_bordes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, redondear_bordes2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(redondear_bordes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(redondear_bordes2Layout.createSequentialGroup()
                                .addComponent(num, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(220, 220, 220)
                                .addComponent(sub_total))
                            .addGroup(redondear_bordes2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(iva)))
                        .addGap(110, 110, 110)
                        .addComponent(total)
                        .addGap(120, 120, 120))
                    .addGroup(redondear_bordes2Layout.createSequentialGroup()
                        .addGroup(redondear_bordes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(redondear_bordes2Layout.createSequentialGroup()
                                .addComponent(cod_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(insertar)))
                        .addGap(15, 15, 15))))
            .addGroup(redondear_bordes2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        redondear_bordes2Layout.setVerticalGroup(
            redondear_bordes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redondear_bordes2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(redondear_bordes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(redondear_bordes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cod_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(insertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(redondear_bordes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(num)
                    .addComponent(sub_total))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(redondear_bordes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iva)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        redondear_bordes1.setBackground(new java.awt.Color(255, 255, 255));
        redondear_bordes1.setRoundBottomLeft(50);
        redondear_bordes1.setRoundBottomRight(50);
        redondear_bordes1.setRoundTopLeft(50);
        redondear_bordes1.setRoundTopRight(50);

        cedula.setBorder(javax.swing.BorderFactory.createTitledBorder("Cedula"));

        buscarc.setBackground(new java.awt.Color(40, 167, 69));
        buscarc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buscarc.setForeground(new java.awt.Color(255, 255, 255));
        buscarc.setText("Buscar");
        buscarc.setPreferredSize(new java.awt.Dimension(90, 31));
        buscarc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarcActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Información del Cliente");

        cedula_cliente.setText("Cédula: ");

        cliente_nom.setText("Nombre:  ");

        cliente_tlfn.setText("Teléfono: ");

        cliente_direc.setText("Email:");

        nuevo_c.setBackground(new java.awt.Color(0, 51, 153));
        nuevo_c.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nuevo_c.setForeground(new java.awt.Color(255, 255, 255));
        nuevo_c.setText("Nuevo");
        nuevo_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo_cActionPerformed(evt);
            }
        });

        limpiar_cliente.setBackground(new java.awt.Color(220, 53, 69));
        limpiar_cliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        limpiar_cliente.setForeground(new java.awt.Color(255, 255, 255));
        limpiar_cliente.setText("Limpiar");
        limpiar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar_clienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout redondear_bordes1Layout = new javax.swing.GroupLayout(redondear_bordes1);
        redondear_bordes1.setLayout(redondear_bordes1Layout);
        redondear_bordes1Layout.setHorizontalGroup(
            redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, redondear_bordes1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(buscarc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(nuevo_c, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(redondear_bordes1Layout.createSequentialGroup()
                        .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(cedula))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, redondear_bordes1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, redondear_bordes1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cliente_nom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cedula_cliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cliente_tlfn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cliente_direc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(68, 68, 68)))
                        .addGap(9, 9, 9)))
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, redondear_bordes1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(limpiar_cliente)
                .addGap(124, 124, 124))
        );
        redondear_bordes1Layout.setVerticalGroup(
            redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel7)
                .addGap(30, 30, 30)
                .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarc, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevo_c, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(cedula_cliente)
                .addGap(26, 26, 26)
                .addComponent(cliente_nom)
                .addGap(26, 26, 26)
                .addComponent(cliente_tlfn)
                .addGap(26, 26, 26)
                .addComponent(cliente_direc)
                .addGap(40, 40, 40)
                .addComponent(limpiar_cliente)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        limpiar_factura.setBackground(new java.awt.Color(220, 53, 69));
        limpiar_factura.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        limpiar_factura.setForeground(new java.awt.Color(255, 255, 255));
        limpiar_factura.setText("Limpiar");
        limpiar_factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar_facturaActionPerformed(evt);
            }
        });

        generar.setBackground(new java.awt.Color(40, 167, 69));
        generar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        generar.setForeground(new java.awt.Color(255, 255, 255));
        generar.setText("Generar");
        generar.setToolTipText("");
        generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(redondear_bordes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(redondear_bordes2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(limpiar_factura, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(generar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(redondear_bordes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(redondear_bordes2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limpiar_factura, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    //ACCION BTN PARA INSERTAR PRODUCTO EN DETALLES
    private void insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarActionPerformed
        if (validacion2()) {
            int cod = Integer.parseInt(cod_producto.getText().trim());
            Object[] datos = new Metodos_Select().get_prod(cod);//OBTENER INFO DEL PRODUCTO
            int cant = Integer.parseInt(cantidad.getText().trim());
            if (datos.length > 1) {
                if (validar_cantidades()) {
                    DefaultTableModel modelo = (DefaultTableModel) tabla_entrada.getModel();//INSERTAR LOS DATOS EN LA TABLA
                    Object[] datosFiltrados = new Object[]{datos[0], datos[1], datos[2], datos[3], cant};
                    modelo.addRow(datosFiltrados);
                    cod_producto.setText("");
                    cantidad.setText("");
                    calculo_label(Float.parseFloat(datos[2].toString()), Float.parseFloat(datos[3].toString()), cant);//MOSTRAR CALCULO EN LABEL
                }
            }
        }
    }//GEN-LAST:event_insertarActionPerformed
    //REALIZAR CALCULO DE IVA, SUB Y TOTAL Y MOSTRAR EN LOS LABEL
    public void calculo_label(float pre, float iv, int cant) {
        acum_sub += pre * cant;
        acum_iva += (pre * (iv / 100)) * cant;
        sub_total.setText(String.format("Sub Total $: %.2f", acum_sub));
        iva.setText(String.format("IVA $: %.2f", acum_iva));
        total.setText(String.format("Monto Total $: %.2f", (acum_iva + acum_sub)));
    }

    //ACCION BTN BUSCAR UN CLIENTE
    private void buscarcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarcActionPerformed
        if (validacion()) {
            int cod = Integer.parseInt(cedula.getText().trim());
            Object[] datos = new Metodos_Select().get_cliente(cod);
            if (datos.length > 1) {
                preparar(datos, false);
            }
        }
    }//GEN-LAST:event_buscarcActionPerformed

    //SUMA DE SUB MAS IVA Y RETORNA EL TOTAL
    public float monto_total(float x, float y) {
        return x + y;
    }

    //ACCION BTN GENERAR FACTURA
    private void generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarActionPerformed
        Validacion fech = new Validacion();
        int totalFilas = tabla_entrada.getRowCount();
        //cabezera
        if (totalFilas == 0) {// SI LA TABLA ESTA VACIA DA ERROR
            JOptionPane.showMessageDialog(null, "La Factura no puede estar vacia.", "Error", 0);
            return;
        }
        int ced = Integer.parseInt(cedula.getText().trim());
        new Metodos_Insert().post_cab_salida(ced, fech.crear_fecha(), fech.hora(), monto_total(acum_iva, acum_sub));// INSERTAR CABECERA DE FACTURA
        //detalles
        int valor0, valor4, numfac = new Metodos_Select().obtenerID_salida("cab_salida");
        String valor1;
        float valor2, valor3;
        for (int i = 0; i < totalFilas; i++) {//RECORRER TODA LA TABLA E INSERTAR EN DETALLES DE FACTURA
            try {
                valor0 = Integer.parseInt(tabla_entrada.getValueAt(i, 0).toString());
                valor1 = tabla_entrada.getValueAt(i, 1).toString();
                valor2 = Float.parseFloat(tabla_entrada.getValueAt(i, 2).toString());
                valor3 = Float.parseFloat(tabla_entrada.getValueAt(i, 3).toString());
                valor4 = Integer.parseInt(tabla_entrada.getValueAt(i, 4).toString());
                new Metodos_Insert().post_det_salida(numfac, valor0, valor1, valor2, valor3, valor4);//INSERTAR EN LOS DETALLES DE LA FACTURA
                new Metodos_Update().actualizar_stock(-valor4, valor0);//ACTUALIZAR EL STOCK DEL PRODUCTO
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error al Generar Factura", "Error", 0);
            }
        }
        cargar_modal(numfac);
        cargar_bitacora();//REGISTRAR ACCION EN LA BITACORA
        limpiar();//LIMPIAR FORMULARIO
        inicializar();
        new PDF().generar(numfac, "detalle_salida", "cab_salida", "Venta");//GENERAR PDF
        Object[] entidad = new Metodos_Select().get_cliente(ced);
        String mail = String.valueOf(entidad[3]);
        System.out.println("Email :" + mail);
        new Email().generar_email("Cliente", mail, numfac);
    }//GEN-LAST:event_generarActionPerformed

    //ACCION BTN ABRIR PANEL PARA REGISTRAR UN NUEVO CLIENTE
    private void nuevo_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo_cActionPerformed
        modal.agregarFondoOpaco(this);
        JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
        Nuevo_Cliente dialog = new Nuevo_Cliente(parent, true, this, user);
        dialog.setVisible(true);
    }//GEN-LAST:event_nuevo_cActionPerformed

    //ACCION BTN LIMPIAR EL FORMULARIO
    private void limpiar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar_clienteActionPerformed
        cedula_cliente.setText("Cedula: ");
        cliente_nom.setText("Nombre: ");
        cliente_tlfn.setText("Telefono: ");
        cliente_direc.setText("Email: ");
        cedula.setText("");
        buscarc.setEnabled(true);
        nuevo_c.setEnabled(true);
        cedula.setEnabled(true);
        inicializar();
    }//GEN-LAST:event_limpiar_clienteActionPerformed

    //LIMPIAR DETALLE DE FACTURA, VACIA EL FORMULARIO
    private void limpiar_facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar_facturaActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tabla_entrada.getModel();
        cod_producto.setText("");
        cantidad.setText("");
        sub_total.setText("Sub Total: ");
        iva.setText("Iva: ");
        total.setText("Monto Total: ");
        modelo.setRowCount(0);
    }//GEN-LAST:event_limpiar_facturaActionPerformed

    //LIMPIAR TODO EL FORMULARIO DE DETALLES DE FACTURA
    public void limpiar() {
        DefaultTableModel modelo = (DefaultTableModel) tabla_entrada.getModel();
        cedula_cliente.setText("Cedula: ");
        cliente_nom.setText("Nombre: ");
        cliente_tlfn.setText("Telefono: ");
        cliente_direc.setText("Email: ");
        cedula.setText("");
        cod_producto.setText("");
        cantidad.setText("");
        sub_total.setText("Sub Total: ");
        iva.setText("Iva: ");
        total.setText("Monto Total: ");
        modelo.setRowCount(0);
        buscarc.setEnabled(true);
        cedula.setEnabled(true);
        nuevo_c.setEnabled(true);
        num.setText("Id: 000" + (new Metodos_Select().obtenerID_salida("cab_salida") + 1));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarc;
    private javax.swing.JTextField cantidad;
    public javax.swing.JTextField cedula;
    private javax.swing.JLabel cedula_cliente;
    private javax.swing.JLabel cliente_direc;
    private javax.swing.JLabel cliente_nom;
    private javax.swing.JLabel cliente_tlfn;
    private javax.swing.JTextField cod_producto;
    private javax.swing.JButton generar;
    private javax.swing.JButton insertar;
    private javax.swing.JLabel iva;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiar_cliente;
    private javax.swing.JButton limpiar_factura;
    private javax.swing.JButton nuevo_c;
    private javax.swing.JLabel num;
    private interfaz.Redondear_bordes redondear_bordes1;
    private interfaz.Redondear_bordes redondear_bordes2;
    private javax.swing.JLabel sub_total;
    private javax.swing.JTable tabla_entrada;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
