package ftn.uns.ac.rs.tim6.controller;

import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import ftn.uns.ac.rs.tim6.model.Insurance;
import ftn.uns.ac.rs.tim6.model.RiskSubcategory;
import ftn.uns.ac.rs.tim6.service.InsuranceService;

@RestController
@RequestMapping("/api")
public class InsuranceController {
	
	@Autowired
	InsuranceService insuranceService;
	
	@RequestMapping(value = "/insurances", method = RequestMethod.GET)
	public ResponseEntity<List<Insurance>> handleGetAllInsurances() {
		List<Insurance> insurances = (List<Insurance>) insuranceService.getAll();
		return new ResponseEntity<List<Insurance>>(insurances, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/price", method = RequestMethod.POST)
	public double handlePrice(@RequestBody String jsonInString) throws JsonProcessingException, IOException {
		
		System.out.println(jsonInString);
		ObjectMapper mapper = new ObjectMapper();	
		JsonNode node = mapper.readTree(jsonInString);
		RiskSubcategory region = mapper.convertValue(node.get("region"), RiskSubcategory.class); 
		RiskSubcategory sum = mapper.convertValue(node.get("sum"), RiskSubcategory.class); 
		RiskSubcategory ageCarrier = mapper.convertValue(node.get("ageCarrier"), RiskSubcategory.class); 
		System.out.println(region.getName());
		System.out.println(region.getId());
		System.out.println(sum.getName());
		System.out.println(ageCarrier.getName());
		return 3;
	}


}

