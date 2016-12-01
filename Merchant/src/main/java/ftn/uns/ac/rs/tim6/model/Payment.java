package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class Payment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue
	 @Column(name = "payment_request_id")
	 private Long paymentRequestId;
	 
	 @Column(name = "merchant_order_id")
	 private Long merchantOrderId;
	 
	 @Column(name = "merchant_id")
	 private String merchantId;
	 
	 @Column(name = "merchant_password")
	 private String merchantPassword;
	 
	 @Column(name = "amount")
	 private double amount;
	 
	 @Column(name = "url")
	 private String url;
	 
	 @Column(name = "payment_id")
	 private Long paymentId;
	 
	 @Column(name = "payment_url")
	 private String paymentUurl;

	public Long getPaymentRequestId() {
		return paymentRequestId;
	}

	public void setPaymentRequestId(Long paymentRequestId) {
		this.paymentRequestId = paymentRequestId;
	}

	public Long getMerchantOrderId() {
		return merchantOrderId;
	}

	public void setMerchantOrderId(Long merchantOrderId) {
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentUurl() {
		return paymentUurl;
	}

	public void setPaymentUurl(String paymentUurl) {
		this.paymentUurl = paymentUurl;
	}

	public Payment() {}

	public Payment(Long paymentRequestId, Long merchantOrderId, String merchantId, String merchantPassword,
			double amount, String url, Long paymentId, String paymentUurl) {
		super();
		this.paymentRequestId = paymentRequestId;
		this.merchantOrderId = merchantOrderId;
		this.merchantId = merchantId;
		this.merchantPassword = merchantPassword;
		this.amount = amount;
		this.url = url;
		this.paymentId = paymentId;
		this.paymentUurl = paymentUurl;
	}
	
	
	
	
	 
	 
}
