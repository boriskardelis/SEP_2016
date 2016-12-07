package ftn.uns.ac.rs.tim6.model;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "VEHICLE")
public class Vehicle implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "VEHICLE_ID")	// dodato nema u modelu
	private Long vehicleID;
	
	@Column(name = "VIN_NUMBER")
	private String vinNumber;
	
	@Column(name = "MAKE")
	private String make;
	
	@Column(name = "TYPE")
	private String type;
	
	
	@Column(name = "YEAR_OF_PRODUCTION")
	private int yearOfProduction;
	
	@Column(name = "REGISTRATION_NUMBER")
	private String RegistrationNumber;
	
	@Column(name = "OWENER_FIRST_NAME")
	private String ownerFirstName;
	
	@Column(name = "OWNER_LAST_NAME")
	private String ownerLastName;
	
	@Column(name = "OWNER_JMBG")
	private String ownerJmbg;

	

	
	
	
}
