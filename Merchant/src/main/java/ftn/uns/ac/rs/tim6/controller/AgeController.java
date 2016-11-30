<<<<<<< HEAD
package ftn.uns.ac.rs.tim6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ftn.uns.ac.rs.tim6.model.Age;
import ftn.uns.ac.rs.tim6.service.AgeService;

@RestController
@RequestMapping("/api")
public class AgeController {
	
	@Autowired
	AgeService ageService;
	
	/*@RequestMapping(value = "/age",						
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Age> getAllAges(@RequestBody Age age) {
		System.out.println("USAO0000000000000000000000000000000");
        return null;
    }*/
	
	@RequestMapping(value = "/ages",						 
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Age> accountSummary() {
	    return ageService.getAll();
	}
	
	}
=======
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
>>>>>>> branch 'master' of https://github.com/boriskardelis/SEP_2016
