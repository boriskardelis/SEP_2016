package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "LANGUAGE")
public class Language implements Serializable{
 
 private static final long serialVersionUID = 1L;
 
  @Id
  @GeneratedValue
  @Column(name = "LANGUAGE_ID")
  private long id;
  
  @Column(name = "LANGUAGE_NAME")
  private String languageName;
  
  
  @OneToMany(mappedBy = "language", cascade = CascadeType.ALL)
  @JsonBackReference
  private List<NameTranslate> nameTranslate;

 public long getId() {
  return id;
 }

 public void setId(long id) {
  this.id = id;
 }

 public String getLanguageName() {
  return languageName;
 }

 public void setLanguageName(String languageName) {
  this.languageName = languageName;
 }

 public List<NameTranslate> getNameTranslate() {
  return nameTranslate;
 }

 public void setNameTranslate(List<NameTranslate> nameTranslate) {
  this.nameTranslate = nameTranslate;
 } 

 public Language(long id, String languageName, List<NameTranslate> nameTranslate) {
  super();
  this.id = id;
  this.languageName = languageName;
  this.nameTranslate = nameTranslate;
 }

 public Language() {
  super();
  // TODO Auto-generated constructor stub
 }
  
 

}