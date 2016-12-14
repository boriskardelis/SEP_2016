package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.uns.ac.rs.tim6.model.PaymentUrlAndId;
import ftn.uns.ac.rs.tim6.repository.PaymentUrlAndIdRepository;

@Service
@Transactional
public class PaymentUrlAndIdService implements GenericService<PaymentUrlAndId>{
	
	@Autowired
	private PaymentUrlAndIdRepository paymentUrlAndIdRepository;

	@Override
	public List<PaymentUrlAndId> getAll() {
		return paymentUrlAndIdRepository.findAll();
	}
	
	@Override
	public PaymentUrlAndId save(PaymentUrlAndId t) {
		return paymentUrlAndIdRepository.save(t);
	}

	@Override
	public PaymentUrlAndId findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
