package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ftn.uns.ac.rs.tim6.model.AcquirerOrderReservation;
import ftn.uns.ac.rs.tim6.repository.AcquirerOrderReservationRepository;

@Service
@Transactional
public class AcquirerOrderReservationService implements GenericService<AcquirerOrderReservation> {
	
	@Autowired
	private AcquirerOrderReservationRepository acquirerOrderReservationRepository;

	@Override
	public List<AcquirerOrderReservation> getAll() {
		return acquirerOrderReservationRepository.findAll();
	}
	
	@Override
	public AcquirerOrderReservation save(AcquirerOrderReservation t) {
		return acquirerOrderReservationRepository.save(t);
	}

	@Override
	public AcquirerOrderReservation findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}