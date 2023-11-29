package co.edu.gestion_inventarios.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ManagerDataBase extends SQLiteOpenHelper {
    private static final String DATA_BASE = "dbUsers";
    private static final int VERSION = 1;
    public static final String TABLE_PEOPLES = "users";
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_PEOPLES + " (user_id varchar(20) PRIMARY KEY, " +
            "user_names varchar(100) NOT NULL, user_mail varchar(100) NOT NULL, user_pss varchar(100) NOT NULL,user_status varchar(1));";
    private static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_PEOPLES;
    public ManagerDataBase(@Nullable Context context){
        super(context, DATA_BASE, null, VERSION);
    };
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(DELETE_TABLE);
        onCreate(db);
    }
}