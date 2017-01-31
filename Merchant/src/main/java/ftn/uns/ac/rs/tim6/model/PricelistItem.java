package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PRICELIST_ITEM")
public class PricelistItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "PRICELIST_ITEM_ID")
	private Integer id;

	@Column(name = "COEFFICIENT")
	private BigDecimal coefficient;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PRICELIST")
	@JsonIgnore
	private Pricelist pricelist;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RISK_SUBCATEGORY")
	@JsonIgnore
	private RiskSubcategory riskSubcategory;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(BigDecimal coefficient) {
		this.coefficient = coefficient;
	}

	public Pricelist getPricelist() {
		return pricelist;
	}

	public void setPricelist(Pricelist pricelist) {
		this.pricelist = pricelist;
	}

	public RiskSubcategory getRiskSubcategory() {
		return riskSubcategory;
	}

	public void setRiskSubcategory(RiskSubcategory riskSubcategory) {
		this.riskSubcategory = riskSubcategory;
	}

	public PricelistItem(Integer id, BigDecimal coefficient, Pricelist pricelist, RiskSubcategory riskSubcategory) {
		super();
		this.id = id;
		this.coefficient = coefficient;
		this.pricelist = pricelist;
		this.riskSubcategory = riskSubcategory;
	}

	public PricelistItem() {
		super();
	}

}