package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.uns.ac.rs.tim6.model.Insurance;
import ftn.uns.ac.rs.tim6.repository.InsuranceRepository;

@Service
@Transactional
public class InsuranceService implements GenericService<Insurance>{

	@Autowired
	private InsuranceRepository insuranceRepository;

	@Override
	public List<Insurance> getAll() {
		return insuranceRepository.findAll();
	}

	@Override
	public Insurance save(Insurance t) {
		return insuranceRepository.save(t);
	}

	@Override
	public Insurance findById(long id) {
		return insuranceRepository.findOne(id);
	}

	public Insurance findByPaymentId(Integer paymentId) {
		List<Insurance> insurances = insuranceRepository.findAll();
		for (Insurance i : insurances) {
			System.out.println(i.getStartDate());
			System.out.println(i.getPaymentId() + " == " + paymentId);
			if (i.getPaymentId().intValue() == paymentId.intValue()) {
				return i;
			}
		}
		return null;
	}
	
	
}
