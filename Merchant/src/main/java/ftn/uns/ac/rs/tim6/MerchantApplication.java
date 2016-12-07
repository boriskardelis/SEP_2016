package ftn.uns.ac.rs.tim6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.drools.runtime.StatefulKnowledgeSession;

import ftn.uns.ac.rs.tim6.model.Buyer;
import ftn.uns.ac.rs.tim6.util.DroolsReadKnowlageBase;

@SpringBootApplication
public class MerchantApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(MerchantApplication.class, args);
		System.out.println("Pokrenuta aplikacija");
		
		
		
		try {
			DroolsReadKnowlageBase kbase = new DroolsReadKnowlageBase();
			StatefulKnowledgeSession ksession = kbase.getSession();
			Buyer buyer = new Buyer(10);
			ksession.insert(buyer);
			
			System.out.println("buyerov telefon " + buyer.getPhoneNumber());
			
			ksession.fireAllRules();
			
			System.out.println("buyerov telefon " + buyer.getPhoneNumber());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
	

	}
}
