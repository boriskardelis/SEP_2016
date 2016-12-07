package ftn.uns.ac.rs.tim6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.ac.rs.tim6.model.Vehicle;
import ftn.uns.ac.rs.tim6.service.VehicleService;

@RestController
@RequestMapping("/api")
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;
	
	@RequestMapping(value = "/vehicles", method = RequestMethod.GET)
	public ResponseEntity<List<Vehicle>> handleGetAllVehicles() {
		List<Vehicle> vehicles = (List<Vehicle>) vehicleService.getAll();
		return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.OK);
	}

}
