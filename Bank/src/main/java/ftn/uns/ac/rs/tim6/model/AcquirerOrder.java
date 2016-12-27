package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACQUIRER_ORDER")
public class AcquirerOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ACQUIRER_ORDER_ID")
	private Long id;

	@Column(name = "ACQUIRER_TIMESTAMP")
	private Timestamp timestamp;

	@Column(name = "PAN")
	private Long pan;

	@Column(name = "SECURITY_CODE")
	private String securityCode;

	@Column(name = "TRANSACTION_AMOUNT")
	private BigDecimal transactionAmount;

	@Column(name = "CARD_HOLDER")
	private String cardHolder;

	@Column(name = "EXP_DATE")
	private Date expDate;

	// ?
	@Column(name = "DIRECTION")
	private String string;

	@OneToOne(fetch = FetchType.LAZY, optional = true, mappedBy = "acquirerOrder")
	private PaymentRequest paymentRequest;

	@OneToOne(fetch = FetchType.LAZY, optional = true, mappedBy = "acquirerOrder")
	private IssuerMessage issuerMessage;

	@OneToOne(fetch = FetchType.LAZY, optional = true, mappedBy = "acquirerOrder")
	private AcquirerOrderReservation acquirerOrderReservation;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ACCOUNT_ID", nullable = true)
	private Account account;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Long getPan() {
		return pan;
	}

	public void setPan(Long pan) {
		this.pan = pan;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public PaymentRequest getPaymentRequest() {
		return paymentRequest;
	}

	public void setPaymentRequest(PaymentRequest paymentRequest) {
		this.paymentRequest = paymentRequest;
	}

	public IssuerMessage getIssuerMessage() {
		return issuerMessage;
	}

	public void setIssuerMessage(IssuerMessage issuerMessage) {
		this.issuerMessage = issuerMessage;
	}

	public AcquirerOrderReservation getAcquirerOrderReservation() {
		return acquirerOrderReservation;
	}

	public void setAcquirerOrderReservation(AcquirerOrderReservation acquirerOrderReservation) {
		this.acquirerOrderReservation = acquirerOrderReservation;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public AcquirerOrder(Long id, Timestamp timestamp, Long pan, String securityCode, BigDecimal transactionAmount,
			String cardHolder, Date expDate, String string, PaymentRequest paymentRequest, IssuerMessage issuerMessage,
			AcquirerOrderReservation acquirerOrderReservation, Account account) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.pan = pan;
		this.securityCode = securityCode;
		this.transactionAmount = transactionAmount;
		this.cardHolder = cardHolder;
		this.expDate = expDate;
		this.string = string;
		this.paymentRequest = paymentRequest;
		this.issuerMessage = issuerMessage;
		this.acquirerOrderReservation = acquirerOrderReservation;
		this.account = account;
	}

	public AcquirerOrder() {
		super();
	}

}
