/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formularios;

import Clases.Clientes;
import Clases.ClientesCRUD;
import Clases.Pedidos;
import Clases.Productos;
import Clases.ProductosCRUD;
import Clases.Proveedor;
import Clases.ProveedorCRUD;
import Clases.Usuario;
import Clases.UsuarioCRUD;
import Clases.Validaciones;
import Clases.Ventas;
import Clases.VentasCRUD;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


/**
 *
 * @author amart
 */
public class FrmMenu extends javax.swing.JFrame {
    Clientes clientes = new Clientes();
    ClientesCRUD clientesCRUD = new ClientesCRUD();
    Productos productos = new Productos();
    ProductosCRUD productoCRUD = new ProductosCRUD();
    Proveedor proveedor = new Proveedor();
    ProveedorCRUD proveedorCRUD = new ProveedorCRUD();
    Usuario empleados = new Usuario();
    UsuarioCRUD empleadosCRUD = new UsuarioCRUD();
    Ventas ventas = new Ventas();
    VentasCRUD ventasCUD = new VentasCRUD();
    Pedidos pedidos = new Pedidos();
    Validaciones validar = new Validaciones();
    int item;
    double TotalaPagar;
    
    
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel mod = new DefaultTableModel();
    Date fechaVenta = new Date();
    String fechaActual =  new SimpleDateFormat("dd/MM/yyyy").format(fechaVenta);

    /**
     * Creates new form FrmMenu
     */
    public FrmMenu() {
        initComponents();
        setLocationRelativeTo(null);
        
        AutoCompleteDecorator.decorate(cbxProveedorProd);
        productoCRUD.ConsultarProveedor(cbxProveedorProd);
        AutoCompleteDecorator.decorate(cbxProductos);
        productoCRUD.ConsultarProducto(cbxProductos);
        AutoCompleteDecorator.decorate(cbxCliente);
        clientesCRUD.ConsultarCliente(cbxCliente);
        txtIDVenta.setVisible(false);
        txtIdCliente.setVisible(false);
        txtIdProd.setVisible(false);
        txtIdEmpleado.setVisible(false);
        txtIdProveedor.setVisible(false);
        
    }
    
    
    
    public void listarCliente(){
        List<Clientes> listarCl = clientesCRUD.ListarCliente();
        modelo = (DefaultTableModel) TablaCliente.getModel();
        Object[] obj = new Object[6];
        for(int i=0; i<listarCl.size();i++){
            obj[0]=listarCl.get(i).getId();
            obj[1]=listarCl.get(i).getDni();
            obj[2]=listarCl.get(i).getNombre();
            obj[3]=listarCl.get(i).getTelefono();
            obj[4]=listarCl.get(i).getDireccion();
            obj[5]=listarCl.get(i).getRazon();
            modelo.addRow(obj);
        }
        TablaCliente.setModel(modelo);
    }
    public void listarProveedor(){
        List<Proveedor> listarProv = proveedorCRUD.ListarProveedor();
        modelo = (DefaultTableModel) TablaProveedor.getModel();
        Object[] obj = new Object[6];
        for(int i=0; i<listarProv.size();i++){
            obj[0]=listarProv.get(i).getId();
            obj[1]=listarProv.get(i).getNif();
            obj[2]=listarProv.get(i).getNombre();
            obj[3]=listarProv.get(i).getTelefono();
            obj[4]=listarProv.get(i).getDireccion();
            obj[5]=listarProv.get(i).getRazonsocial();
            modelo.addRow(obj);
        }
        TablaProveedor.setModel(modelo);
    }
    public void listarProdcutos(){
        List<Productos> listarProd = productoCRUD.ListarProducto();
        modelo = (DefaultTableModel) TablaProducto.getModel();
        Object[] obj = new Object[6];
        for(int i=0; i<listarProd.size();i++){
            obj[0]=listarProd.get(i).getId();
            obj[1]=listarProd.get(i).getCodigo();
            obj[2]=listarProd.get(i).getNombre();
            obj[3]=listarProd.get(i).getProveedor();
            obj[4]=listarProd.get(i).getStock();
            obj[5]=listarProd.get(i).getPrecio();
            modelo.addRow(obj);
        }
        TablaProducto.setModel(modelo);
    }
    public void listarPedidos(){
        List<Ventas> listarPedidos = ventasCUD.ListarPedidos();
        modelo = (DefaultTableModel) TablaVentas.getModel();
        Object[] obj = new Object[6];
        for(int i=0; i<listarPedidos.size();i++){
            obj[0]=listarPedidos.get(i).getId();
            obj[1]=listarPedidos.get(i).getCliente();
            obj[2]=listarPedidos.get(i).getEmpleado();
            obj[3]=listarPedidos.get(i).getTotal();
            modelo.addRow(obj);
        }
        TablaVentas.setModel(modelo);
    }
    public void listarEmpleados(){
        List<Usuario> listarEmple = empleadosCRUD.ListarEmpleado();
        modelo = (DefaultTableModel) TablaEmpleados.getModel();
        Object[] obj = new Object[6];
        for(int i=0; i<listarEmple.size();i++){
            obj[0]=listarEmple.get(i).getId();
            obj[1]=listarEmple.get(i).getNombre();
            obj[2]=listarEmple.get(i).getUsuario();
            obj[3]=listarEmple.get(i).getPass();
            modelo.addRow(obj);
        }
        TablaEmpleados.setModel(modelo);
    }
    
