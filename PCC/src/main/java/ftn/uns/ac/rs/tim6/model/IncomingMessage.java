package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INCOMING_MESSAGE")
public class IncomingMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "INCOMING_MESSAGE_ID")
	private Long id;
	
	@Column(name = "ACQUIRER_ORDER_ID")
	private Long acquirerOrderId;
	
	@Column(name = "ACQUIRER_TIMESTAMP")
	private Timestamp acquirerTimestamp;
	
	@Column(name = "PAN")
	private String pan;
	
	@Column(name = "SECURITY_CODE")
	private String securityCode;
	
	@Column(name = "CARD_HOLDER_NAME")
	private String cardHolderName;
	
	@Column(name = "MONTH")
	private int month;
	
	@Column(name = "YEAR")
	private int year;
	
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BANK")
	private Bank bank;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAcquirerOrderId() {
		return acquirerOrderId;
	}

	public void setAcquirerOrderId(Long acquirerOrderId) {
		this.acquirerOrderId = acquirerOrderId;
	}

	public Timestamp getAcquirerTimestamp() {
		return acquirerTimestamp;
	}

	public void setAcquirerTimestamp(Timestamp acquirerTimestamp) {
		this.acquirerTimestamp = acquirerTimestamp;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	

	public IncomingMessage(Long id, Long acquirerOrderId, Timestamp acquirerTimestamp, String pan, String securityCode,
			String cardHolderName, int month, int year, BigDecimal amount, Bank bank) {
		super();
		this.id = id;
		this.acquirerOrderId = acquirerOrderId;
		this.acquirerTimestamp = acquirerTimestamp;
		this.pan = pan;
		this.securityCode = securityCode;
		this.cardHolderName = cardHolderName;
		this.month = month;
		this.year = year;
		this.amount = amount;
		this.bank = bank;
	}

	public IncomingMessage() {
		super();
	}
	
	
}
