package co.edu.hospedaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import co.edu.hospedaje.entidades.Persona;
import co.edu.hospedaje.model.PersonaDao;

public class RegistroPersona extends AppCompatActivity {
    private Button btnCambio;
    private EditText etNombres;
    private EditText etApellidos;
    private EditText etDocumento;
    private Button btnVolver1;
    private Button btnRegistrar;
    private Button btnListar;
    private Button btnActualizar;
    private Button btnEliminar;
    private Button btnDeshabilitar;
    private ListView listPeople;
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
        btnRegistrar.setOnClickListener(this::createPeople);
        btnListar.setOnClickListener(this::lisPeopleShow);
        btnActualizar.setOnClickListener(this::updatePeople);
        btnEliminar.setOnClickListener(this::deletePeople);
        btnDeshabilitar.setOnClickListener(this::disableStatus);
    }

    private void createPeople(View view) {
        data();
        Persona persona = new Persona(this.names, this.lastnames, this.document);
        PersonaDao dao = new PersonaDao(this, view);
        dao.insertPeorple(persona);
        lisPeopleShow(view);
    }
    private void updatePeople(View view){
        data();
        Persona persona = new Persona(this.names, this.lastnames, this.document);
        PersonaDao dao = new PersonaDao(this, view);
        dao.updatePerson(persona);
        lisPeopleShow(view);
    }
    private void deletePeople(View view){
        data();
        Persona persona = new Persona(this.names, this.lastnames, this.document);
        PersonaDao dao = new PersonaDao(this, view);
        dao.deletePerson(persona);
        lisPeopleShow(view);
    }
    private void disableStatus(View view){
        data();
        Persona persona = new Persona(this.names, this.lastnames, this.document);
        PersonaDao dao = new PersonaDao(this, view);
        dao.disableStatus(persona);
        lisPeopleShow(view);
    }
    private void lisPeopleShow(View view){
        PersonaDao dao = new PersonaDao(this, view);
        ArrayList<Persona> personalista = dao.getPeopleList();
        ArrayAdapter<Persona> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, personalista);
        listPeople.setAdapter(adapter);
        Log.d("ListView", "lisPeopleShow method called");
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
        if(etNombres.getText().toString().matches("^[A-Za-z]{2,10}$")){
            String NombreR = etApellidos.getText().toString();
            NombreR = NombreR.substring(1);
            this.names = etNombres.getText().toString().substring(0, 1).toUpperCase() + NombreR;
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
        if(etApellidos.getText().toString().matches("^[A-Za-z]{2,10}$")){
            String ApellidoR = etApellidos.getText().toString();
            ApellidoR = ApellidoR.substring(1);
            this.lastnames = etApellidos.getText().toString().substring(0,1).toUpperCase() + ApellidoR;
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
    private void data(){
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
        this.btnVolver1 = findViewById(R.id.btnVolver1);
        this.btnRegistrar = findViewById(R.id.btnRegistrar);
        this.listPeople = findViewById(R.id.lvLista);
        this.btnListar = findViewById(R.id.btnListar);
        this.btnActualizar = findViewById(R.id.btnActualizar);
        this.btnEliminar = findViewById(R.id.btnEliminar);
        this.btnDeshabilitar = findViewById(R.id.btnDeshabilitar);
    }
    private void volver(View view){
        Intent irprincipal = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(irprincipal);
    }
}