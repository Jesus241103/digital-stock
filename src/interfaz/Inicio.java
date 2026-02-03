package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import style.Style;
import object.User_sesion;
import others.Api_dolar;

public class Inicio extends javax.swing.JFrame {

    public JButton press;
    public Color color = new Color(255, 153, 0);//COLOR DEL BTN AL SER PRECIONADO
    User_sesion user = null;

    //CONSTRUCTOR, ESTA EN LA PANTALLA PRINCIPAL CON EL MENO
    public Inicio(User_sesion user) {
        this.user=user;
        Style look = new Style();
        look.Style();//APLICAR LOOK AND FEEL A ESTA PANTALLA
        initComponents();
        cargar_panel(new Principal());//MUESTRA EL PANEL PRINCIPAL POR DEFECTO
        this.setLocationRelativeTo(null);
        ocultar_btn();//OCULTA BTN DEL MENU EN CASO DE SER UN USUARIO COMUN
        rol_acceso.setText("Rol de Acceso: " + user.getRol()); //MUETSRA INFO DEL USUARIO QUE ACCEDIO
        ced1.setText("Cedula: " + user.getCedula()); //CEDULA DEL USER QUE ACCEDIO
        nomb1.setText("Usuario: " + user.getNombre());
        press = principal;
        press.setBackground(color);//COLOR DEL BTN DEL PANEL INICIO POR DEFECTO
        
        Api_dolar x = new Api_dolar();
        label_dolar.setText("$: "+x.getPrecio_dolar()+" BS");
        fecha_actualizacion.setText("Fecha: "+x.getFecha());
    }

    public void ocultar_btn() {
        //SI EL ROL ES DISTINTO AL DE ADMINISTRADOR, OCULTA LOS BTN DEL MENU
        if (!user.getRol().equals("Administrador")) {
            reportes.setVisible(false);
            bitacora.setVisible(false);
            usuarios.setVisible(false);
        }

    }

    //ESTA FUNCION ES LLAMADA AL PRECIONAR UN BTN, RECIBE EL PANEL QUE SE VA A MOSTRAR DEPENDIENDO DEL BTN PRECIONADO EN EL MENU
    public void cargar_panel(JPanel panel) {
        panel.setPreferredSize(contenedor.getSize());
        contenedor.removeAll();//LIMPIA CONTENEDOR
        contenedor.setLayout(new BorderLayout());
        contenedor.add(panel, BorderLayout.CENTER); //AGREGA EL PANEL AL CONTENEDOR
        contenedor.revalidate();
        contenedor.repaint();
    }

