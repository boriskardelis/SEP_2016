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
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
