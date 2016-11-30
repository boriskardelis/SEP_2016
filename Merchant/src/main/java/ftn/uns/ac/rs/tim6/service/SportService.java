package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.uns.ac.rs.tim6.model.Sport;
import ftn.uns.ac.rs.tim6.repository.SportRepository;

@Service
@Transactional
public class SportService implements GenericService<Sport>{

	@Autowired
	private SportRepository sportRepository;

	@Override
	public List<Sport> getAll() {
		// TODO Auto-generated method stub
		return sportRepository.findAll();
	}

	@Override
	public Sport save(Sport t) {
		// TODO Auto-generated method stub
		return sportRepository.save(t);
	}
	
	
}
