package ftn.uns.ac.rs.tim6.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.ac.rs.tim6.dto.MerchantDto;
import ftn.uns.ac.rs.tim6.dto.PaymentUrlIdDto;
import ftn.uns.ac.rs.tim6.dto.ResponseMessageDto;
import ftn.uns.ac.rs.tim6.dto.ResponseMessageDto.TransactionResult;
import ftn.uns.ac.rs.tim6.dto.URLDto;
import ftn.uns.ac.rs.tim6.model.Payment;
import ftn.uns.ac.rs.tim6.model.Payment.Status;
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
		
		
		Payment p = new Payment();
		
		System.out.println("paymentID:" + rmdto.getPaymentId());
		p.setPaymentId(rmdto.getPaymentId());
		
		
		
		
		if ( rezultat.equals(TransactionResult.SUCCESSFUL) ) {
			urldto.setUrl("http://localhost:8080/paymentSuccessful?paymentId=" + rmdto.getPaymentId());
			urldto.setMessage("Your payment hes been successfull");
			p.setPaymentStatus(Status.SUCCESSFUL);
		} else if (rezultat.equals(TransactionResult.CVC_INVALID)) {
			urldto.setUrl("http://localhost:8080/paymentError");
			urldto.setMessage("Your CVC is invalid");
		} else if (rezultat.equals(TransactionResult.INSUFFICIENT_FUNDS)) {
			urldto.setUrl("http://localhost:8080/paymentError");
			urldto.setMessage("Insufficient funds");
		} else if (rezultat.equals(TransactionResult.INVALID_DATE)) {
			urldto.setUrl("http://localhost:8080/paymentError");
			urldto.setMessage("Your card date is not valid");
		} 
		
		p.setPaymentMessage(urldto.getMessage());
		paymentService.save(p);
		
		return new ResponseEntity<URLDto>(urldto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/paymentMessage", method = RequestMethod.POST)
	public ResponseEntity<URLDto> handlePaymentID(@RequestBody Long paymentId) {
		
		Payment p = paymentService.findByPaymentId(paymentId);
		URLDto urldto = new URLDto();
		
		urldto.setMessage(p.getPaymentMessage());
		urldto.setStatus(p.getPaymentStatus());	
		
		return new ResponseEntity<URLDto>(urldto, HttpStatus.OK);
	}
	
	

}
