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

import ftn.uns.ac.rs.tim6.dto.AcquirerOrderDto;
import ftn.uns.ac.rs.tim6.model.ResponseMessage;
import ftn.uns.ac.rs.tim6.service.BankService;
import ftn.uns.ac.rs.tim6.service.ResponseMessageService;

@RestController
@RequestMapping("/api")
public class ResponseMessageController {

	@Autowired
	ResponseMessageService responseMessageService;

	@Autowired
	BankService bankService;

	@RequestMapping(value = "/responsemessages", method = RequestMethod.GET)
	public ResponseEntity<List<ResponseMessage>> handleGetAllResponseMessages() {
		List<ResponseMessage> responsemessages = (List<ResponseMessage>) responseMessageService.getAll();
		return new ResponseEntity<List<ResponseMessage>>(responsemessages, HttpStatus.OK);
	}

	@RequestMapping(value = "/response", method = RequestMethod.POST)
	public ResponseEntity<String> handleIncomingMessage(@RequestBody AcquirerOrderDto incomingMessage) {

		// TODO korak 9

		ResponseMessage response = new ResponseMessage();
		RestTemplate client = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		String url = "";

		try {

			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<ResponseMessage> entity = new HttpEntity<ResponseMessage>(response, headers);
			url = client.postForObject("http://localhost:7070/api/issuermessage", entity, String.class);
			return new ResponseEntity<String>(url, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(url, HttpStatus.BAD_REQUEST);
		}
	}

}
