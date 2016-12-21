package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

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
	 
	 @Column(name = "END_DATE")
	 private Date endDate;
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "INSURANCE")
	 private Insurance insurance;
	 
	 @OneToMany(mappedBy = "pricelist",  cascade = CascadeType.ALL)
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

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public List<PricelistItem> getPricelistItems() {
		return pricelistItems;
	}

	public void setPricelistItems(List<PricelistItem> pricelistItems) {
		this.pricelistItems = pricelistItems;
	}

	

	public Pricelist(long id, Date startDate, Date endDate, Insurance insurance, List<PricelistItem> pricelistItems) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.insurance = insurance;
		this.pricelistItems = pricelistItems;
	}

	public Pricelist() {
		super();
	}
	 
	
	 
	
	
}