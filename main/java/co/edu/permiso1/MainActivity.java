package co.edu.permiso1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 100;
    private Button btnCheckPermissions;
    private Button btnRequestPermissions;
    private TextView tvCamera;
    private TextView tvBT;
    private TextView tvDactilar;
    private TextView tvEws;
    private TextView tvRS;
    private TextView tvInternet;
    private TextView tvResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        begin();
        btnCheckPermissions.setOnClickListener(this::voidCheckPermissions);
        btnRequestPermissions.setOnClickListener(this::voidRequestPermissions);
    }
    //5. Verificacion de los permisos
    private void voidCheckPermissions(View view) {
        //Si hay permiso --> 0, si no hay --> -1
        int statusCamera = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA);
        int statusBt = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.BLUETOOTH);
        int statusWES = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int statusRES = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE);
        int statusInternet = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET);
        int statusBiometric = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.USE_BIOMETRIC);
        tvCamera.setText("status camera: "+statusCamera);
        tvBT.setText("status BT: "+statusBt);
        tvInternet.setText("status Internet: "+statusInternet);
        tvDactilar.setText("status Biometic: "+statusBiometric);
        tvRS.setText("status RE: "+statusRES);
        tvEws.setText("status EWS: "+statusWES );
    }
    private void voidRequestPermissions(View view) {
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CAMERA},REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        tvResponse.setText(" "+grantResults[0]);
        if (requestCode == REQUEST_CODE){
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED){
                new AlertDialog.Builder(this)
                        .setTitle("Permisions")
                        .setMessage("You denied permissions. Allow all permissions at Setting->Permissions")
                        .setPositiveButton("Settings", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.fromParts("package",getPackageName(),null));
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();
                            }
                        }).setNegativeButton("exit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                finish();
                            }
                        }).create().show();
            }
        }
    }

    private void begin(){
        this.btnCheckPermissions = findViewById(R.id.btnCheckPermission);
        this.btnRequestPermissions = findViewById(R.id.btnRequestPermission);
        this.tvDactilar = findViewById(R.id.tvFingerprint);
        this.tvBT = findViewById(R.id.tvBT);
        this.tvCamera = findViewById(R.id.tvCamera);
        this.tvInternet = findViewById(R.id.tvInternet);
        this.tvEws = findViewById(R.id.tvEws);
        this.tvResponse = findViewById(R.id.tvResponse);
        this.tvRS = findViewById(R.id.tvReadStorage);
        btnRequestPermissions.setEnabled(true);
    }
}
