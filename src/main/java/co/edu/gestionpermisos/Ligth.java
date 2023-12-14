package co.edu.gestionpermisos;

import android.Manifest;
import android.content.Context;
import android.hardware.camera2.CameraManager;
import android.util.Log;
import android.view.View;

import androidx.core.content.ContextCompat;

import java.io.Serializable;

public class Ligth implements Serializable {
    public void onLigth(Context context, String cameraId, CameraManager cameraManager) {
        try{
            cameraManager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
            cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, true);
        }catch (Exception e){
            Log.i("Flash", e.getMessage());
        }
    }
    public void offLigth(Context context,String cameraId,CameraManager cameraManager) {
        try{
            cameraManager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
            cameraId = cameraManager.getCameraIdList()[0];
            cameraManager.setTorchMode(cameraId, false);
        }catch (Exception e){
            Log.i("Flash", e.getMessage());
        }
    }
}
