package co.edu.gestion_inventarios;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import co.edu.gestion_inventarios.entidades.Persona;
import co.edu.gestion_inventarios.model.PersonaDao;
public class RegistroCuenta extends AppCompatActivity {
    private Button btnRegistrar;
    private EditText etRegistroNombre;
    private EditText etRegistroCorreo;
    private EditText etRegistroContraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        begin();
    }

    private void begin() {
        this.btnRegistrar = findViewById(R.id.btnRegistrarUsuario);
        this.etRegistroNombre = findViewById(R.id.etRegistroNombre);
        this.etRegistroCorreo = findViewById(R.id.etRegistroCorreo);
        this.etRegistroContraseña = findViewById(R.id.etRegistroContraseña);
    }
}
