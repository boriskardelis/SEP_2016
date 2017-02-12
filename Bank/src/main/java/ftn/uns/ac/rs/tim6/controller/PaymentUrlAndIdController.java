package ftn.uns.ac.rs.tim6.controller;

import java.util.ArrayList;
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
import ftn.uns.ac.rs.tim6.model.Merchant;
import ftn.uns.ac.rs.tim6.model.PaymentRequest;
import ftn.uns.ac.rs.tim6.model.PaymentUrlAndId;
import ftn.uns.ac.rs.tim6.service.MerchantService;
import ftn.uns.ac.rs.tim6.service.PaymentRequestService;
import ftn.uns.ac.rs.tim6.service.PaymentUrlAndIdService;

@RestController
@RequestMapping("/api")
public class PaymentUrlAndIdController {

	@Autowired
	PaymentUrlAndIdService paymentUrlAndRequestService;

	@Autowired
	PaymentRequestService paymentRequestService;

	@Autowired
	MerchantService merchantService;

	@RequestMapping(value = "/paymenturlandids", method = RequestMethod.GET)
	public ResponseEntity<List<PaymentUrlAndId>> handleGetAllPaPaymentUrlAndIds() {
		List<PaymentUrlAndId> PaymentUrlAndIds = (List<PaymentUrlAndId>) paymentUrlAndRequestService.getAll();
		return new ResponseEntity<List<PaymentUrlAndId>>(PaymentUrlAndIds, HttpStatus.OK);
	}

	@RequestMapping(value = "/urlid", method = RequestMethod.POST)
	public PaymentUrlIdDto handleBuy(@RequestBody MerchantDto mdto) {
		
		System.out.println("POGODIO BANKU");

		// TODO korak 3
		PaymentUrlIdDto puid = new PaymentUrlIdDto();
		Random randomGenerator = new Random();
		PaymentUrlAndId puidDb = new PaymentUrlAndId();

		if (merchantCheck(mdto)) {

			// TODO korak 4
			puid.setPaymentId(randomGenerator.nextInt(1000));
			puid.setUrl("https://localhost:7070/payment?paymentId=" + puid.getPaymentId());

			puidDb.setPaymentId(puid.getPaymentId());
			puidDb.setPaymentUrl(puid.getUrl());

			setAndSavePaymentRequest(mdto, puidDb);

			return puid;
		}
		return null;

	}

	private void setAndSavePaymentRequest(MerchantDto mdto, PaymentUrlAndId puidDb) {

		PaymentRequest paymentRequest = new PaymentRequest();
		paymentRequest.setMerchantOrderId(mdto.getMerchantOrderID());
		paymentRequest.setMerchantId(mdto.getMerchantId());
		paymentRequest.setMerchantPassword(mdto.getMerchantPassword());
		paymentRequest.setMerchantTimestamp(mdto.getMerchantTimestamp());
		paymentRequest.setAmount(mdto.getAmount());
		// paymentRequest.setErrorUrl(mdto.getErrorUrl());
		paymentRequest.setPaymentUrlAndId(puidDb);
		paymentRequestService.save(paymentRequest);
		return;
	}

	private boolean merchantCheck(MerchantDto mdto) {
		List<Merchant> merchants = new ArrayList<Merchant>();
		merchants = merchantService.getAll();

		for (Merchant merchant : merchants) {
			if (merchant.getMerchantId().equals(mdto.getMerchantId())) {
				if (merchant.getPassword().equals(mdto.getMerchantPassword())) {
					System.out.println("POSTOJI MERCHANT");
					System.out.println("ID " + merchant.getMerchantId());
					System.out.println("PASSWORD " + merchant.getPassword());
					System.out.println("");
					return true;
				}
			}
		}
		System.out.println("NE POSTOJI MERCHANT!!!");
		System.out.println("");
		return false;
	}

}
