/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author amart
 */
public class Conexion {
    String bd1="bodega";
    String bd2="?autoReconnect=true&useSSL=false";
    String user = "Adrian";
    String password = "p@ssw0rd";
    String url ="jdbc:mysql://localhost/";
    String driver = "com.mysql.jdbc.Driver";
    Connection conex = null;
    
    public Connection conectar(){
        try{
            Class.forName(driver);
            conex=DriverManager.getConnection(url+bd1+bd2,user,password);
            //JOptionPane.showMessageDialog(null, "Se conectó a la BD " + bd1);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error en la conexión con la BD "+bd1);
        }
        return conex;
    }
    public void desconectar(){
        try{
            if(conex!=null && !conex.isClosed()){
                conex.close();
                JOptionPane.showMessageDialog(null, "Conexión cerrada");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "NO se puede cerrar la conexión");
        }
    }
    
}
