package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "HOME")
public class Home implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "HOME_ID")
	private long id;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "OWNER_FIRST_NAME")
	private String ownerFirstName;

	@Column(name = "OWNER_LAST_NAME")
	private String ownerLastName;

	@Column(name = "OWNER_JMBG")
	private Long ownerJMBG;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Home(long id, String address, String ownerFirstName, String ownerLastName, Long ownerJMBG) {
		super();
		this.id = id;
		this.address = address;
		this.ownerFirstName = ownerFirstName;
		this.ownerLastName = ownerLastName;
		this.ownerJMBG = ownerJMBG;
	}

	public Home() {
		super();
	}

}
