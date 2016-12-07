package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "INSURANCE")
public class Insurance implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue
	 @Column(name = "ID")
	 private Long id;
	 
	 @Column(name = "NUMBER_OF_PERSONS")
	 private int numberOfPersons;
	 
	 @Column(name = "START_DATE")
	 private Date startDate;
	 
	 @Column(name = "END_DATE")
	 private Date endDate;
	 
	 @Column(name = "TOTAL_PRICE")
	 private double totalPrice;
	 
	 @ManyToMany(fetch = FetchType.EAGER)
	 @JoinTable(name = "RISK_CATEGORY")
	 private List<RiskCategory> riskCategories;
	 
	
	 
	 
	 

	

	
	

	

    
	
	
	

}
