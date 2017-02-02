package ftn.uns.ac.rs.tim6.model;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "VEHICLE")
public class Vehicle implements Serializable {
	
	private static final long serialVersionUID = 1L;

	 @Id
	 @GeneratedValue
	 @Column(name = "VEHICLE_ID")
	 private long id;
	
	@Column(name = "VIN_NUMBER")
	private String vinNumber;
	
	@Column(name = "MAKE")
	private String make;
	
	@Column(name = "TYPE")
	private String type;
	
	
	@Column(name = "YEAR_OF_PRODUCTION")
	private int yearOfProduction;
	
	@Column(name = "REGISTRATION_NUMBER")
	private String registrationNumber;
	
	@Column(name = "OWNER_FIRST_NAME")
	private String ownerFirstName;
	
	@Column(name = "OWNER_LAST_NAME")
	private String ownerLastName;
	
	@Column(name = "OWNER_JMBG")
	private String ownerJmbg;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="INSURANCE_TYPE_ID")
	private InsuranceType insuranceType;


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
		registrationNumber = registrationNumber;
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

	public String getOwnerJmbg() {
		return ownerJmbg;
	}

	public void setOwnerJmbg(String ownerJmbg) {
		this.ownerJmbg = ownerJmbg;
	}

	

	public InsuranceType getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(InsuranceType insuranceType) {
		this.insuranceType = insuranceType;
	}
	
	

	public Vehicle(long id, String vinNumber, String make, String type, int yearOfProduction, String registrationNumber,
			String ownerFirstName, String ownerLastName, String ownerJmbg, InsuranceType insuranceType) {
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
		this.insuranceType = insuranceType;
	}

	public Vehicle() {
		super();
	}
	
	
	

	
	
	
}
