package ftn.uns.ac.rs.tim6.dto;

public class PaymentInfoDto {

	private Long pan;
	private Long securityCode;
	private Long month;
	private Long year;
	private Integer paymentId;

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

	public Long getMonth() {
		return month;
	}

	public void setMonth(Long month) {
		this.month = month;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

}
