package co.edu.hospedaje;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import co.edu.hospedaje.entidades.Persona;
import co.edu.hospedaje.entidades.Transaccion;

public class transaccion extends AppCompatActivity {
    private TextView tvDatopersona;
    private Spinner spOrigin;
    private Spinner spDestiny;
    private Button btnTransaccion;
    private EditText etMonto;
    private EditText etTasa;
    private TextView tvCambio1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaccion);
        begin();
        receiver();
        this.btnTransaccion.setOnClickListener(this::change);
    }

    private void change(View view) {
        Toast.makeText(this, "Seleccion: "+ spOrigin.getSelectedItemPosition(), Toast.LENGTH_SHORT).show();
        Transaccion transaccion;
        long monto = Long.parseLong(etMonto.getText().toString());
        long tasa = Long.parseLong(etTasa.getText().toString());
        if ("USD".equals(spOrigin.getSelectedItem())){
            transaccion = new Transaccion(monto, tasa);
            long cop = transaccion.changeDange();
            tvCambio1.setText("Pesos colombianos: "+cop);
        }
    }

    private void receiver(){
        Bundle data = getIntent().getExtras( );
        if (data != null){
            Persona persona = new Persona();
             persona = (Persona) data.get("persona");
             tvDatopersona.setText(persona.getName()+" "+persona.getLastname());
            //Toast.makeText(this, "El cliente es: " + persona, Toast.LENGTH_LONG).show();
        }else{
            tvDatopersona.setText("libre");
            //Toast.makeText(this, "Los datos son nulos", Toast.LENGTH_LONG).show();
        }
    }
    private void begin(){
        this.tvDatopersona = findViewById(R.id.tvDatosPersona);
        this.spOrigin = findViewById(R.id.spOrigen);
        this.spDestiny= findViewById(R.id.spDestino);
        this.btnTransaccion = findViewById(R.id.btnCambiar);
        this.etMonto = findViewById(R.id.etMonto);
        this.etTasa = findViewById(R.id.etTasa);
        this.tvCambio1 = findViewById(R.id.tvCambio1):
    }
}
