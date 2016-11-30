
package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.uns.ac.rs.tim6.model.Age;
import ftn.uns.ac.rs.tim6.repository.AgeRepository;

@Service
@Transactional
public class AgeService implements GenericService<Age>{
	
	@Autowired
	private AgeRepository ageRepository;

	@Override
	public List<Age> getAll() {
		System.out.println("PROLAZI KROZ METODE");
		return ageRepository.findAll();
	}

	@Override
	public Age save(Age t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

