package master.imd.ufrn.br.carusepattern.getbehavior.domain;

public class SmallCar extends Car {

    public SmallCar(){

            engineCoolantTemp = new NumericAttribute(105, 25);
            engineLoad = new NumericAttribute(1, 0.051);
            engineRpm = new NumericAttribute(4000, 500);
            intakeManifoldPressure = new NumericAttribute(101, 13);
            maf = new NumericAttribute(1, 36);
            shortTermFuelTrimBank1 = new NumericAttribute(99, -100);
            speed = new NumericAttribute(100, 0);
            timingAdvance = new NumericAttribute(46, -54.6);
            throttlePos = new NumericAttribute(87, 9);

    }

}
