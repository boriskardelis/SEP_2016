package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ftn.uns.ac.rs.tim6.model.PaymentRequest;
import ftn.uns.ac.rs.tim6.repository.PaymentRequestRepository;

@Service
@Transactional
public class PaymentRequestService implements GenericService<PaymentRequest> {
	
	@Autowired
	private PaymentRequestRepository paymentRequesteRepository;

	@Override
	public List<PaymentRequest> getAll() {
		return paymentRequesteRepository.findAll();
	}
	
	@Override
	public PaymentRequest save(PaymentRequest t) {
		return paymentRequesteRepository.save(t);
	}

	@Override
	public PaymentRequest findById(long id) {
		return paymentRequesteRepository.findOne(id);
	}
	

}
