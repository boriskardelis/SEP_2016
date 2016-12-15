package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "PAYMENT")
public class Payment implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	 
	 @Id
	 @GeneratedValue
	 @Column(name = "PAYMENT_ID")
	 private Long id;
	 
	 @Column(name = "MERCHANT_ID")
	 private String merchantId;
	 
	 @Column(name = "MERCHANT_ORDER_ID")
	 private Integer merchantOrderId;
	 
	 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public Payment(Long id, String merchantId, Integer merchantOrderId) {
		super();
		this.id = id;
		this.merchantId = merchantId;
		this.merchantOrderId = merchantOrderId;
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
		// TODO Auto-generated constructor stub
	}
	 
	 
}
