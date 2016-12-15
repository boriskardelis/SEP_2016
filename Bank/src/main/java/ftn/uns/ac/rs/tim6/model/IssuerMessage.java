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

@Entity
@Table(name = "ISSUER_MESSAGE")
public class IssuerMessage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "ISSUER_MESSAGE_ID")
	private Long id;
	
	//@Column(name = "ACQUIRER_ORDER_ID")
	//private Long acquirerOrderId;
	
	@Column(name = "ACQUIRER_TIMESTAMP")
	private Timestamp acquirerTimestamp;
	
	@Column(name = "ISSUER_ORDER_ID")
	private Long issuerOrderId;
	
	@Column(name = "ISSUER_TIMESTAMP")
	private Timestamp issuerTimestamp;
	
	@Column(name = "TRANSACTION_RESULT" )
	private Boolean transactionResult;
	
	//?
	@Column(name = "DIRECTION")
	private String string;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ACQUIRER_ORDER_ID" )
	private AcquirerOrder acquirerOrder;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Boolean getTransactionResult() {
		return transactionResult;
	}

	public void setTransactionResult(Boolean transactionResult) {
		this.transactionResult = transactionResult;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public AcquirerOrder getAcquirerOrder() {
		return acquirerOrder;
	}

	public void setAcquirerOrder(AcquirerOrder acquirerOrder) {
		this.acquirerOrder = acquirerOrder;
	}

	public IssuerMessage(Long id, Timestamp acquirerTimestamp, Long issuerOrderId, Timestamp issuerTimestamp,
			Boolean transactionResult, String string, AcquirerOrder acquirerOrder) {
		super();
		this.id = id;
		this.acquirerTimestamp = acquirerTimestamp;
		this.issuerOrderId = issuerOrderId;
		this.issuerTimestamp = issuerTimestamp;
		this.transactionResult = transactionResult;
		this.string = string;
		this.acquirerOrder = acquirerOrder;
	}

	public IssuerMessage() {
		super();
	}
	
	

}
