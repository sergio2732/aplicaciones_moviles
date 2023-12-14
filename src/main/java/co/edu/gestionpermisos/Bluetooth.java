package co.edu.gestionpermisos;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.Serializable;

public class Bluetooth implements Serializable {

    private static final int REQUEST_CODE_BLUETOOTH = 100;
    private Context context;
    private BluetoothManager bluetoothManager;
    private BluetoothAdapter bluetoothAdapter;

    public Bluetooth(Context context) {
        this.context = context;
    }

    public void onBluetooth() {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.BLUETOOTH_ADMIN) != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.BLUETOOTH_ADMIN) ||
                    ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.ACCESS_COARSE_LOCATION)) {
                showExplanationDialog();
            } else {
                ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.BLUETOOTH_ADMIN, Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_CODE_BLUETOOTH);
            }
        }
    }

    public void activateB() {
        try {
            bluetoothManager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
            bluetoothAdapter = bluetoothManager.getAdapter();
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.BLUETOOTH_ADMIN) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.BLUETOOTH_ADMIN}, REQUEST_CODE_BLUETOOTH);
            } else {
                Intent enableBluetoothIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                context.startActivity(enableBluetoothIntent);
            }
        } catch (Exception e) {
            Log.i("Bluetooth mensaje", e.getMessage());
        }
    }

    public void offBluetooth() {
        try {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.BLUETOOTH_ADMIN) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.BLUETOOTH_ADMIN}, REQUEST_CODE_BLUETOOTH);
            }
            if (bluetoothAdapter != null) {
                bluetoothAdapter.disable();
            }
        } catch (Exception e) {
            Log.i("off bluetooth", e.getMessage());
        }
    }

    public void showExplanationDialog() {
        new AlertDialog.Builder(context)
                .setTitle("Permiso de Bluetooth")
                .setMessage("La aplicación necesita este permiso para su correcto funcionamiento")
                .setPositiveButton("Acepto", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.BLUETOOTH}, REQUEST_CODE_BLUETOOTH);
                        dialogInterface.dismiss();
                    }
                })
                .setNegativeButton("No acepto", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        showBluetoothPermissionDeniedDialog(context);
                    }
                })
                .show();
    }

    public void showBluetoothPermissionDeniedDialog(Context context) {
        new AlertDialog.Builder(context)
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
}
