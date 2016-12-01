package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "home_risk_type")
public class HomeRiskType implements Serializable {
	
	 private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue
	 @Column(name = "home_risk_type_id")
	 private Long  homeRiskTypeId;
	 
	 
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

	public Long getHomeRiskTypeId() {
		return homeRiskTypeId;
	}

	public void setHomeRiskTypeId(Long homeRiskTypeId) {
		this.homeRiskTypeId = homeRiskTypeId;
	}

	public HomeRiskType() {
	}

	public HomeRiskType(Long homeRiskTypeId, String homeRiskType, Double riskValue) {
		super();
		this.homeRiskTypeId = homeRiskTypeId;
		this.homeRiskType = homeRiskType;
		this.riskValue = riskValue;
	}
	
	
	
	 
	 

}
