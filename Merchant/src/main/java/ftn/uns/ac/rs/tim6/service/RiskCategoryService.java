package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ftn.uns.ac.rs.tim6.model.RiskCategory;
import ftn.uns.ac.rs.tim6.repository.RiskCategoryRepository;

public class RiskCategoryService implements GenericService<RiskCategory>{

	@Autowired
	private RiskCategoryRepository riskCategoryRepository;
	
	public List<RiskCategory> getAll() {
		return riskCategoryRepository.findAll();
	}

	@Override
	public RiskCategory save(RiskCategory t) {
		return riskCategoryRepository.save(t);
	}

}