    public void limpiarCampos(){
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
    public void limpiarCliente(){
        txtIdCliente.setText("");
        txtDNICliente.setText("");
        txtNombreCliente.setText("");
        txtTelefonoCliente.setText("");
        txtDireccionCliente.setText("");
        txtRazonSocialCliente.setText("");
        
    }
    public void limpiarProveedor(){
        txtIdProveedor.setText("");
        txtNIFProveedor.setText("");
        txtNombreProveedor.setText("");
        txtTelefonoProveedor.setText("");
        txtDireccionProveedor.setText("");
        txtRazonSocialProveedor.setText("");
        
    }
    public void limpiarProducto(){
        txtIdProducto.setText("");
        txtCodigoProd.setText("");
        txtDescripcionProd.setText("");
        cbxProveedorProd.setSelectedItem(null);
        txtCantidadProd.setText("");
        txtPrecioProd.setText("");
        
    }
    public void limpiarEmpleados(){
        txtIdEmpleado.setText("");
        txtNombreEmpleado.setText("");
        txtUserEmpleado.setText("");
        txtPassEmpleado.setText("");
        
    }
    
    public void LimpiarCamposPedido(){
        txtCodigoVenta.setText("");
        cbxProductos.setSelectedIndex(0);
        txtProductoVenta.setText("");
        txtCantidadVenta.setText("");
        txtStock.setText("");
        txtPrecioVenta.setText("");
        txtIDVenta.setText("");
    }
    
    private void LimpiarNuevoPedido(){
        mod = (DefaultTableModel) TablaVenta.getModel();
        int fila = TablaVenta.getRowCount();
        for (int i = 0; i < fila; i++) {
            mod.removeRow(0);
            
        }
    }
    private void LimpiarClienteNuevoPedido(){
        txtDNICliente.setText("");
        txtNombreClienteVenta.setText("");
        txtTelefonoClienteVenta.setText("");
        txtDireccionClienteVenta.setText("");
        txtRazonClienteVenta.setText("");
        
    }
    
    private void RegistrarVenta(){
        String cliente = txtNombreClienteVenta.getText();
        String empleado = lblEmpleado.getText();
        double total=TotalaPagar;
        ventas.setCliente(cliente);
        ventas.setEmpleado(empleado);
        ventas.setTotal(total);
        ventas.setFecha(fechaActual);
        ventasCUD.RegistrarVenta(ventas);
    }
    
    private void RegistrarPedido(){
        int id = ventasCUD.IdVentas();
        for (int i = 0; i < TablaVenta.getRowCount(); i++) {
            String producto = TablaVenta.getValueAt(i, 0).toString();
            int cantidad = Integer.parseInt(TablaVenta.getValueAt(i, 2).toString());
            double precio = Double.parseDouble(TablaVenta.getValueAt(i, 3).toString());
            pedidos.setProductos(producto);
            pedidos.setCantidad(cantidad);
            pedidos.setPrecio(precio);
            pedidos.setId(id);
            ventasCUD.RegistrarPedido(pedidos);
        }
    }
    
    private void ActualizarStockDisponible(){
        for (int i = 0; i < TablaVenta.getRowCount(); i++) {
            String producto = TablaVenta.getValueAt(i,1).toString();
            int cantidad = Integer.parseInt(TablaVenta.getValueAt(i, 2).toString());
            productos = productoCRUD.BuscarProductos(producto);
            int stock = productos.getStock() - cantidad;
            ventasCUD.ActualizarStock(stock, producto);
            
        }
    }
    
    private void CantidadStock(){
        if(!"".equals(txtCantidadVenta.getText())){
            String codigo = txtCodigoVenta.getText();
            String producto = txtProductoVenta.getText();
            int cantidad = Integer.parseInt(txtCantidadVenta.getText());
            double precio = Double.parseDouble(txtPrecioVenta.getText());
            double total =  cantidad * precio;
            int stock = Integer.parseInt(txtStock.getText());
            if(stock >= cantidad){
                item = item + 1;
                mod = (DefaultTableModel) TablaVenta.getModel();
                    for (int i = 0; i < TablaVenta.getRowCount(); i++) {
                        if(TablaVenta.getValueAt(i, 1).equals(txtProductoVenta.getText())){
                           JOptionPane.showMessageDialog(null, "El producto ya esta seleccionado");
                            LimpiarCamposPedido();
                            return;
                            
                        }
                        
                    }
                ArrayList lista = new ArrayList();
                lista.add(item);
                lista.add(codigo);
                lista.add(producto);
                lista.add(cantidad);
                lista.add(precio);
                lista.add(total);
                Object [] obj= new Object[5];
                obj[0]=lista.get(1);
                obj[1]=lista.get(2);
                obj[2]=lista.get(3);
                obj[3]=lista.get(4);
                obj[4]=lista.get(5);
                mod.addRow(obj);
                TablaVenta.setModel(mod);
                    
                CalcularTotal();
                LimpiarCamposPedido();
                    
                cbxProductos.requestFocus();
            }else{
                JOptionPane.showMessageDialog(null, "Stock no disponible");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Por favor, ingrese una cantidad");
        }     
    }
    
    private void CalcularTotal(){
        int filas=TablaVenta.getRowCount();
        TotalaPagar=0;
        for (int i = 0; i < filas; i++) {
            double cantidad= Double.parseDouble(String.valueOf(TablaVenta.getValueAt(i, 4).toString()));
            TotalaPagar = TotalaPagar + cantidad;
        }
        
        lblTotal.setText(String.format("%.2f", TotalaPagar));
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnClientes = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnProvedores = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnEmpleados = new javax.swing.JButton();
        btnNuevoPedido = new javax.swing.JButton();
        btnPedidos = new javax.swing.JButton();
        lblEmpleado = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lblTotalaPagar = new javax.swing.JLabel();
        txtDNIVenta = new javax.swing.JTextField();
        txtNombreClienteVenta = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        TablaVenta = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtCantidadVenta = new javax.swing.JTextField();
        txtCodigoVenta = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        txtStock = new javax.swing.JTextField();
        btnGenerarVenta = new javax.swing.JButton();
        txtTelefonoClienteVenta = new javax.swing.JTextField();
        txtDireccionClienteVenta = new javax.swing.JTextField();
        txtRazonClienteVenta = new javax.swing.JTextField();
        txtIdProd = new javax.swing.JTextField();
        cbxProductos = new javax.swing.JComboBox<>();
        txtProductoVenta = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        cbxCliente = new javax.swing.JComboBox<>();
        btnEliminarVenta = new javax.swing.JButton();
        btnAgregarArticulo = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDNICliente = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        txtTelefonoCliente = new javax.swing.JTextField();
        txtDireccionCliente = new javax.swing.JTextField();
        txtRazonSocialCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaCliente = new javax.swing.JTable();
        btnGuardarCliente = new javax.swing.JButton();
        btnEditarCliente = new javax.swing.JButton();
        btnEliminarCliente = new javax.swing.JButton();
        btnNuevoCliente = new javax.swing.JButton();
        txtIdCliente = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtCodigoProd = new javax.swing.JTextField();
        txtDescripcionProd = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCantidadProd = new javax.swing.JTextField();
        txtPrecioProd = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaProducto = new javax.swing.JTable();
        cbxProveedorProd = new javax.swing.JComboBox<>();
        btnGuardarProd = new javax.swing.JButton();
        btnEditarProd = new javax.swing.JButton();
        btnEliminarProd = new javax.swing.JButton();
        btnNuevoProd = new javax.swing.JButton();
        txtIdProducto = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtNIFProveedor = new javax.swing.JTextField();
        txtNombreProveedor = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtTelefonoProveedor = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtDireccionProveedor = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaProveedor = new javax.swing.JTable();
        btnGuardarProveedor = new javax.swing.JButton();
        btnEditarProveedor = new javax.swing.JButton();
        btnEliminarProveedor = new javax.swing.JButton();
        btnNuevoProveedor = new javax.swing.JButton();
        txtRazonSocialProveedor = new javax.swing.JTextField();
        txtIdProveedor = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        btnGuardarEmpleado = new javax.swing.JButton();
        btnEditarEmpleado = new javax.swing.JButton();
        btnEliminarEmpleado = new javax.swing.JButton();
        btnNuevoEmpleado = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtNombreEmpleado = new javax.swing.JTextField();
        txtUserEmpleado = new javax.swing.JTextField();
        txtPassEmpleado = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        TablaEmpleados = new javax.swing.JTable();
        txtIdEmpleado = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaVentas = new javax.swing.JTable();
        btnPDFVentas = new javax.swing.JButton();
        txtIDVenta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 0, 51));

        btnClientes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clientes.png"))); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnProductos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/productos.jpg"))); // NOI18N
        btnProductos.setText("Productos");
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        btnProvedores.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnProvedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/proveedores.png"))); // NOI18N
        btnProvedores.setText("Proveedores");
        btnProvedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProvedoresActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ramayal.png"))); // NOI18N

        btnEmpleados.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/empleados.png"))); // NOI18N
        btnEmpleados.setText("Empleados");
        btnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosActionPerformed(evt);
            }
        });

        btnNuevoPedido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNuevoPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevopedido.png"))); // NOI18N
        btnNuevoPedido.setText("Nuevo Pedido");
        btnNuevoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPedidoActionPerformed(evt);
            }
        });

        btnPedidos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pedido.png"))); // NOI18N
        btnPedidos.setText("Pedidos");
        btnPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidosActionPerformed(evt);
            }
        });

        lblEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEmpleado.setForeground(new java.awt.Color(204, 204, 204));
        lblEmpleado.setText("Administrador");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnClientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNuevoPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnProvedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(btnPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(lblEmpleado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNuevoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProvedores, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(lblEmpleado)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 750));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nombre.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 690, 128));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("DNI:");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Nombre:");

        lblTotalaPagar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTotalaPagar.setText("Total a Pagar:");

        txtDNIVenta.setEditable(false);

        txtNombreClienteVenta.setEditable(false);
        txtNombreClienteVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreClienteVentaKeyTyped(evt);
            }
        });

        TablaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descipción", "Cantidad", "Precio", "Total"
            }
        ));
        jScrollPane5.setViewportView(TablaVenta);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Código:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Producto:");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Cantidad:");

        txtCantidadVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadVentaKeyTyped(evt);
            }
        });

        txtCodigoVenta.setEditable(false);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Precio:");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Stock");

        txtPrecioVenta.setEditable(false);
        txtPrecioVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioVentaKeyTyped(evt);
            }
        });

        txtStock.setEditable(false);
        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockKeyTyped(evt);
            }
        });

        btnGenerarVenta.setBackground(new java.awt.Color(0, 51, 51));
        btnGenerarVenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGenerarVenta.setForeground(new java.awt.Color(204, 204, 204));
        btnGenerarVenta.setText("Generar Venta");
        btnGenerarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarVentaActionPerformed(evt);
            }
        });

        txtTelefonoClienteVenta.setEditable(false);

        txtDireccionClienteVenta.setEditable(false);

        txtRazonClienteVenta.setEditable(false);

        txtIdProd.setEditable(false);

        cbxProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<seleccionar>" }));
        cbxProductos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxProductosItemStateChanged(evt);
            }
        });

        txtProductoVenta.setEditable(false);
        txtProductoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductoVentaActionPerformed(evt);
            }
        });
        txtProductoVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProductoVentaKeyTyped(evt);
            }
        });

        lblTotal.setText("-----------------");

        cbxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<seleccionar>" }));
        cbxCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxClienteItemStateChanged(evt);
            }
        });

        btnEliminarVenta.setBackground(new java.awt.Color(0, 51, 51));
        btnEliminarVenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEliminarVenta.setForeground(new java.awt.Color(204, 204, 204));
        btnEliminarVenta.setText("Eliminar");
        btnEliminarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVentaActionPerformed(evt);
            }
        });

        btnAgregarArticulo.setBackground(new java.awt.Color(0, 51, 51));
        btnAgregarArticulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAgregarArticulo.setForeground(new java.awt.Color(204, 204, 204));
        btnAgregarArticulo.setText("Añadir");
        btnAgregarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarArticuloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotalaPagar)
                .addGap(58, 58, 58)
                .addComponent(lblTotal)
                .addGap(61, 61, 61))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane5)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel30)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(txtIdProd, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCodigoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel29)
                                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtDNIVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNombreClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addComponent(txtTelefonoClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDireccionClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRazonClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAgregarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEliminarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnGenerarVenta)
                                .addGap(1, 1, 1)))
                        .addGap(17, 17, 17))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCantidadVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 457, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(txtIdProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtDireccionClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtTelefonoClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtRazonClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtCodigoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDNIVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txtProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29)
                            .addComponent(txtNombreClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel30)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAgregarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotalaPagar))
                        .addGap(43, 43, 43))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnGenerarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Nuevo Pedido", jPanel2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("DNI:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Teléfono:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Dirección:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Razón Social:");

        txtTelefonoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoClienteKeyTyped(evt);
            }
        });

        TablaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI", "Nombre", "Teléfono", "Dirección", "Razón Social"
            }
        ));
        TablaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaCliente);

        btnGuardarCliente.setBackground(new java.awt.Color(0, 51, 51));
        btnGuardarCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGuardarCliente.setForeground(new java.awt.Color(204, 204, 204));
        btnGuardarCliente.setText("Guardar");
        btnGuardarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarClienteActionPerformed(evt);
            }
        });

        btnEditarCliente.setBackground(new java.awt.Color(0, 51, 51));
        btnEditarCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEditarCliente.setForeground(new java.awt.Color(204, 204, 204));
        btnEditarCliente.setText("Actualizar");
        btnEditarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClienteActionPerformed(evt);
            }
        });

        btnEliminarCliente.setBackground(new java.awt.Color(0, 51, 51));
        btnEliminarCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEliminarCliente.setForeground(new java.awt.Color(204, 204, 204));
        btnEliminarCliente.setText("Eliminar");
        btnEliminarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });

        btnNuevoCliente.setBackground(new java.awt.Color(0, 51, 51));
        btnNuevoCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNuevoCliente.setForeground(new java.awt.Color(204, 204, 204));
        btnNuevoCliente.setText("Limpiar");
        btnNuevoCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });

        txtIdCliente.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtDireccionCliente)
                        .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtNombreCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtDNICliente, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtRazonSocialCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(btnGuardarCliente)
                .addGap(79, 79, 79)
                .addComponent(btnEditarCliente)
                .addGap(71, 71, 71)
                .addComponent(btnEliminarCliente)
                .addGap(66, 66, 66)
                .addComponent(btnNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtDNICliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtRazonSocialCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 269, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Clientes", jPanel3);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Código:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Descripción:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Cantidad");

        txtCantidadProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadProdKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Precio:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Proveedor:");

        TablaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Codigo", "Descripción", "Proveedor", "Stock", "Precio"
            }
        ));
        TablaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaProductoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaProducto);

        cbxProveedorProd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<seleccionar>" }));

        btnGuardarProd.setBackground(new java.awt.Color(0, 51, 51));
        btnGuardarProd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGuardarProd.setForeground(new java.awt.Color(204, 204, 204));
        btnGuardarProd.setText("Guardar");
        btnGuardarProd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProdActionPerformed(evt);
            }
        });

        btnEditarProd.setBackground(new java.awt.Color(0, 51, 51));
        btnEditarProd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEditarProd.setForeground(new java.awt.Color(204, 204, 204));
        btnEditarProd.setText("Actualizar");
        btnEditarProd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProdActionPerformed(evt);
            }
        });

        btnEliminarProd.setBackground(new java.awt.Color(0, 51, 51));
        btnEliminarProd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEliminarProd.setForeground(new java.awt.Color(204, 204, 204));
        btnEliminarProd.setText("Eliminar");
        btnEliminarProd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProdActionPerformed(evt);
            }
        });

        btnNuevoProd.setBackground(new java.awt.Color(0, 51, 51));
        btnNuevoProd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNuevoProd.setForeground(new java.awt.Color(204, 204, 204));
        btnNuevoProd.setText("Limpiar");
        btnNuevoProd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProdActionPerformed(evt);
            }
        });

        txtIdProducto.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecioProd, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(txtCantidadProd)
                    .addComponent(txtDescripcionProd)
                    .addComponent(txtCodigoProd)
                    .addComponent(cbxProveedorProd, 0, 126, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(btnGuardarProd)
                .addGap(58, 58, 58)
                .addComponent(btnEditarProd)
                .addGap(71, 71, 71)
                .addComponent(btnEliminarProd)
                .addGap(66, 66, 66)
                .addComponent(btnNuevoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtCodigoProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtDescripcionProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtCantidadProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtPrecioProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cbxProveedorProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Productos", jPanel4);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("NIF:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Nombre:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Teléfono:");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Dirección:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Razón Social:");

        TablaProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdProveedor", "NIF", "Nombre", "Teléfono", "Dirección", "Razón Social"
            }
        ));
        TablaProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaProveedorMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TablaProveedor);

        btnGuardarProveedor.setBackground(new java.awt.Color(0, 51, 51));
        btnGuardarProveedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGuardarProveedor.setForeground(new java.awt.Color(204, 204, 204));
        btnGuardarProveedor.setText("Guardar");
        btnGuardarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProveedorActionPerformed(evt);
            }
        });

        btnEditarProveedor.setBackground(new java.awt.Color(0, 51, 51));
        btnEditarProveedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEditarProveedor.setForeground(new java.awt.Color(204, 204, 204));
        btnEditarProveedor.setText("Actualizar");
        btnEditarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProveedorActionPerformed(evt);
            }
        });

        btnEliminarProveedor.setBackground(new java.awt.Color(0, 51, 51));
        btnEliminarProveedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEliminarProveedor.setForeground(new java.awt.Color(204, 204, 204));
        btnEliminarProveedor.setText("Eliminar");
        btnEliminarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProveedorActionPerformed(evt);
            }
        });

        btnNuevoProveedor.setBackground(new java.awt.Color(0, 51, 51));
        btnNuevoProveedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNuevoProveedor.setForeground(new java.awt.Color(204, 204, 204));
        btnNuevoProveedor.setText("Limpiar");
        btnNuevoProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProveedorActionPerformed(evt);
            }
        });

        txtIdProveedor.setEditable(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDireccionProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(txtTelefonoProveedor)
                    .addComponent(txtNombreProveedor)
                    .addComponent(txtNIFProveedor)
                    .addComponent(txtRazonSocialProveedor)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(btnGuardarProveedor)
                .addGap(58, 58, 58)
                .addComponent(btnEditarProveedor)
                .addGap(71, 71, 71)
                .addComponent(btnEliminarProveedor)
                .addGap(66, 66, 66)
                .addComponent(btnNuevoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtNIFProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(txtDireccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23)
                            .addComponent(txtRazonSocialProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Proveedores", jPanel6);

        btnGuardarEmpleado.setBackground(new java.awt.Color(0, 51, 51));
        btnGuardarEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGuardarEmpleado.setForeground(new java.awt.Color(204, 204, 204));
        btnGuardarEmpleado.setText("Guardar");
        btnGuardarEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEmpleadoActionPerformed(evt);
            }
        });

        btnEditarEmpleado.setBackground(new java.awt.Color(0, 51, 51));
        btnEditarEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEditarEmpleado.setForeground(new java.awt.Color(204, 204, 204));
        btnEditarEmpleado.setText("Actualizar");
        btnEditarEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarEmpleadoActionPerformed(evt);
            }
        });

        btnEliminarEmpleado.setBackground(new java.awt.Color(0, 51, 51));
        btnEliminarEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEliminarEmpleado.setForeground(new java.awt.Color(204, 204, 204));
        btnEliminarEmpleado.setText("Eliminar");
        btnEliminarEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEmpleadoActionPerformed(evt);
            }
        });

        btnNuevoEmpleado.setBackground(new java.awt.Color(0, 51, 51));
        btnNuevoEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNuevoEmpleado.setForeground(new java.awt.Color(204, 204, 204));
        btnNuevoEmpleado.setText("Limpiar");
        btnNuevoEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoEmpleadoActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setText("Nombre:");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("Usuario:");

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel38.setText("Password:");

        TablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Usuario", "Password"
            }
        ));
        TablaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(TablaEmpleados);

        txtIdEmpleado.setEditable(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(btnGuardarEmpleado)
                        .addGap(58, 58, 58)
                        .addComponent(btnEditarEmpleado)
                        .addGap(71, 71, 71)
                        .addComponent(btnEliminarEmpleado)
                        .addGap(66, 66, 66)
                        .addComponent(btnNuevoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addComponent(jLabel38)
                            .addComponent(jLabel36))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNombreEmpleado)
                                .addComponent(txtUserEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                            .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(txtNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(txtUserEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(txtPassEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Empleados", jPanel7);

        TablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cliente", "Vendedor", "Total"
            }
        ));
        TablaVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaVentasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TablaVentas);
        if (TablaVentas.getColumnModel().getColumnCount() > 0) {
            TablaVentas.getColumnModel().getColumn(0).setPreferredWidth(20);
            TablaVentas.getColumnModel().getColumn(1).setPreferredWidth(60);
            TablaVentas.getColumnModel().getColumn(2).setPreferredWidth(60);
            TablaVentas.getColumnModel().getColumn(3).setPreferredWidth(60);
        }

        btnPDFVentas.setBackground(new java.awt.Color(0, 51, 51));
        btnPDFVentas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPDFVentas.setForeground(new java.awt.Color(204, 204, 204));
        btnPDFVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pdf.png"))); // NOI18N
        btnPDFVentas.setText("Generar PDF");
        btnPDFVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFVentasActionPerformed(evt);
            }
        });

        txtIDVenta.setEditable(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPDFVentas)
                .addGap(69, 69, 69))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(txtIDVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(txtIDVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnPDFVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pedidos", jPanel8);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 690, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPedidoActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btnNuevoPedidoActionPerformed

    private void btnPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidosActionPerformed
        jTabbedPane1.setSelectedIndex(5);
        limpiarCampos();
        listarPedidos();
    }//GEN-LAST:event_btnPedidosActionPerformed

    private void btnGuardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarClienteActionPerformed
        // TODO add your handling code here:
        if(!"".equals(txtDNICliente.getText())|| !"".equals(txtNombreCliente.getText()) || !"".equals(txtTelefonoCliente.getText()) || !"".equals(txtDireccionCliente.getText())){
          clientes.setDni((txtDNICliente.getText()));
          clientes.setNombre(txtNombreCliente.getText());
          clientes.setTelefono(Integer.parseInt(txtTelefonoCliente.getText()));
          clientes.setDireccion(txtDireccionCliente.getText());
          clientes.setRazon(txtRazonSocialCliente.getText());
          
          clientesCRUD.RegistrarCliente(clientes);
          limpiarCampos();
          limpiarCliente();
          listarCliente();
          JOptionPane.showMessageDialog(null, "Cliente Registrado");
        }else{
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        }
    }//GEN-LAST:event_btnGuardarClienteActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
        listarCliente();
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnClientesActionPerformed

    private void TablaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaClienteMouseClicked
        // TODO add your handling code here:
        int fila = TablaCliente.rowAtPoint(evt.getPoint());
        txtIdCliente.setText(TablaCliente.getValueAt(fila, 0).toString());
        txtDNICliente.setText(TablaCliente.getValueAt(fila, 1).toString());
        txtNombreCliente.setText(TablaCliente.getValueAt(fila, 2).toString());
        txtTelefonoCliente.setText(TablaCliente.getValueAt(fila, 3).toString());
        txtDireccionCliente.setText(TablaCliente.getValueAt(fila, 4).toString());
        txtRazonSocialCliente.setText(TablaCliente.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_TablaClienteMouseClicked

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
        // TODO add your handling code here:
        if(!"".equals(txtIdCliente.getText())){
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Estas seguro de querer eliminar?");
            if(pregunta == 0){
                int id = Integer.parseInt(txtIdCliente.getText());
                clientesCRUD.EliminarCliente(id);
                limpiarCampos();
                limpiarCliente();
                listarCliente();
            }else{
                JOptionPane.showMessageDialog(null, "Seleccione una fila");
            }
        }
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
        if("".equals(txtIdCliente.getText())){
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un fila");
        }else{
 
            if(!"".equals(txtDNICliente.getText())|| !"".equals(txtNombreCliente.getText()) || !"".equals(txtTelefonoCliente.getText()) || !"".equals(txtDireccionCliente.getText()) || !"".equals(txtRazonSocialCliente.getText())){
                clientes.setDni((txtDNICliente.getText()));
            clientes.setNombre(txtNombreCliente.getText());
            clientes.setTelefono(Integer.parseInt(txtTelefonoCliente.getText()));
            clientes.setDireccion(txtDireccionCliente.getText());
            clientes.setRazon(txtRazonSocialCliente.getText());
            clientes.setId(Integer.parseInt(txtIdCliente.getText()));
            
                clientesCRUD.ModificarCliente(clientes);
                limpiarCampos();
                limpiarCliente();
                listarCliente();
            }else{
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }
        }
    }//GEN-LAST:event_btnEditarClienteActionPerformed

    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed
        limpiarCliente();
    }//GEN-LAST:event_btnNuevoClienteActionPerformed

    private void btnGuardarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProveedorActionPerformed
        if(!"".equals(txtNIFProveedor.getText())|| !"".equals(txtNombreProveedor.getText()) || !"".equals(txtTelefonoProveedor.getText()) || !"".equals(txtDireccionProveedor.getText()) || !"".equals(txtRazonSocialProveedor.getText())){
            proveedor.setNif(txtNIFProveedor.getText());
            proveedor.setNombre(txtNombreProveedor.getText());
            proveedor.setTelefono(Integer.parseInt(txtTelefonoProveedor.getText()));
            proveedor.setDireccion(txtDireccionProveedor.getText());
            proveedor.setRazonsocial(txtRazonSocialProveedor.getText());
          
            proveedorCRUD.RegistrarProveedor(proveedor);
            limpiarCampos();
            limpiarProveedor();
            listarProveedor();
            
            
            JOptionPane.showMessageDialog(null, "Proveedor Registrado correctamente");
        }else{
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        }
    }//GEN-LAST:event_btnGuardarProveedorActionPerformed

    private void btnProvedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProvedoresActionPerformed
        // TODO add your handling code here:fadfad
        limpiarCampos();
        listarProveedor();
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_btnProvedoresActionPerformed

    private void TablaProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProveedorMouseClicked
        // TODO add your handling code here:
        int fila = TablaProveedor.rowAtPoint(evt.getPoint());
        txtIdProveedor.setText(TablaProveedor.getValueAt(fila, 0).toString());
        txtNIFProveedor.setText(TablaProveedor.getValueAt(fila, 1).toString());
        txtNombreProveedor.setText(TablaProveedor.getValueAt(fila, 2).toString());
        txtTelefonoProveedor.setText(TablaProveedor.getValueAt(fila, 3).toString());
        txtDireccionProveedor.setText(TablaProveedor.getValueAt(fila, 4).toString());
        txtRazonSocialProveedor.setText(TablaProveedor.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_TablaProveedorMouseClicked

    private void btnEliminarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProveedorActionPerformed
        if(!"".equals(txtIdProveedor.getText())){
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Estas seguro de querer eliminar?");
            if(pregunta == 0){
                int id = Integer.parseInt(txtIdProveedor.getText());
                proveedorCRUD.EliminarProveedor(id);
                limpiarCampos();
                limpiarProveedor();
                listarProveedor();
                
                
            }
        }else{
            JOptionPane.showMessageDialog(null, "");
        }
    }//GEN-LAST:event_btnEliminarProveedorActionPerformed

    private void btnEditarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProveedorActionPerformed
        if("".equals(txtIdProveedor.getText())){
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila");
        }else{
 
            if(!"".equals(txtNIFProveedor.getText())|| !"".equals(txtNombreProveedor.getText()) || !"".equals(txtTelefonoProveedor.getText()) || !"".equals(txtDireccionProveedor.getText()) || !"".equals(txtRazonSocialProveedor.getText())){
                proveedor.setNif(txtNIFProveedor.getText());
                proveedor.setNombre(txtNombreProveedor.getText());
                proveedor.setTelefono(Integer.parseInt(txtTelefonoProveedor.getText()));
                proveedor.setDireccion(txtDireccionProveedor.getText());
                proveedor.setRazonsocial(txtRazonSocialProveedor.getText());
                proveedor.setId(Integer.parseInt(txtIdProveedor.getText()));
            
                proveedorCRUD.ModificarProveedor(proveedor);
                limpiarCampos();
                listarProveedor();
                limpiarProveedor();
                
            }else{
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }
        }
    }//GEN-LAST:event_btnEditarProveedorActionPerformed

    private void btnNuevoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProveedorActionPerformed
        limpiarProveedor();
    }//GEN-LAST:event_btnNuevoProveedorActionPerformed

    private void btnGuardarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProdActionPerformed
        if(!"".equals(txtCodigoProd.getText())|| !"".equals(txtDescripcionProd.getText()) || !"".equals(cbxProveedorProd.getSelectedItem())|| !"".equals(txtCantidadProd.getText()) || !"".equals(txtPrecioProd.getText())){
            productos.setCodigo(txtCodigoProd.getText());
            productos.setNombre(txtDescripcionProd.getText());
            productos.setProveedor(cbxProveedorProd.getSelectedItem().toString());
            productos.setStock(Integer.parseInt(txtCantidadProd.getText()));
            productos.setPrecio(Double.parseDouble(txtPrecioProd.getText()));
          
            productoCRUD.RegistrarProducto(productos);
            limpiarCampos();
            limpiarProducto();
            listarProdcutos();
            JOptionPane.showMessageDialog(null, "Producto Registrado correctamente");
        }else{
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        }
    }//GEN-LAST:event_btnGuardarProdActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        limpiarCampos();
        listarProdcutos();
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnProductosActionPerformed

    private void TablaProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProductoMouseClicked
        int fila = TablaProducto.rowAtPoint(evt.getPoint());
        txtIdProducto.setText(TablaProducto.getValueAt(fila, 0).toString());
        txtCodigoProd.setText(TablaProducto.getValueAt(fila, 1).toString());
        txtDescripcionProd.setText(TablaProducto.getValueAt(fila, 2).toString());
        cbxProveedorProd.setSelectedItem(TablaProducto.getValueAt(fila, 3));
        txtCantidadProd.setText(TablaProducto.getValueAt(fila, 4).toString());
        txtPrecioProd.setText(TablaProducto.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_TablaProductoMouseClicked

    private void btnEliminarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProdActionPerformed
        if(!"".equals(txtIdProducto.getText())){
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Estas seguro de querer eliminar?");
            if(pregunta == 0){
                int id = Integer.parseInt(txtIdProducto.getText());
                productoCRUD.EliminarProducto(id);
                limpiarCampos();
                limpiarProducto();
                listarProdcutos();
                
            }
        }
    }//GEN-LAST:event_btnEliminarProdActionPerformed

    private void btnEditarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProdActionPerformed
        if("".equals(txtIdProducto.getText())){
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un fila");
        }else{
 
            if(!"".equals(txtCodigoProd.getText())|| !"".equals(txtDescripcionProd.getText()) || !"".equals(cbxProveedorProd.getSelectedItem()) || !"".equals(txtCantidadProd.getText()) || !"".equals(txtPrecioProd.getText())){
                productos.setCodigo(txtCodigoProd.getText());
                productos.setNombre(txtDescripcionProd.getText());
                productos.setProveedor(cbxProveedorProd.getSelectedItem().toString());
                productos.setStock(Integer.parseInt(txtCantidadProd.getText()));
                productos.setPrecio(Double.parseDouble(txtPrecioProd.getText()));
                productos.setId(Integer.parseInt(txtIdProducto.getText()));
            
                productoCRUD.ModificarProductos(productos);
                JOptionPane.showMessageDialog(null, "Producto modificado correctamente");
                limpiarCampos();
                listarProdcutos();
                limpiarProducto();
                
            }else{
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }
        }
    }//GEN-LAST:event_btnEditarProdActionPerformed

    private void btnGuardarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEmpleadoActionPerformed
        if(!"".equals(txtNombreEmpleado.getText())|| !"".equals(txtUserEmpleado.getText()) || !"".equals(txtPassEmpleado.getText())){
          empleados.setNombre(txtNombreEmpleado.getText());
          empleados.setUsuario(txtUserEmpleado.getText());
          empleados.setPass(txtPassEmpleado.getText());
          
          empleadosCRUD.RegistrarEmpleado(empleados);
          limpiarCampos();
          limpiarEmpleados();
          listarEmpleados();
          JOptionPane.showMessageDialog(null, "Empleado/Usuario Registrado");
        }else{
            JOptionPane.showMessageDialog(null, "Los campos estan vacios");
        }
    }//GEN-LAST:event_btnGuardarEmpleadoActionPerformed

    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed
        limpiarCampos();
        listarEmpleados();
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_btnEmpleadosActionPerformed

    private void TablaEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaEmpleadosMouseClicked
         int fila = TablaEmpleados.rowAtPoint(evt.getPoint());
        txtIdEmpleado.setText(TablaEmpleados.getValueAt(fila, 0).toString());
        txtNombreEmpleado.setText(TablaEmpleados.getValueAt(fila, 1).toString());
        txtUserEmpleado.setText(TablaEmpleados.getValueAt(fila, 2).toString());
        txtPassEmpleado.setText(TablaEmpleados.getValueAt(fila, 3).toString());
    }//GEN-LAST:event_TablaEmpleadosMouseClicked

    private void btnEliminarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEmpleadoActionPerformed
        if(!"".equals(txtIdEmpleado.getText())){
            int pregunta = JOptionPane.showConfirmDialog(null, "¿Estas seguro de querer eliminar?");
            if(pregunta == 0){
                int id = Integer.parseInt(txtIdEmpleado.getText());
                empleadosCRUD.EliminarEmpleado(id);
                limpiarCampos();
                listarEmpleados();
                limpiarEmpleados();
                
            }
        }
    }//GEN-LAST:event_btnEliminarEmpleadoActionPerformed

    private void btnNuevoProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProdActionPerformed
        limpiarProducto();
    }//GEN-LAST:event_btnNuevoProdActionPerformed

    private void btnNuevoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoEmpleadoActionPerformed
        limpiarEmpleados();
    }//GEN-LAST:event_btnNuevoEmpleadoActionPerformed

    private void btnEditarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarEmpleadoActionPerformed
        if("".equals(txtIdEmpleado.getText())){
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un fila");
        }else{
 
            if(!"".equals(txtNombreEmpleado.getText())|| !"".equals(txtUserEmpleado.getText()) || !"".equals(txtPassEmpleado.getText())){
                empleados.setNombre(txtNombreEmpleado.getText());
                empleados.setUsuario(txtUserEmpleado.getText());
                empleados.setPass(txtPassEmpleado.getText());
                empleados.setId(Integer.parseInt(txtIdEmpleado.getText()));
            
                empleadosCRUD.ModificarEmpleado(empleados);
                JOptionPane.showMessageDialog(null, "Empleado modificado correctamente");
                limpiarCampos();
                listarEmpleados();
                limpiarEmpleados();
                
            }else{
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }
        }
    }//GEN-LAST:event_btnEditarEmpleadoActionPerformed
    
    
    private void cbxProductosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxProductosItemStateChanged

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if(!"".equals(cbxProductos.getSelectedItem())){
                String nombre=(String) cbxProductos.getSelectedItem();
                productos= productoCRUD.BuscarProductos(nombre);
                if(productos.getCodigo() != null){
                    txtCodigoVenta.setText(""+productos.getCodigo());
                    txtProductoVenta.setText(""+productos.getNombre());
                    txtPrecioVenta.setText(""+productos.getPrecio());
                    txtStock.setText(""+productos.getStock());
                    txtCantidadVenta.requestFocus();
                }else{
                    
                    cbxProductos.requestFocus();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre del producto");
                        
            }
          
        }
        
    }//GEN-LAST:event_cbxProductosItemStateChanged

    private void cbxClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxClienteItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if(!"".equals(cbxCliente.getSelectedItem())){
                String nombre=(String) cbxCliente.getSelectedItem();
                clientes= clientesCRUD.BuscarCliente(nombre);
                if(clientes.getDni() != null){
                    txtDNIVenta.setText(""+clientes.getDni());
                    txtNombreClienteVenta.setText(""+clientes.getNombre());
                    txtDireccionClienteVenta.setText(""+clientes.getDireccion());
                    txtTelefonoClienteVenta.setText(""+clientes.getTelefono());
                    txtRazonClienteVenta.setText(""+clientes.getRazon());
                }else{
                    JOptionPane.showMessageDialog(null, "El cliente no existe");
                    cbxCliente.requestFocus();
                }
            }
                
        }
    }//GEN-LAST:event_cbxClienteItemStateChanged

    private void btnGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarVentaActionPerformed
        if(TablaVenta.getRowCount()> 0){
            if(!"".equals(txtNombreClienteVenta.getText())){
                RegistrarVenta();
                RegistrarPedido();
                ActualizarStockDisponible();
                pdf();
                LimpiarNuevoPedido();
                LimpiarClienteNuevoPedido();
            }else{
                JOptionPane.showMessageDialog(null, "Por favor, selecciona un cliente");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Por favor seleccione los productos");
        }
        
    }//GEN-LAST:event_btnGenerarVentaActionPerformed

    private void btnEliminarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVentaActionPerformed
        modelo = (DefaultTableModel) TablaVenta.getModel();
        modelo.removeRow(TablaVenta.getSelectedRow());
        CalcularTotal();
        cbxProductos.requestFocus();
    }//GEN-LAST:event_btnEliminarVentaActionPerformed

    private void btnAgregarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarArticuloActionPerformed
        // TODO add your handling code here:
        CantidadStock();
    }//GEN-LAST:event_btnAgregarArticuloActionPerformed

    private void txtProductoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductoVentaActionPerformed
        
    }//GEN-LAST:event_txtProductoVentaActionPerformed

    private void txtProductoVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoVentaKeyTyped
        validar.soloTexto(evt);
    }//GEN-LAST:event_txtProductoVentaKeyTyped

    private void txtCantidadVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadVentaKeyTyped
        validar.soloNumeros(evt);
    }//GEN-LAST:event_txtCantidadVentaKeyTyped

    private void txtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyTyped
        validar.soloNumeros(evt);
    }//GEN-LAST:event_txtStockKeyTyped

    private void txtPrecioVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaKeyTyped
        validar.soloDecimales(evt, txtPrecioVenta);        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioVentaKeyTyped

    private void txtNombreClienteVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreClienteVentaKeyTyped
        validar.soloTexto(evt);
    }//GEN-LAST:event_txtNombreClienteVentaKeyTyped

    private void TablaVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaVentasMouseClicked
        int fila = TablaVentas.rowAtPoint(evt.getPoint());
        txtIDVenta.setText(TablaVentas.getValueAt(fila, 0).toString());
    }//GEN-LAST:event_TablaVentasMouseClicked

    private void btnPDFVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFVentasActionPerformed
        try {
            int id = Integer.parseInt(txtIDVenta.getText());
            File file = new File("src/PDF_Venta/pedido"+id+".pdf");
            Desktop.getDesktop().open(file);
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }//GEN-LAST:event_btnPDFVentasActionPerformed

    private void txtTelefonoClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoClienteKeyTyped
        validar.soloNumeros(evt);
    }//GEN-LAST:event_txtTelefonoClienteKeyTyped

    private void txtCantidadProdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadProdKeyTyped
        validar.soloNumeros(evt);
    }//GEN-LAST:event_txtCantidadProdKeyTyped
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaCliente;
    private javax.swing.JTable TablaEmpleados;
    private javax.swing.JTable TablaProducto;
    private javax.swing.JTable TablaProveedor;
    private javax.swing.JTable TablaVenta;
    private javax.swing.JTable TablaVentas;
    private javax.swing.JButton btnAgregarArticulo;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnEditarEmpleado;
    private javax.swing.JButton btnEditarProd;
    private javax.swing.JButton btnEditarProveedor;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnEliminarEmpleado;
    private javax.swing.JButton btnEliminarProd;
    private javax.swing.JButton btnEliminarProveedor;
    private javax.swing.JButton btnEliminarVenta;
    private javax.swing.JButton btnEmpleados;
    private javax.swing.JButton btnGenerarVenta;
    private javax.swing.JButton btnGuardarCliente;
    private javax.swing.JButton btnGuardarEmpleado;
    private javax.swing.JButton btnGuardarProd;
    private javax.swing.JButton btnGuardarProveedor;
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JButton btnNuevoEmpleado;
    private javax.swing.JButton btnNuevoPedido;
    private javax.swing.JButton btnNuevoProd;
    private javax.swing.JButton btnNuevoProveedor;
    private javax.swing.JButton btnPDFVentas;
    private javax.swing.JButton btnPedidos;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnProvedores;
    private javax.swing.JComboBox<String> cbxCliente;
    private javax.swing.JComboBox<String> cbxProductos;
    private javax.swing.JComboBox<String> cbxProveedorProd;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblEmpleado;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalaPagar;
    private javax.swing.JTextField txtCantidadProd;
    private javax.swing.JTextField txtCantidadVenta;
    private javax.swing.JTextField txtCodigoProd;
    private javax.swing.JTextField txtCodigoVenta;
    private javax.swing.JTextField txtDNICliente;
    private javax.swing.JTextField txtDNIVenta;
    private javax.swing.JTextField txtDescripcionProd;
    private javax.swing.JTextField txtDireccionCliente;
    private javax.swing.JTextField txtDireccionClienteVenta;
    private javax.swing.JTextField txtDireccionProveedor;
    private javax.swing.JTextField txtIDVenta;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdEmpleado;
    private javax.swing.JTextField txtIdProd;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtIdProveedor;
    private javax.swing.JTextField txtNIFProveedor;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreClienteVenta;
    private javax.swing.JTextField txtNombreEmpleado;
    private javax.swing.JTextField txtNombreProveedor;
    private javax.swing.JTextField txtPassEmpleado;
    private javax.swing.JTextField txtPrecioProd;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtProductoVenta;
    private javax.swing.JTextField txtRazonClienteVenta;
    private javax.swing.JTextField txtRazonSocialCliente;
    private javax.swing.JTextField txtRazonSocialProveedor;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtTelefonoCliente;
    private javax.swing.JTextField txtTelefonoClienteVenta;
    private javax.swing.JTextField txtTelefonoProveedor;
    private javax.swing.JTextField txtUserEmpleado;
    // End of variables declaration//GEN-END:variables

    
    private void pdf(){
        try {
            int id = ventasCUD.IdVentas();
            FileOutputStream archivo;
            File file = new File("src/PDF_Venta/pedido"+id+".pdf");
            archivo = new FileOutputStream(file);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Image img = Image.getInstance("src/img/factura.jpg");
            
            
            Paragraph fecha =  new Paragraph();
            //Font fuente = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
            fecha.add(Chunk.NEWLINE);
            Date date = new Date();
            fecha.add("Factura: "+id+"\n"+"Fecha: "+new SimpleDateFormat("dd/MM/yyyy").format(date)+"\n\n");
            
            
            PdfPTable encabezado = new PdfPTable(4);
            encabezado.setWidthPercentage(100);
            encabezado.getDefaultCell().setBorder(0);
            float[] ColumnaEncabezado = new float[]{40f,30f,70f,40f};
            encabezado.setWidths(ColumnaEncabezado);
            encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            encabezado.addCell(img);
            
            String nif = "B49247091";
            String nombre = "Bodegas Ramayal SL";
            String telefono = "695896366";
            String direccion = "Zamora";
            String razonsocial = "Bodegas Ramayal SL";
            
            encabezado.addCell("");
            encabezado.addCell("NIF: "+nif+"\nNombre: "+nombre+"\nTelefono: "+telefono+"\nDireccion: "+direccion+"\nRazon Social: "+razonsocial);
            encabezado.addCell(fecha);
            doc.add(encabezado);
            
            
            Paragraph clientes =  new Paragraph();
            clientes.add(Chunk.NEWLINE);
            clientes.add("Datos de los clientes"+"\n\n");
            doc.add(clientes);
            
            
            /*
            CLIENTES
            */
            PdfPTable tablaClientes = new PdfPTable(4);
            tablaClientes.setWidthPercentage(100);
            tablaClientes.getDefaultCell().setBorder(0);
            float[] ColumnaClientes = new float[]{20f,50f,30f,40f};
            tablaClientes.setWidths(ColumnaClientes);
            tablaClientes.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cliente1 = new PdfPCell(new Phrase("Dni/NIF"));
            PdfPCell cliente2 = new PdfPCell(new Phrase("Nombre"));
            PdfPCell cliente3 = new PdfPCell(new Phrase("Telefono"));
            PdfPCell cliente4 = new PdfPCell(new Phrase("Direccion"));
            cliente1.setBorder(0);
            cliente2.setBorder(0);
            cliente3.setBorder(0);
            cliente4.setBorder(0);
            cliente1.setBackgroundColor(BaseColor.DARK_GRAY);
            cliente2.setBackgroundColor(BaseColor.DARK_GRAY);
            cliente3.setBackgroundColor(BaseColor.DARK_GRAY);
            cliente4.setBackgroundColor(BaseColor.DARK_GRAY);
            tablaClientes.addCell(cliente1);
            tablaClientes.addCell(cliente2);
            tablaClientes.addCell(cliente3);
            tablaClientes.addCell(cliente4);
            tablaClientes.addCell(txtDNIVenta.getText());
            tablaClientes.addCell(txtNombreClienteVenta.getText());
            tablaClientes.addCell(txtTelefonoClienteVenta.getText());
            tablaClientes.addCell(txtDireccionClienteVenta.getText());
            doc.add(tablaClientes);
            
            
            /*
            Productos
            */
            PdfPTable tablaProductos = new PdfPTable(4);
            tablaProductos.setWidthPercentage(100);
            tablaProductos.getDefaultCell().setBorder(0);
            float[] ColumnaProductos = new float[]{10f,50f,15f,20f};
            tablaProductos.setWidths(ColumnaProductos);
            tablaProductos.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell producto1 = new PdfPCell(new Phrase("Cantidad"));
            PdfPCell producto2 = new PdfPCell(new Phrase("Nombre"));
            PdfPCell producto3 = new PdfPCell(new Phrase("Precio"));
            PdfPCell producto4 = new PdfPCell(new Phrase("Total"));
            producto1.setBorder(0);
            producto2.setBorder(0);
            producto3.setBorder(0);
            producto4.setBorder(0);
            producto1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tablaProductos.addCell(producto1);
            tablaProductos.addCell(producto2);
            tablaProductos.addCell(producto3);
            tablaProductos.addCell(producto4);
            for (int i = 0; i < TablaVenta.getRowCount(); i++) {
                String producto = TablaVenta.getValueAt(i, 1).toString();
                String cantidad = TablaVenta.getValueAt(i, 2).toString();
                String precio = TablaVenta.getValueAt(i, 3).toString();
                String total =  TablaVenta.getValueAt(i, 4).toString();
                tablaProductos.addCell(cantidad);
                tablaProductos.addCell(producto);
                tablaProductos.addCell(precio);
                tablaProductos.addCell(total);
            }
            
            doc.add(tablaProductos);
            
            Paragraph info =  new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("TOTAL a pagar: " + TotalaPagar);
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);
            
            Paragraph firma =  new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Firma\n\n");
            firma.add("\n\n-------------------------------");
            info.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);
            
            Paragraph mensaje =  new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("\n\nGracias por su compra");
            info.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);
            
            
            doc.close();
            archivo.close();
            Desktop.getDesktop().open(file);
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }



}
