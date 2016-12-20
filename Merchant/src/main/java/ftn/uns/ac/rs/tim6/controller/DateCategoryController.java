package ftn.uns.ac.rs.tim6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.ac.rs.tim6.model.Pricelist;
import ftn.uns.ac.rs.tim6.service.DateCategoryService;

@RestController
@RequestMapping("/api")
public class DateCategoryController {
	
	@Autowired
	DateCategoryService dateCategoryService;
	
	@RequestMapping(value = "datecategories", method = RequestMethod.GET)
	public ResponseEntity<List<Pricelist>> handleGetAllDateCategory(){
		List<Pricelist> datecategories = (List<Pricelist>) dateCategoryService.getAll();
		return new ResponseEntity<List<Pricelist>>(datecategories, HttpStatus.OK);
	}
}
