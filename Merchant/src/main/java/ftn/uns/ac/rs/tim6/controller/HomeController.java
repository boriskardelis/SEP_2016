package ftn.uns.ac.rs.tim6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.ac.rs.tim6.model.Home;
import ftn.uns.ac.rs.tim6.service.HomeService;

@RestController
@RequestMapping("/api")
public class HomeController {
	
	@Autowired
	HomeService homeService;
	
	@RequestMapping(value = "/homes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Home> handleGetAllHome() {
		return homeService.getAll();
	}

}
