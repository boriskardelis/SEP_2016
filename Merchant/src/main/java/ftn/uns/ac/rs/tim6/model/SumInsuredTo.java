package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "sum_insured_to")
public class SumInsuredTo implements Serializable {
	
	 private static final long serialVersionUID = 1L;
	
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

	public SumInsuredTo() {}

	public SumInsuredTo(Long id, Double riskValue) {
		super();
		this.id = id;
		RiskValue = riskValue;
	}
	
	
	
	
	
	
	 

}
