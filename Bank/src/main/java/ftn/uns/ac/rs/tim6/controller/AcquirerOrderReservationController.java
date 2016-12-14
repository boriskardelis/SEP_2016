package ftn.uns.ac.rs.tim6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.ac.rs.tim6.model.AcquirerOrderReservation;
import ftn.uns.ac.rs.tim6.service.AcquirerOrderReservationService;

@RestController
@RequestMapping("/api")
public class AcquirerOrderReservationController {
	
	@Autowired
	AcquirerOrderReservationService acquirerOrderReservationService;
	
@RequestMapping(value = "/acquirerOrderReservations", method = RequestMethod.GET)
	
	public ResponseEntity<List<AcquirerOrderReservation>> handleGetAllAcquirerOrderReservations() {
		List<AcquirerOrderReservation> acquirerOrderReservations = (List<AcquirerOrderReservation>) acquirerOrderReservationService.getAll();
		return new ResponseEntity<List<AcquirerOrderReservation>>(acquirerOrderReservations, HttpStatus.OK);
	}
}
