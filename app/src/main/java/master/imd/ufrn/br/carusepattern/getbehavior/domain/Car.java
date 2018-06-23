package master.imd.ufrn.br.carusepattern.getbehavior.domain;

public abstract class Car {

    protected NumericAttribute engineRpm;
    protected NumericAttribute engineLoad;
    protected NumericAttribute speed;
    protected NumericAttribute intakeManifoldPressure;
    protected NumericAttribute maf;
    protected NumericAttribute timingAdvance;
    protected NumericAttribute throttlePos;
    protected NumericAttribute shortTermFuelTrimBank1;
    protected NumericAttribute engineCoolantTemp;

    public NumericAttribute getEngineRpm() {
        return engineRpm;
    }

    public NumericAttribute getEngineLoad() {
        return engineLoad;
    }

    public NumericAttribute getSpeed() {
        return speed;
    }

    public NumericAttribute getIntakeManifoldPressure() {
        return intakeManifoldPressure;
    }

    public NumericAttribute getMaf() {
        return maf;
    }

    public NumericAttribute getTimingAdvance() {
        return timingAdvance;
    }

    public NumericAttribute getThrottlePos() {
        return throttlePos;
    }

    public NumericAttribute getShortTermFuelTrimBank1() {
        return shortTermFuelTrimBank1;
    }

    public NumericAttribute getEngineCoolantTemp() {
        return engineCoolantTemp;
    }

}
