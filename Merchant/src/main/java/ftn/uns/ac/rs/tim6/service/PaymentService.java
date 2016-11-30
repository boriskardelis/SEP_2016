package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.uns.ac.rs.tim6.model.Payment;
import ftn.uns.ac.rs.tim6.repository.PaymentRepository;

@Service
@Transactional
public class PaymentService implements GenericService<Payment> {

	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public List<Payment> getAll() {
		// TODO Auto-generated method stub
		return paymentRepository.findAll();
	}

	@Override
	public Payment save(Payment t) {
		// TODO Auto-generated method stub
		return paymentRepository.save(t);
	}
	
	
}
