package ftn.uns.ac.rs.tim6.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ftn.uns.ac.rs.tim6.model.NameTranslate;
import ftn.uns.ac.rs.tim6.repository.NameTranslateRepository;

@Service
@Transactional
public class NameTranslateService implements GenericService<NameTranslate> {

	@Autowired
	private NameTranslateRepository nameTranslateRepository;

	public List<NameTranslate> getAll() {
		return nameTranslateRepository.findAll();
	}

	@Override
	public NameTranslate save(NameTranslate t) {
		return nameTranslateRepository.save(t);
	}

	@Override
	public NameTranslate findById(long id) {
		return nameTranslateRepository.findOne(id);
	}

}