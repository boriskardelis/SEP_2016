package ftn.uns.ac.rs.tim6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

	@RequestMapping(value = "/issuermessage", method = RequestMethod.POST)
	public ResponseEntity<String> handleIncomingMessage(@RequestBody String incomingMessage) {

		// TODO korak 10
		RestTemplate client = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		String url = "";

		try {

			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<String>(url, headers);
			//TODO korak 10.1 na frontend banke?
			url = client.postForObject("http://localhost:8080/api/nesto", entity, String.class); 
			return new ResponseEntity<String>(url, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(url, HttpStatus.BAD_REQUEST);
		}
	}

}