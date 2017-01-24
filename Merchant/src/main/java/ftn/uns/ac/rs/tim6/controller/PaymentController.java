package ftn.uns.ac.rs.tim6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ftn.uns.ac.rs.tim6.dto.ResponseMessageDto;
import ftn.uns.ac.rs.tim6.dto.ResponseMessageDto.TransactionResult;
import ftn.uns.ac.rs.tim6.dto.URLDto;
import ftn.uns.ac.rs.tim6.model.Payment;
import ftn.uns.ac.rs.tim6.service.PaymentService;

@RestController
@RequestMapping("/api")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@RequestMapping(value = "/payments", method = RequestMethod.GET)
	public ResponseEntity<List<Payment>> handleGetAllPayments() {
		List<Payment> payments = (List<Payment>) paymentService.getAll();
		return new ResponseEntity<List<Payment>>(payments, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/incomingresult", method = RequestMethod.POST)
	public ResponseEntity<URLDto> handleIncomingMessage(@RequestBody ResponseMessageDto rmdto) {
		
		URLDto urldto = new URLDto();
		
		System.out.println("Usao u MERCHANT za URL");
		System.out.println(rmdto.getResult().toString());
		
		//TODO korak 11

		TransactionResult rezultat = rmdto.getResult();
		
		if ( rezultat.equals(TransactionResult.SUCCESSFUL) ) {
			urldto.setUrl("http://localhost:7070/paymentSuccessful");
			urldto.setMessage("Your payment hes been successfull");
		} else if (rezultat.equals(TransactionResult.CVC_INVALID)) {
			urldto.setUrl("http://localhost:7070/paymentError");
			urldto.setMessage("Your CVC is invalid");
		} else if (rezultat.equals(TransactionResult.INSUFFICIENT_FUNDS)) {
			urldto.setUrl("http://localhost:7070/paymentError");
			urldto.setMessage("Insufficient funds");
		} else if (rezultat.equals(TransactionResult.INVALID_DATE)) {
			urldto.setUrl("http://localhost:7070/paymentError");
			urldto.setMessage("Your card date is not valid");
		} 
		
		return new ResponseEntity<URLDto>(urldto, HttpStatus.OK);
	}

}
