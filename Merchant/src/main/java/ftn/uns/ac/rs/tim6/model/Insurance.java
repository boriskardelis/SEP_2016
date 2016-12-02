package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "insurance")
public class Insurance implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue
	 @Column(name = "insurance_id")
	 private Long insuranceID;
	 
	 @Column(name = "number_of_persons")
	 private int numberOfPersons;
	 
	 @Column(name = "start_date")
	 private Date startDate;
	 
	 @Column(name = "end_date")
	 private Date endDate;
	 
	 @Column(name = "total_price")
	 private double totalPrice;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "region")
	 private Region region;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "sport")
	 private Sport sport;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "sum_insured_to")
	 private SumInsuredTo sumInsuredTo;
	 
	 @OneToOne(cascade=CascadeType.ALL)  
	 @JoinColumn(name="home_insurance_id")
	 private HomeInsurance homeInsurance;
	 
	 
	 
	 

	public Long getInsuranceID() {
		return insuranceID;
	}

	public void setInsuranceID(Long insuranceID) {
		this.insuranceID = insuranceID;
	}

	public int getNumberOfPersons() {
        return numberOfPersons;
    }
 
    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
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

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}
	
	
	public SumInsuredTo getSumInsuredTo() {
		return sumInsuredTo;
	}

	public void setSumInsuredTo(SumInsuredTo sumInsuredTo) {
		this.sumInsuredTo = sumInsuredTo;
	}
	
	public HomeInsurance getHomeInsurance() {
		return homeInsurance;
	}

	public void setHomeInsurance(HomeInsurance homeInsurance) {
		this.homeInsurance = homeInsurance;
	}

	public Insurance(){}

	public Insurance(Long insuranceID, int numberOfPersons, Date startDate, Date endDate, double totalPrice,
			Region region, Sport sport, SumInsuredTo sumInsuredTo, HomeInsurance homeInsurance) {
		super();
		this.insuranceID = insuranceID;
		this.numberOfPersons = numberOfPersons;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPrice = totalPrice;
		this.region = region;
		this.sport = sport;
		this.sumInsuredTo = sumInsuredTo;
		this.homeInsurance = homeInsurance;
	}
	
	

	

    
	
	
	

}
