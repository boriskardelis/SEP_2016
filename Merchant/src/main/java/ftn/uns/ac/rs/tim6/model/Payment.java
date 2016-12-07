package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "PAYMENT")
public class Payment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue
	 @Column(name = "ID")
	 private Long id;
	 
	 @Column(name = "MERCHANT_ORDER_ID")
	 private Long merchantOrderId;
	 
	 @Column(name = "MERCHANT_ID")
	 private String merchantId;
	 
	 @Column(name = "MERCHANT_PASSWORD")
	 private String merchantPassword;
	 
	 @Column(name = "AMOUNT")
	 private double amount;
	 
	 @Column(name = "URL")
	 private String url;
	 
	 @Column(name = "PAYMENT_ID")
	 private Long paymentId;
	 
	 @Column(name = "PAYMENT_URL")
	 private String paymentUurl;

	
	
	 
	 
}
