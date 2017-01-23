package ftn.uns.ac.rs.tim6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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

/*	@RequestMapping(value = "/response", method = RequestMethod.POST)
	public void handleIncomingMessage(@RequestBody ResponseMessageDto rmdto) {

		// korak 9
		RestTemplate client = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

		try {

			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<ResponseMessageDto> entity = new HttpEntity<ResponseMessageDto>(rmdto, headers);
			client.postForObject("http://localhost:7070/api/issuermessage", entity, String.class);
			return;

		} catch (Exception e) {
			return;
		}
	}*/

}
