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
