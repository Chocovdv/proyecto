/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 * La clase Clientes representa un cliente con información básica
 * como id, dni, nombre, teléfono, dirección y razón social.
 * 
 * @autor amart
 */
public class Clientes {
    private int id;
    private String dni;
    private String nombre;
    private int telefono;
    private String direccion;
    private String razon;

    /**
     * Constructor por defecto para la clase Clientes.
     */
    public Clientes(){
        
    }

    /**
     * Constructor con parámetros para inicializar un objeto Clientes.
     * 
     * @param id El ID del cliente.
     * @param dni El DNI del cliente.
     * @param nombre El nombre del cliente.
     * @param telefono El número de teléfono del cliente.
     * @param direccion La dirección del cliente.
     * @param razon La razón social del cliente.
     */
    public Clientes(int id, String dni, String nombre, int telefono, String direccion, String razon) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.razon = razon;
    }
    
    /**
     * Establece el ID del cliente.
     * 
     * @param id El nuevo ID del cliente.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del cliente.
     * 
     * @param id El nuevo ID del cliente.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el DNI del cliente.
     * 
     * @return El DNI del cliente.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del cliente.
     * 
     * @param dni El nuevo DNI del cliente.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el nombre del cliente.
     * 
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     * 
     * @param nombre El nuevo nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el número de teléfono del cliente.
     * 
     * @return El número de teléfono del cliente.
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del cliente.
     * 
     * @param telefono El nuevo número de teléfono del cliente.
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    /**
     * Obtiene la dirección del cliente.
     * 
     * @return La dirección del cliente.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del cliente.
     * 
     * @param direccion La nueva dirección del cliente.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    /**
     * Obtiene la razón social del cliente.
     * 
     * @return La razón social del cliente.
     */
    public String getRazon() {
        return razon;
    }

    /**
     * Establece la razón social del cliente.
     * 
     * @param razon La nueva razón social del cliente.
     */
    public void setRazon(String razon) {
        this.razon = razon;
    }
    
    
}
