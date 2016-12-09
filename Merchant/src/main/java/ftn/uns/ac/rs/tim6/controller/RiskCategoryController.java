package ftn.uns.ac.rs.tim6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.ac.rs.tim6.model.RiskCategory;
import ftn.uns.ac.rs.tim6.service.RiskCategoryService;

@RestController
@RequestMapping("/api")
public class RiskCategoryController {
	
	@Autowired
	RiskCategoryService riskCategoryService;
	
	@RequestMapping(value = "/riskcategories", method = RequestMethod.GET)
	public ResponseEntity<List<RiskCategory>> getCategories() {
		List<RiskCategory> riskcategories = (List<RiskCategory>) riskCategoryService.getAll();
		return new ResponseEntity<List<RiskCategory>>(riskcategories, HttpStatus.OK);
	}

}
