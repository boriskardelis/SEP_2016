package ftn.uns.ac.rs.tim6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
	
/*	@RequestMapping(value = "/paymentresult", method = RequestMethod.POST)
	public void handleIncomingMessage(@RequestBody String result) {

		// korak 11
		// primiti pravilan format poslati pravilan format
		RestTemplate client = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		
		
		try {

			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<String>("objekat koji saljem", headers);
			//korak 10.1 na frontend banke?
			client.postForObject("http://localhost:8080/api/paymentresult", entity, String.class); 
			return;

		} catch (Exception e) {
			return;
		}
	}*/

}
