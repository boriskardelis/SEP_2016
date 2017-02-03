package ftn.uns.ac.rs.tim6.dto;

import java.math.BigDecimal;
import java.util.ArrayList;

import ftn.uns.ac.rs.tim6.model.Buyer;
import ftn.uns.ac.rs.tim6.model.Home;
import ftn.uns.ac.rs.tim6.model.Person;
import ftn.uns.ac.rs.tim6.model.Vehicle;

public class InsuranceInfoDto {

	private Vehicle vehicle;
	private ArrayList<Person> persons = new ArrayList<Person>();
	private Person personHolder;
	private Buyer buyer;
	private Home home;
	private InsuranceDto itemsForDrools;
	private BigDecimal premiumPrice;
	private BigDecimal taxPrice;
	private BigDecimal discountPrice;
	private BigDecimal totalPrice;
	private boolean contractor;
//	private ArrayList<InsuranceType> insuranceTypes = new ArrayList<InsuranceType>();

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public ArrayList<Person> getPersons() {
		return persons;
	}

	public void setPersons(ArrayList<Person> persons) {
		this.persons = persons;
	}

	public Person getPersonHolder() {
		return personHolder;
	}

	public void setPersonHolder(Person personHolder) {
		this.personHolder = personHolder;
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

	public InsuranceDto getItemsForDrools() {
		return itemsForDrools;
	}

	public void setItemsForDrools(InsuranceDto itemsForDrools) {
		this.itemsForDrools = itemsForDrools;
	}

	public BigDecimal getPremiumPrice() {
		return premiumPrice;
	}

	public void setPremiumPrice(BigDecimal premiumPrice) {
		this.premiumPrice = premiumPrice;
	}

	public BigDecimal getTaxPrice() {
		return taxPrice;
	}

	public void setTaxPrice(BigDecimal taxPrice) {
		this.taxPrice = taxPrice;
	}

	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isContractor() {
		return contractor;
	}

	public void setContractor(boolean contractor) {
		this.contractor = contractor;
	}

}
