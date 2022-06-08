package com.example.helper_royale;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String nomedb = "BDHelper_Royale";

    // below int is our database version
    private static final int versao_banco = 1;

    // below variable is for our table name.
    private static final String tabela_perfil = "TBPerfil";

    // below variable is for our id column.
    private static final String Tag_COL = "TagPlayer";

    // below variable is for our course name column
    private static final String Senha_COL = "SenhaPlayer";


    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, nomedb, null, versao_banco);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + tabela_perfil + " ("
                + Tag_COL + "TEXT Primary key, "
                + Senha_COL + " TEXT not null)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new course to our sqlite database.
    public void addPerfil(String tagPerfil, String senhaPlayer) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(Tag_COL, tagPerfil);
        values.put(Tag_COL, senhaPlayer );


        // after adding all values we are passing
        // content values to our table.
        db.insert(tabela_perfil, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + tabela_perfil);
        onCreate(db);
    }
}

