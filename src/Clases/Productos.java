/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 * La clase Productos representa un artículo disponible en un inventario.
 * Contiene información como el ID, el código, el nombre, el proveedor, el stock y el precio del producto.
 *  @author amart
 */

public class Productos {
    private int id;
    private String codigo;
    private String nombre;
    private String proveedor;
    private int stock;
    private double precio;
    /**
     * Constructor por defecto de la clase Productos.
     */
    public Productos(){
        
    }

    /**
     * Constructor parametrizado de la clase Productos.
     * @param id El ID del producto.
     * @param codigo El código del producto.
     * @param nombre El nombre del producto.
     * @param proveedor El proveedor del producto.
     * @param stock La cantidad en stock del producto.
     * @param precio El precio del producto.
     */
    public Productos(int id, String codigo, String nombre, String proveedor, int stock, double precio) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.stock = stock;
        this.precio = precio;
    }

    /**
     * Obtiene el ID del producto.
     * @return El ID del producto.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del producto.
     * @param id El nuevo ID del producto.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el código del producto.
     * @return El código del producto.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código del producto.
     * @param codigo El nuevo código del producto.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtiene el nombre del producto.
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     * @param nombre El nuevo nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el proveedor del producto.
     * @return El proveedor del producto.
     */
    public String getProveedor() {
        return proveedor;
    }

    /**
     * Establece el proveedor del producto.
     * @param proveedor El nuevo proveedor del producto.
     */
    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

     /**
     * Obtiene el stock del producto.
     * @return La cantidad en stock del producto.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Establece el stock del producto.
     * @param stock La nueva cantidad en stock del producto.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Obtiene el precio del producto.
     * @return El precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     * @param precio El nuevo precio del producto.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
