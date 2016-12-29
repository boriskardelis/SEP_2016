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

	@Column(name = "ACQUIRER_ORDER_ID_ID")
	private Integer acquirerOrderId;

	@Column(name = "ACQUIRER_TIMESTAMP")
	private Timestamp timestamp;

	@Column(name = "PAN")
	private Long pan;

	@Column(name = "SECURITY_CODE")
	private Long securityCode;

	@Column(name = "TRANSACTION_AMOUNT")
	private BigDecimal transactionAmount;

	@Column(name = "CARD_HOLDER")
	private String cardHolder;

	@Column(name = "EXP_DATE_YEAR")
	private Long expDateYear;

	@Column(name = "EXP_DATE_MONTH")
	private Long expDateMonth;

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

	public Long getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(Long securityCode) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getAcquirerOrderId() {
		return acquirerOrderId;
	}

	public void setAcquirerOrderId(Integer acquirerOrderId) {
		this.acquirerOrderId = acquirerOrderId;
	}

	public AcquirerOrder() {
		super();
	}

	public AcquirerOrder(Long id, Integer acquirerOrderId, Timestamp timestamp, Long pan, Long securityCode,
			BigDecimal transactionAmount, String cardHolder, Long expDateYear, Long expDateMonth,
			PaymentRequest paymentRequest, IssuerMessage issuerMessage,
			AcquirerOrderReservation acquirerOrderReservation, Account account) {
		super();
		this.id = id;
		this.acquirerOrderId = acquirerOrderId;
		this.timestamp = timestamp;
		this.pan = pan;
		this.securityCode = securityCode;
		this.transactionAmount = transactionAmount;
		this.cardHolder = cardHolder;
		this.expDateYear = expDateYear;
		this.expDateMonth = expDateMonth;
		this.paymentRequest = paymentRequest;
		this.issuerMessage = issuerMessage;
		this.acquirerOrderReservation = acquirerOrderReservation;
		this.account = account;
	}

}
