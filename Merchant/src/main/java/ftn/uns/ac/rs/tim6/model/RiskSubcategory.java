package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "RISK_SUBCATEGORY")

public class RiskSubcategory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "RISK_SUBCATEGORY_ID")
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "NAME_SERBIAN")
	private String nameSerbian;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RISK_CATEGORY")
	private RiskCategory riskCategory;

	@OneToMany(mappedBy = "riskSubcategory", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<PricelistItem> pricelistItems;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameSerbian() {
		return nameSerbian;
	}

	public void setNameSerbian(String nameSerbian) {
		this.nameSerbian = nameSerbian;
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

	public RiskSubcategory(Integer id, String name, String nameSerbian, RiskCategory riskCategory,
			List<PricelistItem> pricelistItems) {
		super();
		this.id = id;
		this.name = name;
		this.nameSerbian = nameSerbian;
		this.riskCategory = riskCategory;
		this.pricelistItems = pricelistItems;
	}

	public RiskSubcategory() {
		super();
	}

}