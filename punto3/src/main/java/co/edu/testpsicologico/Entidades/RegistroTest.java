package co.edu.testpsicologico.Entidades;

import java.io.Serializable;

public class RegistroTest implements Serializable{
    private String idPregunta;
    private String spPregunta;
    private String verPregunta;
    public RegistroTest(){
    }
    public RegistroTest(String idPregunta, String spPregunta){
        this.idPregunta = idPregunta;
        this.spPregunta = spPregunta;
    }

    public String getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(String idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getSpPregunta() {
        return spPregunta;
    }

    public void setSpPregunta(String spPregunta) {
        this.spPregunta = spPregunta;
    }
    @Override
    public String toString(){
        this.verPregunta = spPregunta;
        return verPregunta;
    }
}
