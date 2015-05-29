package appg711.com.edu.uniajc.appg711.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by haruiz on 5/28/15.
 */
public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final  String DATABASE_NAME = "uniajcdb";


    //el metodo constructor
    public DBHandler(Context context){

        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }


    //se ejecuta luego de que  la base de datos es creada
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE CONTACTS( " +
                "ID INTEGER PRIMARY KEY," +
                "NOMBRE TEXT," +
                "TEL TEXT" +
                ") ");

         db.execSQL("INSERT INTO CONTACTS VALUES(100, 'HENRY RUIZ', '3103821025')");

        db.execSQL("INSERT INTO CONTACTS VALUES(101, 'CAROLINA GARCIA', '31038233025')");

        db.execSQL("INSERT INTO CONTACTS VALUES(1002, 'VICTOR MARIO', '31038212025')");


    }

    //SOLO SI LA VERSION CAMBIA
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS CONTACTS");

        onCreate(db);
    }

    public ArrayList getListaContactos() throws Exception {

        ArrayList data = new ArrayList();//mi lista donde voy a guardar los contactos

        SQLiteDatabase db = this.getReadableDatabase();//obtengo la conexion  a la base datos

        //validando si la conexion esta abierta
        if(!db.isOpen())
            throw  new Exception("la conexion no esta abierta aún");

        //ejecuto la consulta
        Cursor resultSet = db.rawQuery("SELECT * FROM CONTACTS", null);

        //encontre resultados
        if(resultSet.getCount() > 0){

            while(resultSet.moveToNext()){

                int indexColumn =  resultSet.getColumnIndex("NOMBRE");

                data.add(resultSet.getString(indexColumn));

            }
        }
        else{

            throw new Exception("NO hay datos en la tabla de contactos");
        }

        return data;
    }
}
