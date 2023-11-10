package co.edu.calcularedad;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText etFecha;
    private Button btnCalcular;
    private TextView tvEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        begin();
        validarFecha();
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fechaIngresada= etFecha.getText().toString();
                int edad = calcularEdad(fechaIngresada);
                if (validarFecha() == true){
                    tvEdad.setText(String.valueOf(edad));
                }
            }
        });
    }

    private int calcularEdad(String fechaNacimiento) {
        try {
            Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNacimiento);
            Calendar actual = Calendar.getInstance();
            Calendar cFecha = Calendar.getInstance();
            cFecha.setTime(fecha);
            int edad = 0;
            if(actual.get(Calendar.YEAR) > cFecha.get(Calendar.YEAR)){
                 edad = actual.get(Calendar.YEAR) - cFecha.get(Calendar.YEAR);
            }else{
                Toast.makeText(this, "Por favor ingrese una edad menor a la fecha de hoy", Toast.LENGTH_LONG).show();
            }
            return edad;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private void begin() {
        this.etFecha = findViewById(R.id.etFecha);
        this.btnCalcular = findViewById(R.id.btnCalcular);
        this.tvEdad = findViewById(R.id.tvEdad);
    }
    private boolean validarFecha(){
        boolean estado;
        if(etFecha.getText().toString().matches("^[0-9/]{10}$")){
            estado = true;
        }else{
            Toast.makeText(this, "Por favor ingrese la fecha como se indica en el formato, solo numeros", Toast.LENGTH_LONG).show();
            estado = false;
        }
        return estado;
    }
}
