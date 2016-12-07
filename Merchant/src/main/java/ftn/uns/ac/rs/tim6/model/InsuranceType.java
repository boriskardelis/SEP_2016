package ftn.uns.ac.rs.tim6.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "INSURANCE_TYPE")
public class InsuranceType implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue
	 @Column(name = "ID")
	 private Long id;
	 
	 @Column(name = "INSURANCE_NAME")
	 private String insuranceName;
	 
	/* @ManyToMany(fetch = FetchType.EAGER)
	 @JoinTable(name = "RISK_CATEGORY")
	 private List<RiskCategory> riskCategories;*/
	 
	 
}
