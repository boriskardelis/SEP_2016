package ftn.uns.ac.rs.tim6.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ftn.uns.ac.rs.tim6.dto.AcquirerOrderDto;
import ftn.uns.ac.rs.tim6.dto.PaymentInfoDto;
import ftn.uns.ac.rs.tim6.model.AcquirerOrder;
import ftn.uns.ac.rs.tim6.model.PaymentRequest;
import ftn.uns.ac.rs.tim6.service.AccountService;
import ftn.uns.ac.rs.tim6.service.AcquirerOrderService;
import ftn.uns.ac.rs.tim6.service.PaymentRequestService;

@RestController
@RequestMapping("/api")
public class AcquirerOrderController {

	@Autowired
	AcquirerOrderService acquirerOrderService;

	@Autowired
	AccountService accountService;

	@Autowired
	PaymentRequestService paymentRequestService;

	@RequestMapping(value = "/acquirerOrders", method = RequestMethod.GET)

	public ResponseEntity<List<AcquirerOrder>> handleGetAllAcquirerOrders() {
		List<AcquirerOrder> acquirerOrders = (List<AcquirerOrder>) acquirerOrderService.getAll();
		return new ResponseEntity<List<AcquirerOrder>>(acquirerOrders, HttpStatus.OK);
	}

	@RequestMapping(value = "/payment/pay", method = RequestMethod.POST)
	public ResponseEntity<String> handlePay(@RequestBody PaymentInfoDto paymentInfo) {

		
		RestTemplate client = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		
		
		// TODO korak 12 na ovaj url cekamo odgovor celog kruga
		String url = "";
		
		// TODO korak 5
		// moraju se identicno zvati atributi na frontendu i backendu
		// pravimo AcquirerOrder, zahtev za proveru kartice
		
		// TODO korak 5.2 timestamp, proveriti svuda -> treba sertifikat
		// acquirerOrder.setTimestamp(new Timestamp(null, null));
		
		AcquirerOrder acquirerOrder = setAndSaveAcquirerOrder(paymentInfo);
		AcquirerOrderDto aodto = createAcquirerOrderDto(acquirerOrder);
		
		
		

		// TODO korak 6

		try {

			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<AcquirerOrderDto> entity = new HttpEntity<AcquirerOrderDto>(aodto, headers);
			url = client.postForObject("http://localhost:9090/api/incomingacquirerorder", entity, String.class);
			return new ResponseEntity<String>(url, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(url, HttpStatus.BAD_REQUEST);
		}

	}

	private AcquirerOrderDto createAcquirerOrderDto(AcquirerOrder acquirerOrder) {
		
		
		
		AcquirerOrderDto aodto = new AcquirerOrderDto();
		aodto.setPan(acquirerOrder.getPan());
		aodto.setSecurityCode(acquirerOrder.getSecurityCode());
		aodto.setTransactionAmount(acquirerOrder.getTransactionAmount());
		aodto.setCardHolder(acquirerOrder.getCardHolder());
		aodto.setExpDateYear(acquirerOrder.getExpDateYear());
		aodto.setExpDateMonth(acquirerOrder.getExpDateMonth());
		aodto.setAcquirerOrderId(acquirerOrder.getAcquirerOrderId());
		return aodto;
	}

	private AcquirerOrder setAndSaveAcquirerOrder(PaymentInfoDto paymentInfo) {
		PaymentRequest paymentRequest = paymentRequestService.findByPaymentId(paymentInfo.getPaymentId());
		AcquirerOrder acquirerOrder = new AcquirerOrder();
		Random randomGenerator = new Random();
		//korak 5.1 orderId Number(10)
		acquirerOrder.setAcquirerOrderId(randomGenerator.nextInt(1000));
		acquirerOrder.setPan(paymentInfo.getPan());
		acquirerOrder.setSecurityCode(paymentInfo.getSecurityCode());
		acquirerOrder.setTransactionAmount(paymentRequest.getAmount());
		acquirerOrder.setCardHolder("ZA SAD NEKI CARD HOLDER");
		acquirerOrder.setExpDateYear(paymentInfo.getYear());
		acquirerOrder.setExpDateMonth(paymentInfo.getMonth());
		acquirerOrderService.save(acquirerOrder);
		return acquirerOrder;
	}
}
