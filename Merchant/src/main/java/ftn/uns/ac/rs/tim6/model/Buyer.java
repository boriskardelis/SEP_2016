package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "BUYER")
public class Buyer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "BUYER_ID")
	private Long id;

	@Size(min = 1, max = 30)
	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "JMBG", length = 13)
	private Long jmbg;

	@Size(min = 9, max = 9)
	@Column(name = "PASSPORT_NUMBER")
	private String passportNumber;

	@Size(min = 1, max = 30)
	@Column(name = "EMAIL")
	private String email;

	@Size(min = 1, max = 70)
	@Column(name = "FIRST_NAME")
	private String firstName;

	@Size(min = 1, max = 30)
	@Column(name = "ADDRESS")
	private String address;

	@Size(min = 1, max = 30)
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@Column(name = "INSURED")
	private boolean insured;

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isInsured() {
		return insured;
	}

	public void setInsured(boolean insured) {
		this.insured = insured;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Buyer(Long id, String lastName, Long jmbg, String passportNumber, String email, String firstName,
			String address, String phoneNumber, boolean insured) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.jmbg = jmbg;
		this.passportNumber = passportNumber;
		this.email = email;
		this.firstName = firstName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.insured = insured;
	}

	public Buyer() {
		super();
	}

}
