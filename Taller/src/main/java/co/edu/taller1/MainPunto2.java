package co.edu.taller1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import co.edu.taller1.entidades.RegistroCliente2;
public class MainPunto2 extends AppCompatActivity{
    EditText etFacturaNombre;
    EditText etFacturaApellido;
    EditText etFacturaDireccion;
    Button btnFacturaCompra;
    String name;
    String lastname;
    String direction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punto2);
        begin();
        this.btnFacturaCompra.setOnClickListener(this::Compra);
    }

    private void Compra(View view) {
        validarNombre();
        validarApellido();
        validarDireccion();
        String name = etFacturaNombre.getText().toString();
        String lastname = etFacturaApellido.getText().toString();
        String direction = etFacturaDireccion.getText().toString();
        RegistroCliente2 cliente = new RegistroCliente2(name, lastname, direction);
        Intent ircompra = new Intent(getApplicationContext(), Producto2.class);
        ircompra.putExtra("Datos", cliente);
        if (validarNombre() == true && validarApellido() == true && validarDireccion() == true){
            startActivity(ircompra);
        }
    }

    private void begin(){
        this.etFacturaNombre = findViewById(R.id.etFacturaNombre);
        this.etFacturaApellido = findViewById(R.id.etFacturaApellido);
        this.etFacturaDireccion = findViewById(R.id.etFacturaDireccion);
        this.btnFacturaCompra = findViewById(R.id.btnFacturaCompra);
        this.name = "";
        this.lastname = "";
        this.direction = "";
    }
    private boolean validarNombre(){
        //validación de datos
        boolean estado;
        if(etFacturaNombre.getText().toString().matches("^[A-Z]{0,1}+[a-z]{1,10}$")){
            this.name = etFacturaNombre.getText().toString();
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
        if(etFacturaApellido.getText().toString().matches("^[A-Z]{0,1}+[a-z]{2,10}$")){
            this.lastname = etFacturaApellido.getText().toString();
            estado = true;
        }else{
            Toast.makeText(this, "Los datos del apellido no son validos", Toast.LENGTH_LONG).show();
            estado = false;
        }
        return estado;
    }
    private boolean validarDireccion(){
        //validación de datos
        boolean estado;
        if(etFacturaDireccion.getText().toString().matches("^[A-Za-z1-9#-]{2,40}$")){
            this.direction = etFacturaDireccion.getText().toString();
            estado = true;
        }else{
            Toast.makeText(this, "Los datos de la dirección con incorrectos, no se permiten espacios en el dato.", Toast.LENGTH_LONG).show();
            estado = false;
        }
        return estado;
    }
}
