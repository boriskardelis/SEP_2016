package ftn.uns.ac.rs.tim6.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INSURANCE_TYPE")
public class InsuranceType implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue
	 @Column(name = "INSURANCE_TYPE_ID")
	 private long id;
	 
	 @Column(name = "INSURANCE_NAME")
	 private String insuranceName;
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "INSURANCE")
	 private Insurance insurance;
	 
	 @ManyToMany(cascade = CascadeType.ALL)
	 @JoinTable(name = "INSURANCE_TYPE_RISK",
	 			joinColumns=@JoinColumn(name="INSURANCE_TYPE_ID"),
	 			inverseJoinColumns=@JoinColumn(name="RISK_CATEGORY_ID"))
	 private List<RiskCategory> riskCategories;
	 


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public List<RiskCategory> getRiskCategories() {
		return riskCategories;
	}

	public void setRiskCategories(List<RiskCategory> riskCategories) {
		this.riskCategories = riskCategories;
	}

    	

	public InsuranceType(long id, String insuranceName, Insurance insurance, List<RiskCategory> riskCategories) {
		super();
		this.id = id;
		this.insuranceName = insuranceName;
		this.insurance = insurance;
		this.riskCategories = riskCategories;
	}

	public InsuranceType() {
		super();
	}
	  
	
	 
	 
}
