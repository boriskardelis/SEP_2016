package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "home")
public class Home implements Serializable {

	private static final long serialVersionUID = 1L;
	
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

	public Home() {}

	public Home(Long id, String address, String ownerFirstName, String ownerLastName, Long ownerJMBG) {
		super();
		this.id = id;
		this.address = address;
		this.ownerFirstName = ownerFirstName;
		this.ownerLastName = ownerLastName;
		this.ownerJMBG = ownerJMBG;
	}
	
	
	 
	 
	 
	 
	 
	 
}
