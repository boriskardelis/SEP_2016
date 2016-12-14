package ftn.uns.ac.rs.tim6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ftn.uns.ac.rs.tim6.model.Account;
import ftn.uns.ac.rs.tim6.service.AccountService;


@RestController
@RequestMapping("/api")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping(value = "/accounts", method = RequestMethod.GET)
	
	public ResponseEntity<List<Account>> handleGetAllAccounts() {
		List<Account> accounts = (List<Account>) accountService.getAll();
		return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
	}

}