    //CONFIGURA EL SCROLL PARA EL PANEL DE REPORTES
    private void configurarScroll() {
        Reporte_entrada panel = new Reporte_entrada();
        JScrollPane scroll = new JScrollPane(panel);
        contenedor.add(scroll, BorderLayout.CENTER);
        scroll.getHorizontalScrollBar().setUnitIncrement(110);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        ced1 = new javax.swing.JLabel();
        nomb1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rol_acceso = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fecha_actualizacion = new javax.swing.JLabel();
        label_dolar = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        principal = new javax.swing.JButton();
        entrada = new javax.swing.JButton();
        salida = new javax.swing.JButton();
        productos = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        proveedores = new javax.swing.JButton();
        clientes = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        usuarios = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        reportes = new javax.swing.JButton();
        bitacora = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        contenedor = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(null);
        setMinimumSize(new java.awt.Dimension(1500, 800));
        setPreferredSize(new java.awt.Dimension(1500, 800));
        setSize(new java.awt.Dimension(1500, 800));

        background.setBackground(new java.awt.Color(240, 240, 240));
        background.setPreferredSize(new java.awt.Dimension(1000, 600));

        header.setBackground(new java.awt.Color(0, 0, 153));
        header.setPreferredSize(new java.awt.Dimension(744, 150));

        ced1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ced1.setForeground(new java.awt.Color(255, 255, 255));
        ced1.setText("Cedula:");

        nomb1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nomb1.setForeground(new java.awt.Color(255, 255, 255));
        nomb1.setText("Usuario: ");
        nomb1.setRequestFocusEnabled(false);

        jLabel3.setBackground(new java.awt.Color(255, 153, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/avatar.png"))); // NOI18N

        rol_acceso.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        rol_acceso.setForeground(new java.awt.Color(255, 255, 255));
        rol_acceso.setText("Rol de Acceso: ");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cambio-de-divisas (1).png"))); // NOI18N

        fecha_actualizacion.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        fecha_actualizacion.setForeground(new java.awt.Color(255, 255, 255));
        fecha_actualizacion.setText("Fecha:");

        label_dolar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        label_dolar.setForeground(new java.awt.Color(255, 255, 255));
        label_dolar.setText("$:");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(0, 111, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fecha_actualizacion)
                    .addComponent(label_dolar))
                .addGap(161, 161, 161)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rol_acceso)
                    .addComponent(ced1)
                    .addComponent(nomb1))
                .addGap(100, 100, 100))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, headerLayout.createSequentialGroup()
                        .addComponent(nomb1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ced1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rol_acceso))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(headerLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, 0)
                                .addComponent(fecha_actualizacion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(label_dolar)))))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        menu.setBackground(new java.awt.Color(0, 0, 153));

        principal.setBackground(new java.awt.Color(0, 0, 153));
        principal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        principal.setForeground(new java.awt.Color(255, 255, 255));
        principal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/menu-principal.png"))); // NOI18N
        principal.setText("Principal");
        principal.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        principal.setBorderPainted(false);
        principal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        principal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        principal.setIconTextGap(13);
        principal.setInheritsPopupMenu(true);
        principal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                principalActionPerformed(evt);
            }
        });

        entrada.setBackground(new java.awt.Color(0, 0, 153));
        entrada.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        entrada.setForeground(new java.awt.Color(255, 255, 255));
        entrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/anadir-al-carrito.png"))); // NOI18N
        entrada.setText("Entrada");
        entrada.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        entrada.setBorderPainted(false);
        entrada.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        entrada.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        entrada.setIconTextGap(13);
        entrada.setInheritsPopupMenu(true);
        entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entradaActionPerformed(evt);
            }
        });

        salida.setBackground(new java.awt.Color(0, 0, 153));
        salida.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        salida.setForeground(new java.awt.Color(255, 255, 255));
        salida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bolsa-de-la-compra.png"))); // NOI18N
        salida.setText("Salida");
        salida.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        salida.setBorderPainted(false);
        salida.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        salida.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        salida.setIconTextGap(13);
        salida.setInheritsPopupMenu(true);
        salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salidaActionPerformed(evt);
            }
        });

        productos.setBackground(new java.awt.Color(0, 0, 153));
        productos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        productos.setForeground(new java.awt.Color(255, 255, 255));
        productos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/supermercado.png"))); // NOI18N
        productos.setText("Productos");
        productos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        productos.setBorderPainted(false);
        productos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        productos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        productos.setIconTextGap(13);
        productos.setInheritsPopupMenu(true);
        productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productosActionPerformed(evt);
            }
        });

        salir.setBackground(new java.awt.Color(0, 0, 153));
        salir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        salir.setForeground(new java.awt.Color(255, 255, 255));
        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar-sesion.png"))); // NOI18N
        salir.setText("Salir");
        salir.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        salir.setBorderPainted(false);
        salir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        salir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        salir.setIconTextGap(13);
        salir.setInheritsPopupMenu(true);
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        proveedores.setBackground(new java.awt.Color(0, 0, 153));
        proveedores.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        proveedores.setForeground(new java.awt.Color(255, 255, 255));
        proveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/proveedor-hotelero.png"))); // NOI18N
        proveedores.setText("Proveedores");
        proveedores.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        proveedores.setBorderPainted(false);
        proveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        proveedores.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        proveedores.setIconTextGap(13);
        proveedores.setInheritsPopupMenu(true);
        proveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proveedoresActionPerformed(evt);
            }
        });

        clientes.setBackground(new java.awt.Color(0, 0, 153));
        clientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        clientes.setForeground(new java.awt.Color(255, 255, 255));
        clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nueva-cuenta.png"))); // NOI18N
        clientes.setText("Clientes");
        clientes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        clientes.setBorderPainted(false);
        clientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        clientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        clientes.setIconTextGap(13);
        clientes.setInheritsPopupMenu(true);
        clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        usuarios.setBackground(new java.awt.Color(0, 0, 153));
        usuarios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usuarios.setForeground(new java.awt.Color(255, 255, 255));
        usuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/trabajando-con-laptop.png"))); // NOI18N
        usuarios.setText("Usuarios");
        usuarios.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        usuarios.setBorderPainted(false);
        usuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        usuarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        usuarios.setIconTextGap(13);
        usuarios.setInheritsPopupMenu(true);
        usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DIGITAL");

        reportes.setBackground(new java.awt.Color(0, 0, 153));
        reportes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        reportes.setForeground(new java.awt.Color(255, 255, 255));
        reportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/informe-seo.png"))); // NOI18N
        reportes.setText("Reportes");
        reportes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        reportes.setBorderPainted(false);
        reportes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        reportes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        reportes.setIconTextGap(13);
        reportes.setInheritsPopupMenu(true);
        reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportesActionPerformed(evt);
            }
        });

        bitacora.setBackground(new java.awt.Color(0, 0, 153));
        bitacora.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bitacora.setForeground(new java.awt.Color(255, 255, 255));
        bitacora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/verificar.png"))); // NOI18N
        bitacora.setText("Bitacora");
        bitacora.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        bitacora.setBorderPainted(false);
        bitacora.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bitacora.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bitacora.setIconTextGap(13);
        bitacora.setInheritsPopupMenu(true);
        bitacora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bitacoraActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("STOCK");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/huawei.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Control Total de tu Inventario");

        jSeparator2.setBackground(new java.awt.Color(255, 204, 0));
        jSeparator2.setForeground(new java.awt.Color(255, 204, 51));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/walmart.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("@DIGITAL STOCK - 2025");

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel5))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addGap(20, 20, 20))
            .addGroup(menuLayout.createSequentialGroup()
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(principal, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(salida, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(productos, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(reportes, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(bitacora, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel7))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(menuLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel4)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel5))
                    .addComponent(jLabel1))
                .addGap(10, 10, 10)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(principal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(salida, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(productos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(proveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(reportes, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(bitacora, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(25, 25, 25))
        );

        proveedores.getAccessibleContext().setAccessibleName("registrar_proveedor");

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 774, Short.MAX_VALUE)
        );
        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 629, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
                    .addComponent(contenedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backgroundLayout.createSequentialGroup()
                        .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 1073, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //ACCION BTN DE VER BITACORA
    private void bitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bitacoraActionPerformed
        press.setBackground(new Color(0, 0, 153));//COLOR POR DEFECTO DEL BTN PRECIONADO ANTERIORMENTE
        Bitacora panel = new Bitacora();
        cargar_panel(panel);//CARGAR PANEL BITACORA
        press = bitacora;
        press.setBackground(color);
    }//GEN-LAST:event_bitacoraActionPerformed

    //ACCIONN BTN DE REPORTES
    private void reportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportesActionPerformed
        press.setBackground(new Color(0, 0, 153));//COLOR POR DEFECTO DEL BTN PRECIONADO ANTERIORMENTE
        Reporte_entrada panel = new Reporte_entrada();
        cargar_panel(panel);//MUESTRA PANEL DE REPORTES
        configurarScroll();
        press = reportes;
        press.setBackground(color);
    }//GEN-LAST:event_reportesActionPerformed

    //CARGAR PANEL DE CLIENTES BTN
    private void clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesActionPerformed
        press.setBackground(new Color(0, 0, 153));//COLOR POR DEFECTO DEL BTN PRECIONADO ANTERIORMENTE
        Cliente panel = new Cliente(user);
        cargar_panel(panel);//MUESTRA EL PANEL DE CLIENTES
        press = clientes;
        press.setBackground(color);
    }//GEN-LAST:event_clientesActionPerformed

    //BTN MODULO PROVEEDORES
    private void proveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proveedoresActionPerformed
        press.setBackground(new Color(0, 0, 153));//COLOR POR DEFECTO DEL BTN PRECIONADO ANTERIORMENTE
        Proveedor panel = new Proveedor(user);
        cargar_panel(panel); //CARGAR PANEL DE PROVEEDORES
        press = proveedores;
        press.setBackground(color);
    }//GEN-LAST:event_proveedoresActionPerformed

    //BTN SALIR
    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        press.setBackground(new Color(0, 0, 153));//COLOR POR DEFECTO DEL BTN PRECIONADO ANTERIORMENTE
        this.setVisible(false);
        Login x = new Login(); // SE REDIRIJE AL LOGIN
        x.setVisible(true);
        press = salir;
        press.setBackground(color);
    }//GEN-LAST:event_salirActionPerformed

    //MODULO PRODUCTOS ACCION BTN
    private void productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosActionPerformed
        press.setBackground(new Color(0, 0, 153));//COLOR POR DEFECTO DEL BTN PRECIONADO ANTERIORMENTE
        Producto panel = new Producto(user);
        cargar_panel(panel); //CARGAR PANLE DE PRODUCTOS
        press = productos;
        press.setBackground(color);
    }//GEN-LAST:event_productosActionPerformed

    //BTN REGISTRAR SALIDA DE PRODUCTOS O VENTA
    private void salidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salidaActionPerformed
        press.setBackground(new Color(0, 0, 153));//COLOR POR DEFECTO DEL BTN PRECIONADO ANTERIORMENTE
        Venta_Cliente panel = new Venta_Cliente(user);
        cargar_panel(panel);//MOSTRAR PANLE DE VENTAS O FACTURACION A CLIENTE
        press = salida;
        press.setBackground(color);
    }//GEN-LAST:event_salidaActionPerformed

    //PANEL ENTRADAS ACCION BTN
    private void entradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entradaActionPerformed
        press.setBackground(new Color(0, 0, 153));//COLOR POR DEFECTO DEL BTN PRECIONADO ANTERIORMENTE
        Compra_Proveedor panel = new Compra_Proveedor(user);
        cargar_panel(panel);//CARGA PANEL DE FACTUACION A PROVEEDOR O COMPRA
        press = entrada;
        press.setBackground(color);
    }//GEN-LAST:event_entradaActionPerformed

    //CARGAR EL PANEL PRINCIPAL O INICIAL
    private void principalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_principalActionPerformed
        press.setBackground(new Color(0, 0, 153));//COLOR POR DEFECTO DEL BTN PRECIONADO ANTERIORMENTE
        Principal panel = new Principal();
        cargar_panel(panel);//MOSTRAR EL PANEL
        press = principal;
        press.setBackground(color);
    }//GEN-LAST:event_principalActionPerformed

    //BTN ACCION VER USUARIOS, PANEL DE USUARIOS DEL SISTEMA
    private void usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariosActionPerformed
        press.setBackground(new Color(0, 0, 153));//COLOR POR DEFECTO DEL BTN PRECIONADO ANTERIORMENTE
        Usuarios panel = new Usuarios();
        cargar_panel(panel);//CARGA PANEL DE USUARIOS
        press = usuarios;
        press.setBackground(color);

    }//GEN-LAST:event_usuariosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton bitacora;
    private javax.swing.JLabel ced1;
    private javax.swing.JButton clientes;
    private javax.swing.JPanel contenedor;
    private javax.swing.JButton entrada;
    private javax.swing.JLabel fecha_actualizacion;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel label_dolar;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel nomb1;
    private javax.swing.JButton principal;
    private javax.swing.JButton productos;
    private javax.swing.JButton proveedores;
    private javax.swing.JButton reportes;
    private javax.swing.JLabel rol_acceso;
    private javax.swing.JButton salida;
    private javax.swing.JButton salir;
    private javax.swing.JButton usuarios;
    // End of variables declaration//GEN-END:variables
}
