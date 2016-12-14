package ftn.uns.ac.rs.tim6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ftn.uns.ac.rs.tim6.model.PaymentRequest;
import ftn.uns.ac.rs.tim6.service.PaymentRequestService;

@RestController
@RequestMapping("/api")
public class PaymentRequestController {
	@Autowired
	PaymentRequestService paymentRequestService;
	
	@RequestMapping(value = "/paymentrequests", method = RequestMethod.GET)
	
	public ResponseEntity<List<PaymentRequest>> handleGetAllPaymentRequests() {
		List<PaymentRequest> paymentRequests = (List<PaymentRequest>) paymentRequestService.getAll();
		return new ResponseEntity<List<PaymentRequest>>(paymentRequests, HttpStatus.OK);
	}

}
