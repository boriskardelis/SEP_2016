package ftn.uns.ac.rs.tim6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.ac.rs.tim6.model.RiskSubcategory;
import ftn.uns.ac.rs.tim6.service.PricelistService;
import ftn.uns.ac.rs.tim6.service.RiskSubcategoryService;

@RestController
@RequestMapping("/api")
public class RiskSubcategoryController {
	
	@Autowired
	RiskSubcategoryService riskSubcategoryService;
	
	@Autowired
	PricelistService pricelistService;
	
	@RequestMapping(value = "/risksubcategories", method = RequestMethod.GET)
	public ResponseEntity<List<RiskSubcategory>> getSubcategories() {
		List<RiskSubcategory> risksubcategories = (List<RiskSubcategory>) pricelistService.getCurrentPricelistSubcategories();
		return new ResponseEntity<List<RiskSubcategory>>(risksubcategories, HttpStatus.OK);
	}
}
