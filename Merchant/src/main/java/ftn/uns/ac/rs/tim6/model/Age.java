package ftn.uns.ac.rs.tim6.model;

import javax.persistence.*;


@Entity
@Table(name = "age")
public class Age {

	

	@Id
	 @GeneratedValue
	 @Column(name = "age_id")
	 private Long id;
	 
	 @Column(name = "age_risk_value")
	 private Double ageRiskValue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAgeRiskValue() {
		return ageRiskValue;
	}

	public void setAgeRiskValue(Double ageRiskValue) {
		this.ageRiskValue = ageRiskValue;
	}

	

	 
/*	 @OneToMany(fetch = FetchType.LAZY)
	 @JoinColumn(name = "person")
	 private Person person;  */
}
