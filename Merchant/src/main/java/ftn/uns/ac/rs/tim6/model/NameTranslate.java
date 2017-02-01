package ftn.uns.ac.rs.tim6.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "NAME_TRANSLATE")
public class NameTranslate implements Serializable  {
 
 private static final long serialVersionUID = 1L;
 
  @Id
  @GeneratedValue
  @Column(name = "NAME_TRANSLATE_ID")
  private long id;
  
  @Column(name = "NAME")
  private String name;
  
  
  
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "LANGUAGE")
  //@JsonManagedReference
  private Language language;

 public long getId() {
  return id;
 }

 public void setId(long id) {
  this.id = id;
 }

 

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public Language getLanguage() {
  return language;
 }

 public void setLanguage(Language language) {
  this.language = language;
 }

 public NameTranslate(long id, String name, Language language) {
  super();
  this.id = id;
  this.name = name;
  this.language = language;
 }

 public NameTranslate() {
  super();
  // TODO Auto-generated constructor stub
 }
  
  

}