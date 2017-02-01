package ftn.uns.ac.rs.tim6.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ftn.uns.ac.rs.tim6.model.Language;
import ftn.uns.ac.rs.tim6.repository.LanguageRepository;

@Service
@Transactional
public class LanguageService  implements GenericService<Language>{
 
 @Autowired
 private LanguageRepository languageRepository;
  
 public List<Language> getAll() {
  return languageRepository.findAll();
 }

 @Override
 public Language save(Language t) {
  return languageRepository.save(t);
 }

 @Override
 public Language findById(long id) {
  return languageRepository.findOne(id);
 }

}