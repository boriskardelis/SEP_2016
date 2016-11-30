package ftn.uns.ac.rs.tim6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.uns.ac.rs.tim6.model.Car;

public interface CarRepository extends JpaRepository<Car, Long>  {

}
