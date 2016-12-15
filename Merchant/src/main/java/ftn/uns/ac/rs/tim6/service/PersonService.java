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
		return personRepository.findAll();
	}

	@Override
	public Person save(Person t) {
		return personRepository.save(t);
	}

	@Override
	public Person findById(long id) {
		return personRepository.findOne(id);
	};
}
