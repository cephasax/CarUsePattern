package master.imd.ufrn.br.carusepattern.getbehavior.domain;

import java.io.Serializable;
import java.util.Date;

public class Element implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer idElement;

	private Date date;
	
	private String predictedValue;
	
	public Element() {
		this.date = new Date();
		this.predictedValue = new String("cluster1");
	}

	public Integer getIdElement() {
		return idElement;
	}

	public void setIdElement(Integer idElement) {
		this.idElement = idElement;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPredictedValue() {
		return predictedValue;
	}

	public void setPredictedValue(String predictedValue) {
		this.predictedValue = predictedValue;
	}
	
}
