package ftn.uns.ac.rs.tim6.model;

import javax.persistence.*;

public class Home {

	 @Id
	 @GeneratedValue
	 @Column(name = "home_id")
	 private Long  id;
	 
	 @Column(name = "address")
	 private String  address;
	 
	 @Column(name = "owner_first_name")
	 private String  ownerFirstName;
	 
	 @Column(name = "owner_last_name")
	 private String  ownerLastName;
	 
	 @Column(name = "ownerJMBG")
	 private Long ownerJMBG;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Long getOwnerJMBG() {
		return ownerJMBG;
	}

	public void setOwnerJMBG(Long ownerJMBG) {
		this.ownerJMBG = ownerJMBG;
	}
	 
	 
	 
	 
	 
	 
}
