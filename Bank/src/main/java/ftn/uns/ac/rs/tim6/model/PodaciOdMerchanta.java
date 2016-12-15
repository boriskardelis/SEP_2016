package ftn.uns.ac.rs.tim6.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mysql.fabric.xmlrpc.base.Array;

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
		// TODO Auto-generated constructor stub
	}
	
	
		
	
	
	

}
