package ftn.uns.ac.rs.tim6.dto;

import ftn.uns.ac.rs.tim6.dto.ResponseMessageDto.TransactionResult;
import ftn.uns.ac.rs.tim6.model.Payment.Status;

public class URLDto {

	private String url;
	private Status status;
	private TransactionResult result;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public TransactionResult getResult() {
		return result;
	}

	public void setResult(TransactionResult result) {
		this.result = result;
	}

}
