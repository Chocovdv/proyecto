/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author amart
 */
public class Ventas {
    private int id;
    private String cliente;
    private String empleado;
    private double total;
    private String fecha;
    
    /**
     * Constructor por defecto de la clase Ventas.
     */
    public Ventas(){
        
    }

     /**
     * Constructor parametrizado de la clase Ventas.
     * @param id El ID de la venta.
     * @param cliente El nombre del cliente.
     * @param empleado El nombre del empleado que realizó la venta.
     * @param total El total de la venta.
     * @param fecha La fecha de la venta.
     */
    public Ventas(int id, String cliente, String empleado, double total, String fecha) {
        this.id = id;
        this.cliente = cliente;
        this.empleado = empleado;
        this.total = total;
        this.fecha = fecha;
    }

    /**
     * Obtiene el ID de la venta.
     * @return El ID de la venta.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID de la venta.
     * @param id El nuevo ID de la venta.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del cliente.
     * @return El nombre del cliente.
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * Establece el nombre del cliente.
     * @param cliente El nuevo nombre del cliente.
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene el nombre del empleado que realizó la venta.
     * @return El nombre del empleado que realizó la venta.
     */
    public String getEmpleado() {
        return empleado;
    }

    /**
     * Establece el nombre del empleado que realizó la venta.
     * @param empleado El nuevo nombre del empleado que realizó la venta.
     */
    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    /**
     * Obtiene el total de la venta.
     * @return El total de la venta.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Establece el total de la venta.
     * @param total El nuevo total de la venta.
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Obtiene la fecha de la venta.
     * @return La fecha de la venta.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la venta.
     * @param fecha La nueva fecha de la venta.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}
