/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
/**
 *
 * @author amart
 */
public class ProductosCRUD {
    Conexion objetoConex =  new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarProducto(Productos prod){
        String sql = "INSERT INTO productos  (codigo,nombre,idProveedores,stock,precio) VALUES (?,?,?,?,?)";
        try {
            con= objetoConex.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, prod.getCodigo());
            ps.setString(2, prod.getNombre());
            ps.setString(3, prod.getProveedor());
            ps.setInt(4, prod.getStock());
            ps.setDouble(5, prod.getPrecio());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
    public void ConsultarProveedor(JComboBox prov){
        String sql = "SELECT nombre FROM proveedores";
        try {
            con =  objetoConex.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                prov.addItem(rs.getString("nombre"));
            }
        } catch (Exception e) {
            System.out.println("Error "+e);
        }
    }
    public List ListarProducto(){
        List<Productos> listaProd = new ArrayList();
        String sql ="SELECT * from productos";
        try {
            con=objetoConex.conectar();
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Productos objetoProductos = new Productos();
                objetoProductos.setId(rs.getInt("idProductos"));
                objetoProductos.setCodigo(rs.getString("codigo"));
                objetoProductos.setNombre(rs.getString("nombre"));
                objetoProductos.setProveedor(rs.getString("IdProveedores"));
                objetoProductos.setStock(rs.getInt("stock"));
                objetoProductos.setPrecio(rs.getDouble("precio"));
                listaProd.add(objetoProductos);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return listaProd;
    }
    public boolean EliminarProducto(int id){
        String sql = "DELETE FROM productos WHERE idProductos = ?";
        try {
            con=objetoConex.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error " +e);
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error "+e);
            }
        }
    }
    public boolean ModificarProductos(Productos prod){
        String sql = "UPDATE productos SET codigo=?,nombre=?,idProveedores=?,stock=?,precio=? WHERE idProductos=?";
        try {
            con=objetoConex.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, prod.getCodigo());
            ps.setString(2, prod.getNombre());
            ps.setString(3, prod.getProveedor());
            ps.setInt(4, prod.getStock());
            ps.setDouble(5,prod.getPrecio());
            ps.setInt(6, prod.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error   "+e);
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error "+e);
            }
        }
    }
    
    //############################################################
    /*

                            NUEVO PEDIDO

    */
    //############################################################
    
    public Productos BuscarProductos(String nombre){
        Productos objetoProducto =  new Productos();
        String sql = "SELECT * FROM productos WHERE nombre =?";
        try {
            con = objetoConex.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            if(rs.next()){
                objetoProducto.setCodigo(rs.getString("codigo"));
                objetoProducto.setNombre(rs.getString("nombre"));
                objetoProducto.setPrecio(rs.getDouble("precio"));
                objetoProducto.setStock(rs.getInt("stock"));
                
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return objetoProducto;
    }
    
    
    public void ConsultarProducto(JComboBox prod){
        String sql = "SELECT nombre FROM productos";
        try {
            con =  objetoConex.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                prod.addItem(rs.getString("nombre"));
            }
        } catch (Exception e) {
            System.out.println("Error "+e);
        }
    }
    
    
}
