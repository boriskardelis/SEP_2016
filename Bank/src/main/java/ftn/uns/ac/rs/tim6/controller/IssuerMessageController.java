package ftn.uns.ac.rs.tim6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ftn.uns.ac.rs.tim6.model.IssuerMessage;
import ftn.uns.ac.rs.tim6.service.IssuerMessageService;

@RestController
@RequestMapping("/api")
public class IssuerMessageController {

	@Autowired
	IssuerMessageService issuerMessageService;

	@RequestMapping(value = "/issuermessages", method = RequestMethod.GET)

	public ResponseEntity<List<IssuerMessage>> handleGetAllIssuerMessages() {
		List<IssuerMessage> issuerMessages = (List<IssuerMessage>) issuerMessageService.getAll();
		return new ResponseEntity<List<IssuerMessage>>(issuerMessages, HttpStatus.OK);
	}

}