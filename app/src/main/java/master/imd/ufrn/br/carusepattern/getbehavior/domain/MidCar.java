package master.imd.ufrn.br.carusepattern.getbehavior.domain;

public class MidCar extends Car {

    public MidCar(){

        engineCoolantTemp = new NumericAttribute(105, 25);
        engineLoad = new NumericAttribute(1, 0.051);
        engineRpm = new NumericAttribute(4000, 500);
        intakeManifoldPressure = new NumericAttribute(101, 13);
        maf = new NumericAttribute(1, 36);
        shortTermFuelTrimBank1 = new NumericAttribute(16, -100);
        speed = new NumericAttribute(120, 0);
        timingAdvance = new NumericAttribute(48, -63);
        throttlePos = new NumericAttribute(87, 0);
    }


}
