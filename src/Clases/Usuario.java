/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 * La clase Usuario representa un usuario del sistema.
 * @author DAW
 */

public class Usuario {
    private int id;
    private String nombre;
    private String usuario;
    private String pass;
    
    /**
     * Constructor por defecto de la clase Usuario.
     */
    public Usuario(){
        
    }

    /**
     * Constructor parametrizado de la clase Usuario.
     * @param id El ID del usuario.
     * @param nombre El nombre del usuario.
     * @param usuario El nombre de usuario único del usuario.
     * @param pass La contraseña del usuario.
     */
    public Usuario(int id, String nombre, String usuario, String pass) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.pass = pass;
    }

    /**
     * Obtiene el ID del usuario.
     * @return El ID del usuario.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del usuario.
     * @param id El nuevo ID del usuario.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del usuario.
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del usuario.
     * @param nombre El nuevo nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre de usuario único.
     * @return El nombre de usuario único.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre de usuario único.
     * @param usuario El nuevo nombre de usuario único.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    /**
     * Obtiene la contraseña del usuario.
     * @return La contraseña del usuario.
     */

    public String getPass() {
        return pass;
    }

    /**
     * Establece la contraseña del usuario.
     * @param pass La nueva contraseña del usuario.
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
}
