package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.uns.ac.rs.tim6.model.PricelistItem;
import ftn.uns.ac.rs.tim6.repository.PricelistItemRepository;


@Service
@Transactional
public class PricelistItemService implements GenericService<PricelistItem>{
	
	@Autowired
	private PricelistItemRepository pricelistItemRepository;

	public List<PricelistItem> getAll() {
		return pricelistItemRepository.findAll();
	}

	@Override
	public PricelistItem save(PricelistItem t) {
		return pricelistItemRepository.save(t);
	}

	@Override
	public PricelistItem findById(long id) {
		return pricelistItemRepository.findOne(id);
	}

}
