package ftn.uns.ac.rs.tim6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.uns.ac.rs.tim6.model.Age;

@SpringBootApplication
//@RestController
public class MerchantApplication {

   /* @RequestMapping("/")
    public String home() {
        return "Hello Docker World asda ";
    }*/
	

    public static void main(String[] args) {
    	System.out.println("ASDADA");
    	
    	Age newAge = new Age();
    	long id = 12312312;
    	newAge.setId(id);
    	newAge.setHomeRiskValue(1.3);
    	 
        SpringApplication.run(MerchantApplication.class, args);
        
        System.out.println(newAge.getId());
    }

}