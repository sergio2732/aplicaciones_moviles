package co.edu.gestion_inventarios.model;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.google.android.material.snackbar.Snackbar;

import android.database.SQLException;
import java.util.ArrayList;
import android.database.Cursor;
import android.view.View;

import co.edu.gestion_inventarios.entidades.Persona;

public class PersonaDao {
    private ManagerDataBase dataBase;
    Context context;
    View view;
    Persona persona;

    public PersonaDao(Context context, View view) {
        this.context = context;
        this.view = view;
        this.dataBase = new ManagerDataBase(this.context);
    }
    private ContentValues ValuesPersona(Persona persona){
        ContentValues values = new ContentValues();
        values.put("user_names", persona.getName());
        values.put("user_email", persona.getEmail());
        values.put("user_pss", persona.getPss());
        values.put("user_status", "1");
        return values;
    }
    public void insertPeorple(Persona persona){
        try{
            SQLiteDatabase db = dataBase.getWritableDatabase();
            if(db != null){
                ContentValues values = ValuesPersona(persona);
                long code = db.insert(ManagerDataBase.TABLE_PEOPLES, null, values);
                Snackbar.make(this.view, "Se ha registrado al usuario: "+code,Snackbar.LENGTH_LONG).show();
            }else{
                Snackbar.make(this.view, "No se ha registrado al usuario",Snackbar.LENGTH_LONG).show();
            }
        }catch (SQLException e){
            Log.i("Error en DB", ""+e);
            Snackbar.make(this.view, "Error comuniquese con los Desarrolladores",Snackbar.LENGTH_LONG).show();
        }
    }
}