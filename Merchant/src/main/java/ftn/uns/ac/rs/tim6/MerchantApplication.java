package ftn.uns.ac.rs.tim6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ftn.uns.ac.rs.tim6.model.Age;

@SpringBootApplication
public class MerchantApplication {

    public static void main(String[] args) {
    	System.out.println("ASDADA");
    	
    	Age newAge = new Age();
    	long id = 12312312;
    	newAge.setId(id);
    	newAge.setAgeRiskValue(1.3);
    	 
        SpringApplication.run(MerchantApplication.class, args);
        
        System.out.println(newAge.getId());
    }

}


