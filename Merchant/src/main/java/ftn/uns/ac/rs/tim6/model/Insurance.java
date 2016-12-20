package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "INSURANCE")
public class Insurance implements Serializable{
	
	private static final long serialVersionUID = 1L;
	 
	 @Id
	 @GeneratedValue
	 @Column(name = "INSURANCE_ID")
	 private long id;
	 
	 @Column(name = "NUMBER_OF_PERSONS")
	 private int numberOfPersons;
	 
	 @Column(name = "START_DATE")
	 private Date startDate;
	 
	 @Column(name = "END_DATE")
	 private Date endDate;
	 
	 @Column(name = "TOTAL_PRICE")
	 private double totalPrice;
	 
	/* @ManyToMany(cascade = CascadeType.ALL)
	 @JoinTable(name = "INSURANCE_RISK",
	 			joinColumns=@JoinColumn(name="INSURANCE_ID"),
	 			inverseJoinColumns=@JoinColumn(name="RISK_CATEGORY_ID"))
	 private List<RiskCategory> riskCategories;*/
	 
	 @OneToMany(mappedBy = "insurance", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 private List<InsuranceType> insuranceTypes;
	 
	 @OneToMany(mappedBy = "insurance", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 private List<Pricelist> pricelists;
	 
	 @OneToMany(mappedBy = "insurance", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 private List<Person> persons;
	 
	 @OneToOne(fetch=FetchType.EAGER)
	  @JoinColumn(name="BUYER")
	  private Buyer buyer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumberOfPersons() {
		return numberOfPersons;
	}

	public void setNumberOfPersons(int numberOfPersons) {
		this.numberOfPersons = numberOfPersons;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	

	/*public List<RiskCategory> getRiskCategories() {
		return riskCategories;
	}

	public void setRiskCategories(List<RiskCategory> riskCategories) {
		this.riskCategories = riskCategories;
	}*/
	

	public List<Pricelist> getPricelists() {
		return pricelists;
	}

	public void setPricelists(List<Pricelist> pricelists) {
		this.pricelists = pricelists;
	}

	public List<InsuranceType> getInsuranceTypes() {
		return insuranceTypes;
	}

	public void setInsuranceTypes(List<InsuranceType> insuranceTypes) {
		this.insuranceTypes = insuranceTypes;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	

	

	public Insurance(long id, int numberOfPersons, Date startDate, Date endDate, double totalPrice,
			List<InsuranceType> insuranceTypes, List<Pricelist> pricelists, List<Person> persons, Buyer buyer) {
		super();
		this.id = id;
		this.numberOfPersons = numberOfPersons;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPrice = totalPrice;
		this.insuranceTypes = insuranceTypes;
		this.pricelists = pricelists;
		this.persons = persons;
		this.buyer = buyer;
	}

	public Insurance() {
		super();
	}
	 

	

}
