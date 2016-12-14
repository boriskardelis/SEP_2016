package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ACCOUNT_ID")
	private Long id;
	
	@Column(name = "ACCOUNT_NUMBER")
	private String firstName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy= "account")
	private List<AcquirerOrder> acquirerOrder;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy= "account")
	private List<Card> card;
	
	@OneToOne(fetch = FetchType.LAZY, optional = true, mappedBy= "account")
	private Merchant merchant;
	
	@OneToOne(fetch = FetchType.LAZY, optional = true, mappedBy= "account")
	private AcquirerOrderReservation acquirerOrderReservation;

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

	public List<AcquirerOrder> getAcquirerOrder() {
		return acquirerOrder;
	}

	public void setAcquirerOrder(List<AcquirerOrder> acquirerOrder) {
		this.acquirerOrder = acquirerOrder;
	}

	public List<Card> getCard() {
		return card;
	}

	public void setCard(List<Card> card) {
		this.card = card;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public AcquirerOrderReservation getAcquirerOrderReservation() {
		return acquirerOrderReservation;
	}

	public void setAcquirerOrderReservation(AcquirerOrderReservation acquirerOrderReservation) {
		this.acquirerOrderReservation = acquirerOrderReservation;
	}

	public Account(Long id, String firstName, List<AcquirerOrder> acquirerOrder, List<Card> card, Merchant merchant,
			AcquirerOrderReservation acquirerOrderReservation) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.acquirerOrder = acquirerOrder;
		this.card = card;
		this.merchant = merchant;
		this.acquirerOrderReservation = acquirerOrderReservation;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
