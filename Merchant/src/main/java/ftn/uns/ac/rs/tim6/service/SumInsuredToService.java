package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.uns.ac.rs.tim6.model.SumInsuredTo;
import ftn.uns.ac.rs.tim6.repository.SumInsuredToRepository;

@Service
@Transactional
public class SumInsuredToService implements GenericService<SumInsuredTo> {

	@Autowired
	private SumInsuredToRepository sumInsuredToRepository;

	@Override
	public List<SumInsuredTo> getAll() {
		// TODO Auto-generated method stub
		return sumInsuredToRepository.findAll();
	}

	@Override
	public SumInsuredTo save(SumInsuredTo t) {
		// TODO Auto-generated method stub
		return sumInsuredToRepository.save(t);
	}
	
	
}
