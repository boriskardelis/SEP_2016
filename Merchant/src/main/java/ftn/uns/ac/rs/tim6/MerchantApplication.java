package ftn.uns.ac.rs.tim6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ftn.uns.ac.rs.tim6.model.Age;

@SpringBootApplication
public class MerchantApplication {

	public static void main(String[] args) {
		SpringApplication.run(MerchantApplication.class, args); 
		System.out.println("hello");
		
		Age newAge = new Age();
		long i = 12348910;
		newAge.setId(i);
		newAge.setAgeRiskValue(2.5);
		
		
	}
}
