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
	 
	 @Column(name = "home_risk_value")
	 private Double homeRiskValue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getHomeRiskValue() {
		return homeRiskValue;
	}

	public void setHomeRiskValue(Double homeRiskValue) {
		this.homeRiskValue = homeRiskValue;
	}
	 
}
