package co.edu.hospedaje.entidades;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Persona implements Serializable {
    private String name;
    private String lastname;
    private String document;
    private ArrayList<Transaccion> transacciones = new ArrayList<>();

    public Persona(String name, String lastname, String document) {
        this.name = name;
        this.lastname = lastname;
        this.document = document;
    }
    public Persona(){
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public ArrayList<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(ArrayList<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", document='" + document + '\'' +
                ", transacciones=" + transacciones +
                '}';
    }
}
