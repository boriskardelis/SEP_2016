package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.uns.ac.rs.tim6.model.Pricelist;
import ftn.uns.ac.rs.tim6.repository.PricelistRepository;


@Service
@Transactional
public class PricelistService implements GenericService<Pricelist>{
	
	@Autowired
	private PricelistRepository pricelistRepository;

	public List<Pricelist> getAll() {
		return pricelistRepository.findAll();
	}

	@Override
	public Pricelist save(Pricelist t) {
		return pricelistRepository.save(t);
	}

	@Override
	public Pricelist findById(long id) {
		return pricelistRepository.findOne(id);
	}

}
