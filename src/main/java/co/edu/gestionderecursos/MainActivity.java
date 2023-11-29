package co.edu.gestionderecursos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.camera2.CameraManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import co.edu.gestionderecursos.R;

public class MainActivity extends AppCompatActivity {
    public static final int INT_DEFAULT = -100;
    private Context context;
    private Activity activity;
    //Android version
    private TextView versionAnd;
    private int vSDK;
    //Bateria
    private ProgressBar pbLevelBatt;
    private TextView tvLevelBatt;
    IntentFilter battFilter;
    //Linterna - Flash
    CameraManager cameraManager;
    private Button btnOn;
    private Button btnOff;
    String cameraId;
    //Conexión
    private TextView tvConexion;
    ConnectivityManager conexion;
    //Archivos
    private EditText nameFile;
    private FileStorage fileStorage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inicio o enlace de componentes
        begin();
        //Botonos de flash
        this.btnOn.setOnClickListener(this::onLigth);
        this.btnOff.setOnClickListener(this::offLigth);
        //bateria
        battFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(broadReceiver, battFilter);

    }
    //Chequeo de conexion
    private void checkConexion(){
        conexion = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = conexion.getActiveNetworkInfo();
        boolean stateNet = networkInfo != null && networkInfo.isConnectedOrConnecting();
        if(stateNet){
            tvConexion.setText("State ON");
        }else{
            tvConexion.setText("State OFF");
        }
    }
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
            cameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
            cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, true);
        }catch (Exception e){
            Log.i("Flash", e.getMessage());
        }
    }
    private void offLigth(View view) {
        try{
            cameraManager.setTorchMode(cameraId, false);
        }catch (Exception e){
            Log.i("Flash", e.getMessage());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        String versionSO = Build.VERSION.RELEASE;
        vSDK = Build.VERSION.SDK_INT;
        versionAnd.setText("Version SO" + versionSO + " / SDK " + vSDK);
        checkConexion();
    }

    private void begin(){
        this.context = getApplicationContext();
        this.activity = this;
        this.versionAnd = findViewById(R.id.tvVersionAndroid);
        this.pbLevelBatt = findViewById(R.id.pbLevelBaterry);
        this.tvLevelBatt = findViewById(R.id.tvLevelBaterry_2);
        this.tvConexion = findViewById(R.id.tvConexion);
        this.btnOn = findViewById(R.id.btnOn);
        this.btnOff = findViewById(R.id.btnOff);
    }
}