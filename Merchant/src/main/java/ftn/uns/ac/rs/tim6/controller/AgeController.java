
package ftn.uns.ac.rs.tim6.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import ftn.uns.ac.rs.tim6.model.Age;
import ftn.uns.ac.rs.tim6.service.AgeService;

@RestController
@RequestMapping("/api")
public class AgeController {

	@Autowired
	AgeService ageService;

	@RequestMapping(value = "/ages", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Age> handleGetAllAges() {
		return ageService.getAll();
	}
	
/*	@RequestMapping(value = "/ages", method = RequestMethod.POST)
	public Age handlePostAge(@Valid @RequestBody Age ageResource) {
		Age age = new Age();
		age.setAge(ageResource.getAge());
		Age saved = ageService.save(age);
		return new Age(saved.getAge(), saved.getRiskValue());
	}
*/
}
