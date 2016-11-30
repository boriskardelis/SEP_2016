package ftn.uns.ac.rs.tim6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.uns.ac.rs.tim6.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>  {

}
