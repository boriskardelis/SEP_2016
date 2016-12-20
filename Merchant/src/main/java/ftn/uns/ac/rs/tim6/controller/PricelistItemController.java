package ftn.uns.ac.rs.tim6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.ac.rs.tim6.model.PricelistItem;
import ftn.uns.ac.rs.tim6.service.PricelistItemService;



@RestController
@RequestMapping("/api")
public class PricelistItemController {
	
	@Autowired
	PricelistItemService pricelistItemService;
	
	@RequestMapping(value = "pricelistItems", method = RequestMethod.GET)
	public ResponseEntity<List<PricelistItem>> getAllPricelistItems(){
		List<PricelistItem> pricelistItems = (List<PricelistItem>) pricelistItemService.getAll();
		return new ResponseEntity<List<PricelistItem>>(pricelistItems, HttpStatus.OK);
	}
}
