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

@Entity
@Table(name = "CARD")
public class Card implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "CARD_ID")
	private Long id;
	
	@Column(name = "CARD_HOLDER")
	private String cardHolder;
	
	@Column(name = "PAN")
	private Long pan;
	
	@Column(name = "SECURITY_CODE")
	private Long securityCode;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn( name = "ACCOUNT", nullable = true)
	private Account account;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
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

	public Card(Long id, String cardHolder, Long pan, Long securityCode, Account account) {
		super();
		this.id = id;
		this.cardHolder = cardHolder;
		this.pan = pan;
		this.securityCode = securityCode;
		this.account = account;
	}

	public Card() {
		super();
	}
	
	

}
