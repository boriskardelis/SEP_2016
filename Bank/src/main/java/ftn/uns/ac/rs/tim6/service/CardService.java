package ftn.uns.ac.rs.tim6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ftn.uns.ac.rs.tim6.model.Card;
import ftn.uns.ac.rs.tim6.repository.CardRepository;

@Service
@Transactional
public class CardService implements GenericService<Card>{
	
	@Autowired
	private CardRepository cardRepository;

	@Override
	public List<Card> getAll() {
		return cardRepository.findAll();
	}
	
	@Override
	public Card save(Card t) {
		return cardRepository.save(t);
	}

	@Override
	public Card findById(long id) {
		return cardRepository.findOne(id);
	}
}
