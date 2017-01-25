package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "PAYMENT")
public class Payment implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	public enum Status {
		SUCCESSFUL,
		FAILED,
		ERROR
	}
	 
	 @Id
	 @GeneratedValue
	 @Column(name = "PAYMENT_ID")
	 private Long id;
	 
	 @Column(name = "PAYMENT_ID_ID")
	 private Long paymentId;

	 @Column(name = "MERCHANT_ID")
	 private String merchantId;
	 
	 @Column(name = "MERCHANT_ORDER_ID")
	 private Integer merchantOrderId;
	 
	 @Column(name = "PAYMENT_MESSAGE")
	 private String paymentMessage;
	 
	 @Column(name = "PAYMENT_STATUS")
	 private Status paymentStatus;
	 
	

	public String getPaymentMessage() {
		return paymentMessage;
	}

	public void setPaymentMessage(String paymentMessage) {
		this.paymentMessage = paymentMessage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Status getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Status paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	
	 public Payment(Long id, Long paymentId, String merchantId, Integer merchantOrderId, String paymentMessage,
			Status paymentStatus) {
		super();
		this.id = id;
		this.paymentId = paymentId;
		this.merchantId = merchantId;
		this.merchantOrderId = merchantOrderId;
		this.paymentMessage = paymentMessage;
		this.paymentStatus = paymentStatus;
	}


	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public Integer getMerchantOrderId() {
		return merchantOrderId;
	}

	public void setMerchantOrderId(Integer merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
	}

	public Payment() {
		super();
	}
	 
	 
}
