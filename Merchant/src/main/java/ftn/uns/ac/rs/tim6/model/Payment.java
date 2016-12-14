package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "PAYMENT")
public class Payment implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	 
	 @Id
	 @GeneratedValue
	 @Column(name = "PAYMENT_ID")
	 private Long id;
	 
	 @Column(name = "FIRST_NAME")
	 private String firstName;
	 
	 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	

	public Payment(Long id, String firstName) {
		super();
		this.id = id;
		this.firstName = firstName;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
}
