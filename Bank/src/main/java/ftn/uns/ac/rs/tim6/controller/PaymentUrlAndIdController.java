package ftn.uns.ac.rs.tim6.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.ac.rs.tim6.dto.PaymentUrlIdDto;
import ftn.uns.ac.rs.tim6.model.PaymentUrlAndId;
import ftn.uns.ac.rs.tim6.service.PaymentUrlAndIdService;


@RestController
@RequestMapping("/api")
public class PaymentUrlAndIdController {
	@Autowired
	PaymentUrlAndIdService paymentUrlAndRequestService;
	
	@RequestMapping(value = "/paymenturlandids", method = RequestMethod.GET)
	public ResponseEntity<List<PaymentUrlAndId>> handleGetAllPaPaymentUrlAndIds() {
		List<PaymentUrlAndId> PaymentUrlAndIds = (List<PaymentUrlAndId>) paymentUrlAndRequestService.getAll();
		return new ResponseEntity<List<PaymentUrlAndId>>(PaymentUrlAndIds, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/urlid", method = RequestMethod.POST)
	public String handleBuy(@RequestBody String suma) throws IOException {

		System.out.println("suma u BANCI!!! : " + suma);
		PaymentUrlIdDto puid = new PaymentUrlIdDto();
		
		
		return suma;
	}
	
}
