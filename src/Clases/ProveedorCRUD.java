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
public class ProveedorCRUD {
    Conexion objetoConex =  new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public boolean RegistrarProveedor(Proveedor prov){
        String sql = "INSERT INTO proveedores (NIF,nombre,telefono,direccion,razonsocial) VALUES (?,?,?,?,?)";
        try {
            con= objetoConex.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, prov.getNif());
            ps.setString(2, prov.getNombre());
            ps.setInt(3, prov.getTelefono());
            ps.setString(4, prov.getDireccion());
            ps.setString(5, prov.getRazonsocial());
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
    public List ListarProveedor(){
        List<Proveedor> listaProv = new ArrayList();
        String sql ="SELECT * from proveedores";
        try {
            con=objetoConex.conectar();
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Proveedor objetoProveedor = new Proveedor();
                objetoProveedor.setId(rs.getInt("idProveedores"));
                objetoProveedor.setNif(rs.getString("NIF"));
                objetoProveedor.setNombre(rs.getString("nombre"));
                objetoProveedor.setTelefono(rs.getInt("telefono"));
                objetoProveedor.setDireccion(rs.getString("direccion"));
                objetoProveedor.setRazonsocial(rs.getString("razonsocial"));
                listaProv.add(objetoProveedor);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return listaProv;
    }
    public boolean EliminarProveedor(int id){
        String sql = "DELETE FROM proveedores WHERE idProveedores = ?";
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
    public boolean ModificarProveedor(Proveedor prov){
        String sql = "UPDATE proveedores SET NIF=?,nombre=?,telefono=?,direccion=?,razonsocial=? WHERE idProveedores=?";
        try {
            con=objetoConex.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, prov.getNif());
            ps.setString(2, prov.getNombre());
            ps.setInt(3, prov.getTelefono());
            ps.setString(4, prov.getDireccion());
            ps.setString(5,prov.getRazonsocial());
            ps.setInt(6, prov.getId());
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
}
