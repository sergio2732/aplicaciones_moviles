package co.edu.gestionpermisos;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {
    public static final int INT_DEFAULT = -100;
    private static final int REQUEST_CODE_BLUETOOTH = 100;

    private Context context;
    private Activity activity;
    //Android version
    private TextView versionAnd;
    private int vSDK;
    private ImageButton btnSaveFile;
    //Bluetooth
    BluetoothManager bluetoothManager;
    BluetoothAdapter bluetoothAdapter;
    //Bateria
    private ProgressBar pbLevelBatt;
    private TextView tvLevelBatt;
    IntentFilter battFilter;
    //Linterna - Flash
    CameraManager cameraManager;
    private Button btnOn;
    private Button btnOff;
    private Button btnOnB;
    private Button btnOffB;
    private Button btnPermisosB;
    String cameraId;
    private TextView tvConexion;
    //Archivos
    private EditText etnameFile;
    FileStorage fileStorage;
    Status checkStatus;
    Ligth ligth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inicio o enlace de componentes
        begin();
        //Botonos de flash
        this.btnOn.setOnClickListener(this::onLigth);
        this.btnOff.setOnClickListener(this::offLigth);
        //Bluetooth
        this.btnOnB.setOnClickListener(this::onBluetooth);
        this.btnOffB.setOnClickListener(this::offBluetooth);
        this.btnPermisosB.setOnClickListener(this::activateB);
        this.btnSaveFile.setOnClickListener(this::saveFile);
        //bateria
        battFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(broadReceiver, battFilter);
    }
    private void activateB(View view) {
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.BLUETOOTH_ADMIN) != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.BLUETOOTH_ADMIN) ||
                    ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_COARSE_LOCATION)) {
                showExplanationDialog();
            } else {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.BLUETOOTH_ADMIN, Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_CODE_BLUETOOTH);
            }
        }
    }
    private void saveFile(View view) {

        fileStorage.saveFile(String.valueOf(this.etnameFile), "archivo.txt");
    }

    //Chequeo de conexion

    BroadcastReceiver broadReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int levelBattery = intent .getIntExtra(BatteryManager.EXTRA_LEVEL, INT_DEFAULT);
            pbLevelBatt.setProgress(levelBattery);
            tvLevelBatt.setText("Level Baterry: "+ levelBattery+"%");

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadReceiver);
    }

    private void onLigth(View view) {
        try{
            ligth.onLigth(context, cameraId, cameraManager);
        }catch (Exception e){
            Log.i("Flash", e.getMessage());
        }
    }
    private void offLigth(View view) {
        try{
            ligth.offLigth(context, cameraId, cameraManager);
        }catch (Exception e){
            Log.i("Flash", e.getMessage());
        }
    }
    private void onBluetooth(View view) {
        try {
            bluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
            bluetoothAdapter = bluetoothManager.getAdapter();
            if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.BLUETOOTH_ADMIN) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.BLUETOOTH_ADMIN}, REQUEST_CODE_BLUETOOTH);
            } else {
                Intent activateB = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivity(activateB);
            }
        } catch(Exception e){
            Log.i("Bluetooth mensaje", e.getMessage());
        }
    }
    private void offBluetooth(View view) {
        try {
            if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.BLUETOOTH_ADMIN) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.BLUETOOTH_ADMIN}, REQUEST_CODE_BLUETOOTH);
            }
            bluetoothAdapter.disable();
        }catch(Exception e){
            Log.i("off bluetooth", e.getMessage());
        }
    }
    private void showExplanationDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Permiso de Bluetooth")
                .setMessage("la palicación necesita este permiso para su correcto funcionamiento")
                .setPositiveButton("Acepto", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.BLUETOOTH}, REQUEST_CODE_BLUETOOTH);
                        dialogInterface.dismiss();
                    }
                })
                .setNegativeButton("No acepto", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        showBluetoothPermissionDeniedDialog();
                    }
                })
                .show();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_BLUETOOTH) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            } else {
                showBluetoothPermissionDeniedDialog();
            }
        }
    }
    private void showBluetoothPermissionDeniedDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Permiso de Bluetooth denegado")
                .setMessage("No se otorgó el permiso para Bluetooth. Por favor, habilite los permisos en la configuración.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String versionSO = Build.VERSION.RELEASE;
        vSDK = Build.VERSION.SDK_INT;
        versionAnd.setText("Version SO" + versionSO + " / SDK " + vSDK);
        if(checkStatus != null){
            tvConexion.setText(checkStatus.checkConexion(context));
        }
    }

    private void begin(){
        this.context = getApplicationContext();
        this.activity = this;
        this.versionAnd = findViewById(R.id.tvVersionAndroid);
        this.pbLevelBatt = findViewById(R.id.pbLevelBaterry);
        this.tvLevelBatt = findViewById(R.id.tvLevelBaterry_2);
        this.tvConexion = findViewById(R.id.tvConexion);
        this.btnSaveFile = findViewById(R.id.btnSaveFile);
        this.etnameFile = findViewById(R.id.etNameFIle);
        this.btnOn = findViewById(R.id.btnOn);
        this.btnOff = findViewById(R.id.btnOff);
        this.btnOnB = findViewById(R.id.btnOnB);
        this.btnOffB = findViewById(R.id.btnOffB);
        this.btnPermisosB = findViewById(R.id.btnPermisosB);
        this.fileStorage = new FileStorage(context, activity);
        this.checkStatus = new Status();
        this.ligth = new Ligth();
    }
}