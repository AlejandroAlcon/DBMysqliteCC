package com.lex.alcon.alejandro.lex.dbmysqlitecc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ALEJANDRO ALCON on 08-may-19.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "persona.db";
    public static final String TABLE_NAME = "persona";

    //.....
    public static final String COL1 = "id_persona";
    public static final String COL2 = "nombres";
    public static final String COL3 = "ap_paterno";
    public static final String COL4 = "ap_materno";




    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (id_persona INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombres text,ap_paterno text,ap_materno text) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


//77719454
    public boolean insertData(String nombres, String ap_paterno, String ap_materno)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL2,nombres);
        contentValues.put(COL3,ap_paterno);
        contentValues.put(COL4,ap_materno);


        long res=db.insert(TABLE_NAME,null,contentValues);

        if (res== -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }


    public Cursor getAllData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+ TABLE_NAME,null);
        return res;

    }
    public boolean updateData(String id_persona, String nombres, String ap_paterno, String ap_materno )
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL1,id_persona);
        contentValues.put(COL2,nombres);
        contentValues.put(COL3,ap_paterno);
        contentValues.put(COL4,ap_materno);

        db.update(TABLE_NAME,contentValues,"id_persona = ?",new String[] {id_persona});
        return true;
        //22CC727PCS
    }

    public Integer deleteData(String id_persona)
    {
       SQLiteDatabase db=this.getWritableDatabase();
       return db.delete(TABLE_NAME,"id_persona=?",new String[]{id_persona});
    }






}
