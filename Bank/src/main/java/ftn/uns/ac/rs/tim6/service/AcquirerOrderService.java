package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ftn.uns.ac.rs.tim6.model.AcquirerOrder;
import ftn.uns.ac.rs.tim6.repository.AcquirerOrderRepository;

@Service
@Transactional
public class AcquirerOrderService implements GenericService<AcquirerOrder> {
	
	@Autowired
	private AcquirerOrderRepository acquirerOrderRepository;

	@Override
	public List<AcquirerOrder> getAll() {
		return acquirerOrderRepository.findAll();
	}
	
	@Override
	public AcquirerOrder save(AcquirerOrder t) {
		return acquirerOrderRepository.save(t);
	}

	@Override
	public AcquirerOrder findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
