package master.imd.ufrn.br.carusepattern.getbehavior.domain;

public class BigCar extends Car{

    public BigCar(){
        engineCoolantTemp = new NumericAttribute(105, 25);
        engineLoad = new NumericAttribute(1, 0.051);
        engineRpm = new NumericAttribute(4000, 500);
        intakeManifoldPressure = new NumericAttribute(101, 13);
        maf = new NumericAttribute(1, 57);
        shortTermFuelTrimBank1 = new NumericAttribute(30, -100);
        speed = new NumericAttribute(140, 0);
        timingAdvance = new NumericAttribute(47, -63);
        throttlePos = new NumericAttribute(88, 3);
    }

}
