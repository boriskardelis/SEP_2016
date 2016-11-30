package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.uns.ac.rs.tim6.model.HomeRiskType;
import ftn.uns.ac.rs.tim6.repository.HomeRiskTypeRepository;

@Service
@Transactional
public class HomeRiskTypeService implements GenericService<HomeRiskType> {

	@Autowired
	private HomeRiskTypeRepository homeRiskTypeRepository;

	@Override
	public List<HomeRiskType> getAll() {
		// TODO Auto-generated method stub
		return homeRiskTypeRepository.findAll();
	}

	@Override
	public HomeRiskType save(HomeRiskType t) {
		// TODO Auto-generated method stub
		return null;
	}
}
