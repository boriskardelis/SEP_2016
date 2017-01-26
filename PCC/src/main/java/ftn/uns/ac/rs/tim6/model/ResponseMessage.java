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

import ftn.uns.ac.rs.tim6.dto.ResponseMessageDto.TransactionResult;

@Entity
@Table(name = "RESPONSE_MESSAGE")
public class ResponseMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "RESPONSE_MESSAGE_ID")
	private Long id;

	@Column(name = "ACQUIRER_ORDER_ID")
	private Integer acquirerOrderId;

	@Column(name = "ACQUIRER_TIMESTAMP")
	private Timestamp acquirerTimestamp;

	@Column(name = "ISSUER_ORDER_ID")
	private Integer issuerOrderId;

	@Column(name = "ISSUER_TIMESTAMP")
	private Timestamp issuerTimestamp;

	@Column(name = "RESULT")
	private TransactionResult result;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BANK")
	private Bank bank;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getIssuerOrderId() {
		return issuerOrderId;
	}

	public void setIssuerOrderId(Integer issuerOrderId) {
		this.issuerOrderId = issuerOrderId;
	}

	public Timestamp getIssuerTimestamp() {
		return issuerTimestamp;
	}

	public void setIssuerTimestamp(Timestamp issuerTimestamp) {
		this.issuerTimestamp = issuerTimestamp;
	}

	public TransactionResult getResult() {
		return result;
	}

	public void setResult(TransactionResult result) {
		this.result = result;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ResponseMessage(Long id, Integer acquirerOrderId, Timestamp acquirerTimestamp, Integer issuerOrderId,
			Timestamp issuerTimestamp, TransactionResult result, Bank bank) {
		super();
		this.id = id;
		this.acquirerOrderId = acquirerOrderId;
		this.acquirerTimestamp = acquirerTimestamp;
		this.issuerOrderId = issuerOrderId;
		this.issuerTimestamp = issuerTimestamp;
		this.result = result;
		this.bank = bank;
	}

	public ResponseMessage() {
		super();
	}

}
