package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "RISK_SUBCATEGORY")

public class RiskSubcategory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "RISK_SUBCATEGORY_ID")
	private Integer id;

	/*
	 * @Column(name = "COEFFICIENT") private BigDecimal coefficient;
	 */

	/*
	 * @Column(name = "NAME") private String name;
	 */

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RISK_CATEGORY")
	private RiskCategory riskCategory;

	@OneToMany(mappedBy = "riskSubcategory", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<PricelistItem> pricelistItems;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "NAME_TRANSLATE")
	private NameTranslate nameTranslate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/*
	 * public BigDecimal getCoefficient() { return coefficient; } public void
	 * setCoefficient(BigDecimal coefficient) { this.coefficient = coefficient;
	 * }
	 */

	/*
	 * public String getName() { return name; }
	 * 
	 * public void setName(String name) { this.name = name; }
	 */

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

	public NameTranslate getNameTranslate() {
		return nameTranslate;
	}

	public void setNameTranslate(NameTranslate nameTranslate) {
		this.nameTranslate = nameTranslate;
	}

	public RiskSubcategory(Integer id, RiskCategory riskCategory, List<PricelistItem> pricelistItems,
			NameTranslate nameTranslate) {
		super();
		this.id = id;
		this.riskCategory = riskCategory;
		this.pricelistItems = pricelistItems;
		this.nameTranslate = nameTranslate;
	}

	public RiskSubcategory() {
		super();
	}

}