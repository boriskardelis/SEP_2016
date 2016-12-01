package ftn.uns.ac.rs.tim6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.ac.rs.tim6.model.Buyer;
import ftn.uns.ac.rs.tim6.service.BuyerService;

@RestController
@RequestMapping("/api")
public class BuyerController {

	@Autowired
	BuyerService buyerService;
	
	@RequestMapping(value = "/buyers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Buyer> handleGetAllBuyers() {
		return buyerService.getAll();
	}
}
