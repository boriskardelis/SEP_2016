package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ftn.uns.ac.rs.tim6.model.Account;
import ftn.uns.ac.rs.tim6.repository.AccountRepository;

@Service
@Transactional
public class AccountService implements GenericService<Account> {
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<Account> getAll() {
		return accountRepository.findAll();
	}
	
	@Override
	public Account save(Account t) {
		return accountRepository.save(t);
	}

	@Override
	public Account findById(long id) {
		return accountRepository.findOne(id);
	}

}
