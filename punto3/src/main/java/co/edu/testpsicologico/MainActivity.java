package co.edu.testpsicologico;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import co.edu.testpsicologico.Entidades.RegistroTest;

public class MainActivity extends AppCompatActivity {
    TextView tvEnunciado1;
    TextView tvEnunciado2;
    TextView tvEnunciado3;
    TextView tvEnunciado4;
    TextView tvEnunciado5;
    TextView tvEnunciado6;
    Spinner spPregunta1;
    Spinner spPregunta2;
    Spinner spPregunta3;
    Spinner spPregunta4;
    Spinner spPregunta5;
    Spinner spPregunta6;
    Button btnResultado;
    private int conteo1 = 0;
    private int conteo2 = 0;
    private int conteo3 = 0;
    private int conteo4 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        begin();
        PreguntasTest();
        btnResultado.setOnClickListener(this::irResultado);
    }

    private void irResultado(View view) {
        Intent irResultado = new Intent(getApplicationContext(), Resultado.class);
        RegistroTest info1 = (RegistroTest) spPregunta1.getSelectedItem();
        RegistroTest info2 = (RegistroTest) spPregunta2.getSelectedItem();
        RegistroTest info3 = (RegistroTest) spPregunta3.getSelectedItem();
        RegistroTest info4 = (RegistroTest) spPregunta4.getSelectedItem();
        RegistroTest info5 = (RegistroTest) spPregunta5.getSelectedItem();
        RegistroTest info6 = (RegistroTest) spPregunta6.getSelectedItem();
        if (info1.getIdPregunta() == "1"){conteo1 = conteo1 + 1;}else if(info1.getIdPregunta() == "2"){conteo2= conteo2 + 1;}else if(info1.getIdPregunta() == "3"){conteo3 = conteo3 + 1;}else if(info1.getIdPregunta() == "4"){conteo4 = conteo4+1;}
        if (info2.getIdPregunta() == "1"){conteo1 = conteo1 + 1;}else if(info2.getIdPregunta() == "2"){conteo2= conteo2 + 1;}else if(info2.getIdPregunta() == "3"){conteo3 = conteo3 + 1;}else if(info2.getIdPregunta() == "4"){conteo4 = conteo4+1;}
        if (info3.getIdPregunta() == "1"){conteo1 = conteo1 + 1;}else if(info3.getIdPregunta() == "2"){conteo2= conteo2 + 1;}else if(info3.getIdPregunta() == "3"){conteo3 = conteo3 + 1;}else if(info3.getIdPregunta() == "4"){conteo4 = conteo4+1;}
        if (info4.getIdPregunta() == "1"){conteo1 = conteo1 + 1;}else if(info4.getIdPregunta() == "2"){conteo2= conteo2 + 1;}else if(info4.getIdPregunta() == "3"){conteo3 = conteo3 + 1;}else if(info4.getIdPregunta() == "4"){conteo4 = conteo4+1;}
        if (info5.getIdPregunta() == "1"){conteo1 = conteo1 + 1;}else if(info5.getIdPregunta() == "2"){conteo2= conteo2 + 1;}else if(info5.getIdPregunta() == "3"){conteo3 = conteo3 + 1;}else if(info5.getIdPregunta() == "4"){conteo4 = conteo4+1;}
        if (info6.getIdPregunta() == "1"){conteo1 = conteo1 + 1;}else if(info6.getIdPregunta() == "2"){conteo2= conteo2 + 1;}else if(info6.getIdPregunta() == "3"){conteo3 = conteo3 + 1;}else if(info6.getIdPregunta() == "4"){conteo4 = conteo4+1;}
        if (conteo1 > conteo2 && conteo1 > conteo3 && conteo1 > conteo4){
            irResultado.putExtra("Opcion1", "5");
        } else if (conteo2 > conteo1 && conteo2 > conteo3 && conteo2> conteo4) {
            irResultado.putExtra("Opcion2", "5");
        } else if (conteo3 > conteo1 && conteo3 > conteo2 && conteo3 > conteo4) {
            irResultado.putExtra("Opcion3", "5");
        } else if (conteo4 > conteo1 && conteo4 > conteo2 && conteo4 > conteo3) {
            irResultado.putExtra("Opcion4", "5");
        }
        startActivity(irResultado);
    }

    private void begin(){
        this.tvEnunciado1 = findViewById(R.id.tvEnunciado1);
        this.tvEnunciado2 = findViewById(R.id.tvEnunciado2);
        this.tvEnunciado3 = findViewById(R.id.tvEnunciado3);
        this.tvEnunciado4 = findViewById(R.id.tvEnunciado4);
        this.tvEnunciado5 = findViewById(R.id.tvEnunciado5);
        this.tvEnunciado6 = findViewById(R.id.tvEnunciado6);
        this.spPregunta1 = findViewById(R.id.spPregunta1);
        this.spPregunta2 = findViewById(R.id.spPregunta2);
        this.spPregunta3 = findViewById(R.id.spPregunta3);
        this.spPregunta4 = findViewById(R.id.spPregunta4);
        this.spPregunta5 = findViewById(R.id.spPregunta5);
        this.spPregunta6 = findViewById(R.id.spPregunta6);
        this.btnResultado = findViewById(R.id.btnResultado);
    }
    private void PreguntasTest(){
        ArrayList<RegistroTest> preguntas1 = new ArrayList<>();
        preguntas1.add(new RegistroTest("1", "De resultados, de lo que desea lograr"));
        preguntas1.add(new RegistroTest("2", "Sueños y aspiraciones"));
        preguntas1.add(new RegistroTest("3", "Sentamientos y experiencias"));
        preguntas1.add(new RegistroTest("4", "Datos y cantidades"));
        ArrayAdapter<RegistroTest> adapter1 = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, preguntas1);
        ArrayList<RegistroTest> preguntas2 = new ArrayList<>();
        preguntas2.add(new RegistroTest("1", "Muy rápido"));
        preguntas2.add(new RegistroTest("2", "Rápido"));
        preguntas2.add(new RegistroTest("3", "Más lento"));
        preguntas2.add(new RegistroTest("4", "Moderado"));
        ArrayAdapter<RegistroTest> adapter2 = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, preguntas2);
        ArrayList<RegistroTest> preguntas3 = new ArrayList<>();
        preguntas3.add(new RegistroTest("1", "Ropa de diseñador, viste con buen gusto, formal, elegante"));
        preguntas3.add(new RegistroTest("2", "Colores fuertes, modernos, informal"));
        preguntas3.add(new RegistroTest("3", "Suave, colores claros, casual"));
        preguntas3.add(new RegistroTest("4", "Conservador, tradicional, profesional"));
        ArrayAdapter<RegistroTest> adapter3 = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, preguntas3);
        ArrayList<RegistroTest> preguntas4 = new ArrayList<>();
        preguntas4.add(new RegistroTest("1", "Directo al punto"));
        preguntas4.add(new RegistroTest("2", "Animado, impulsivo"));
        preguntas4.add(new RegistroTest("3", "Pensamientos pausados, casual"));
        preguntas4.add(new RegistroTest("4", "Específico, conciso"));
        ArrayAdapter<RegistroTest> adapter4 = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, preguntas4);
        ArrayList<RegistroTest> preguntas5 = new ArrayList<>();
        preguntas5.add(new RegistroTest("1", "Los resultados"));
        preguntas5.add(new RegistroTest("2", "El aplauso"));
        preguntas5.add(new RegistroTest("3", "La probación"));
        preguntas5.add(new RegistroTest("4", "La actividad"));
        ArrayAdapter<RegistroTest> adapter5 = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, preguntas5);
        ArrayList<RegistroTest> preguntas6 = new ArrayList<>();
        preguntas6.add(new RegistroTest("1", "Las presionas, los cambios"));
        preguntas6.add(new RegistroTest("2", "Lo interesante, lo divertido"));
        preguntas6.add(new RegistroTest("3", "El compañerismo, el apoyo"));
        preguntas6.add(new RegistroTest("4", "La precisión, la información"));
        ArrayAdapter<RegistroTest> adapter6 = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, preguntas6);
        spPregunta1.setAdapter(adapter1);
        spPregunta2.setAdapter(adapter2);
        spPregunta3.setAdapter(adapter3);
        spPregunta4.setAdapter(adapter4);
        spPregunta5.setAdapter(adapter5);
        spPregunta6.setAdapter(adapter6);
    }
}