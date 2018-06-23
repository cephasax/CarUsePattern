package master.imd.ufrn.br.carusepattern.getbehavior.util;
import java.util.ArrayList;
import java.util.Calendar;

import master.imd.ufrn.br.carusepattern.getbehavior.domain.ReadingFromCar;

import static master.imd.ufrn.br.carusepattern.getbehavior.util.DoubleUtils.randomDouble;


public class MockReadings {

    public static ArrayList<ReadingFromCar> createReadings(){

        ArrayList<ReadingFromCar> readings = new ArrayList<ReadingFromCar>();
        ArrayList<String> placas = new ArrayList<String>();
        placas.add("MTC-4052");
        placas.add("IET-5682");
        placas.add("JZC-6601");
        placas.add("MZF-6638");
        placas.add("KIZ-5481");
        placas.add("MPJ-8698");
        placas.add("KFE-0204");
        placas.add("KGM-5852");
        placas.add("LZH-2182");
        placas.add("LWI-2246");

        for(String s: placas) {
            Calendar c = Calendar.getInstance();
            ReadingFromCar rfc = new ReadingFromCar(s, DateParser.dateToString(c.getTime()));

            rfc.setEngineCoolantTemp(randomDouble());
            rfc.setEngineLoad(randomDouble());
            rfc.setEngineRpm(randomDouble());
            rfc.setIntakeManifoldPressure(randomDouble());
            rfc.setMaf(randomDouble());
            rfc.setSpeed(randomDouble());
            rfc.setShortTermFuelTrimBank1(randomDouble());
            rfc.setThrottlePos(randomDouble());
            rfc.setTimingAdvance(randomDouble());

            //MOCK ids
            rfc.setIdReadingFromCar(0);
            rfc.getElement().setIdElement(0);

            readings.add(rfc);
        }

        return readings;
    }



}
