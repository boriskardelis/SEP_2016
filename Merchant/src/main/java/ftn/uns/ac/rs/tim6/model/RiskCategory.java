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
	@Column(name = "RISK_CATEGORY_ID")
	private long id;

	@Column(name = "NAME")
	private String name;

	@ManyToMany(mappedBy = "riskCategories")
	private List<InsuranceType> insuranceTypes;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<InsuranceType> getInsuranceTypes() {
		return insuranceTypes;
	}

	public void setInsuranceTypes(List<InsuranceType> insuranceTypes) {
		this.insuranceTypes = insuranceTypes;
	}

	public RiskCategory(long id, String name, List<InsuranceType> insuranceTypes) {
		super();
		this.id = id;
		this.name = name;
		this.insuranceTypes = insuranceTypes;
	}

	public RiskCategory() {
		super();
	}

}