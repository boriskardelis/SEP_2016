package ftn.uns.ac.rs.tim6.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PodaciOdMerchanta {
	
	private String merchantId;
	private Integer merchantOrderId;
	
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public Integer getMerchantOrderId() {
		return merchantOrderId;
	}
	public void setMerchantOrderId(Integer merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
	}

	public PodaciOdMerchanta() {
		super();
	}
	
	
		
	
	
	

}
