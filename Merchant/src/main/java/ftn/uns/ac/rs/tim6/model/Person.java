package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person implements Serializable {
	
	
	 private static final long serialVersionUID = 1L;	
	 
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
	 
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "age")
	 private Age age;
	 
     
	 
	 
	 

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

	public Age getAge() {
		return age;
	}

	public void setAge(Age age) {
		this.age = age;
	}

	public Person() {}

	public Person(String firstName, String lastName, Long personJMBG, String passportNumber, String adress,
			String phoneNumber, Age age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.personJMBG = personJMBG;
		this.passportNumber = passportNumber;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.age = age;
	}
	
	

	
	
	
	
	 
}
