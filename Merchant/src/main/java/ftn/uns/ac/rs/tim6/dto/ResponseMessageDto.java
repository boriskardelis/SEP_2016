package ftn.uns.ac.rs.tim6.dto;

import java.sql.Timestamp;

public class ResponseMessageDto {

	public enum TransactionResult {
		SUCCESSFUL, INSUFFICIENT_FUNDS, INVALID_DATE, CVC_INVALID, ERROR
	}

	private TransactionResult result;
	private Long paymentId;
	private Integer acquirerOrderId;
	private Timestamp acquirerTimestamp;
	private Integer merchantOrderId;
	private Timestamp merchantTimestamp;

	public TransactionResult getResult() {
		return result;
	}

	public void setResult(TransactionResult result) {
		this.result = result;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
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

	public Integer getMerchantOrderId() {
		return merchantOrderId;
	}

	public void setMerchantOrderId(Integer merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
	}

	public Timestamp getMerchantTimestamp() {
		return merchantTimestamp;
	}

	public void setMerchantTimestamp(Timestamp merchantTimestamp) {
		this.merchantTimestamp = merchantTimestamp;
	}

}
