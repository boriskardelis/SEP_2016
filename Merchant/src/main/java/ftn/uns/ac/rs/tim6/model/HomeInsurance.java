package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "home_insurance")
public class HomeInsurance implements Serializable{
	
	private static final long serialVersionUID = 1L;

	 @Id
	 @GeneratedValue
	 @Column(name = "home_insurance_id")
	 private Long id;
	 
	 @Column(name = "risk_value")
	 private Double riskValue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getRiskValue() {
		return riskValue;
	}

	public void setRiskValue(Double riskValue) {
		this.riskValue = riskValue;
	}

	public HomeInsurance() {}

	public HomeInsurance(Long id, Double riskValue) {
		super();
		this.id = id;
		this.riskValue = riskValue;
	}
	
	
	 
	
}
