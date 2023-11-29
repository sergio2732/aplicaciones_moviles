package co.edu.gestionderecursos;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileStorage {
    private Context context;
    private Activity activity;
    private String nameFolder = "Archivo:)";
    public FileStorage(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }
    //Crear directorio
    private void createDir(File file){
        if(!file.exists()){
            file.mkdirs();
        }
    }
    public void saveFile(String nameFile, String information){
        File folder = null;
        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.P){
            folder = new File(Environment.getExternalStorageDirectory(), nameFolder);
            createDir(folder);
            Toast.makeText(context, "Ruta:"+folder, Toast.LENGTH_LONG).show();
        }else{
            //Versiones superiores a la 10(Q)
            folder = new File(context.getExternalFilesDir(Environment.MEDIA_SHARED), nameFolder);
            createDir(folder);
            Toast.makeText(context, "Ruta:"+folder, Toast.LENGTH_LONG).show();
        }
        if (folder != null){
            try{
                File file = new File(folder, nameFile);
                FileWriter writer = new FileWriter(file);
                writer.append(information);
                writer.flush();
                writer.close();
                Toast.makeText(context, "Se ha guardado el archivo", Toast.LENGTH_SHORT).show();
            }catch (IOException e){
                Log.i("---Archivo---", ""+e.getMessage());
            }
        }
    }
}
