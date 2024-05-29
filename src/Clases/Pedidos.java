/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author amart
 */
public class Pedidos {
    private int id;
    private String productos;
    private int cantidad;
    private double precio;
    private int venta;
    
    public Pedidos(){
        
    }

    public Pedidos(int id, String productos, int cantidad, double precio, int venta) {
        this.id = id;
        this.productos = productos;
        this.cantidad = cantidad;
        this.precio = precio;
        this.venta = venta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getVenta() {
        return venta;
    }

    public void setVenta(int venta) {
        this.venta = venta;
    }
    
    
}
