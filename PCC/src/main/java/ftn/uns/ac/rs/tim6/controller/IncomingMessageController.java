package ftn.uns.ac.rs.tim6.controller;

import java.util.ArrayList;
import java.util.List;
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
import ftn.uns.ac.rs.tim6.dto.ResponseMessageDto;
import ftn.uns.ac.rs.tim6.model.Bank;
import ftn.uns.ac.rs.tim6.model.IncomingMessage;
import ftn.uns.ac.rs.tim6.model.ResponseMessage;
import ftn.uns.ac.rs.tim6.service.BankService;
import ftn.uns.ac.rs.tim6.service.IncomingMessageService;
import ftn.uns.ac.rs.tim6.service.ResponseMessageService;
import ftn.uns.ac.rs.tim6.util.CheckerCertificates;

@RestController
@RequestMapping("/api")
public class IncomingMessageController {

	@Autowired
	IncomingMessageService incomingMessageService;

	@Autowired
	BankService bankService;

	@Autowired
	ResponseMessageService responseMessageService;

	@RequestMapping(value = "/incomingmessages", method = RequestMethod.GET)

	public ResponseEntity<List<IncomingMessage>> handleGetAllIncomingMessages() {
		List<IncomingMessage> incomingmessages = (List<IncomingMessage>) incomingMessageService.getAll();
		return new ResponseEntity<List<IncomingMessage>>(incomingmessages, HttpStatus.OK);
	}

	@RequestMapping(value = "/incomingacquirerorder", method = RequestMethod.POST)
	public ResponseEntity<ResponseMessageDto> handleIncomingMessage(@RequestBody AcquirerOrderDto aodto) {

		// TODO korak 7
		Bank bank = findBankByPan(aodto.getPan());

		RestTemplate client = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		ResponseMessageDto rmdto = new ResponseMessageDto();
		setAndSaveIncomingMessage(aodto, bank);

		rmdto.setAcquirerOrderId(aodto.getAcquirerOrderId());
		rmdto.setAcquirerTimestamp(aodto.getTimestamp());

		try {

			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<AcquirerOrderDto> entity = new HttpEntity<AcquirerOrderDto>(aodto, headers);
			// check certificates	
			CheckerCertificates checkerCertificate = new CheckerCertificates();
			checkerCertificate.doTrustToCertificates();
			rmdto = client.postForObject("https://localhost:" + bank.getPort() + "/api/reservation", entity,
					ResponseMessageDto.class);
			setAndSaveResponseMessage(rmdto, bank);
			return new ResponseEntity<ResponseMessageDto>(rmdto, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<ResponseMessageDto>(rmdto, HttpStatus.BAD_REQUEST);
		}
	}

	private void setAndSaveResponseMessage(ResponseMessageDto rmdto, Bank bank) {
		ResponseMessage rm = new ResponseMessage();
		rm.setAcquirerOrderId(rmdto.getAcquirerOrderId());
		rm.setAcquirerTimestamp(rmdto.getAcquirerTimestamp());
		rm.setIssuerOrderId(rmdto.getMerchantOrderId());
		rm.setIssuerTimestamp(rmdto.getMerchantTimestamp());
		rm.setResult(rmdto.getResult());
		rm.setBank(bank);
		responseMessageService.save(rm);

	}

	private void setAndSaveIncomingMessage(AcquirerOrderDto aodto, Bank bank) {
		IncomingMessage im = new IncomingMessage();
		im.setAcquirerOrderId(aodto.getAcquirerOrderId());
		im.setAcquirerTimestamp(aodto.getTimestamp());
		im.setPan(aodto.getPan());
		im.setSecurityCode(aodto.getSecurityCode());
		im.setCardHolderName(aodto.getCardHolder());
		im.setExpDateYear(aodto.getExpDateYear());
		im.setExpDateMonth(aodto.getExpDateMonth());
		im.setAmount(aodto.getTransactionAmount());
		im.setBank(bank);
		incomingMessageService.save(im);

	}

	private Bank findBankByPan(Long pan) {
		// A BBBBB CCCCCCCCCCCC D ja uzimam prvih 6 cifara
		Long panBanke = Long.parseLong(Long.toString(pan).substring(0, 6));
		List<Bank> banke = new ArrayList<Bank>();
		banke = bankService.getAll();
		for (Bank bank : banke) {
			if (bank.getPan().longValue() == panBanke.longValue()) {
				System.out.println("NASLI SMO BANKU sa portom: ");
				System.out.println(bank.getPort());
				return bank;
			}
		}
		System.out.println("NISMO NASLI SMO BANKU!!!");
		return null;
	}

}
