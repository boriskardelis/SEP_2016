package ftn.uns.ac.rs.tim6.model;


import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "region")
public class Region implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	public enum Kontinenti {
		EUROPE("Europe"),
		ASIA("Asia"),
		NORTH_AMERICA("North America"),
		SOUTH_AMERICA("South America"),
		AFRICA("Africa"),
		AUSTRALIA("Australia");
		
		private String name;
		
		private Kontinenti(String value) {
			this.name = value;
		}
		
		@Override
		public String toString() {
			return name;
		}
	}
	
	 @Id
	 @GeneratedValue
	 @Column(name = "region")
	 private Kontinenti region;
	 
	 @Column(name = "risk_value")
	 private Double riskValue;
	 
	 
	

	public Kontinenti getRegion() {
		return region;
	}

	public void setRegion(Kontinenti region) {
		this.region = region;
	}

	public Double getRiskValue() {
		return riskValue;
	}

	public void setRiskValue(Double riskValue) {
		this.riskValue = riskValue;
	}

	public Region() {}

	public Region(Kontinenti region, Double riskValue) {
		super();
		this.region = region;
		this.riskValue = riskValue;
	}
	 
	
	
	
	 
	 
	 

}
