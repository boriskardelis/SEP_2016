package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ftn.uns.ac.rs.tim6.model.InsuranceType;
import ftn.uns.ac.rs.tim6.repository.InsuranceTypeRepository;

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

}
