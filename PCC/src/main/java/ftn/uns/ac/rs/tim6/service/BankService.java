package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.uns.ac.rs.tim6.model.Bank;
import ftn.uns.ac.rs.tim6.repository.BankRepository;

@Service
@Transactional
public class BankService implements GenericService<Bank>  {
	
	@Autowired
	private BankRepository bankRepository;

	@Override
	public List<Bank> getAll() {
		return bankRepository.findAll();
	}

	@Override
	public Bank save(Bank t) {
		return bankRepository.save(t);
	}

	@Override
	public Bank findById(long id) {
		return bankRepository.findOne(id);
	}

}
