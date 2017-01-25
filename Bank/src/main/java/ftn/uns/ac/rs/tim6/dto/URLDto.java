package ftn.uns.ac.rs.tim6.dto;

public class URLDto {
	
	public enum Status {
		SUCCESSFUL,
		FAILED,
		ERROR
	}
	
	private String url;
	private String message;
	private Status status;
	

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
