package ftn.uns.ac.rs.tim6.controller;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ftn.uns.ac.rs.tim6.dto.AcquirerOrderDto;
import ftn.uns.ac.rs.tim6.dto.ResponseMessageDto;
import ftn.uns.ac.rs.tim6.dto.ResponseMessageDto.TransactionResult;
import ftn.uns.ac.rs.tim6.model.Account;
import ftn.uns.ac.rs.tim6.model.AcquirerOrderReservation;
import ftn.uns.ac.rs.tim6.model.Card;
import ftn.uns.ac.rs.tim6.service.AccountService;
import ftn.uns.ac.rs.tim6.service.AcquirerOrderReservationService;
import ftn.uns.ac.rs.tim6.service.CardService;

@RestController
@RequestMapping("/api")
public class AcquirerOrderReservationController {

	@Autowired
	AcquirerOrderReservationService acquirerOrderReservationService;

	@Autowired
	AccountService accountService;

	@Autowired
	CardService cardService;

	@RequestMapping(value = "/acquirerOrderReservations", method = RequestMethod.GET)
	public ResponseEntity<List<AcquirerOrderReservation>> handleGetAllAcquirerOrderReservations() {
		List<AcquirerOrderReservation> acquirerOrderReservations = (List<AcquirerOrderReservation>) acquirerOrderReservationService
				.getAll();
		return new ResponseEntity<List<AcquirerOrderReservation>>(acquirerOrderReservations, HttpStatus.OK);
	}

	@RequestMapping(value = "/reservation", method = RequestMethod.POST)
	public ResponseEntity<ResponseMessageDto> handleIncomingMessage(@RequestBody AcquirerOrderDto aodto) {

		ResponseMessageDto rmdto = new ResponseMessageDto();
		Account account = accountService.findByPan(aodto.getPan());
		MathContext mc = new MathContext(10);

		System.out.println("stigli smo u banku B " + aodto.getPan());
		int res = account.getAccountBalance().compareTo(aodto.getTransactionAmount());
		BigDecimal b1 = account.getAccountBalance();

		Card card = cardService.findByPan(aodto.getPan());
		Boolean valid = cardCheck(card, aodto, rmdto);

		if (valid) {

			// TODO korak 8
			if (res == 0) { // tacno

				rmdto.setResult(TransactionResult.SUCCESSFUL);
				b1 = account.getAccountBalance().subtract(aodto.getTransactionAmount(), mc);
				account.setAccountBalance(b1);
				accountService.save(account);

			} else if (res == 1) { // ima vise

				rmdto.setResult(TransactionResult.SUCCESSFUL);
				b1 = account.getAccountBalance().subtract(aodto.getTransactionAmount(), mc);
				account.setAccountBalance(b1);
				accountService.save(account);

			} else if (res == -1) { // nema dovoljno

				rmdto.setResult(TransactionResult.INSUFFICIENT_FUNDS);
			}
			rmdto.setAcquirerOrderId(aodto.getAcquirerOrderId());
			rmdto.setAcquirerTimestamp(aodto.getTimestamp());
			rmdto.setMerchantTimestamp(aodto.getTimestamp());

		} else {

			System.out.println("kartica nije validna");

		}

		try {
			// TODO korak 9
			return new ResponseEntity<ResponseMessageDto>(rmdto, HttpStatus.OK);

		} catch (Exception e) {
			rmdto.setResult(TransactionResult.ERROR);
			return new ResponseEntity<ResponseMessageDto>(rmdto, HttpStatus.BAD_REQUEST);
		}

	}

	private Boolean cardCheck(Card card, AcquirerOrderDto aodto, ResponseMessageDto rmdto) {
		if (aodto.getExpDateMonth() != null || aodto.getExpDateYear() != null || aodto.getSecurityCode() != null) {

			if (card.getMonth().longValue() == aodto.getExpDateMonth().longValue()
					&& card.getYear().longValue() == aodto.getExpDateYear().longValue()
					&& card.getSecurityCode().longValue() == aodto.getSecurityCode().longValue()) {
				return true;

			} else {
				rmdto.setResult(TransactionResult.ERROR);
			}
			rmdto.setResult(TransactionResult.ERROR);
			if (card.getMonth().longValue() != aodto.getExpDateMonth().longValue()
					|| card.getYear().longValue() != aodto.getExpDateYear().longValue()) {
				rmdto.setResult(TransactionResult.INVALID_DATE);

			} else if (card.getSecurityCode().longValue() != aodto.getSecurityCode().longValue()) {
				rmdto.setResult(TransactionResult.CVC_INVALID);
			}
		} else {
			rmdto.setResult(TransactionResult.ERROR);
		}
		return false;
	}
}
