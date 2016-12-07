package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ftn.uns.ac.rs.tim6.model.DateCategory;
import ftn.uns.ac.rs.tim6.repository.DateCategoryRepository;

public class DateCategoryService implements GenericService<DateCategory>{
	
	@Autowired
	private DateCategoryRepository dateCategoryRepository;

	public List<DateCategory> getAll() {
		return dateCategoryRepository.findAll();
	}

	@Override
	public DateCategory save(DateCategory t) {
		return dateCategoryRepository.save(t);
	}

}
