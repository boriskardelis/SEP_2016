package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ftn.uns.ac.rs.tim6.model.Merchant;
import ftn.uns.ac.rs.tim6.repository.MerchantRepository;

@Service
@Transactional
public class MerchantService implements GenericService<Merchant> {
	
	@Autowired
	private MerchantRepository merchantRepository;

	@Override
	public List<Merchant> getAll() {
		return merchantRepository.findAll();
	}
	
	@Override
	public Merchant save(Merchant t) {
		return merchantRepository.save(t);
	}

	@Override
	public Merchant findById(long id) {
		return merchantRepository.findOne(id);
	}


}
