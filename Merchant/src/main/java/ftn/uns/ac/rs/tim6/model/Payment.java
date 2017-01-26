package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;

import javax.persistence.*;

import ftn.uns.ac.rs.tim6.dto.ResponseMessageDto.TransactionResult;

@Entity
@Table(name = "PAYMENT")
public class Payment implements Serializable {

	private static final long serialVersionUID = 1L;

	public enum Status {
		SUCCESSFUL, FAILED, ERROR
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

	@Column(name = "TRANSACTIONAL_RESULT")
	private TransactionResult transactionResult;

	@Column(name = "PAYMENT_STATUS")
	private Status paymentStatus;

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

	public TransactionResult getTransactionResult() {
		return transactionResult;
	}

	public void setTransactionResult(TransactionResult transactionResult) {
		this.transactionResult = transactionResult;
	}

	public Status getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Status paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Payment(Long id, Long paymentId, String merchantId, Integer merchantOrderId,
			TransactionResult transactionResult, Status paymentStatus) {
		super();
		this.id = id;
		this.paymentId = paymentId;
		this.merchantId = merchantId;
		this.merchantOrderId = merchantOrderId;
		this.transactionResult = transactionResult;
		this.paymentStatus = paymentStatus;
	}

	public Payment() {
		super();
	}

}
