package interfaz;

import database.Metodos_Select;
import style.Style;

public class Principal extends javax.swing.JPanel {

    //CONSTRUCTOR
    public Principal() {
        Metodos_Select metodosDB = new Metodos_Select();
        Style look = new Style();
        look.Style();
        initComponents();

        num_productos.setText("" + metodosDB.contarProductos());//OBTENER CANTIDAD DE PRODUCTOS Y MOSTRAR EN EL LABEL
        num_clientes.setText("" + metodosDB.contarClientes());//OBTENER CANTIDAD DE CLIENTES Y MOSTRAR EN EL LABEL
        num_proveedores.setText("" + metodosDB.contarProveedor());//OBTENER CANTIDAD DE PROVEEDORES Y MOSTRAR EN EL LABEL
        numsalida.setText("" + metodosDB.contarFactura("cab_salida"));//OBTENER CANTIDAD DE SALIDAS O VENTAS Y MOSTRAR EN EL LABEL
        numentradas.setText("" + metodosDB.contarFactura("cab_factura"));//OBTENER CANTIDAD DE ENTRADAS O COMPRAS Y MOSTRAR EN EL LABEL
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        redondear_bordes1 = new interfaz.Redondear_bordes();
        sub_panel1 = new interfaz.Redondear_bordes();
        num_productos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        sub_panel2 = new interfaz.Redondear_bordes();
        num_clientes = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        sub_panel3 = new interfaz.Redondear_bordes();
        jLabel7 = new javax.swing.JLabel();
        num_proveedores = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        sub_panel5 = new interfaz.Redondear_bordes();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        numsalida = new javax.swing.JLabel();
        sub_panel4 = new interfaz.Redondear_bordes();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        numentradas = new javax.swing.JLabel();
        redondear_bordes2 = new interfaz.Redondear_bordes();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(240, 240, 240));

        jPanel1.setBackground(new java.awt.Color(240, 240, 240));

        redondear_bordes1.setBackground(new java.awt.Color(255, 255, 255));
        redondear_bordes1.setRoundBottomLeft(50);
        redondear_bordes1.setRoundBottomRight(50);
        redondear_bordes1.setRoundTopLeft(50);
        redondear_bordes1.setRoundTopRight(50);

        sub_panel1.setBackground(new java.awt.Color(40, 167, 69));
        sub_panel1.setForeground(new java.awt.Color(255, 255, 255));
        sub_panel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sub_panel1.setRoundBottomLeft(30);
        sub_panel1.setRoundBottomRight(30);
        sub_panel1.setRoundTopLeft(30);
        sub_panel1.setRoundTopRight(30);

