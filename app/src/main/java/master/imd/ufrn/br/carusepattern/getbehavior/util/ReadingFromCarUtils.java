package master.imd.ufrn.br.carusepattern.getbehavior.util;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import master.imd.ufrn.br.carusepattern.getbehavior.domain.CountAndMean;
import master.imd.ufrn.br.carusepattern.getbehavior.domain.ReadingFromCar;
import master.imd.ufrn.br.carusepattern.getbehavior.domain.Element;

public class ReadingFromCarUtils {

    private static CountAndMean engineRpm;
    private static CountAndMean engineLoad;
    private static CountAndMean speed;
    private static CountAndMean intakeManifoldPressure;
    private static CountAndMean maf;
    private static CountAndMean timingAdvance;
    private static CountAndMean throttlePos;
    private static CountAndMean shortTermFuelTrimBank1;
    private static CountAndMean engineCoolantTemp;

    private static String vehicleId;
    private static Date date;

    public static ReadingFromCar sumarizeReadings(ArrayList<ReadingFromCar> readings){

        vehicleId = readings.get(0).getVehicleId();
        date = readings.get(0).getElement().getDate();
        buildCountValues();

        for(ReadingFromCar rfc: readings){
            checkAndIncreaseValues(engineRpm, rfc.getEngineRpm());
            checkAndIncreaseValues(engineLoad, rfc.getEngineLoad());
            checkAndIncreaseValues(speed, rfc.getSpeed());
            checkAndIncreaseValues(intakeManifoldPressure, rfc.getIntakeManifoldPressure());
            checkAndIncreaseValues(maf, rfc.getMaf());
            checkAndIncreaseValues(timingAdvance, rfc.getTimingAdvance());
            checkAndIncreaseValues(throttlePos, rfc.getThrottlePos());
            checkAndIncreaseValues(shortTermFuelTrimBank1, rfc.getShortTermFuelTrimBank1());
            checkAndIncreaseValues(engineCoolantTemp, rfc.getEngineCoolantTemp());
        }

        calcMeans();

        return makeReadingFromCar();
    }

    private static void calcMeans(){
        engineRpm.calcMid();
        engineLoad.calcMid();
        speed.calcMid();
        intakeManifoldPressure.calcMid();
        maf.calcMid();
        timingAdvance.calcMid();
        throttlePos.calcMid();
        shortTermFuelTrimBank1.calcMid();
        engineCoolantTemp.calcMid();
    }

    private static ReadingFromCar makeReadingFromCar(){
        Element element = new Element();
        element.setDate(date);

        ReadingFromCar r = new ReadingFromCar();
        r.setElement(element);

        r.setVehicleId(vehicleId);

        r.setEngineRpm(engineRpm.getMean());
        r.setEngineLoad(engineLoad.getMean());
        r.setSpeed(speed.getMean());
        r.setIntakeManifoldPressure(intakeManifoldPressure.getMean());
        r.setMaf(maf.getMean());
        r.setTimingAdvance(timingAdvance.getMean());
        r.setThrottlePos(throttlePos.getMean());
        r.setShortTermFuelTrimBank1(shortTermFuelTrimBank1.getMean());
        r.setEngineCoolantTemp(engineCoolantTemp.getMean());

        return r;
    }

    private static void checkAndIncreaseValues(CountAndMean cam, Double value){
        if(value != null){
            cam.increaseTotalValue(value);
            cam.increaseCount();
        }
    }

    private static void buildCountValues(){
        engineRpm= new CountAndMean();
        engineLoad= new CountAndMean();
        speed= new CountAndMean();
        intakeManifoldPressure= new CountAndMean();
        maf= new CountAndMean();
        timingAdvance= new CountAndMean();
        throttlePos= new CountAndMean();
        shortTermFuelTrimBank1= new CountAndMean();
        engineCoolantTemp= new CountAndMean();
    }

    public static ReadingFromCar makeReadingFromHashMap(HashMap<String,String> hash) throws ParseException {

        String vehicleId = new String(hash.get("vehicleId"));
        String date = new String(hash.get("date"));

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

        element.setDate(DateParser.stringToDate(date));

        reading.setElement(element);

        return reading;

    }

}
