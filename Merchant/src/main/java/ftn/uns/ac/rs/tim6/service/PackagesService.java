package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.uns.ac.rs.tim6.model.Packages;
import ftn.uns.ac.rs.tim6.repository.PackagesRepository;

@Service
@Transactional
public class PackagesService implements GenericService<Packages> {

	@Autowired
	private PackagesRepository packagesRepository;

	@Override
	public List<Packages> getAll() {
		// TODO Auto-generated method stub
		return packagesRepository.findAll();
	}

	@Override
	public Packages save(Packages t) {
		// TODO Auto-generated method stub
		return packagesRepository.save(t);
	}
	
	
}
