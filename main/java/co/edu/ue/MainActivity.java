package co.edu.ue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNumber1;
    private EditText etNumber2;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.etNumber1 = findViewById(R.id.etNumber1);
        this.etNumber2 = findViewById(R.id.etNumber2);
        this.tvResultado = findViewById(R.id.tvResultado);
    }
    public void sumar(View view){
        double num1 = Double.parseDouble(this.etNumber1.getText().toString());
        double num2 = Double.parseDouble(this.etNumber2.getText().toString());
        double suma = num1 + num2;
        tvResultado.setText("El resultado es: "+suma);
        Toast.makeText(this, "El resultado es: "+suma, Toast.LENGTH_LONG).show();
    }
    public void restar(View view){
        double num1 = Double.parseDouble(this.etNumber1.getText().toString());
        double num2 = Double.parseDouble(this.etNumber2.getText().toString());
        double restar = num1 - num2;
        tvResultado.setText("El resultado es: "+restar);
        Toast.makeText(this, "El resultado es: "+restar, Toast.LENGTH_LONG).show();
    }
    public void multiplicar(View view){
        double num1 = Double.parseDouble(this.etNumber1.getText().toString());
        double num2 = Double.parseDouble(this.etNumber2.getText().toString());
        double multiplicar = num1 * num2;
        tvResultado.setText("El resultado es: "+multiplicar);
        Toast.makeText(this, "El resultado es: "+multiplicar, Toast.LENGTH_LONG).show();
    }
    public void dividir(View view){
        double num1 = Double.parseDouble(this.etNumber1.getText().toString());
        double num2 = Double.parseDouble(this.etNumber2.getText().toString());
        double dividir = num1 / num2;
        tvResultado.setText("El resultado es: "+dividir);
        Toast.makeText(this, "El resultado es: "+dividir, Toast.LENGTH_LONG).show();
    }
}