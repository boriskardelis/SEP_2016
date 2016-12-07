package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")
public class Person implements Serializable {
	
	
	 private static final long serialVersionUID = 1L;	
	 
	 @Id
	 @GeneratedValue
	 @Column(name = "PERSON_ID")
	 private long id;
	 
	 @Column(name = "FIRST_NAME")
	 private String firstName;
	 
	 @Column(name = "LAST_NAME")
	 private String lastName;
	 
	 @Column(name = "JMBG")
	 private Long jmbg;
	 
	 @Column(name = "PASSPORT_NUMBER")
	 private String passportNumber;
	 
	 @Column(name = "ADRESS")
	 private String adress;
	 
	 @Column(name = "PHONE_NUMBER")
	 private String phoneNumber;
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "INSURANCE")
	 private Insurance insurance;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public Long getJmbg() {
		return jmbg;
	}

	public void setJmbg(Long jmbg) {
		this.jmbg = jmbg;
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

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public Person(long id, String firstName, String lastName, Long jmbg, String passportNumber, String adress,
			String phoneNumber, Insurance insurance) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.jmbg = jmbg;
		this.passportNumber = passportNumber;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.insurance = insurance;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
	 
}
