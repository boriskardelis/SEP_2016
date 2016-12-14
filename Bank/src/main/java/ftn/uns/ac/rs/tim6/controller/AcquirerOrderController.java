package ftn.uns.ac.rs.tim6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ftn.uns.ac.rs.tim6.model.AcquirerOrder;
import ftn.uns.ac.rs.tim6.service.AcquirerOrderService;

@RestController
@RequestMapping("/api")
public class AcquirerOrderController {
	
	@Autowired
	AcquirerOrderService acquirerOrderService;
	
@RequestMapping(value = "/acquirerOrders", method = RequestMethod.GET)
	
	public ResponseEntity<List<AcquirerOrder>> handleGetAllAcquirerOrders() {
		List<AcquirerOrder> acquirerOrders = (List<AcquirerOrder>) acquirerOrderService.getAll();
		return new ResponseEntity<List<AcquirerOrder>>(acquirerOrders, HttpStatus.OK);
	}
}
