package ftn.uns.ac.rs.tim6.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ftn.uns.ac.rs.tim6.model.NameTranslate;
import ftn.uns.ac.rs.tim6.service.NameTranslateService;

@RestController
@RequestMapping("/api")
public class NameTranslateController {
 
 @Autowired
 NameTranslateService nameTranslateService;
 
 @RequestMapping(value = "/nametranslates", method = RequestMethod.GET)
 public ResponseEntity<List<NameTranslate>> getNameTranslates() {
  List<NameTranslate> nametranslates = (List<NameTranslate>) nameTranslateService.getAll();
  return new ResponseEntity<List<NameTranslate>>(nametranslates, HttpStatus.OK);
 }

}