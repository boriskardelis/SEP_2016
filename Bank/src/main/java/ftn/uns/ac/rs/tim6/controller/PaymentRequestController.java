package ftn.uns.ac.rs.tim6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ftn.uns.ac.rs.tim6.dto.AmountDto;
import ftn.uns.ac.rs.tim6.dto.PaymentInfoDto;
import ftn.uns.ac.rs.tim6.model.Account;
import ftn.uns.ac.rs.tim6.model.AcquirerOrder;
import ftn.uns.ac.rs.tim6.model.PaymentRequest;
import ftn.uns.ac.rs.tim6.service.AccountService;
import ftn.uns.ac.rs.tim6.service.PaymentRequestService;

@RestController
@RequestMapping("/api")
public class PaymentRequestController {

	@Autowired
	PaymentRequestService paymentRequestService;

	@Autowired
	AccountService accountService;

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

	@RequestMapping(value = "/payment/pay", method = RequestMethod.POST)
	public ResponseEntity<String> handlePay(@RequestBody PaymentInfoDto paymentInfo) {

		AcquirerOrder acquirerOrder = new AcquirerOrder();
		RestTemplate client = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		String url = "";

		//moraju se identicno zvati atributi na frontendu i backendu
		// TODO provara kartice
		System.out.println(paymentInfo.getPan());
		System.out.println(paymentInfo.getPaymentId());
		System.out.println(paymentInfo.getSecurityCode());
		System.out.println(paymentInfo.getYear());
		System.out.println(paymentInfo.getMonth());
		
		

		// TODO orderId Number(10)

		// TODO vraca acc na osnovu pan-a, ali to ovde ne radimo
		Account acc = accountService.findByPan(paymentInfo.getPan());

		// TODO nadji korisnika porsledi podatke PCC...
		PaymentRequest paymentRequest = paymentRequestService.findByPaymentId(paymentInfo.getPaymentId());
		
		acquirerOrder.setPan(paymentInfo.getPan());
		acquirerOrder.setAccount(acc);
		acquirerOrder.setPaymentRequest(paymentRequest);

		try {

			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<String>(acquirerOrder.toString(), headers);
			url = client.postForObject("http://localhost:9090/api/incomingmessage", entity, String.class);
			return new ResponseEntity<String>(url, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(url, HttpStatus.BAD_REQUEST);
		}

	}
}
