package ftn.uns.ac.rs.tim6.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.ac.rs.tim6.model.IncomingMessage;
import ftn.uns.ac.rs.tim6.service.IncomingMessageService;

@RestController
@RequestMapping("/api")
public class IncomingMessageController {

	@Autowired
	IncomingMessageService incomingMessageService;

	@RequestMapping(value = "/incomingmessages", method = RequestMethod.GET)

	public ResponseEntity<List<IncomingMessage>> handleGetAllIncomingMessages() {
		List<IncomingMessage> incomingmessages = (List<IncomingMessage>) incomingMessageService.getAll();
		return new ResponseEntity<List<IncomingMessage>>(incomingmessages, HttpStatus.OK);
	}

	@RequestMapping(value = "/incomingmessage", method = RequestMethod.POST)
	public String handleBuy(@RequestBody String testString) {
		System.out.println("U PCC-u " + testString);
		return "Vratili se iz PCC-a";
	}

}
