package co.edu.hospedaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import co.edu.hospedaje.entidades.Persona;

public class RegistroPersona extends AppCompatActivity {
    private Button btnCambio;
    private EditText etNombres;
    private EditText etApellidos;
    private EditText etDocumento;
    private Button btnVolver1;
    String names;
    String lastnames;
    String document;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_persona);
        begin();
        btnCambio.setOnClickListener(this::goCambio);
        btnVolver1.setOnClickListener(this::volver);
    }
    private void goCambio(View view){
        validarNombre();
        validarApellido();
        validarDocumento();
        Persona persona = new Persona(names, lastnames, document);
        Intent go = new Intent(getApplicationContext(), transaccion.class);
        go.putExtra("persona", persona);
        if (validarNombre() == true && validarApellido() == true && validarDocumento() == true){
            startActivity(go);
        }
    }
    private boolean validarNombre(){
        //validación de datos
        boolean estado;
        if(etNombres.getText().toString().matches("^[A-Z]{1}+[a-z]{2,10}$")){
            this.names = etNombres.getText().toString();
            estado = true;
        }else{
            Toast.makeText(this, "Los datos del nombre no son validos", Toast.LENGTH_LONG).show();
            estado = false;
        }
        return estado;
    }
    private boolean validarApellido(){
        //validación de datos
        boolean estado;
        if(etApellidos.getText().toString().matches("^[A-Z]{1}+[a-z]{2,10}$")){
            this.lastnames = etApellidos.getText().toString();
            estado = true;
        }else{
            Toast.makeText(this, "Los datos del apellido no son validos", Toast.LENGTH_LONG).show();
            estado = false;
        }
        return estado;
    }
    private boolean validarDocumento(){
        //validación de datos
        boolean estado;
        if(etDocumento.getText().toString().matches("^[0-9]{10}$")){
            this.document = etDocumento.getText().toString();
            estado = true;
        }else{
            Toast.makeText(this, "Los datos del documento no son validos", Toast.LENGTH_LONG).show();
            estado = false;
        }
        return estado;
    }
    private void begin(){
        this.btnCambio = findViewById(R.id.btnCambio);
        this.etNombres = findViewById(R.id.etNombres);
        this.etApellidos = findViewById(R.id.etApellidos);
        this.etDocumento = findViewById(R.id.etDocumento);
        this.names = "";
        this.lastnames = "";
        this.document = "";
        this.btnVolver1 = findViewById(R.id.btnVolver1);
    }

    private void volver(View view){
        Intent irprincipal = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(irprincipal);
    }
}
