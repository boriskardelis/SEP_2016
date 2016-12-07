package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ftn.uns.ac.rs.tim6.model.RiskSubcategory;
import ftn.uns.ac.rs.tim6.repository.RiskSubcategoryRepository;

public class RiskSubcategoryService implements GenericService<RiskSubcategory>{
	
	@Autowired
	private RiskSubcategoryRepository riskSubcategoryRepository;

	public List<RiskSubcategory> getAll() {
		return riskSubcategoryRepository.findAll();
	}

	@Override
	public RiskSubcategory save(RiskSubcategory t) {
		return riskSubcategoryRepository.save(t);
	}

}
