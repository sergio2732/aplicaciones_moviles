package co.edu.taller1.entidades;

import java.io.Serializable;
public class RegistroCliente2 implements Serializable {
    private String name;
    private String lastname;
    private String direction;

    public RegistroCliente2(String name, String lastname, String direction){
        this.name = name;
        this.lastname = lastname;
        this.direction = direction;
    }
    public RegistroCliente2(){
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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
    @Override
    public String toString(){
        return "Cliente {" + "name='" + name + '\'' + ", lastname=´" + lastname + '\'' +", direction='" + direction + "}";
    }
}
