package co.edu.hospedaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import co.edu.hospedaje.entidades.Persona;

public class RegistroPersona extends AppCompatActivity {
    private Button btnCambio;
    private EditText etNombres;
    private EditText etApellidos;
    private EditText etDocumento;
    String names;
    String lastnames;
    String document;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_persona);
        begin();
        btnCambio.setOnClickListener(this::goCambio);
    }
    private void goCambio(View view){
        data();
        Persona persona = new Persona(names, lastnames, document);
        Intent go = new Intent(getApplicationContext(), transaccion.class);
        go.putExtra("persona", persona);
        startActivity(go);
    }
    private void data(){
        //validación de datos
        this.names = etNombres.getText().toString();
        this.lastnames = etApellidos.getText().toString();
        this.document = etDocumento.getText().toString();
    }
    private void begin(){
        this.btnCambio = findViewById(R.id.btnCambio);
        this.etNombres = findViewById(R.id.etNombres);
        this.etApellidos = findViewById(R.id.etApellidos);
        this.etDocumento = findViewById(R.id.etDocumento);
        this.names = "";
        this.lastnames = "";
        this.document = "";
    }
}
