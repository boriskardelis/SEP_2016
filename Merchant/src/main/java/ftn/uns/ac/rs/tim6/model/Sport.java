package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "sport")
public class Sport implements Serializable {
	
	 private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue
	 @Column(name = "sport_id")
	 private Long id;
	
	 @Column(name = "sport_risk_value")
	 private Double RiskValue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getRiskValue() {
		return RiskValue;
	}

	public void setRiskValue(Double riskValue) {
		RiskValue = riskValue;
	}

	public Sport() {}

	public Sport(Long id, Double riskValue) {
		super();
		this.id = id;
		RiskValue = riskValue;
	}
	
	
	 
	
	
	
}
