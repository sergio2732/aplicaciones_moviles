package co.edu.gestionpermisos;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.Serializable;

public class Status implements Serializable {
    private String mstatus;
    ConnectivityManager conexion;
    private Context context;
    public String checkConexion(Context context){
        conexion = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = conexion.getActiveNetworkInfo();
        boolean stateNet = networkInfo != null && networkInfo.isConnectedOrConnecting();
        if(stateNet){
            mstatus = "State ON";
        }else{
             mstatus = "State OFF";
        }
        return mstatus;
    }
}
