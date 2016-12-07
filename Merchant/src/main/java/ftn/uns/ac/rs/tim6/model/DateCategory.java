package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "DATE_CATEGORY")
public class DateCategory implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue
	 @Column(name = "ID")
	 private Long id;
	 
	 @Column(name = "START_DATE")
	 private Date startDate;
	 
	 @Column(name = "END_DATE")
	 private Date endDate;
	 
	 
	
	
}
