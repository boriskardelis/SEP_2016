package ftn.uns.ac.rs.tim6.model;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "car_id")	// dodato nema u modelu
	private Long id;
	
	@Column(name = "car_vin_number")
	private String carVinNumber;
	
	@Column(name = "car_year_of_production")
	private int carYearOfProduction;
	
	@Column(name = "car_registration_number")
	private String carRegistrationNumber;
	
	@Column(name = "car_owner_firs_name")
	private String carOwnerFirstName;
	
	@Column(name = "car_owner_last_name")
	private String carOwnerLastName;
	
	@Column(name = "car_owner_jmbg")
	private String carOwnerJmbg;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCarVinNumber() {
		return carVinNumber;
	}

	public void setCarVinNumber(String carVinNumber) {
		this.carVinNumber = carVinNumber;
	}

	public int getCarYearOfProduction() {
		return carYearOfProduction;
	}

	public void setCarYearOfProduction(int carYearOfProduction) {
		this.carYearOfProduction = carYearOfProduction;
	}

	public String getCarRegistrationNumber() {
		return carRegistrationNumber;
	}

	public void setCarRegistrationNumber(String carRegistrationNumber) {
		this.carRegistrationNumber = carRegistrationNumber;
	}

	public String getCarOwnerFirstName() {
		return carOwnerFirstName;
	}

	public void setCarOwnerFirstName(String carOwnerFirstName) {
		this.carOwnerFirstName = carOwnerFirstName;
	}

	public String getCarOwnerLastName() {
		return carOwnerLastName;
	}

	public void setCarOwnerLastName(String carOwnerLastName) {
		this.carOwnerLastName = carOwnerLastName;
	}

	public String getCarOwnerJmbg() {
		return carOwnerJmbg;
	}

	public void setCarOwnerJmbg(String carOwnerJmbg) {
		this.carOwnerJmbg = carOwnerJmbg;
	}

	public Car() {}

	public Car(Long id, String carVinNumber, int carYearOfProduction, String carRegistrationNumber,
			String carOwnerFirstName, String carOwnerLastName, String carOwnerJmbg) {
		super();
		this.id = id;
		this.carVinNumber = carVinNumber;
		this.carYearOfProduction = carYearOfProduction;
		this.carRegistrationNumber = carRegistrationNumber;
		this.carOwnerFirstName = carOwnerFirstName;
		this.carOwnerLastName = carOwnerLastName;
		this.carOwnerJmbg = carOwnerJmbg;
	}

	
	
	
}
