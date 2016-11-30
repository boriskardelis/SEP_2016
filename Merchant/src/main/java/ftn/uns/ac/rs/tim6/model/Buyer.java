package ftn.uns.ac.rs.tim6.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "buyer")
public class Buyer {

	@Id
	@GeneratedValue
	@Column(name = "buyer_id")
	private Long id;
	
	@Column(name = "buyer_last_name")
	private String buyerLastName;
	
	@Column(name = "buyer_jmbg")
	private int buyerJMBG;
	
	@Column(name = "buyer_passport_number")
	private int buyerPassportNumber;
	
	@Column(name = "buyer_email")
	private String buyerEmail;
	
	@Column(name = "buyer_First_name")
	private String buyerFirstName;
	
	@Column(name = "buyer_address")
	private String buyerAddress;
	
	@Column(name = "buyer_phone_number")
	private int buyerPhoneNumber;
	
	

	public Buyer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Buyer(Long id, String buyerLastName, int buyerJMBG, int buyerPassportNumber, String buyerEmail,
			String buyerFirstName, String buyerAddress, int buyerPhoneNumber) {
		super();
		this.id = id;
		this.buyerLastName = buyerLastName;
		this.buyerJMBG = buyerJMBG;
		this.buyerPassportNumber = buyerPassportNumber;
		this.buyerEmail = buyerEmail;
		this.buyerFirstName = buyerFirstName;
		this.buyerAddress = buyerAddress;
		this.buyerPhoneNumber = buyerPhoneNumber;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBuyerLastName() {
		return buyerLastName;
	}

	public void setBuyerLastName(String buyerLastName) {
		this.buyerLastName = buyerLastName;
	}

	public int getBuyerJMBG() {
		return buyerJMBG;
	}

	public void setBuyerJMBG(int buyerJMBG) {
		this.buyerJMBG = buyerJMBG;
	}

	public int getBuyerPassportNumber() {
		return buyerPassportNumber;
	}

	public void setBuyerPassportNumber(int buyerPassportNumber) {
		this.buyerPassportNumber = buyerPassportNumber;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	public String getBuyerFirstName() {
		return buyerFirstName;
	}

	public void setBuyerFirstName(String buyerFirstName) {
		this.buyerFirstName = buyerFirstName;
	}

	public String getBuyerAddress() {
		return buyerAddress;
	}

	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}

	public int getBuyerPhoneNumber() {
		return buyerPhoneNumber;
	}

	public void setBuyerPhoneNumber(int buyerPhoneNumber) {
		this.buyerPhoneNumber = buyerPhoneNumber;
	}
	
	
	
}
