package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")
public class Person implements Serializable {
	
	
	 private static final long serialVersionUID = 1L;	
	 
	 @Id
	 @GeneratedValue
	 @Column(name = "ID")
	 private Long id;
	 
	 @Column(name = "FIRST_NAME")
	 private String firstName;
	 
	 @Column(name = "LAST_NAME")
	 private String lastName;
	 
	 @Column(name = "JMBG")
	 private Long jmbg;
	 
	 @Column(name = "PASSPORT_NUMBER")
	 private String passportNumber;
	 
	 @Column(name = "ADRESS")
	 private String adress;
	 
	 @Column(name = "PHONE_NUMBER")
	 private String phoneNumber;
	 
}
