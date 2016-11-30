package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.uns.ac.rs.tim6.model.Car;
import ftn.uns.ac.rs.tim6.repository.CarRepository;

@Service
@Transactional
public class CarService implements GenericService<Car>{
	
	@Autowired
	private CarRepository carRepository;

	@Override
	public List<Car> getAll() {
		// TODO Auto-generated method stub
		return carRepository.findAll();
	}

	@Override
	public Car save(Car t) {
		// TODO Auto-generated method stub
		return null;
	}

}
