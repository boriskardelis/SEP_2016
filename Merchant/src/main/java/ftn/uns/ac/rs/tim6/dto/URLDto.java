package ftn.uns.ac.rs.tim6.dto;

import ftn.uns.ac.rs.tim6.model.Payment.Status;

public class URLDto {
		
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

