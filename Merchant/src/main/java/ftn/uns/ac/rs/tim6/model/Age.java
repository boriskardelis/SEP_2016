package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "age")
public class Age implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public enum AgeEnum {
		UNDER_18("Under 18"),
		BETWEEN_18_AND_60("Between 18 and 60"),
		OVER_60("Over 60");
		
		private String name;
		
		private AgeEnum(String value) {
			this.name = value;
		}
		
		@Override
		public String toString() {
			return name;
		}
	}

	 @Id
	 @GeneratedValue
	 @Column(name = "age")
	 private AgeEnum age;
	 
	 @Column(name = "risk_value")
	 private Double riskValue;

	 

	public AgeEnum getAge() {
		return age;
	}

	public void setAge(AgeEnum age) {
		this.age = age;
	}

	public Double getRiskValue() {
		return riskValue;
	}

	public void setRiskValue(Double riskValue) {
		this.riskValue = riskValue;
	}

	public Age() {}

	public Age(AgeEnum age, Double riskValue) {
		super();
		this.age = age;
		this.riskValue = riskValue;
	}
	
	

	
	
	 
	 
	 
	 
	 
}
