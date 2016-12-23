package ftn.uns.ac.rs.tim6.dto;

import java.math.BigInteger;

public class PaymentUrlIdDto {
	
	private long id;
	private String url;
	private BigInteger paymentId;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public BigInteger getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(BigInteger paymentId) {
		this.paymentId = paymentId;
	}
	
	
}
