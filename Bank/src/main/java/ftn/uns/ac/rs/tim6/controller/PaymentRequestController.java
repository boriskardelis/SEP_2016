package ftn.uns.ac.rs.tim6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ftn.uns.ac.rs.tim6.dto.AmountDto;
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

	@RequestMapping(value = "/payment/{id}", method = RequestMethod.GET)
	public ResponseEntity<AmountDto> handleGetPaymentAmmount(@PathVariable("id") Long id) {

		System.out.println("PRINT ID");
		System.out.println(id);
		// long idLong = Long.parseLong(id);
		AmountDto adto = new AmountDto();
		PaymentRequest paymentRequest = paymentRequestService.findByPaymentId(id);
		adto.setAmount(paymentRequest.getAmount());

		return new ResponseEntity<AmountDto>(adto, HttpStatus.OK);
	}

}
