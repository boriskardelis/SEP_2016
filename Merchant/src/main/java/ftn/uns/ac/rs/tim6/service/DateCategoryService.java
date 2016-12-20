package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.uns.ac.rs.tim6.model.Pricelist;
import ftn.uns.ac.rs.tim6.repository.DateCategoryRepository;

@Service
@Transactional
public class DateCategoryService implements GenericService<Pricelist>{
	
	@Autowired
	private DateCategoryRepository dateCategoryRepository;

	public List<Pricelist> getAll() {
		return dateCategoryRepository.findAll();
	}

	@Override
	public Pricelist save(Pricelist t) {
		return dateCategoryRepository.save(t);
	}

	@Override
	public Pricelist findById(long id) {
		return dateCategoryRepository.findOne(id);
	}

}
