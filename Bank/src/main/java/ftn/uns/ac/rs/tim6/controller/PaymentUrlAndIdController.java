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
	PaymentRequestService paymentRequestService;

	@RequestMapping(value = "/paymenturlandids", method = RequestMethod.GET)
	public ResponseEntity<List<PaymentUrlAndId>> handleGetAllPaPaymentUrlAndIds() {
		List<PaymentUrlAndId> PaymentUrlAndIds = (List<PaymentUrlAndId>) paymentUrlAndRequestService.getAll();
		return new ResponseEntity<List<PaymentUrlAndId>>(PaymentUrlAndIds, HttpStatus.OK);
	}

	@RequestMapping(value = "/urlid", method = RequestMethod.POST)
	public PaymentUrlIdDto handleBuy(@RequestBody MerchantDto mdto){
		
		//TODO dobio sam merchanta kreiraj sta imas
		PaymentUrlIdDto puid = new PaymentUrlIdDto();
		Random randomGenerator = new Random();
		PaymentRequest paymentRequest = new PaymentRequest();
		PaymentUrlAndId puidDb = new PaymentUrlAndId();

		puid.setPaymentId(randomGenerator.nextInt(1000));
		puid.setUrl("http://localhost:7070/payment?paymentId=" + puid.getPaymentId());
		
		//TODO proveri dobijenog merchanta, i napravi sta imas 
		paymentRequest.setAmount(mdto.getAmount());
		paymentRequest.setId(puid.getPaymentId());
		puidDb.setPaymentId(puid.getPaymentId());
		puidDb.setPaymentUrl(puid.getUrl());
		paymentRequest.setPaymentUrlAndId(puidDb);
		paymentRequestService.save(paymentRequest);
		
//		System.out.println("PAYMENT REQUEST");
//		System.out.println(paymentRequest.getAmount());
//		System.out.println(paymentRequest.getPaymentUrlAndId().getPaymentUrl());
//		System.out.println(paymentRequest.getPaymentUrlAndId().getPaymentId());
//		
//		
//		System.out.println("SUMA URL I ID U BANCI!!!");
//		System.out.println(mdto.getAmount());
//		System.out.println(puid.getUrl());
//		System.out.println(puid.getPaymentId());
		
		
		return puid;
	}

}
