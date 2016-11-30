package ftn.uns.ac.rs.tim6.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ftn.uns.ac.rs.tim6.model.Age;

@RestController
@RequestMapping("/api")
public class AgeController {

	@RequestMapping(value = "/age",						//test 
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Age> getAllAges() {
        return null;
    }
	

}
