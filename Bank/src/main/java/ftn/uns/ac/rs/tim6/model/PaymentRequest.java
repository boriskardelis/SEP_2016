package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "PAYMENT_REQUEST")
public class PaymentRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "PAYMENT_REQUEST_ID")
	private Long id;
	
	@Column(name = "MERCHANT_ORDER_ID")
	private Integer merchantOrderId;
	
	@Column(name = "MERCHANT_ID")
	private String merchantId;
	
	@Column(name = "MERCHANT_PASSWORD")
	private String merchantPassword;
	
	@Column(name = "MERCHANT_TIMESTAMP")
	private Date merchantTimestamp;
	
	@Column(name = "AMOUNT")
	private double amount;
	
	@URL
	@Column(name = "ERROR_URL")
	private String errorUrl;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( name = "PAYMENT_REQUEST_MERCHANT")
	private Merchant merchant;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACQUIRER_ORDER_ID")
	private AcquirerOrder acquirerOrder;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "PAYMENT_URL_AND_ID")
	private PaymentUrlAndId paymentUrlAndId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMerchantOrderId() {
		return merchantOrderId;
	}

	public void setMerchantOrderId(Integer merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantPassword() {
		return merchantPassword;
	}

	public void setMerchantPassword(String merchantPassword) {
		this.merchantPassword = merchantPassword;
	}

	public Date getMerchantTimestamp() {
		return merchantTimestamp;
	}

	public void setMerchantTimestamp(Date merchantTimestamp) {
		this.merchantTimestamp = merchantTimestamp;
	}

	

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getErrorUrl() {
		return errorUrl;
	}

	public void setErrorUrl(String errorUrl) {
		this.errorUrl = errorUrl;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public AcquirerOrder getAcquirerOrder() {
		return acquirerOrder;
	}

	public void setAcquirerOrder(AcquirerOrder acquirerOrder) {
		this.acquirerOrder = acquirerOrder;
	}

	public PaymentUrlAndId getPaymentUrlAndId() {
		return paymentUrlAndId;
	}

	public void setPaymentUrlAndId(PaymentUrlAndId paymentUrlAndId) {
		this.paymentUrlAndId = paymentUrlAndId;
	}

	public PaymentRequest(Long id, Integer merchantOrderId, String merchantId, String merchantPassword,
			Date merchantTimestamp, long amount, String errorUrl, Merchant merchant, AcquirerOrder acquirerOrder,
			PaymentUrlAndId paymentUrlAndId) {
		super();
		this.id = id;
		this.merchantOrderId = merchantOrderId;
		this.merchantId = merchantId;
		this.merchantPassword = merchantPassword;
		this.merchantTimestamp = merchantTimestamp;
		this.amount = amount;
		this.errorUrl = errorUrl;
		this.merchant = merchant;
		this.acquirerOrder = acquirerOrder;
		this.paymentUrlAndId = paymentUrlAndId;
	}

	public PaymentRequest() {
		super();
	}
	
	
	

}
