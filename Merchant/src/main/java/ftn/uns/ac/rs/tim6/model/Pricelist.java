package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PRICELIST")
public class Pricelist implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue
	 @Column(name = "PRICELIST_ID")
	 private long id;
	 
	 @Column(name = "START_DATE")
	 private Date startDate;
	 
	 @OneToMany(mappedBy = "pricelist", cascade = CascadeType.ALL)
	 private List<Insurance> insurance;
	 
	 @OneToMany(mappedBy = "pricelist",  cascade = CascadeType.ALL)
	 @JsonIgnore
	 private List<PricelistItem> pricelistItems;
	 

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	

	public List<PricelistItem> getPricelistItems() {
		return pricelistItems;
	}

	public void setPricelistItems(List<PricelistItem> pricelistItems) {
		this.pricelistItems = pricelistItems;
	}

	

	public List<Insurance> getInsurance() {
		return insurance;
	}

	public void setInsurance(List<Insurance> insurance) {
		this.insurance = insurance;
	}
	

	public Pricelist(long id, Date startDate, List<Insurance> insurance,
			List<PricelistItem> pricelistItems) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.insurance = insurance;
		this.pricelistItems = pricelistItems;
	}

	public Pricelist() {
		super();
	}
	 
	
	 
	
	
}