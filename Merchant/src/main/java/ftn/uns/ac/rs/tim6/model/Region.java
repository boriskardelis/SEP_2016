package ftn.uns.ac.rs.tim6.model;

import javax.persistence.*;

@Entity
@Table(name = "region")
public class Region {
	
	
	public enum Kontinenti {
		EUROPE("Europe"),
		ASIA("Asia"),
		NORTH_AMERICA("North America"),
		SOUTH_AMERICA("South America"),
		AFRICA("Africa"),
		AUSTRALIA("Australia");
		
		private String name;
		
		private Kontinenti(String value) {
			this.name = value;
		}
		
		@Override
		public String toString() {
			return name;
		}
	}
	
	 @Id
	 @GeneratedValue
	 @Enumerated(EnumType.STRING)
	 @Column(name = "region")
	 private Kontinenti region;

}
