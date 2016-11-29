package ftn.uns.ac.rs.tim6.model;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "home_insurance")
public class Age {

	 @Id
	 @GeneratedValue
	 @Column(name = "home_insurance_id")
	 private Long id;
	 
	 @Column(name = "home_risk_value")
	 private Double homeRiskValue;

	 
/*	 @OneToMany(fetch = FetchType.LAZY)
	 @JoinColumn(name = "person")
	 private Person person;  */
}
