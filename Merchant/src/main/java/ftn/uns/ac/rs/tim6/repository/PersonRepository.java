package ftn.uns.ac.rs.tim6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.uns.ac.rs.tim6.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
