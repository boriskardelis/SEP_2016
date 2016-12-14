package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.uns.ac.rs.tim6.model.IssuerMessage;
import ftn.uns.ac.rs.tim6.repository.IssuerMessageRepository;

@Service
@Transactional
public class IssuerMessageService implements GenericService<IssuerMessage> {
	
	@Autowired
	private IssuerMessageRepository issuerMessageRepository;

	@Override
	public List<IssuerMessage> getAll() {
		return issuerMessageRepository.findAll();
	}
	
	@Override
	public IssuerMessage save(IssuerMessage t) {
		return issuerMessageRepository.save(t);
	}

	@Override
	public IssuerMessage findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
