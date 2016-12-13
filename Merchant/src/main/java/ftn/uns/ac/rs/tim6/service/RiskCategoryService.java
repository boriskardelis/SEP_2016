package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.uns.ac.rs.tim6.model.RiskCategory;
import ftn.uns.ac.rs.tim6.repository.RiskCategoryRepository;
@Service
@Transactional
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

	@Override
	public RiskCategory findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
