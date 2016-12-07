package ftn.uns.ac.rs.tim6.model;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name = "RISK_SUBCATEGORY")

public class RiskSubcategory implements Serializable {
	
	private static final long serialVersionUID = 1L;	
	 
	 @Id
	 @GeneratedValue
	 @Column(name = "ID")
	 private Long id;
	 
	 @Column(name = "COEFFICIENT")
	 private BigDecimal coefficient;
	 
	 @Column(name = "NAME")
	 private String name;
	 
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "RISK_CATEGORY")
	 private RiskCategory riskCategory;
	 

}
