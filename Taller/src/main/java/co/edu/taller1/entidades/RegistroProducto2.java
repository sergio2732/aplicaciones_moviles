package co.edu.taller1.entidades;

import java.io.Serializable;

public class RegistroProducto2 implements Serializable {
    private Integer id;
    private String NombreProducto;
    private Integer precio;
    private String verProductos;
    public RegistroProducto2(){
    }
    public RegistroProducto2(Integer id, String nombreProducto, Integer precio) {
        this.id = id;
        this.NombreProducto = nombreProducto;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        NombreProducto = nombreProducto;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
    @Override
    public String toString(){
        this.verProductos = "id: "+ id + " - " + NombreProducto + " " + "$" + precio;
        return verProductos;
    }
}
