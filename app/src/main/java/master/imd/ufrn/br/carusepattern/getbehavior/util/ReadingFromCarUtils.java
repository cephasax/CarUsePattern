package master.imd.ufrn.br.carusepattern.getbehavior.util;

import android.util.Log;

import com.google.gson.Gson;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import master.imd.ufrn.br.carusepattern.getbehavior.domain.ReadingFromCar;
import master.imd.ufrn.br.carusepattern.getbehavior.domain.Element;

public class ReadingFromCarUtils {

    private static String vehicleId;
    private static Date date;

    public static ReadingFromCar makeReadingFromHashMap(HashMap<String,String> hash) throws ParseException {

        String vehicleId = new String(hash.get("vehicleId"));
        String date = new String(hash.get("element"));

        Element element = new Element();

        ReadingFromCar reading = new ReadingFromCar(vehicleId, date);
        reading.setEngineCoolantTemp(Double.valueOf(hash.get("engineCoolantTemp")));
        reading.setEngineLoad(Double.valueOf(hash.get("engineLoad")));
        reading.setEngineRpm(Double.valueOf(hash.get("engineRpm")));
        reading.setIntakeManifoldPressure(Double.valueOf(hash.get("intakeManifoldPressure")));
        reading.setMaf(Double.valueOf(hash.get("maf")));
        reading.setSpeed(Double.valueOf(hash.get("speed")));
        reading.setShortTermFuelTrimBank1(Double.valueOf(hash.get("shortTermFuelTrimBank1")));
        reading.setThrottlePos(Double.valueOf(hash.get("throttlePos")));
        reading.setTimingAdvance(Double.valueOf(hash.get("timingAdvance")));

        reading.setIdReadingFromCar(Integer.valueOf(hash.get("idReadingFromCar")));

        element.setDate(DateParser.stringToDate(date));

        reading.setElement(element);

        return reading;

    }

    public static ReadingFromCar makeReadingFromResponseString(String string) throws ParseException {

        Gson gson = new Gson();
        ReadingFromCar r = gson.fromJson(string, ReadingFromCar.class);

        return r;

    }

}
