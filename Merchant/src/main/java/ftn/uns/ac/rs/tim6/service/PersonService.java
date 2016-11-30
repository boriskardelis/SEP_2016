package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.uns.ac.rs.tim6.model.Person;
import ftn.uns.ac.rs.tim6.repository.PersonRepository;

@Service
@Transactional
public class PersonService implements GenericService<Person>{

	@Autowired
	private PersonRepository personRepository;

	@Override
	public List<Person> getAll() {
		// TODO Auto-generated method stub
		return personRepository.findAll();
	}

	@Override
	public Person save(Person t) {
		// TODO Auto-generated method stub
		return null;
	};
	
	
}
