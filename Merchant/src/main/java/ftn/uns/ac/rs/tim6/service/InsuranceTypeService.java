package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.uns.ac.rs.tim6.model.InsuranceType;
import ftn.uns.ac.rs.tim6.repository.InsuranceTypeRepository;
@Service
@Transactional
public class InsuranceTypeService implements GenericService<InsuranceType>{

	@Autowired
	private InsuranceTypeRepository insuranceTypeRepository;
		
	public List<InsuranceType> getAll() {
		return insuranceTypeRepository.findAll();
	}

	@Override
	public InsuranceType save(InsuranceType t) {
		return insuranceTypeRepository.save(t);
	}

	@Override
	public InsuranceType findById(long id) {
		return insuranceTypeRepository.findOne(id);
	}

}
