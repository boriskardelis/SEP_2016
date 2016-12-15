package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BUYER")
public class Buyer implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "BUYER_ID")
	private Long id;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "JMBG")
	private int JMBG;
	
	@Column(name = "PASSPORT_NUMBER")
	private int passportNumber;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "PHONE_NUMBER")
	private int phoneNumber;
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public int getJMBG() {
		return JMBG;
	}



	public void setJMBG(int jMBG) {
		JMBG = jMBG;
	}



	public int getPassportNumber() {
		return passportNumber;
	}



	public void setPassportNumber(int passportNumber) {
		this.passportNumber = passportNumber;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public int getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

    

	public Buyer(Long id, String lastName, int jMBG, int passportNumber, String email, String firstName, String address,
			int phoneNumber) {
		super();
		this.id = id;
		this.lastName = lastName;
		JMBG = jMBG;
		this.passportNumber = passportNumber;
		this.email = email;
		this.firstName = firstName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	//test
	public Buyer(int phoneNumber){
		this.phoneNumber = phoneNumber;
	}



	public Buyer() {
		super();
	}
	
	

	
	
	
	
}
