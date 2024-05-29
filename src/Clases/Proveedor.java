/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 * La clase Proveedor representa un proveedor de productos.
 * @author amart
 */


public class Proveedor {
    private int id;
    private String nif;
    private String nombre;
    private int telefono;
    private String direccion;
    private String razonsocial;
    
    /**
     * Constructor parametrizado de la clase Proveedor.
     * @param id El ID del proveedor.
     * @param nif El NIF del proveedor.
     * @param nombre El nombre del proveedor.
     * @param telefono El número de teléfono del proveedor.
     * @param direccion La dirección del proveedor.
     * @param razonsocial La razón social del proveedor.
     */
    public Proveedor(){
        
    }

    /**
     * Constructor parametrizado de la clase Proveedor.
     * @param id El ID del proveedor.
     * @param nif El NIF del proveedor.
     * @param nombre El nombre del proveedor.
     * @param telefono El número de teléfono del proveedor.
     * @param direccion La dirección del proveedor.
     * @param razonsocial La razón social del proveedor.
     */
    public Proveedor(int id, String nif, String nombre, int telefono, String direccion, String razonsocial) {
        this.id = id;
        this.nif = nif;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.razonsocial = razonsocial;
    }

    /**
     * Obtiene el ID del proveedor.
     * @return El ID del proveedor.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del proveedor.
     * @param id El nuevo ID del proveedor.
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Obtiene el NIF del proveedor.
     * @return El NIF del proveedor.
     */

    public String getNif() {
        return nif;
    }

    
    /**
     * Establece el NIF del proveedor.
     * @param nif El nuevo NIF del proveedor.
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * Obtiene el nombre del proveedor.
     * @return El nombre del proveedor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del proveedor.
     * @param nombre El nuevo nombre del proveedor.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el número de teléfono del proveedor.
     * @return El número de teléfono del proveedor.
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del proveedor.
     * @param telefono El nuevo número de teléfono del proveedor.
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la dirección del proveedor.
     * @return La dirección del proveedor.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del proveedor.
     * @param direccion La nueva dirección del proveedor.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene la razón social del proveedor.
     * @return La razón social del proveedor.
     */
    public String getRazonsocial() {
        return razonsocial;
    }
    /**
     * Establece la razón social del proveedor.
     * @param razonsocial La nueva razón social del proveedor.
     */
    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }
    
    
}
