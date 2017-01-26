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
	private Integer acquirerOrderId;
	
	@Column(name = "ACQUIRER_TIMESTAMP")
	private Timestamp acquirerTimestamp;
	
	@Column(name = "PAN")
	private Long pan;
	
	@Column(name = "SECURITY_CODE")
	private Long securityCode;
	
	@Column(name = "CARD_HOLDER_NAME")
	private String cardHolderName;
	
	@Column(name = "EXP_DATE_YEAR")
	private Long expDateYear;
	
	@Column(name = "EXP_DATE_MONTH")
	private Long expDateMonth;
	
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

	public Integer getAcquirerOrderId() {
		return acquirerOrderId;
	}

	public void setAcquirerOrderId(Integer acquirerOrderId) {
		this.acquirerOrderId = acquirerOrderId;
	}

	public Timestamp getAcquirerTimestamp() {
		return acquirerTimestamp;
	}

	public void setAcquirerTimestamp(Timestamp acquirerTimestamp) {
		this.acquirerTimestamp = acquirerTimestamp;
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

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public Long getExpDateYear() {
		return expDateYear;
	}

	public void setExpDateYear(Long expDateYear) {
		this.expDateYear = expDateYear;
	}

	public Long getExpDateMonth() {
		return expDateMonth;
	}

	public void setExpDateMonth(Long expDateMonth) {
		this.expDateMonth = expDateMonth;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public IncomingMessage() {
		super();
	}

	public IncomingMessage(Long id, Integer acquirerOrderId, Timestamp acquirerTimestamp, Long pan, Long securityCode,
			String cardHolderName, Long expDateYear, Long expDateMonth, BigDecimal amount, Bank bank) {
		super();
		this.id = id;
		this.acquirerOrderId = acquirerOrderId;
		this.acquirerTimestamp = acquirerTimestamp;
		this.pan = pan;
		this.securityCode = securityCode;
		this.cardHolderName = cardHolderName;
		this.expDateYear = expDateYear;
		this.expDateMonth = expDateMonth;
		this.amount = amount;
		this.bank = bank;
	}

	
	
}
