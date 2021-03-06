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

@Entity
@Table(name = "BANK")
public class Bank implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "BANK_ID")
	private Long id;

	@Column(name = "BANK_PAN")
	private Long pan;

	@Column(name = "BANK_PORT")
	private Long port;

	@Column(name = "BANK_NAME")
	private String name;

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

	public Long getPan() {
		return pan;
	}

	public void setPan(Long pan) {
		this.pan = pan;
	}

	public Long getPort() {
		return port;
	}

	public void setPort(Long port) {
		this.port = port;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Bank() {
		super();
	}

	public Bank(Long id, Long pan, Long port, String name, List<IncomingMessage> incomingMessages,
			List<ResponseMessage> requestMessages) {
		super();
		this.id = id;
		this.pan = pan;
		this.port = port;
		this.name = name;
		this.incomingMessages = incomingMessages;
		this.requestMessages = requestMessages;
	}

}
