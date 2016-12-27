package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RESPONSE_MESSAGE")
public class ResponseMessage implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "RESPONSE_MESSAGE_ID")
	private Long id;
	
	@Column(name = "ACQUIRER_ORDER_ID")
	private Long acquirerOrderId;
	
	@Column (name = "RESULT")
	private Boolean result;
	
	@Column(name = "ACQUIRER_TIMESTAMP")
	private Timestamp acquirerTimestamp;
	
	@Column(name = "ISSUER_ORDER_ID")
	private Long issuerOrderId;
	
	@Column(name = "ISSUER_TIMESTAMP")
	private Timestamp issuerTimestamp;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BANK")
	private Bank bank;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAcquirerOrderId() {
		return acquirerOrderId;
	}

	public void setAcquirerOrderId(Long acquirerOrderId) {
		this.acquirerOrderId = acquirerOrderId;
	}

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	public Timestamp getAcquirerTimestamp() {
		return acquirerTimestamp;
	}

	public void setAcquirerTimestamp(Timestamp acquirerTimestamp) {
		this.acquirerTimestamp = acquirerTimestamp;
	}

	public Long getIssuerOrderId() {
		return issuerOrderId;
	}

	public void setIssuerOrderId(Long issuerOrderId) {
		this.issuerOrderId = issuerOrderId;
	}

	public Timestamp getIssuerTimestamp() {
		return issuerTimestamp;
	}

	public void setIssuerTimestamp(Timestamp issuerTimestamp) {
		this.issuerTimestamp = issuerTimestamp;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
	

	public ResponseMessage(Long id, Long acquirerOrderId, Boolean result, Timestamp acquirerTimestamp,
			Long issuerOrderId, Timestamp issuerTimestamp, Bank bank) {
		super();
		this.id = id;
		this.acquirerOrderId = acquirerOrderId;
		this.result = result;
		this.acquirerTimestamp = acquirerTimestamp;
		this.issuerOrderId = issuerOrderId;
		this.issuerTimestamp = issuerTimestamp;
		this.bank = bank;
	}

	public ResponseMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
