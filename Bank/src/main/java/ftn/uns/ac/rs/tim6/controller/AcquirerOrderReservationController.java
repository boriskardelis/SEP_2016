package ftn.uns.ac.rs.tim6.controller;

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
	public ResponseEntity<String> handleIncomingMessage(@RequestBody String incomingMessage) {
		
		RestTemplate client = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		String url = "";
		
		//TODO korak 8 provera pristiglog zahteva
		//TODO korak 8.1 provera novca
		//TODO korak 8.2 prosledjivanje odgovora nazad PCC-u 
		
		AcquirerOrderReservation aor = new AcquirerOrderReservation();
		
		try {

			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<AcquirerOrderReservation> entity = new HttpEntity<AcquirerOrderReservation>(aor, headers);
			url = client.postForObject("http://localhost:9090/api/response", entity, String.class);
			return new ResponseEntity<String>(url, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(url, HttpStatus.BAD_REQUEST);
		}
		
		
	}
}
