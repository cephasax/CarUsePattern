package master.imd.ufrn.br.carusepattern.getbehavior.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import master.imd.ufrn.br.carusepattern.getbehavior.helper.DatabaseHelper;

public abstract class GeneralDao {

    protected SQLiteDatabase db;
    protected String tableName;
    protected String[] colunas;

    protected GeneralDao(Context context){
        DatabaseHelper databaseHelper = DatabaseHelper.getHelper(context);
        db = databaseHelper.getWritableDatabase();
        this.tableName = new String();
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public String getTableName() {
        return tableName;
    }

    public void clearThisTable(){
        db.execSQL("delete FROM " + tableName);
    }

}
