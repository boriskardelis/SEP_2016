package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "packages")
public class Packages implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public enum TowingByKilometers {
		UNDER_50("Under 50"),
		BETWEEN_50_AND_200("Between 50 and 200"),
		OVER_200("Over 200");;
		
		private String name;
		
		private TowingByKilometers(String value) {
			this.name = value;
		}
		
		@Override
		public String toString() {
			return name;
		}
	}
	
	public enum RepairPrice {
		E100,
		E300,
		E500,
		E1000,
		E2000
	}
	
	public enum HotelAccommodation {
		One_Day("One day"),
		BETWEEN_1_AND_3("Between 1 and 3"),
		OVER_3("Over 3");;
		
		private String name;
		
		private HotelAccommodation(String value) {
			this.name = value;
		}
		
		@Override
		public String toString() {
			return name;
		}
	}
	
	 @Id
	 @GeneratedValue
	 @Column(name = "package_id")
	 private Long packageId;
	 
	 @Column(name = "towing_by_kilometer")
	 private TowingByKilometers towingByKilometers;
	 
	 @Column(name = "car_repairs")
	 private RepairPrice carRepairs;
	 
	 @Column(name = "hotel_accommodation")
	 private HotelAccommodation hotelAcommodation;
	 
	 @Column(name = "alternative_transport")
	 private String alternative_transport;

	public Long getPackageId() {
		return packageId;
	}

	public void setPackageId(Long packageId) {
		this.packageId = packageId;
	}

	public TowingByKilometers getTowingByKilometers() {
		return towingByKilometers;
	}

	public void setTowingByKilometers(TowingByKilometers towingByKilometers) {
		this.towingByKilometers = towingByKilometers;
	}

	public RepairPrice getCarRepairs() {
		return carRepairs;
	}

	public void setCarRepairs(RepairPrice carRepairs) {
		this.carRepairs = carRepairs;
	}

	public HotelAccommodation getHotelAcommodation() {
		return hotelAcommodation;
	}

	public void setHotelAcommodation(HotelAccommodation hotelAcommodation) {
		this.hotelAcommodation = hotelAcommodation;
	}

	public String getAlternative_transport() {
		return alternative_transport;
	}

	public void setAlternative_transport(String alternative_transport) {
		this.alternative_transport = alternative_transport;
	}

	public Packages() {}

	public Packages(Long packageId, TowingByKilometers towingByKilometers, RepairPrice carRepairs,
			HotelAccommodation hotelAcommodation, String alternative_transport) {
		super();
		this.packageId = packageId;
		this.towingByKilometers = towingByKilometers;
		this.carRepairs = carRepairs;
		this.hotelAcommodation = hotelAcommodation;
		this.alternative_transport = alternative_transport;
	}
	
	
	 
	
	 
	 
	 

}
