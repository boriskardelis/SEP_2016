package ftn.uns.ac.rs.tim6.model;


import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "road_help_insurance")
public class RoadHelpInsurance implements Serializable {
	
	 private static final long serialVersionUID = 1L;
	
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
	 private List<Packages> packagesList;
	 
	 @OneToMany(fetch = FetchType.LAZY)
	 @JoinColumn(name = "car")
	 private List<Car> carList;
	 

	public List<Packages> getPackagesList() {
		return packagesList;
	}

	public void setPackagesList(List<Packages> packagesList) {
		this.packagesList = packagesList;
	}

	public List<Car> getCarList() {
		return carList;
	}

	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}

	public RoadHelpInsurance() {}

	public RoadHelpInsurance(Long id, Date date, List<Packages> packagesList, List<Car> carList) {
		super();
		this.id = id;
		this.date = date;
		this.packagesList = packagesList;
		this.carList = carList;
	}
	
	

	
}
