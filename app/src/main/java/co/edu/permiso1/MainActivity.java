package co.edu.permiso1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 100;
    //1.Declaracion de objetos del view a utilizar
    private Button btnRequestPermission;
    private Button btnCheckPermissio;
    private TextView tvTitulo;
    private TextView tvCamera;
    private TextView tvBT;
    private TextView tvEws;
    private TextView tvRS;
    private TextView tvInternet;
    private TextView tvDactilar;
    private TextView tvResponse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //3.ññamado de enlaces de datos
        begin();
        //4. Enlace de botones a metodos
        btnCheckPermissio.setOnClickListener(this::voidCheckPermission);
        btnRequestPermission.setOnClickListener(this::voidRequestPermission);
    }
    //5. Verificación de los pernisos
    private void voidCheckPermission(View view) {
        //Si hay permiso --> 0 --->si no hay --> -1
        int statusCamera = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA);
        int statusBT = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.BLUETOOTH);
        int statusEws = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int statusRs = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE);
        int statusInternet = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET);
        int statusDactilar = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.USE_BIOMETRIC);
        //Tarea: no poner el status sino poner un aviso dependiendo de la situacion
        tvCamera.setText("Status camera: " + statusCamera);
        tvBT.setText("Status bluthoo: " + statusBT);
        tvEws.setText("Status Ews: " + statusEws);
        tvRS.setText("Status Rs: " + statusRs);
        tvInternet.setText("Status camera: " + statusInternet);
        tvDactilar.setText("Status camera: " + statusDactilar);
    }
    //Gestion de permiso
    private void voidRequestPermission(View view) {
        if (ActivityCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.CAMERA) != PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(MainActivity.this, new String []{Manifest.permission.CAMERA}, REQUEST_CODE);
        }
    }
    //7. Gestion de respuesta de usuario respecto a la solicitud de permiso


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        tvResponse.setText(""+ grantResults);
    }

    //2. enlaces de objetos
    private void  begin(){
        this.btnRequestPermission = findViewById(R.id.btnRequestPermission);
        this.btnCheckPermissio = findViewById(R.id.btnCheckPermission);
        this.tvTitulo = findViewById(R.id.tvTitulo);
        this.tvCamera = findViewById(R.id.tvCamera);
        this.tvBT = findViewById(R.id.tvBT);
        this.tvEws = findViewById(R.id.tvEws);
        this.tvRS = findViewById(R.id.tvRS);
        this.tvInternet = findViewById(R.id.tvInternet);
        this.tvDactilar = findViewById(R.id.tvDactilar);
        this.tvResponse = findViewById(R.id.tvResponse);
        btnRequestPermission.setEnabled(true);
    }
}
