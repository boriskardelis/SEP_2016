package ftn.uns.ac.rs.tim6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ftn.uns.ac.rs.tim6.model.Card;
import ftn.uns.ac.rs.tim6.service.CardService;

@RestController
@RequestMapping("/api")
public class CardController {
	
	@Autowired
	CardService cardService;
	
	@RequestMapping(value = "/cards", method = RequestMethod.GET)
	
	public ResponseEntity<List<Card>> handleGetAllCards() {
		List<Card> cards = (List<Card>) cardService.getAll();
		return new ResponseEntity<List<Card>>(cards, HttpStatus.OK);
	}

}
