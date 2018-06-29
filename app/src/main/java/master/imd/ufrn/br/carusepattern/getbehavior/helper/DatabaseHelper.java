package master.imd.ufrn.br.carusepattern.getbehavior.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Database Helper to manage Application Database
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "car_use_pattern";
    private static final int DB_VERSION = 1;

    private static final String READINGS_TABLE_CREATE_RFC = "CREATE TABLE READINGS_FROM_CAR (" +
                                                            "ID_READING_FROM_CAR INTEGER PRIMARY KEY AUTOINCREMENT," +
                                                            "ENGINE_COOLANT_TEMP TEXT," +
                                                            "ENGINE_LOAD TEXT," +
                                                            "ENGINE_RPM TEXT," +
                                                            "INTAKE_MANIFOLD_PRESSURE TEXT," +
                                                            "MAF TEXT," +
                                                            "SHORT_TERM_FUEL_TRIM_BANK_1 TEXT," +
                                                            "SPEED TEXT," +
                                                            "THROTTLE_POS TEXT," +
                                                            "TIMING_ADVANCE TEXT," +
                                                            "VEHICLE_ID TEXT, " +
                                                            "ID_ELEMENT TEXT," +
                                                            "DATE TEXT," +
                                                            "PREDICTED_VALUE TEXT);";
    
    private static DatabaseHelper instance;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static synchronized DatabaseHelper getHelper(Context context) {
        if (instance == null) {
            instance = new DatabaseHelper(context);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(READINGS_TABLE_CREATE_RFC);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // No migrations needed
    }
}
