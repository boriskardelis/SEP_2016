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
import org.drools.runtime.StatefulKnowledgeSession;

import ftn.uns.ac.rs.tim6.dto.AgeSubCategoryDto;
import ftn.uns.ac.rs.tim6.dto.InsurancePriceDto;
import ftn.uns.ac.rs.tim6.model.Insurance;
import ftn.uns.ac.rs.tim6.model.RiskSubcategory;
import ftn.uns.ac.rs.tim6.service.InsuranceService;
import ftn.uns.ac.rs.tim6.service.RiskSubcategoryService;
import ftn.uns.ac.rs.tim6.util.DroolsReadKnowlageBase;

@RestController
@RequestMapping("/api")
public class InsuranceController {

	@Autowired
	InsuranceService insuranceService;

	@Autowired
	RiskSubcategoryService riskSubcategoryService;

	@RequestMapping(value = "/insurances", method = RequestMethod.GET)
	public ResponseEntity<List<Insurance>> handleGetAllInsurances() {
		List<Insurance> insurances = (List<Insurance>) insuranceService.getAll();
		return new ResponseEntity<List<Insurance>>(insurances, HttpStatus.OK);
	}

	@RequestMapping(value = "/price", method = RequestMethod.POST)
	public InsurancePriceDto handlePrice(@RequestBody String jsonInString) throws JsonProcessingException, IOException {
		
		InsurancePriceDto dto = new InsurancePriceDto();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(jsonInString);

		RiskSubcategory region = mapper.convertValue(node.get("region"), RiskSubcategory.class);
		RiskSubcategory sum = mapper.convertValue(node.get("sum"), RiskSubcategory.class);
		RiskSubcategory ageCarrier = mapper.convertValue(node.get("ageCarrier"), RiskSubcategory.class);
		
		AgeSubCategoryDto ageType = mapper.convertValue(node.get("ageType"), AgeSubCategoryDto.class);
		
		System.out.println("region " + region);
		System.out.println("ageType string: " + ageType);
		
		dto.getRisks().add(region);
		dto.getRisks().add(sum);
		dto.getRisks().add(ageCarrier);
		
		DroolsReadKnowlageBase kbase = new DroolsReadKnowlageBase();

		try {

			StatefulKnowledgeSession ksession = kbase.getSession();
			ksession.insert(dto);
			ksession.fireAllRules();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("izasli iz drools-a, cena: " + dto.getTotalPrice());

		return dto;
	}

}
