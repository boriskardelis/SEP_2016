package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.uns.ac.rs.tim6.model.IncomingMessage;
import ftn.uns.ac.rs.tim6.repository.IncomingMessageRepository;

@Service
@Transactional
public class IncomingMessageService implements GenericService<IncomingMessage>{
	
	@Autowired
	private IncomingMessageRepository incomingMessageRepository;

	@Override
	public List<IncomingMessage> getAll() {
		return incomingMessageRepository.findAll();
	}

	@Override
	public IncomingMessage save(IncomingMessage t) {
		return incomingMessageRepository.save(t);
	}

	@Override
	public IncomingMessage findById(long id) {
		return incomingMessageRepository.getOne(id);
	}

}
