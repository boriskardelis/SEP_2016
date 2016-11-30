package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.uns.ac.rs.tim6.model.Home;
import ftn.uns.ac.rs.tim6.repository.HomeRepository;

@Service
@Transactional
public class HomeService implements GenericService<Home>{

	@Autowired
	private HomeRepository homeRepository;

	@Override
	public List<Home> getAll() {
		// TODO Auto-generated method stub
		return homeRepository.findAll();
	}

	@Override
	public Home save(Home t) {
		// TODO Auto-generated method stub
		return homeRepository.save(t);
	}
	
	
}
