package ftn.uns.ac.rs.tim6.controller;

import java.io.IOException;
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
import ftn.uns.ac.rs.tim6.model.PaymentRequest;
import ftn.uns.ac.rs.tim6.model.PaymentUrlAndId;
import ftn.uns.ac.rs.tim6.service.PaymentRequestService;
import ftn.uns.ac.rs.tim6.service.PaymentUrlAndIdService;

@RestController
@RequestMapping("/api")
public class PaymentUrlAndIdController {
	
	@Autowired
	PaymentUrlAndIdService paymentUrlAndRequestService;
	
	@Autowired
	PaymentRequestService paymentRequestService1;
	
	@Autowired
	PaymentUrlAndIdService paymentRequestService;

	@RequestMapping(value = "/paymenturlandids", method = RequestMethod.GET)
	public ResponseEntity<List<PaymentUrlAndId>> handleGetAllPaPaymentUrlAndIds() {
		List<PaymentUrlAndId> PaymentUrlAndIds = (List<PaymentUrlAndId>) paymentUrlAndRequestService.getAll();
		return new ResponseEntity<List<PaymentUrlAndId>>(PaymentUrlAndIds, HttpStatus.OK);
	}

	@RequestMapping(value = "/urlid", method = RequestMethod.POST)
	public PaymentUrlIdDto handleBuy(@RequestBody MerchantDto mdto) throws IOException {
		
		PaymentUrlIdDto puid = new PaymentUrlIdDto();
		Random randomGenerator = new Random();
		PaymentRequest paymentRequest = new PaymentRequest();
		
		puid.setPaymentId(paymentRequest.getId());
		puid.setUrl("http://localhost:7070/payment?paymentId=" + puid.getPaymentId());	
		
		paymentRequest.setAmount(mdto.getAmount());
		paymentRequest.setId(puid.getPaymentId());
		paymentRequestService1.save(paymentRequest);
		
		System.out.println(puid.getUrl());
		System.out.println(puid.getPaymentId());
		System.out.println("suma u BANCI!!! : " + mdto.getAmount());

		return puid;
	}

}