        num_productos.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        num_productos.setForeground(new java.awt.Color(255, 255, 255));
        num_productos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        num_productos.setText("50");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Productos");
        jLabel2.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Microsoft Himalaya", 0, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tienda-de-comestibles.png"))); // NOI18N

        javax.swing.GroupLayout sub_panel1Layout = new javax.swing.GroupLayout(sub_panel1);
        sub_panel1.setLayout(sub_panel1Layout);
        sub_panel1Layout.setHorizontalGroup(
            sub_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(sub_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(num_productos))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        sub_panel1Layout.setVerticalGroup(
            sub_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sub_panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sub_panel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(num_productos)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                .addContainerGap())
        );

        sub_panel2.setBackground(new java.awt.Color(220, 53, 69));
        sub_panel2.setPreferredSize(new java.awt.Dimension(300, 100));
        sub_panel2.setRoundBottomLeft(30);
        sub_panel2.setRoundBottomRight(30);
        sub_panel2.setRoundTopLeft(30);
        sub_panel2.setRoundTopRight(30);

        num_clientes.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        num_clientes.setForeground(new java.awt.Color(255, 255, 255));
        num_clientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        num_clientes.setText("50");

        jLabel4.setFont(new java.awt.Font("Microsoft Himalaya", 0, 36)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nueva-cuenta (1).png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Clientes");
        jLabel5.setToolTipText("");

        javax.swing.GroupLayout sub_panel2Layout = new javax.swing.GroupLayout(sub_panel2);
        sub_panel2.setLayout(sub_panel2Layout);
        sub_panel2Layout.setHorizontalGroup(
            sub_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel2Layout.createSequentialGroup()
                .addGroup(sub_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sub_panel2Layout.createSequentialGroup()
                        .addGap(0, 66, Short.MAX_VALUE)
                        .addComponent(num_clientes)
                        .addGap(35, 35, 35))
                    .addGroup(sub_panel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel4)
                .addGap(10, 10, 10))
        );
        sub_panel2Layout.setVerticalGroup(
            sub_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sub_panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sub_panel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(num_clientes)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                .addContainerGap())
        );

        sub_panel3.setBackground(new java.awt.Color(255, 204, 51));
        sub_panel3.setPreferredSize(new java.awt.Dimension(300, 100));
        sub_panel3.setRoundBottomLeft(30);
        sub_panel3.setRoundBottomRight(30);
        sub_panel3.setRoundTopLeft(30);
        sub_panel3.setRoundTopRight(30);

        jLabel7.setFont(new java.awt.Font("Microsoft Himalaya", 0, 36)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/proveedor-hotelero (1).png"))); // NOI18N

        num_proveedores.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        num_proveedores.setForeground(new java.awt.Color(255, 255, 255));
        num_proveedores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        num_proveedores.setText("50");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Proveedores");
        jLabel8.setToolTipText("");

        javax.swing.GroupLayout sub_panel3Layout = new javax.swing.GroupLayout(sub_panel3);
        sub_panel3.setLayout(sub_panel3Layout);
        sub_panel3Layout.setHorizontalGroup(
            sub_panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel3Layout.createSequentialGroup()
                .addGroup(sub_panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sub_panel3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sub_panel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(num_proveedores)
                        .addGap(35, 35, 35)))
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        sub_panel3Layout.setVerticalGroup(
            sub_panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sub_panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sub_panel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(num_proveedores)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                .addContainerGap())
        );

        sub_panel5.setBackground(new java.awt.Color(102, 0, 204));
        sub_panel5.setRoundBottomLeft(30);
        sub_panel5.setRoundBottomRight(30);
        sub_panel5.setRoundTopLeft(30);
        sub_panel5.setRoundTopRight(30);

        jLabel9.setFont(new java.awt.Font("Microsoft Himalaya", 0, 36)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bolsa-de-la-compra (1).png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Ventas");
        jLabel10.setToolTipText("");

        numsalida.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        numsalida.setForeground(new java.awt.Color(255, 255, 255));
        numsalida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numsalida.setText("00");

        javax.swing.GroupLayout sub_panel5Layout = new javax.swing.GroupLayout(sub_panel5);
        sub_panel5.setLayout(sub_panel5Layout);
        sub_panel5Layout.setHorizontalGroup(
            sub_panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sub_panel5Layout.createSequentialGroup()
                .addGroup(sub_panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sub_panel5Layout.createSequentialGroup()
                        .addContainerGap(67, Short.MAX_VALUE)
                        .addComponent(numsalida)
                        .addGap(35, 35, 35))
                    .addGroup(sub_panel5Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel9)
                .addGap(10, 10, 10))
        );
        sub_panel5Layout.setVerticalGroup(
            sub_panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sub_panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sub_panel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(numsalida)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                .addContainerGap())
        );

        sub_panel4.setBackground(new java.awt.Color(0, 204, 204));
        sub_panel4.setRoundBottomLeft(30);
        sub_panel4.setRoundBottomRight(30);
        sub_panel4.setRoundTopLeft(30);
        sub_panel4.setRoundTopRight(30);

        jLabel3.setFont(new java.awt.Font("Microsoft Himalaya", 0, 36)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anadir-al-carrito (1).png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Compras");
        jLabel6.setToolTipText("");

        numentradas.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        numentradas.setForeground(new java.awt.Color(255, 255, 255));
        numentradas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numentradas.setText("00");

        javax.swing.GroupLayout sub_panel4Layout = new javax.swing.GroupLayout(sub_panel4);
        sub_panel4.setLayout(sub_panel4Layout);
        sub_panel4Layout.setHorizontalGroup(
            sub_panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sub_panel4Layout.createSequentialGroup()
                .addGroup(sub_panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sub_panel4Layout.createSequentialGroup()
                        .addContainerGap(67, Short.MAX_VALUE)
                        .addComponent(numentradas)
                        .addGap(35, 35, 35))
                    .addGroup(sub_panel4Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel3)
                .addGap(10, 10, 10))
        );
        sub_panel4Layout.setVerticalGroup(
            sub_panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sub_panel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sub_panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sub_panel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(numentradas)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout redondear_bordes1Layout = new javax.swing.GroupLayout(redondear_bordes1);
        redondear_bordes1.setLayout(redondear_bordes1Layout);
        redondear_bordes1Layout.setHorizontalGroup(
            redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(sub_panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sub_panel2, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sub_panel3, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sub_panel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sub_panel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        redondear_bordes1Layout.setVerticalGroup(
            redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redondear_bordes1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(redondear_bordes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sub_panel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sub_panel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sub_panel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sub_panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sub_panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        redondear_bordes2.setBackground(new java.awt.Color(255, 255, 255));
        redondear_bordes2.setRoundBottomLeft(50);
        redondear_bordes2.setRoundBottomRight(50);
        redondear_bordes2.setRoundTopLeft(50);
        redondear_bordes2.setRoundTopRight(50);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel11.setText("\"Bienvenido al Sistema de Facturación y Gestión de Almacén: \"Digital Stock\".");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel12.setText("Esta herramienta integral ha sido diseñada para optimizar por completo el control de su inventario,");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel13.setText("Su objetivo es proporcionarle información precisa y en tiempo real, fundamental para la");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel14.setText("toma de decisiones estratégicas y para mantener una gestión eficiente de todos los activos.\"");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel15.setText("agilizando cada operación de entrada y salida de productos.");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/huawei.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Segoe UI", 3, 33)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("DIGITAL");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 3, 33)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("STOCK");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/walmart.png"))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Segoe UI", 3, 17)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Control Total de tu Inventario");

        jSeparator2.setBackground(new java.awt.Color(255, 204, 0));
        jSeparator2.setForeground(new java.awt.Color(255, 204, 51));

        javax.swing.GroupLayout redondear_bordes2Layout = new javax.swing.GroupLayout(redondear_bordes2);
        redondear_bordes2.setLayout(redondear_bordes2Layout);
        redondear_bordes2Layout.setHorizontalGroup(
            redondear_bordes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redondear_bordes2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(redondear_bordes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(redondear_bordes2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(redondear_bordes2Layout.createSequentialGroup()
                        .addGroup(redondear_bordes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addGap(38, 38, 38)
                        .addGroup(redondear_bordes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(redondear_bordes2Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(12, 12, 12)
                                .addGroup(redondear_bordes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(redondear_bordes2Layout.createSequentialGroup()
                                        .addGap(65, 65, 65)
                                        .addComponent(jLabel18))
                                    .addGroup(redondear_bordes2Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(29, Short.MAX_VALUE))
                            .addGroup(redondear_bordes2Layout.createSequentialGroup()
                                .addGroup(redondear_bordes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        redondear_bordes2Layout.setVerticalGroup(
            redondear_bordes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(redondear_bordes2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(redondear_bordes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(redondear_bordes2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14))
                    .addGroup(redondear_bordes2Layout.createSequentialGroup()
                        .addGroup(redondear_bordes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addGroup(redondear_bordes2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18))
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(redondear_bordes1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(redondear_bordes2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(redondear_bordes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(redondear_bordes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel num_clientes;
    public javax.swing.JLabel num_productos;
    private javax.swing.JLabel num_proveedores;
    public javax.swing.JLabel numentradas;
    public javax.swing.JLabel numsalida;
    private interfaz.Redondear_bordes redondear_bordes1;
    private interfaz.Redondear_bordes redondear_bordes2;
    private interfaz.Redondear_bordes sub_panel1;
    private interfaz.Redondear_bordes sub_panel2;
    private interfaz.Redondear_bordes sub_panel3;
    private interfaz.Redondear_bordes sub_panel4;
    private interfaz.Redondear_bordes sub_panel5;
    // End of variables declaration//GEN-END:variables

}
