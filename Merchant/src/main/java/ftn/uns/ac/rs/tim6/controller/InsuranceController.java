package ftn.uns.ac.rs.tim6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.ac.rs.tim6.model.Insurance;
import ftn.uns.ac.rs.tim6.service.InsuranceService;

@RestController
@RequestMapping("/api")
public class InsuranceController {
	
	@Autowired
	InsuranceService insuranceService;
	
	@RequestMapping(value = "/insurances", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Insurance> handleGetAllInsurance() {
		return insuranceService.getAll();
	}

}
