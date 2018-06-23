package master.imd.ufrn.br.carusepattern.getbehavior.domain;

import com.google.gson.Gson;

import java.io.Serializable;

import master.imd.ufrn.br.carusepattern.getbehavior.util.DateParser;

public class ReadingFromCar extends Reading implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer idReadingFromCar;

	private double engineCoolantTemp;
	private double engineLoad; 
	private double engineRpm;
	private double intakeManifoldPressure; 
	private double maf;
	private double shortTermFuelTrimBank1;
	private double speed;
	private double throttlePos;
	private double timingAdvance;
	private String vehicleId;

	private Element element;
	
	public ReadingFromCar() {}
	
	public ReadingFromCar(String vehicleId, String date) {
		this.vehicleId = vehicleId;
		this.element = new Element();
		
		try {
			this.element.setDate(DateParser.stringToDate(date));
		} catch (Exception e) {
			this.element.setDate(null);
			e.printStackTrace();
		}
	}
	
	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Integer getIdReadingFromCar() {
		return idReadingFromCar;
	}

	public void setIdReadingFromCar(Integer idReadingFromCar) {
		this.idReadingFromCar = idReadingFromCar;
	}

	public double getEngineCoolantTemp() {
		return engineCoolantTemp;
	}
	
	public void setEngineCoolantTemp(double engineCoolantTemp) {
		this.engineCoolantTemp = engineCoolantTemp;
	}
	
	public double getEngineLoad() {
		return engineLoad;
	}
	
	public void setEngineLoad(double engineLoad) {
		this.engineLoad = engineLoad;
	}
	
	public double getEngineRpm() {
		return engineRpm;
	}
	
	public void setEngineRpm(double engineRpm) {
		this.engineRpm = engineRpm;
	}
	
	public double getIntakeManifoldPressure() {
		return intakeManifoldPressure;
	}
	
	public void setIntakeManifoldPressure(double intakeManifoldPressure) {
		this.intakeManifoldPressure = intakeManifoldPressure;
	}
	
	public double getMaf() {
		return maf;
	}
	
	public void setMaf(double maf) {
		this.maf = maf;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public double getShortTermFuelTrimBank1() {
		return shortTermFuelTrimBank1;
	}
	
	public void setShortTermFuelTrimBank1(double shortTermFuelTrimBank1) {
		this.shortTermFuelTrimBank1 = shortTermFuelTrimBank1;
	}
	
	public double getThrottlePos() {
		return throttlePos;
	}
	
	public void setThrottlePos(double throttlePos) {
		this.throttlePos = throttlePos;
	}
	
	public double getTimingAdvance() {
		return timingAdvance;
	}
	
	public void setTimingAdvance(double timingAdvance) {
		this.timingAdvance = timingAdvance;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	@Override
	public String toString() {
		return "ReadingFromCar: " + "\n"
			   + " engineCoolantTemp = " + engineCoolantTemp + "\n"
			   + " engineLoad = " + engineLoad + "\n"
			   + " engineRpm = " + engineRpm + "\n"
			   + " intakeManifoldPressure = " + intakeManifoldPressure + "\n"
			   + " maf = " + maf + "\n"
			   + " shortTermFuelTrimBank1 = " + shortTermFuelTrimBank1 + "\n"
			   + " speed = " + speed + "\n"
			   + " throttlePos = " + throttlePos + "\n"
			   + " timingAdvance = " + timingAdvance + "\n"
			   + " vehicleId = " + vehicleId + "\n"
			   + " idElement = " + element.getPredictedValue() + "\n"
		       + " elementDate = " + DateParser.dateToString(element.getDate()) + "\n"
			   + " predictedValue = " + element.getPredictedValue();
	}

	public String toGsonString() {
		Gson gson = new Gson();
		String json = new String();
		json = gson.toJson(this);
		return json;
	}

}
