package ftn.uns.ac.rs.tim6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.ac.rs.tim6.model.InsuranceType;
import ftn.uns.ac.rs.tim6.service.InsuranceTypeService;

@RestController
@RequestMapping("/api")
public class InsuranceTypeController {
	
	@Autowired
	InsuranceTypeService insuranceTypeService;
	
	@RequestMapping(value = "/insurancetypes", method = RequestMethod.GET)
	public ResponseEntity<List<InsuranceType>> handleGetAllInsuranceTypes() {
		List<InsuranceType> insurancetypes = (List<InsuranceType>) insuranceTypeService.getAll();
		return new ResponseEntity<List<InsuranceType>>(insurancetypes, HttpStatus.OK);
	}

}
