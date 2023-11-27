package co.edu.hospedaje.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.google.android.material.snackbar.Snackbar;

import android.database.SQLException;
import java.util.ArrayList;
import android.database.Cursor;
import android.view.View;

import co.edu.hospedaje.entidades.Persona;

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
        values.put("peop_names", persona.getName());
        values.put("peop_lastNames", persona.getLastname());
        values.put("peop_document", persona.getDocument());
        values.put("peop_status", "1");
        return values;
    }
    public void insertPeorple(Persona persona){
        try{
            SQLiteDatabase db = dataBase.getWritableDatabase();
            if(db != null){
                ContentValues values = ValuesPersona(persona);
                long code = db.insert(ManagerDataBase.TABLE_PEOPLES, null, values);
                Snackbar.make(this.view, "Se ha registrado la persona: "+code,Snackbar.LENGTH_LONG).show();
            }else{
                Snackbar.make(this.view, "No se ha registrado la persona",Snackbar.LENGTH_LONG).show();
            }
        }catch (SQLException e){
            Log.i("Error en DB", ""+e);
            Snackbar.make(this.view, "Error comuniquese con los Desarrolladores",Snackbar.LENGTH_LONG).show();
        }
    }
    public void updatePerson(Persona persona) {
        try {
            SQLiteDatabase db = dataBase.getWritableDatabase();
            if (db != null) {
                ContentValues values = ValuesPersona(persona);
                String[] updateId = {String.valueOf(persona.getDocument())};
                long changes = db.update(ManagerDataBase.TABLE_PEOPLES, values, "peop_document=?", updateId);
                if (changes > 0) {
                    Snackbar.make(this.view, "Se actualizaron los datos", Snackbar.LENGTH_LONG).show();
                } else {
                    Snackbar.make(this.view, "No se pudieron actualizar los datos", Snackbar.LENGTH_LONG).show();
                }
            } else {
                Snackbar.make(this.view, "No hay cuenta registrada", Snackbar.LENGTH_LONG).show();
            }
        } catch (SQLException e) {
            Log.i("Error en DB", "" + e);
            Snackbar.make(this.view, "Error, comuníquese con los Desarrolladores", Snackbar.LENGTH_LONG).show();
        }
    }
    public void deletePerson(Persona persona){
        try{
            SQLiteDatabase db = dataBase.getWritableDatabase();
            if(db != null){
              String [] deleteId = {String.valueOf(persona.getDocument())};
              long deletes = db.delete(ManagerDataBase.TABLE_PEOPLES, "peop_document=?", deleteId);
              if(deletes == 0){
                  Snackbar.make(this.view, "No se ha podido completar la operacion", Snackbar.LENGTH_LONG).show();
              }else{
                  Snackbar.make(this.view, "Se a eliminado a la persona exitosamente", Snackbar.LENGTH_LONG).show();
              }
            }
        }catch (SQLException e){
            Log.i("Error en DB", "" + e);
            Snackbar.make(this.view, "Error, comuníquese con los Desarrolladores", Snackbar.LENGTH_LONG).show();
        }
    }
    public void disableStatus(Persona persona){
        try{
            SQLiteDatabase db = dataBase.getWritableDatabase();
            if(db != null){
                ContentValues valueStatus = new ContentValues();
                valueStatus.put("peop_status", "0");
                String [] disableId = {String.valueOf(persona.getDocument())};
                long disable = db.update(ManagerDataBase.TABLE_PEOPLES, valueStatus, "peop_document=?", disableId);
                if (disable != 0){
                    Snackbar.make(this.view, "Se ha deshabilitado al usuario", Snackbar.LENGTH_LONG).show();
                }else{
                    Snackbar.make(this.view, "No se ha podido deshabiliar al usuario", Snackbar.LENGTH_LONG).show();
                }
            }
        }catch (SQLException e){
            Log.i("Error en DB", "" + e);
            Snackbar.make(this.view, "Error, comuníquese con los Desarrolladores", Snackbar.LENGTH_LONG).show();
        }
    }
    public ArrayList<Persona> getPeopleList(){
        SQLiteDatabase db = dataBase.getReadableDatabase();
        String query ="select * from peoples where peop_status = '1';";
        ArrayList<Persona> listPeople = new ArrayList<>();
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()){
            do{
                Persona persona = new Persona();
                persona.setDocument(cursor.getString(0));
                persona.setName(cursor.getString(1));
                persona.setLastname(cursor.getString(2));
                listPeople.add(persona);

            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listPeople;
    }
}
