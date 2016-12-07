package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BUYER")
public class Buyer implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "JMBG")
	private int JMBG;
	
	@Column(name = "PASSPORT_NUMBER")
	private int passportNumber;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "PHONE_NUMBER")
	private int phoneNumber;
	
	

	public Buyer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
	
	
}
