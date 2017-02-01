package ftn.uns.ac.rs.tim6.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.ac.rs.tim6.dto.InsuranceDto;
import ftn.uns.ac.rs.tim6.model.Pricelist;
import ftn.uns.ac.rs.tim6.model.RiskSubcategory;
import ftn.uns.ac.rs.tim6.service.PricelistService;
import ftn.uns.ac.rs.tim6.service.RiskSubcategoryService;
import ftn.uns.ac.rs.tim6.util.DateConverter;

@RestController
@RequestMapping("/api")
public class RiskSubcategoryController {
	
	@Autowired
	RiskSubcategoryService riskSubcategoryService;
	
	@Autowired
	PricelistService pricelistService;
	
	@RequestMapping(value = "/risksubcategories", method = RequestMethod.POST)
	public ResponseEntity<List<RiskSubcategory>> getSubcategories(@RequestBody String language) {
		
		Date sqlDate = new Date();
		
		System.out.println("SQL kreiran datum: " + sqlDate);
		
		List<Pricelist> listPricelist = pricelistService.findCurrentPriceList(sqlDate);
		System.out.println("Lista priceliste: " + listPricelist);
		
		Pricelist p = listPricelist.get(0);
		System.out.println("PRVA list pricelistL " + p.getId());
		
		List<RiskSubcategory> listSubs = riskSubcategoryService.findSubcategoriesByLanguage(language, p);
		for (RiskSubcategory riskSubcategory : listSubs) {
			System.out.println("listSubs: " + riskSubcategory.getPricelistItems().size());
			
		}
		System.out.println("DUZINA LISTE: " + listSubs.size());
		System.out.println("LISTA PREMA ENGL: " + listSubs);
		System.out.println("PRVI: " + listSubs.get(0).getNameTranslate().getName());
		System.out.println("DRUGI: " + listSubs.get(1).getNameTranslate().getName());
		
		
		//List<RiskSubcategory> risksubcategories = (List<RiskSubcategory>) pricelistService.getCurrentPricelistSubcategories();
		return new ResponseEntity<List<RiskSubcategory>>(listSubs, HttpStatus.OK);
	}
}
