package ftn.uns.ac.rs.tim6.dto;

import java.math.BigDecimal;

public class MerchantDto {

	private BigDecimal amount;
	
	private long orderID;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public long getOrderID() {
		return orderID;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	
}
