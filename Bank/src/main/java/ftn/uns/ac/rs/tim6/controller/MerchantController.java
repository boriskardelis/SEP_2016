package ftn.uns.ac.rs.tim6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ftn.uns.ac.rs.tim6.model.Merchant;
import ftn.uns.ac.rs.tim6.service.MerchantService;

@RestController
@RequestMapping("/api")
public class MerchantController {
	
	@Autowired
	MerchantService merchantService;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	
	public ResponseEntity<List<Merchant>> handleGetAllUsers() {
		List<Merchant> merchants = (List<Merchant>) merchantService.getAll();
		return new ResponseEntity<List<Merchant>>(merchants, HttpStatus.OK);
	}


}
