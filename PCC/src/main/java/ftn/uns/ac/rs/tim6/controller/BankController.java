package ftn.uns.ac.rs.tim6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.ac.rs.tim6.model.Bank;
import ftn.uns.ac.rs.tim6.service.BankService;

@RestController
@RequestMapping("/api")
public class BankController {
	
	@Autowired
	BankService bankService;
	
@RequestMapping(value = "/banks", method = RequestMethod.GET)
	
	public ResponseEntity<List<Bank>> handleGetAllBanks() {
		List<Bank> banks = (List<Bank>) bankService.getAll();
		return new ResponseEntity<List<Bank>>(banks, HttpStatus.OK);
	}

}
