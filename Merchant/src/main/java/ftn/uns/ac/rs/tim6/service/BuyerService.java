package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.uns.ac.rs.tim6.model.Buyer;
import ftn.uns.ac.rs.tim6.repository.BuyerRepository;

@Service
@Transactional
public class BuyerService implements GenericService<Buyer> {


	@Autowired
	private BuyerRepository buyerRepository;

	@Override
	public List<Buyer> getAll() {
		return buyerRepository.findAll();
	}

	@Override
	public Buyer save(Buyer t) {
		return buyerRepository.save(t);
	}

	@Override
	public Buyer findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
