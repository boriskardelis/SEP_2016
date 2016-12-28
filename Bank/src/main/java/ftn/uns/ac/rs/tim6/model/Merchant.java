package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MERCHANT")
public class Merchant implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "MERCHANT_ID")
	private String merchantId;

	@Column(name = "MERCHANT_PASSWORD")
	private String password;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant", cascade = CascadeType.ALL)
	private List<PaymentRequest> paymentRequests;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "ACCOUNT_ID", nullable = false)
	private Account account;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PaymentRequest> getPaymentRequests() {
		return paymentRequests;
	}

	public void setPaymentRequests(List<PaymentRequest> paymentRequests) {
		this.paymentRequests = paymentRequests;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Merchant(Long id, String merchantId, String password, List<PaymentRequest> paymentRequests,
			Account account) {
		super();
		this.id = id;
		this.merchantId = merchantId;
		this.password = password;
		this.paymentRequests = paymentRequests;
		this.account = account;
	}

	public Merchant() {
		super();
	}

}
