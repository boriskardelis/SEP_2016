package ftn.uns.ac.rs.tim6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class MerchantApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		
		SpringApplication.run(MerchantApplication.class, args);
		System.out.println("Merchant pokrenut");

	}
	//war
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MerchantApplication.class);
    }
	
}
