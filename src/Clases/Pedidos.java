/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 * La clase Pedidos representa un pedido con información sobre los productos, 
 * cantidad, precio y venta.
 * 
 * @autor amart
 */
public class Pedidos {
    private int id;
    private String productos;
    private int cantidad;
    private double precio;
    private int venta;
    /**
     * Constructor por defecto para la clase Pedidos.
     */
    
    public Pedidos(){
        
    }

    /**
     * Constructor con parámetros para inicializar un objeto Pedidos.
     * 
     * @param id El ID del pedido.
     * @param productos Los productos del pedido.
     * @param cantidad La cantidad de productos en el pedido.
     * @param precio El precio de los productos en el pedido.
     * @param venta La venta asociada al pedido.
     */
    public Pedidos(int id, String productos, int cantidad, double precio, int venta) {
        this.id = id;
        this.productos = productos;
        this.cantidad = cantidad;
        this.precio = precio;
        this.venta = venta;
    }
     /**
     * Obtiene el ID del pedido.
     * 
     * @return El ID del pedido.
     */

    public int getId() {
        return id;
    }

     /**
     * Establece el ID del pedido.
     * 
     * @param id El nuevo ID del pedido.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene los productos del pedido.
     * 
     * @return Los productos del pedido.
     */
    public String getProductos() {
        return productos;
    }

    
    /**
     * Establece los productos del pedido.
     * 
     * @param productos Los nuevos productos del pedido.
     */
    public void setProductos(String productos) {
        this.productos = productos;
    }

    
    /**
     * Obtiene la cantidad de productos en el pedido.
     * 
     * @return La cantidad de productos en el pedido.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de productos en el pedido.
     * 
     * @param cantidad La nueva cantidad de productos en el pedido.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    /**
     * Obtiene el precio de los productos en el pedido.
     * 
     * @return El precio de los productos en el pedido.
     */

    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio de los productos en el pedido.
     * 
     * @param precio El nuevo precio de los productos en el pedido.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la venta asociada al pedido.
     * 
     * @return La venta asociada al pedido.
     */
    public int getVenta() {
        return venta;
    }

    
    /**
     * Establece la venta asociada al pedido.
     * 
     * @param venta La nueva venta asociada al pedido.
     */
    public void setVenta(int venta) {
        this.venta = venta;
    }
    
    
}
