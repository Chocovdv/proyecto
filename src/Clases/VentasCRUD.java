/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author amart
 */
public class VentasCRUD {
    Connection con;
    Conexion objetoConexion = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int respuesta;
    
    /**
     * Registra una nueva venta en la base de datos.
     * @param venta La venta a registrar.
     * @return El resultado de la operación de registro.
     */
    public int RegistrarVenta(Ventas venta){
        String sql ="INSERT INTO ventas (idClientes,idUsuario, total,fecha) VALUES (?,?,?,?)";
        try {
            con = objetoConexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, venta.getCliente());
            ps.setString(2, venta.getEmpleado());
            ps.setDouble(3, venta.getTotal());
            ps.setString(4, venta.getFecha());
            ps.execute();
            
        } catch (Exception e) {
            System.out.println("Error "+e);
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error "+e);
            }
        }
        return respuesta;
    }
    /**
     * Registra un nuevo pedido en la base de datos.
     * @param pedido El pedido a registrar.
     * @return El resultado de la operación de registro.
     */
    public int RegistrarPedido(Pedidos pedido){
        String sql = "INSERT INTO ventas_has_productos (idProductos,Cantidad,Precio,idVentas) VALUES (?,?,?,?)";
        try {
            con = objetoConexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, pedido.getProductos());
            ps.setInt(2, pedido.getCantidad());
            ps.setDouble(3, pedido.getPrecio());
            ps.setInt(4, pedido.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println("Error "+e);
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error: "+e);
            }
        }
        return respuesta;
        
    }
    /**
     * Actualiza el stock de un producto en la base de datos.
     * @param cantidad La nueva cantidad de stock.
     * @param producto El nombre del producto.
     * @return true si la actualización fue exitosa, false si ocurrió un error.
     */
    public boolean ActualizarStock(int cantidad, String producto){
        String sql ="UPDATE productos SET stock=? WHERE nombre=?";
        try{
            con = objetoConexion.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cantidad);
            ps.setString(2, producto);
            ps.execute();
            return true;
        }catch(Exception e){
            System.out.println("Error: "+e);
            return false;
        }
    }
    /**
     * Lista todos los pedidos almacenados en la base de datos.
     * @return Una lista de pedidos.
     */
    public List ListarPedidos(){
        List<Ventas> listaPedidos = new ArrayList();
        String sql ="SELECT * from ventas";
        try {
            con=objetoConexion.conectar();
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Ventas objetoPedidos = new Ventas();
                objetoPedidos.setId(rs.getInt("idVentas"));
                objetoPedidos.setCliente(rs.getString("idClientes"));
                objetoPedidos.setEmpleado(rs.getString("idUsuario"));
                objetoPedidos.setTotal(rs.getDouble("total"));
                listaPedidos.add(objetoPedidos);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return listaPedidos;
    }
    /**
     * Obtiene el ID de la última venta registrada en la base de datos.
     * @return El ID de la última venta.
     */
    public int IdVentas(){
        int id = 0;
        String sql = "SELECT MAX(idVentas) FROM ventas";
        try {
            con = objetoConexion.conectar();
            ps= con.prepareStatement(sql);
            rs =  ps.executeQuery();
            if(rs.next()){
                id=rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return id;
    }
    
}
