package ftn.uns.ac.rs.tim6.model;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Vehicle implements Serializable {
	
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

	

	
	
	
}
