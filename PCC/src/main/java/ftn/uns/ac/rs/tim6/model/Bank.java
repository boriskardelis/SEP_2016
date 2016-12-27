package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "BANK")
public class Bank implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "BANK_ID")
	private Long id;
	
	@Column(name = "BANK_PAN")
	private Long bankPan;
	
	@Column(name = "BANK_NAME")
	private String bankName;
	
	@OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
	private List<IncomingMessage> incomingMessages;
	
	@OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
	private List<ResponseMessage> requestMessages;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBankPan() {
		return bankPan;
	}

	public void setBankPan(Long bankPan) {
		this.bankPan = bankPan;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public List<IncomingMessage> getIncomingMessages() {
		return incomingMessages;
	}

	public void setIncomingMessages(List<IncomingMessage> incomingMessages) {
		this.incomingMessages = incomingMessages;
	}

	public List<ResponseMessage> getRequestMessages() {
		return requestMessages;
	}

	public void setRequestMessages(List<ResponseMessage> requestMessages) {
		this.requestMessages = requestMessages;
	}

	public Bank(Long id, Long bankPan, String bankName, List<IncomingMessage> incomingMessages,
			List<ResponseMessage> requestMessages) {
		super();
		this.id = id;
		this.bankPan = bankPan;
		this.bankName = bankName;
		this.incomingMessages = incomingMessages;
		this.requestMessages = requestMessages;
	}

	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
