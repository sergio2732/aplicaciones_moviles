package co.edu.gestion_inventarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnIngresar;
    private Button btnRegistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        begin();
        this.btnRegistrar.setOnClickListener(this::irRegistrar);
        this.btnIngresar.setOnClickListener(this::irIngreso);
    }

    private void irIngreso(View view) {
        Intent irIngreso = new Intent(getApplicationContext(), IngresoCuenta.class);
        startActivity(irIngreso);
    }

    private void irRegistrar(View view) {
        Intent irRegistrar = new Intent(getApplicationContext(), RegistroCuenta.class);
        startActivity(irRegistrar);
    }

    private void begin(){
        this.btnIngresar = findViewById(R.id.btnIngresar);
        this.btnRegistrar = findViewById(R.id.btnRegistrar);
    }
}