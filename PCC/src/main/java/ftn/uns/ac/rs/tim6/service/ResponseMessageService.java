package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.uns.ac.rs.tim6.model.ResponseMessage;
import ftn.uns.ac.rs.tim6.repository.ResponseMessageRepository;

@Service
@Transactional
public class ResponseMessageService implements GenericService<ResponseMessage>{
	
	@Autowired
	private ResponseMessageRepository responseMessageRepository;

	@Override
	public List<ResponseMessage> getAll() {
		return responseMessageRepository.findAll();
	}

	@Override
	public ResponseMessage save(ResponseMessage t) {
		return responseMessageRepository.save(t);
	}

	@Override
	public ResponseMessage findById(long id) {
		return responseMessageRepository.getOne(id);
	}

}
