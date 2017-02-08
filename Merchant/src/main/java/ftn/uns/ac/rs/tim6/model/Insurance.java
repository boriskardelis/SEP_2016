package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "INSURANCE")
public class Insurance implements Serializable {

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
	private BigDecimal totalPrice;

	@Column(name = "DISCOUNT_PRICE")
	private BigDecimal discountPrice;

	@Column(name = "TAX_PRICE")
	private BigDecimal taxPrice;

	@Column(name = "PREMIUM_PRICE")
	private BigDecimal premiumPrice;

	@Column(name = "PAYMENT_ID")
	private Integer paymentId;

	@Column(name = "INS_LANGUAGE")
	private String language;

	@OneToMany(mappedBy = "insurance", cascade = CascadeType.ALL)
	private List<InsuranceType> insuranceTypes;

	@OneToMany(mappedBy = "insurance", cascade = CascadeType.ALL)
	private List<Person> persons;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PRICELIST")
	private Pricelist pricelist;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BUYER")
	private Buyer buyer;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "HOME_ID")
	private Home home;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "VEHICLE_ID")
	private Vehicle vehicle;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "SHOPPING_CART", joinColumns = @JoinColumn(name = "INSURANCE_ID"), inverseJoinColumns = @JoinColumn(name = "RISK_SUBCATEGORY_ID"))
	private List<RiskSubcategory> riskSubategories;

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

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
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

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Pricelist getPricelist() {
		return pricelist;
	}

	public void setPricelist(Pricelist pricelist) {
		this.pricelist = pricelist;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}

	public BigDecimal getTaxPrice() {
		return taxPrice;
	}

	public void setTaxPrice(BigDecimal taxPrice) {
		this.taxPrice = taxPrice;
	}

	public BigDecimal getPremiumPrice() {
		return premiumPrice;
	}

	public void setPremiumPrice(BigDecimal premiumPrice) {
		this.premiumPrice = premiumPrice;
	}

	public List<RiskSubcategory> getRiskSubategories() {
		return riskSubategories;
	}

	public void setRiskSubategories(List<RiskSubcategory> riskSubategories) {
		this.riskSubategories = riskSubategories;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Insurance(long id, int numberOfPersons, Date startDate, Date endDate, BigDecimal totalPrice,
			BigDecimal discountPrice, BigDecimal taxPrice, BigDecimal premiumPrice, Integer paymentId,
			List<InsuranceType> insuranceTypes, List<Person> persons, Pricelist pricelist, Buyer buyer, Home home,
			Vehicle vehicle, List<RiskSubcategory> riskSubategories) {
		super();
		this.id = id;
		this.numberOfPersons = numberOfPersons;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPrice = totalPrice;
		this.discountPrice = discountPrice;
		this.taxPrice = taxPrice;
		this.premiumPrice = premiumPrice;
		this.paymentId = paymentId;
		this.insuranceTypes = insuranceTypes;
		this.persons = persons;
		this.pricelist = pricelist;
		this.buyer = buyer;
		this.home = home;
		this.vehicle = vehicle;
		this.riskSubategories = riskSubategories;
	}

	public Insurance() {
		super();
	}

}