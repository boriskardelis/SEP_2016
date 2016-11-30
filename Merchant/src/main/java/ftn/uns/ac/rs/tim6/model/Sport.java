package ftn.uns.ac.rs.tim6.model;

import javax.persistence.*;

@Entity
@Table(name = "sport")
public class Sport {
	
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
	 
	@OneToMany(fetch = FetchType.LAZY)
	 @JoinColumn(name = "person")
	 private Person person;
	
	
}
