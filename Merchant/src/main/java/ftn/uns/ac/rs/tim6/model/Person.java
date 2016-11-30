package ftn.uns.ac.rs.tim6.model;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {
	
	 
	 @Column(name = "first_name")
	 private String firstName;
	 
	 @Column(name = "last_name")
	 private String lastName;
	 
	 @Id
	 @GeneratedValue
	 @Column(name = "person_JMBG")
	 private Long personJMBG;
	 
	 @Column(name = "passport_number")
	 private String passportNumber;
	 
	 @Column(name = "adress")
	 private String adress;
	 
	 @Column(name = "phone_number")
	 private String phoneNumber;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getPersonJMBG() {
		return personJMBG;
	}

	public void setPersonJMBG(Long personJMBG) {
		this.personJMBG = personJMBG;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	 
	 
	 
	
	 
	 
	 
	 
}
