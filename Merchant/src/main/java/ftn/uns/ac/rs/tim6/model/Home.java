package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "HOME")
public class Home implements Serializable {

	private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue
	 @Column(name = "ID")
	 private Long  id;
	 
	 @Column(name = "ADDRESS")
	 private String  address;
	 
	 @Column(name = "OWNER_FIRST_NAME")
	 private String  ownerFirstName;
	 
	 @Column(name = "OWNER_LAST_NAME")
	 private String  ownerLastName;
	 
	 @Column(name = "OWNER_JMBG")
	 private Long ownerJMBG;

	
	
	 
	 
	 
	 
	 
	 
}
