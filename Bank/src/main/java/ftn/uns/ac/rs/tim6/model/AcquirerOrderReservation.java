package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACQUIRER_ORDER_RESERVATION")
public class AcquirerOrderReservation implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ACQUIRER_ORDER_RESERVATION_ID")
	private Long id;
	
	@Column(name = "RESERVATION_AMOUNT")
	private BigDecimal reservationAmount;
	
	@OneToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "ACQUIRER_ORDER_ID" , nullable = true)
	private AcquirerOrder acquirerOrder;
	
	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "ACCOUNT_ID" , nullable = false)
	private Account account;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getReservationAmount() {
		return reservationAmount;
	}

	public void setReservationAmount(BigDecimal reservationAmount) {
		this.reservationAmount = reservationAmount;
	}

	public AcquirerOrder getAcquirerOrder() {
		return acquirerOrder;
	}

	public void setAcquirerOrder(AcquirerOrder acquirerOrder) {
		this.acquirerOrder = acquirerOrder;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public AcquirerOrderReservation(Long id, BigDecimal reservationAmount, AcquirerOrder acquirerOrder,
			Account account) {
		super();
		this.id = id;
		this.reservationAmount = reservationAmount;
		this.acquirerOrder = acquirerOrder;
		this.account = account;
	}

	public AcquirerOrderReservation() {
		super();
	}
	
	
	

	
	
}
