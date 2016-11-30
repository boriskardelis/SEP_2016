package ftn.uns.ac.rs.tim6.model;

import javax.persistence.*;

@Entity
@Table(name = "sum_insured_to")
public class SumInsuredTo {
	
	 @Id
	 @GeneratedValue
	 @Column(name = "sum_insured_to_id")
	 private Long id;
	
	 @Column(name = "risk_value")
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
		this.RiskValue = riskValue;
	}
	
	@OneToMany(fetch = FetchType.LAZY)
	 @JoinColumn(name = "person")
	 private Person person;
	 
	 

}
