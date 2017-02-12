package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "VEHICLE")
public class Vehicle implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "VEHICLE_ID")
	private long id;

	@Size(min = 17, max = 17)
	@Column(name = "VIN_NUMBER")
	private String vinNumber;

	@Size(min = 1, max = 30)
	@Column(name = "MAKE")
	private String make;

	@Size(min = 1, max = 30)
	@Column(name = "TYPE")
	private String type;

/*	@Min(value = 1900)
	@Max(value = 2017)*/
	@Column(name = "YEAR_OF_PRODUCTION")
	private int yearOfProduction;

	@Size(min = 5, max = 10)
	@Column(name = "REGISTRATION_NUMBER")
	private String registrationNumber;

	@Size(min = 1, max = 30)
	@Column(name = "OWNER_FIRST_NAME")
	private String ownerFirstName;

	@Size(min = 1, max = 30)
	@Column(name = "OWNER_LAST_NAME")
	private String ownerLastName;

	// @Max(value = 13)
	@Column(name = "OWNER_JMBG", length = 13)
	private long ownerJmbg;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVinNumber() {
		return vinNumber;
	}

	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getYearOfProduction() {
		return yearOfProduction;
	}

	public void setYearOfProduction(int yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getOwnerFirstName() {
		return ownerFirstName;
	}

	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}

	public String getOwnerLastName() {
		return ownerLastName;
	}

	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}

	public long getOwnerJmbg() {
		return ownerJmbg;
	}

	public void setOwnerJmbg(long ownerJmbg) {
		this.ownerJmbg = ownerJmbg;
	}

	public Vehicle(long id, String vinNumber, String make, String type, int yearOfProduction, String registrationNumber,
			String ownerFirstName, String ownerLastName, long ownerJmbg) {
		super();
		this.id = id;
		this.vinNumber = vinNumber;
		this.make = make;
		this.type = type;
		this.yearOfProduction = yearOfProduction;
		this.registrationNumber = registrationNumber;
		this.ownerFirstName = ownerFirstName;
		this.ownerLastName = ownerLastName;
		this.ownerJmbg = ownerJmbg;
	}

	public Vehicle() {
		super();
	}

}
