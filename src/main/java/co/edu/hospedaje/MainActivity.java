package co.edu.hospedaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnPersona;

    private Button btnCambio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        begin();
        //Formas de hacer onclick -> eventos
        btnPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irPersona =  new Intent(getApplicationContext(), RegistroPersona.class);
                startActivity(irPersona);
            }
        });
        //Tercera forma del Onclick -> Eventos
        this.btnCambio.setOnClickListener(this::transaccion);
    }

    private void transaccion(View view) {
        Intent irTransaccion = new Intent(getApplicationContext(), transaccion.class);
        startActivity(irTransaccion);
    }

    private void begin(){
        this.btnPersona = findViewById(R.id.btnPersona);
        this.btnCambio = findViewById(R.id.btnTransaccion);
    }
}