package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "RISK_CATEGORY")
public class RiskCategory implements Serializable {
	
	 private static final long serialVersionUID = 1L;	
	 
	 @Id
	 @GeneratedValue
	 @Column(name = "ID")
	 private Long id;
	 
	 @Column(name = "NAME")
	 private String name;
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "DATE_CATEGORY")
	 private DateCategory dateCategory;
	 
	 @ManyToMany(fetch = FetchType.EAGER, mappedBy = "riskCategories")
	 private List<Insurance> insurances;
	 
	 /*@ManyToMany(fetch = FetchType.EAGER, mappedBy = "insurenceTypes")
	 private List<InsuranceType> insuranceTypes;*/

}
