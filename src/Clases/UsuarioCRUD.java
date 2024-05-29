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
 * @author DAW
 */
public class UsuarioCRUD {
    Conexion objetoConex =  new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
     public boolean RegistrarEmpleado(Usuario emple){
        String sql = "INSERT INTO usuario (nombre, usuario,password) VALUES (?,?,?)";
        try {
            con= objetoConex.conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, emple.getNombre());
            ps.setString(2, emple.getUsuario());
            ps.setString(3, emple.getPass());
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
     public List ListarEmpleado(){
        List<Usuario> listaEmple = new ArrayList();
        String sql ="SELECT * from usuario";
        try {
            con=objetoConex.conectar();
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Usuario objetoEmple = new Usuario();
                objetoEmple.setId(rs.getInt("idUsuario"));
                objetoEmple.setNombre(rs.getString("nombre"));
                objetoEmple.setUsuario(rs.getString("usuario"));
                objetoEmple.setPass(rs.getString("password"));
                listaEmple.add(objetoEmple);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return listaEmple;
    }
     public boolean EliminarEmpleado(int id){
        String sql = "DELETE FROM usuario WHERE idUsuario = ?";
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
     public boolean ModificarEmpleado(Usuario emple){
        String sql = "UPDATE usuario SET nombre=?,usuario=?,password=? WHERE idUsuario=?";
        try {
            con=objetoConex.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, emple.getNombre());
            ps.setString(2, emple.getUsuario());
            ps.setString(3, emple.getPass());
            ps.setInt(4, emple.getId());
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
