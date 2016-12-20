package ftn.uns.ac.rs.tim6.model;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "RISK_SUBCATEGORY")

public class RiskSubcategory implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	 
	 @Id
	 @GeneratedValue
	 @Column(name = "RISK_SUBCATEGORY_ID")
	 private long id;
	 
	/* @Column(name = "COEFFICIENT")
	 private BigDecimal coefficient;*/
	 
	 @Column(name = "NAME")
	 private String name;
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "RISK_CATEGORY")
	 private RiskCategory riskCategory;
	 
	 @OneToMany(mappedBy = "pricelist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	 private List<PricelistItem> pricelistItems;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/*public BigDecimal getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(BigDecimal coefficient) {
		this.coefficient = coefficient;
	}*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RiskCategory getRiskCategory() {
		return riskCategory;
	}

	public void setRiskCategory(RiskCategory riskCategory) {
		this.riskCategory = riskCategory;
	}

	

	public List<PricelistItem> getPricelistItems() {
		return pricelistItems;
	}

	public void setPricelistItems(List<PricelistItem> pricelistItems) {
		this.pricelistItems = pricelistItems;
	}

	

	public RiskSubcategory(long id, String name, RiskCategory riskCategory, List<PricelistItem> pricelistItems) {
		super();
		this.id = id;
		this.name = name;
		this.riskCategory = riskCategory;
		this.pricelistItems = pricelistItems;
	}

	public RiskSubcategory() {
		super();
	}
	 
	 
	 

}
