package ftn.uns.ac.rs.tim6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.ac.rs.tim6.service.SportService;

@RestController
@RequestMapping("/api")
public class SportController {
	
	@Autowired
	SportService sportService;

}
