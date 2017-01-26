package ftn.uns.ac.rs.tim6.service;

import java.util.ArrayList;
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
	private PaymentRequestRepository paymentRequestRepository;

	@Override
	public List<PaymentRequest> getAll() {
		return paymentRequestRepository.findAll();
	}

	@Override
	public PaymentRequest save(PaymentRequest t) {
		return paymentRequestRepository.save(t);
	}

	@Override
	public PaymentRequest findById(long id) {
		return paymentRequestRepository.findOne(id);
	}

	public PaymentRequest findByPaymentId(Integer id) {
		List<PaymentRequest> paymentRequestList = new ArrayList<PaymentRequest>();
		paymentRequestList = paymentRequestRepository.findAll();
		for (PaymentRequest paymentRequest : paymentRequestList) {
			if (paymentRequest.getPaymentUrlAndId().getPaymentId().intValue() == id.intValue()) {
				return paymentRequest;
			}
		}
		return null;

	}

}
