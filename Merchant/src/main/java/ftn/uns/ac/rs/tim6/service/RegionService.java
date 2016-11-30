package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.uns.ac.rs.tim6.model.Region;
import ftn.uns.ac.rs.tim6.repository.RegionRepository;

@Service
@Transactional
public class RegionService implements GenericService<Region> {

	@Autowired
	private RegionRepository regionRepository;

	@Override
	public List<Region> getAll() {
		// TODO Auto-generated method stub
		return regionRepository.findAll();
	}

	@Override
	public Region save(Region t) {
		// TODO Auto-generated method stub
		return null;
	};
	
	
}
