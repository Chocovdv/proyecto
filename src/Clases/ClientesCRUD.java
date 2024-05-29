/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author amart
 */
public class ClientesCRUD {
    Conexion objetoConex =  new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public boolean RegistrarCliente(Clientes cl){
        String sql = "INSERT INTO clientes  (DNI, nombre, telefono,direccion, razonsocial) VALUES (?,?,?,?,?)";
        try {
            con= objetoConex.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, cl.getDni());
            ps.setString(2, cl.getNombre());
            ps.setInt(3, cl.getTelefono());
            ps.setString(4, cl.getDireccion());
            ps.setString(5, cl.getRazon());
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
    public List ListarCliente(){
        List<Clientes> listaCl = new ArrayList();
        String sql ="SELECT * from clientes";
        try {
            con=objetoConex.conectar();
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Clientes objetoClientes = new Clientes();
                objetoClientes.setId(rs.getInt("idClientes"));
                objetoClientes.setDni(rs.getString("DNI"));
                objetoClientes.setNombre(rs.getString("nombre"));
                objetoClientes.setTelefono(rs.getInt("telefono"));
                objetoClientes.setDireccion(rs.getString("direccion"));
                objetoClientes.setRazon(rs.getString("razonsocial"));
                listaCl.add(objetoClientes);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return listaCl;
    }
    public boolean EliminarCliente(int id){
        String sql = "DELETE FROM clientes WHERE idClientes = ?";
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
    public boolean ModificarCliente(Clientes client){
        String sql = "UPDATE clientes SET DNI=?,nombre=?,telefono=?,direccion=?,razonsocial=? WHERE idClientes=?";
        try {
            con=objetoConex.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, client.getDni());
            ps.setString(2, client.getNombre());
            ps.setInt(3, client.getTelefono());
            ps.setString(4, client.getDireccion());
            ps.setString(5,client.getRazon());
            ps.setInt(6, client.getId());
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
    
    
    //#######################################
    //              NUEVO PEDIDO
    //######################################
    
    public Clientes BuscarCliente(String nombre){
        Clientes objetoCliente = new Clientes();
        String sql = "SELECT * FROM clientes WHERE nombre= ? ";
        try {
            con = objetoConex.conectar();
            ps =  con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs=ps.executeQuery();
            if(rs.next()){
                objetoCliente.setDni(rs.getString("DNI"));
                objetoCliente.setNombre(rs.getString("nombre"));
                objetoCliente.setTelefono(rs.getInt("telefono"));
                objetoCliente.setDireccion(rs.getString("direccion"));
                objetoCliente.setRazon(rs.getString("razonsocial"));
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return objetoCliente;
    }
    
   
    public void ConsultarCliente(JComboBox cliente){
        String sql = "SELECT nombre FROM clientes";
        try {
            con =  objetoConex.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                cliente.addItem(rs.getString("nombre"));
            }
        } catch (Exception e) {
            System.out.println("Error "+e);
        }
    }
    
}

