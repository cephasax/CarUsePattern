package master.imd.ufrn.br.carusepattern.getbehavior.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import master.imd.ufrn.br.carusepattern.getbehavior.domain.Element;
import master.imd.ufrn.br.carusepattern.getbehavior.domain.ReadingFromCar;
import master.imd.ufrn.br.carusepattern.getbehavior.util.DateParser;


/**
 * Created by Cephas
 */
public class ReadingFromCarDao extends GeneralDao{

    public ReadingFromCarDao(Context context){
        super(context);
        this.tableName = "READINGS_FROM_CAR";

        colunas = new String[]{	"ID_READING_FROM_CAR",
                                "ENGINE_COOLANT_TEMP",
                                "ENGINE_LOAD",
                                "ENGINE_RPM",
                                "INTAKE_MANIFOLD_PRESSURE",
                                "MAF",
                                "SHORT_TERM_FUEL_TRIM_BANK_1",
                                "SPEED",
                                "THROTTLE_POS",
                                "TIMING_ADVANCE",
                                "VEHICLE_ID",
                                "ID_ELEMENT",
                                "DATE",
                                "PREDICTED_VALUE" };
    }

    public void insertOrUpdate(ReadingFromCar reading) {
        ContentValues values = new ContentValues(14);

        values.put("ID_READING_FROM_CAR", reading.getIdReadingFromCar());
        values.put("ENGINE_COOLANT_TEMP", String.valueOf(reading.getEngineCoolantTemp()));
        values.put("ENGINE_LOAD", String.valueOf(reading.getEngineLoad()));
        values.put("ENGINE_RPM", String.valueOf(reading.getEngineRpm()));
        values.put("INTAKE_MANIFOLD_PRESSURE", String.valueOf(reading.getIntakeManifoldPressure()));
        values.put("MAF", String.valueOf(reading.getMaf()));
        values.put("SHORT_TERM_FUEL_TRIM_BANK_1", String.valueOf(reading.getShortTermFuelTrimBank1()));
        values.put("SPEED", String.valueOf(reading.getSpeed()));
        values.put("THROTTLE_POS", String.valueOf(reading.getThrottlePos()));
        values.put("TIMING_ADVANCE", String.valueOf(reading.getTimingAdvance()));
        values.put("VEHICLE_ID", String.valueOf(reading.getVehicleId()));

        values.put("ID_ELEMENT" , String.valueOf(reading.getElement().getIdElement()));
        values.put("DATE", DateParser.dateToString(reading.getElement().getDate()));
        values.put("PREDICTED_VALUE", String.valueOf(reading.getElement().getPredictedValue()));

/*        if(reading.getIdReadingFromCar() > 0) {
            db.update("READINGS_FROM_CAR", values, "id = ?",
                      new String[] { "" + reading.getIdReadingFromCar()});
        }
        else {*/
            db.insert("READINGS_FROM_CAR", null, values);
       /* }*/
    }

    public void remove(ReadingFromCar reading) {
        String[] id = {String.valueOf(reading.getIdReadingFromCar())};
        db.delete("READINGS_FROM_CAR", "ID_READING_FROM_CAR=?", id);
    }

    public List<ReadingFromCar> list() throws ParseException {
        List<ReadingFromCar> readingsFromCar = new ArrayList<ReadingFromCar>();
        Cursor c = db.query("READINGS_FROM_CAR", this.colunas,
                            null, null, null, null, "VEHICLE_ID");
        if (c.moveToFirst()){
            do{
                ReadingFromCar reading = new ReadingFromCar();
                Element element = new Element();
                reading.setElement(element);

                reading.setIdReadingFromCar(c.getInt(0));

                reading.setEngineCoolantTemp(c.getDouble(1));
                reading.setEngineLoad(c.getDouble(2));
                reading.setEngineRpm(c.getDouble(3));
                reading.setIntakeManifoldPressure(c.getDouble(4));
                reading.setMaf(c.getDouble(5));
                reading.setShortTermFuelTrimBank1(c.getDouble(6));
                reading.setSpeed(c.getDouble(7));
                reading.setThrottlePos(c.getDouble(8));
                reading.setTimingAdvance(c.getDouble(9));

                reading.setVehicleId(c.getString(10));

                reading.getElement().setIdElement(c.getInt(11));
                reading.getElement().setDate(DateParser.stringToDate(c.getString(12)));
                reading.getElement().setPredictedValue(c.getString(13));

                readingsFromCar.add(reading);
            }
            while(c.moveToNext());
        }
        c.close();
        return readingsFromCar;
    }

    public ReadingFromCar findByPrimaryKey(int id) throws ParseException {
        ReadingFromCar reading = new ReadingFromCar();
        Element element = new Element();
        reading.setElement(element);

        Cursor c = db.query("READINGS_FROM_CAR", this.colunas,
                                 "ID_READING_FROM_CAR="+id, null, null, null, null);

        if (c.moveToFirst()){
            reading.setIdReadingFromCar(c.getInt(0));

            reading.setEngineCoolantTemp(c.getDouble(1));
            reading.setEngineLoad(c.getDouble(2));
            reading.setEngineRpm(c.getDouble(3));
            reading.setIntakeManifoldPressure(c.getDouble(4));
            reading.setMaf(c.getDouble(5));
            reading.setShortTermFuelTrimBank1(c.getDouble(6));
            reading.setSpeed(c.getDouble(7));
            reading.setThrottlePos(c.getDouble(8));
            reading.setTimingAdvance(c.getDouble(9));

            reading.setVehicleId(c.getString(10));

            reading.getElement().setIdElement(c.getInt(11));
            reading.getElement().setDate(DateParser.stringToDate(c.getString(12)));
            reading.getElement().setPredictedValue(c.getString(13));
        }
        c.close();
        return reading;
    }

    public ReadingFromCar getLastRecord(String vId) throws ParseException {
        ReadingFromCar reading = new ReadingFromCar();
        Element element = new Element();
        reading.setElement(element);

        Cursor c = db.rawQuery("select * from READINGS_FROM_CAR"
                + " where VEHICLE_ID = '"
                + vId+"'"
                + " order by date desc limit 1", null);
        if (c.moveToFirst()){
            reading.setIdReadingFromCar(c.getInt(0));

            reading.setEngineCoolantTemp(c.getDouble(1));
            reading.setEngineLoad(c.getDouble(2));
            reading.setEngineRpm(c.getDouble(3));
            reading.setIntakeManifoldPressure(c.getDouble(4));
            reading.setMaf(c.getDouble(5));
            reading.setShortTermFuelTrimBank1(c.getDouble(6));
            reading.setSpeed(c.getDouble(7));
            reading.setThrottlePos(c.getDouble(8));
            reading.setTimingAdvance(c.getDouble(9));

            reading.setVehicleId(c.getString(10));

            reading.getElement().setIdElement(c.getInt(11));
            reading.getElement().setDate(DateParser.stringToDate(c.getString(12)));
            reading.getElement().setPredictedValue(c.getString(13));
        }
        c.close();
        return reading;
    }

    public boolean isAlreadyInDataBase(Integer id) throws ParseException {
        boolean isAlreadyInDataBase = false;
        Cursor c = db.query("READINGS_FROM_CAR", this.colunas,
                "ID_READING_FROM_CAR="+id, null, null, null, null);
        isAlreadyInDataBase = c.moveToFirst();
        c.close();
        return isAlreadyInDataBase;
    }

}

