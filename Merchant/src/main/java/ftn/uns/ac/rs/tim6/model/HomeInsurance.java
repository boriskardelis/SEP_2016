package ftn.uns.ac.rs.tim6.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "home_insurance")
public class HomeInsurance {

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
	 
}
