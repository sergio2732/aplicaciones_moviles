package co.edu.testpsicologico;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import co.edu.testpsicologico.Entidades.RegistroTest;

public class Resultado extends AppCompatActivity {
    private TextView tvPersonalidad;
    private TextView tvDescripcion;
    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        begin();
        ResultadoTest();
        btnVolver.setOnClickListener(this::Volver);
    }

    private void Volver(View view) {
        Intent Volver = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(Volver);
    }

    private void begin(){
        this.tvPersonalidad = findViewById(R.id.tvPersonalidad);
        this.tvDescripcion = findViewById(R.id.tvDescripcion);
        this.btnVolver = findViewById(R.id.btnVolver);
    }
    private void ResultadoTest(){
        Intent irResultado = getIntent();
        String resultado1 = irResultado.getStringExtra("Opcion1");
        String resultado2 = irResultado.getStringExtra("Opcion2");
        String resultado3 = irResultado.getStringExtra("Opcion3");
        String resultado4 = irResultado.getStringExtra("Opcion4");
        if (resultado1 == "5"){
            Toast.makeText(this, "Pantera", Toast.LENGTH_SHORT).show();
            tvPersonalidad.setText("Pantera");
        }
        if (resultado2 == "5"){
            Toast.makeText(this, "Pavo", Toast.LENGTH_SHORT).show();
            tvPersonalidad.setText("Pavo");
        }
        if (resultado3 == "5"){
            Toast.makeText(this, "Delfin", Toast.LENGTH_SHORT).show();
            tvPersonalidad.setText("Delfin");
        }
        if (resultado4 == "5"){
            Toast.makeText(this, "Buho", Toast.LENGTH_SHORT).show();
            tvPersonalidad.setText("Buho");
        }
    }
}
