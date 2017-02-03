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
		return paymentRepository.findAll();
	}

	@Override
	public Payment save(Payment t) {
		return paymentRepository.save(t);
	}

	@Override
	public Payment findById(long id) {
		return paymentRepository.findOne(id);
	}

	public Payment findByPaymentId(Integer paymentId) {
		List<Payment> payments = paymentRepository.findAll();
		for (Payment payment : payments) {
			if (payment.getPaymentId().intValue() == paymentId.intValue()) {
				System.out.println("Nasao je paymentID i to je: " + payment.getPaymentId());
				return payment;
			}
		}
		System.out.println("Nije nasao paymentID");
		return null;
	}

}
