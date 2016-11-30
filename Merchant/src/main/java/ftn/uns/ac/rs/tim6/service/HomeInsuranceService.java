package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.uns.ac.rs.tim6.model.HomeInsurance;
import ftn.uns.ac.rs.tim6.repository.HomeInsuranceRepository;

@Service
@Transactional
public class HomeInsuranceService implements GenericService<HomeInsurance>{

	@Autowired
	private HomeInsuranceRepository homeInsuranceRepository;

	@Override
	public List<HomeInsurance> getAll() {
		// TODO Auto-generated method stub
		return homeInsuranceRepository.findAll();
	}

	@Override
	public HomeInsurance save(HomeInsurance t) {
		// TODO Auto-generated method stub
		return homeInsuranceRepository.save(t);
	}
	
	
}
