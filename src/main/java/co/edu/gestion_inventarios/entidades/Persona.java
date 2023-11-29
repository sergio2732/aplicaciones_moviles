package co.edu.gestion_inventarios.entidades;
import java.io.Serializable;

public class Persona implements Serializable {
    private String name;
    private String email;
    private String pss;

    public Persona(String name, String email, String pss) {
        this.name = name;
        this.email = email;
        this.pss = pss;
    }
    public Persona(){
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPss() {
        return pss;
    }

    public void setPss(String pss) {
        this.pss = pss;
    }
    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}