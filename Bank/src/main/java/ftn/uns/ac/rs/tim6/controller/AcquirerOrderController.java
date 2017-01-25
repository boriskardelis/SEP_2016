package ftn.uns.ac.rs.tim6.controller;

import java.math.BigDecimal;
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
import ftn.uns.ac.rs.tim6.dto.ResponseMessageDto;
import ftn.uns.ac.rs.tim6.dto.ResponseMessageDto.TransactionResult;
import ftn.uns.ac.rs.tim6.dto.URLDto;
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
	public ResponseEntity<URLDto> handlePay(@RequestBody PaymentInfoDto paymentInfo) {

		RestTemplate client = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		ResponseMessageDto rmdto = new ResponseMessageDto();
		URLDto urldto = new URLDto();

		// TODO korak 5
		// moraju se identicno zvati atributi na frontendu i backendu
		// pravimo AcquirerOrder, zahtev za proveru kartice

		// TODO korak 5.2 timestamp, proveriti svuda -> treba sertifikat
		// acquirerOrder.setTimestamp(new Timestamp(null, null));
		
		System.out.println("PaymentID iz paymentINFO" + paymentInfo.getPaymentId());
		
		AcquirerOrder acquirerOrder = setAndSaveAcquirerOrder(paymentInfo);
		AcquirerOrderDto aodto = createAcquirerOrderDto(acquirerOrder);

		// TODO korak 6

		try {

			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<AcquirerOrderDto> entity = new HttpEntity<AcquirerOrderDto>(aodto, headers);

			System.out.println("PRE SLANJA PCC-u");
			// poruka prema PCC-u i dalje u krug
			rmdto = client.postForObject("http://localhost:9090/api/incomingacquirerorder", entity,
					ResponseMessageDto.class);
			
			rmdto.setPaymentId(paymentInfo.getPaymentId()); //setujemo paymentID
			
			System.out.println("PaymentID NAKON SETOVANJA: " + rmdto.getPaymentId());

			System.out.println("RMDTO: ");
			System.out.println(rmdto.toString());
			
			
//			TransactionResult rezultat = rmdto.getResult();
//			BigDecimal balance = acquirerOrder.getAccount().getAccountBalance();
//			BigDecimal toAdd = acquirerOrder.getTransactionAmount();
//			
//			System.out.println(rezultat + "  " + balance + "   " + toAdd);
//			
//			if (rezultat.equals(TransactionResult.SUCCESSFUL)) {
//				// dodati merchantu $$$
//				balance = balance.add(toAdd);
//				System.out.println(balance);
//				accountService.save(acquirerOrder.getAccount());
//			}

			// TODO korak 10


			// poruka prema merchantu koja se prosledjuje od PCC-a
			HttpEntity<ResponseMessageDto> entityResponse = new HttpEntity<ResponseMessageDto>(rmdto, headers);
			urldto = client.postForObject("http://localhost:8080/api/incomingresult", entityResponse, URLDto.class);
			
			//urldto.setUrl(urldto.getUrl()+ "?paymentId=" + paymentInfo.getPaymentId());
		

			System.out.println("Vracen urldto: " + urldto.getMessage());
			return new ResponseEntity<URLDto>(urldto, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<URLDto>(urldto, HttpStatus.BAD_REQUEST);
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
		// korak 5.1 orderId Number(10)
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
