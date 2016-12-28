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

import ftn.uns.ac.rs.tim6.dto.IncomingAcquirerOrderMessageDto;
import ftn.uns.ac.rs.tim6.model.Bank;
import ftn.uns.ac.rs.tim6.model.IncomingMessage;
import ftn.uns.ac.rs.tim6.model.ResponseMessage;
import ftn.uns.ac.rs.tim6.service.BankService;
import ftn.uns.ac.rs.tim6.service.IncomingMessageService;

@RestController
@RequestMapping("/api")
public class IncomingMessageController {

	@Autowired
	IncomingMessageService incomingMessageService;

	@Autowired
	BankService bankService;

	@RequestMapping(value = "/incomingmessages", method = RequestMethod.GET)

	public ResponseEntity<List<IncomingMessage>> handleGetAllIncomingMessages() {
		List<IncomingMessage> incomingmessages = (List<IncomingMessage>) incomingMessageService.getAll();
		return new ResponseEntity<List<IncomingMessage>>(incomingmessages, HttpStatus.OK);
	}

	@RequestMapping(value = "/incomingacquirerorder", method = RequestMethod.POST)
	public ResponseEntity<String> handleIncomingMessage(@RequestBody IncomingAcquirerOrderMessageDto incomingMessage) {
		
		Bank bank = findBankByPan(incomingMessage.getPan());

		// TODO korak 7 nadjemo banku preko PAN-a
		// 7.1 OVO NECE RADITI mapirati pristiglu poruku na ovu sto nam treba

		ResponseMessage response = new ResponseMessage();
		RestTemplate client = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		String url = "";

		try {

			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<ResponseMessage> entity = new HttpEntity<ResponseMessage>(response, headers);
			url = client.postForObject("http://localhost:" + bank.getPort() + "/api/reservation", entity, String.class);
			return new ResponseEntity<String>(url, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(url, HttpStatus.BAD_REQUEST);
		}
	}

	private Bank findBankByPan(Long pan) {
		// TODO korak 7.3 iz pan-a kartice odrediti pan banke, i prosledi banku
		// A BBBBB CCCCCCCCCCCC D
		return null;
	}

}
