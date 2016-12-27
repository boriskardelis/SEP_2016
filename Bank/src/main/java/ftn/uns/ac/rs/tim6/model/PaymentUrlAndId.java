package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "PAYMENT_URL_AND_ID")
public class PaymentUrlAndId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "PAYMENT_URL_AND_ID")
	private Long id;
	
	@Column(name = "PAYMENT_ID")
	private Long paymentId;
	
	@URL
	@Column(name = "PAYMENT_URL")
	private String paymentUrl;
		
	@OneToOne(fetch = FetchType.LAZY, mappedBy= "paymentUrlAndId", cascade=CascadeType.ALL)
	private PaymentRequest paymentRequest;

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

	public String getPaymentUrl() {
		return paymentUrl;
	}

	public void setPaymentUrl(String paymentUrl) {
		this.paymentUrl = paymentUrl;
	}

	public PaymentRequest getPaymentRequest() {
		return paymentRequest;
	}

	public void setPaymentRequest(PaymentRequest paymentRequest) {
		this.paymentRequest = paymentRequest;
	}

	public PaymentUrlAndId(Long id, Long paymentId, String paymentUrl, PaymentRequest paymentRequest) {
		super();
		this.id = id;
		this.paymentId = paymentId;
		this.paymentUrl = paymentUrl;
		this.paymentRequest = paymentRequest;
	}

	public PaymentUrlAndId() {
		super();
	}
	
	

}
