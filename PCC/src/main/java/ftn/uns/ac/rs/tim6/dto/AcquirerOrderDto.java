package ftn.uns.ac.rs.tim6.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class AcquirerOrderDto {

	private Timestamp timestamp;
	private Long pan;
	private Long securityCode;
	private BigDecimal transactionAmount;
	private String cardHolder;
	private Long expDateYear;
	private Long expDateMonth;
	private Integer acquirerOrderId;

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

	public Integer getAcquirerOrderId() {
		return acquirerOrderId;
	}

	public void setAcquirerOrderId(Integer acquirerOrderId) {
		this.acquirerOrderId = acquirerOrderId;
	}

}
