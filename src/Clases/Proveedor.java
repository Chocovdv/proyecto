/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author amart
 */
public class Proveedor {
    private int id;
    private String nif;
    private String nombre;
    private int telefono;
    private String direccion;
    private String razonsocial;
    
    public Proveedor(){
        
    }

    public Proveedor(int id, String nif, String nombre, int telefono, String direccion, String razonsocial) {
        this.id = id;
        this.nif = nif;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.razonsocial = razonsocial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }
    
    
}
