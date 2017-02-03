package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.uns.ac.rs.tim6.model.Pricelist;
import ftn.uns.ac.rs.tim6.model.RiskSubcategory;
import ftn.uns.ac.rs.tim6.repository.RiskSubcategoryRepository;

@Service
@Transactional
public class RiskSubcategoryService implements GenericService<RiskSubcategory> {

	@Autowired
	private RiskSubcategoryRepository riskSubcategoryRepository;

	public List<RiskSubcategory> getAll() {
		return riskSubcategoryRepository.findAll();
	}

	@Override
	public RiskSubcategory save(RiskSubcategory t) {
		return riskSubcategoryRepository.save(t);
	}

	@Override
	public RiskSubcategory findById(long id) {
		return riskSubcategoryRepository.findOne(id);
	}

	public List<RiskSubcategory> findSubcategoriesByLanguage(String language, Pricelist p) {
		return riskSubcategoryRepository.findSubcategoriesByLanguage(language, p);
	}

}
