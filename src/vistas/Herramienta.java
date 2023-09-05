/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

/**
 *
 * @author gassani
 */
public class Herramienta {
    private int id = -1;
    private String nombre;
    private String descripcion;
    private int stock;
    private boolean estado;

        public Herramienta(int id, String nombre, String descripcion, int stock, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.estado = estado;
    }
    public Herramienta(String nombre, String descripcion) {
      this.id= -1;
    }

    public Herramienta() {
      
    }
        public Herramienta( String nombre, String descripcion, int stock, boolean estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.estado = estado;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Herramientas{" + "id=" + id + ", nombre=" + nombre + ", estado=" + estado + '}';
    }
    
    
}
