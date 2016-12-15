package ftn.uns.ac.rs.tim6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.ac.rs.tim6.model.ResponseMessage;
import ftn.uns.ac.rs.tim6.service.ResponseMessageService;

@RestController
@RequestMapping("/api")
public class ResponseMessageController {
	
	@Autowired
	ResponseMessageService responseMessageService;
	
@RequestMapping(value = "/responsemessages", method = RequestMethod.GET)
	
	public ResponseEntity<List<ResponseMessage>> handleGetAllResponseMessages() {
		List<ResponseMessage> responsemessages = (List<ResponseMessage>) responseMessageService.getAll();
		return new ResponseEntity<List<ResponseMessage>>(responsemessages, HttpStatus.OK);
	}

}
