package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import ftn.uns.ac.rs.tim6.dto.ResponseMessageDto.TransactionResult;

@Entity
@Table(name = "ISSUER_MESSAGE")
public class IssuerMessage implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ISSUER_MESSAGE_ID")
	private Long id;

	@Column(name = "TRANSACTION_RESULT")
	private TransactionResult transactionResult;

	@Column(name = "ACQUIRER_ORDER_ID")
	private Integer acquirerOrderId;

	@Column(name = "ACQUIRER_TIMESTAMP")
	private Timestamp acquirerTimestamp;

	@Column(name = "ISSUER_ORDER_ID")
	private Integer issuerOrderId;

	@Column(name = "ISSUER_TIMESTAMP")
	private Timestamp issuerTimestamp;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ACQUIRER_ORDER")
	private AcquirerOrder acquirerOrder;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TransactionResult getTransactionResult() {
		return transactionResult;
	}

	public void setTransactionResult(TransactionResult transactionResult) {
		this.transactionResult = transactionResult;
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

	public AcquirerOrder getAcquirerOrder() {
		return acquirerOrder;
	}

	public void setAcquirerOrder(AcquirerOrder acquirerOrder) {
		this.acquirerOrder = acquirerOrder;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public IssuerMessage(Long id, TransactionResult transactionResult, Integer acquirerOrderId,
			Timestamp acquirerTimestamp, Integer issuerOrderId, Timestamp issuerTimestamp, AcquirerOrder acquirerOrder) {
		super();
		this.id = id;
		this.transactionResult = transactionResult;
		this.acquirerOrderId = acquirerOrderId;
		this.acquirerTimestamp = acquirerTimestamp;
		this.issuerOrderId = issuerOrderId;
		this.issuerTimestamp = issuerTimestamp;
		this.acquirerOrder = acquirerOrder;
	}

	public IssuerMessage() {
		super();
	}

}
