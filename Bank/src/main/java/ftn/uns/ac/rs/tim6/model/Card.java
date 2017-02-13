package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CARD")
public class Card implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "CARD_ID")
	private Integer id;
	
	@Size(min = 1, max = 31)
	@Column(name = "MONTH")
	private Long month;
	
	@Column(name = "YEAR", length = 4)
	private Long year;
	
	@Size(min = 1, max = 30)
	@Column(name = "CARD_HOLDER_NAME")
	private String cardHolderName;
	
	@Size(min = 10, max = 16)
	@Column(name = "PAN")
	private Long pan;
	
	@Size(min = 3, max = 4)
	@Column(name = "SECURITY_CODE")
	private Long securityCode;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ACCOUNT", nullable = true)
	private Account account;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getMonth() {
		return month;
	}

	public void setMonth(Long month) {
		this.month = month;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public Long getPan() {
		return pan;
	}

	public void setPan(Long pan) {
		this.pan = pan;
	}

	public Long getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(Long securityCode) {
		this.securityCode = securityCode;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Card(Integer id, Long month, Long year, String cardHolderName, Long pan, Long securityCode, Account account) {
		super();
		this.id = id;
		this.month = month;
		this.year = year;
		this.cardHolderName = cardHolderName;
		this.pan = pan;
		this.securityCode = securityCode;
		this.account = account;
	}

	public Card() {
		super();
	}

}
