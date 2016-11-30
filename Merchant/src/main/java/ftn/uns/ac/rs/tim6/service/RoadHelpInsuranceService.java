package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.uns.ac.rs.tim6.model.RoadHelpInsurance;
import ftn.uns.ac.rs.tim6.repository.RoadHelpInsuranceRepository;

@Service
@Transactional
public class RoadHelpInsuranceService implements GenericService<RoadHelpInsurance> {

	@Autowired
	private RoadHelpInsuranceRepository roadHelpInsuranceRepository;

	@Override
	public List<RoadHelpInsurance> getAll() {
		// TODO Auto-generated method stub
		return roadHelpInsuranceRepository.findAll();
	}

	@Override
	public RoadHelpInsurance save(RoadHelpInsurance t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
