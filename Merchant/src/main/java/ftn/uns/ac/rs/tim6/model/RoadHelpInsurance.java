package ftn.uns.ac.rs.tim6.model;


import java.sql.Date;
import java.util.List;

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
	 private List<Packages> packagesList;
	 
	 @OneToMany(fetch = FetchType.LAZY)
	 @JoinColumn(name = "car")
	 private List<Car> carList;
	 
/*	 @OneToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "insurance")
	 private Insurance insurance; */

	

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

/*	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	 
*/	 
}
