package ftn.uns.ac.rs.tim6.model;

import java.sql.Date;

import javax.persistence.*;


public class Insurance {
	
	 @Id
	 @GeneratedValue
	 @Column(name = "insurance")
	 private Long insurance;
	 
	 @Column(name = "number_of_person")
	 private int numberOfPersons;
	 
	 @Column(name = "start_date")
	 private Date startDate;
	 
	 @Column(name = "end_date")
	 private Date endDate;
	 
	 @Column(name = "total_price")
	 private double totalPrice;

	public Long getInsurance() {
		return insurance;
	}

	public void setInsurance(Long insurance) {
		this.insurance = insurance;
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

	 
	 
	 
	 
	 
	 

}
