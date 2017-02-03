package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BUYER")
public class Buyer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "BUYER_ID")
	private Long id;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "JMBG")
	private Long jmbg;

	@Column(name = "PASSPORT_NUMBER")
	private Long passportNumber;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

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

	public Long getJMBG() {
		return jmbg;
	}

	public void setJMBG(Long jMBG) {
		this.jmbg = jMBG;
	}

	public Long getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(Long passportNumber) {
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

	public Buyer(Long id, String lastName, Long jMBG, Long passportNumber, String email, String firstName,
			String address, String phoneNumber) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.jmbg = jMBG;
		this.passportNumber = passportNumber;
		this.email = email;
		this.firstName = firstName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public Buyer() {
		super();
	}

}
