package ftn.uns.ac.rs.tim6.model;


import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "road_help_insurance")
public class RoadHelpInsurance {
	
	 @Id
	 @GeneratedValue
	 @Column(name = "road_help_insurance_id")
	 private Long id;
	 
	 @Column(name = "road_help_insurance_duration")
	 private Date date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	 
	 @OneToMany(fetch = FetchType.LAZY)
	 @JoinColumn(name = "packages")
	 private Packages packages;
	 
	 @OneToMany(fetch = FetchType.LAZY)
	 @JoinColumn(name = "car")
	 private Car car;
	 
	 @OneToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "insurance")
	 private Insurance insurance;

	public Packages getPackages() {
		return packages;
	}

	public void setPackages(Packages packages) {
		this.packages = packages;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	 
	 
}
