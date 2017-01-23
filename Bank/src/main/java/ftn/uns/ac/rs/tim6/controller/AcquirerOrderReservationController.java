package ftn.uns.ac.rs.tim6.controller;

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
import ftn.uns.ac.rs.tim6.model.AcquirerOrderReservation;
import ftn.uns.ac.rs.tim6.service.AcquirerOrderReservationService;

@RestController
@RequestMapping("/api")
public class AcquirerOrderReservationController {

	@Autowired
	AcquirerOrderReservationService acquirerOrderReservationService;

	@RequestMapping(value = "/acquirerOrderReservations", method = RequestMethod.GET)
	public ResponseEntity<List<AcquirerOrderReservation>> handleGetAllAcquirerOrderReservations() {
		List<AcquirerOrderReservation> acquirerOrderReservations = (List<AcquirerOrderReservation>) acquirerOrderReservationService
				.getAll();
		return new ResponseEntity<List<AcquirerOrderReservation>>(acquirerOrderReservations, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/reservation", method = RequestMethod.POST)
	public ResponseEntity<ResponseMessageDto> handleIncomingMessage(@RequestBody AcquirerOrderDto aodto) {
		
		ResponseMessageDto rmdto = new ResponseMessageDto();
		
		//TODO korak 8 provera pristiglog zahteva
		//TODO korak 8.1 provera novca
		//TODO korak 8.2 prosledjivanje odgovora nazad PCC-u 
		System.out.println("stigli smo u banku B " + aodto.getPan());
		
	//	AcquirerOrderReservation aor = new AcquirerOrderReservation();
		rmdto.setResult(TransactionResult.SUCCESSFUL);
	
		
		try {
			//TODO korak 9
			return new ResponseEntity<ResponseMessageDto>(rmdto, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<ResponseMessageDto>(rmdto, HttpStatus.BAD_REQUEST);
		}
		
		
	}
}
