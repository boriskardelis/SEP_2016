package ftn.uns.ac.rs.tim6.model;

import javax.persistence.*;

@Entity
@Table(name = "home_risk_type")
public class HomeRiskType {
	
	 @Id
	 @GeneratedValue
	 @Column(name = "home_risk_type")
	 private String  homeRiskType;
	 
	 @Column(name = "risk_value")
	 private Double riskValue;

	public String getHomeRiskType() {
		return homeRiskType;
	}

	public void setHomeRiskType(String homeRiskType) {
		this.homeRiskType = homeRiskType;
	}

	public Double getRiskValue() {
		return riskValue;
	}

	public void setRiskValue(Double riskValue) {
		this.riskValue = riskValue;
	}
	 
	 

}
