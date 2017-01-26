package ftn.uns.ac.rs.tim6.dto;

import ftn.uns.ac.rs.tim6.dto.ResponseMessageDto.TransactionResult;

public class URLDto {

	public enum Status {
		SUCCESSFUL, FAILED, ERROR
	}

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
