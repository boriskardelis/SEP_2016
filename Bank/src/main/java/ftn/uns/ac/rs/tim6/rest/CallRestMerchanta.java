package ftn.uns.ac.rs.tim6.rest;

import static org.mockito.Matchers.anyInt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import ftn.uns.ac.rs.tim6.model.PodaciOdMerchanta;

@Component
public class CallRestMerchanta implements CommandLineRunner {
	
	public static void callRestMerchanta(){
		/*RestTemplate restTemplate = new RestTemplate();
		PodaciOdMerchanta[] podaciOdMerchanta = restTemplate.getForObject("http://localhost:8080/api/payments", PodaciOdMerchanta[].class);
		System.out.println("Od merchanta sam dobio " + podaciOdMerchanta[0]);*/
		
		/*RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<PodaciOdMerchanta>> response =
		        restTemplate.exchange("hhttp://localhost:8080/api/payments",
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<PodaciOdMerchanta>>() {
		            });
		List<PodaciOdMerchanta> podaciOdMerchanta = response.getBody();
		System.out.println("Od merchanta sam dobio " + podaciOdMerchanta.isEmpty());*/
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<PodaciOdMerchanta[]> response = restTemplate.getForEntity("http://localhost:8080/api/payments", PodaciOdMerchanta[].class);
		PodaciOdMerchanta[] podaciOdMerchanta  = response.getBody();
		System.out.println("Od merchanta sam dobio " + podaciOdMerchanta[0].getMerchantId() + " " 	+ podaciOdMerchanta[0].getMerchantOrderId());
		
	}

	@Override
	public void run(String... args) throws Exception {
		callRestMerchanta();
		
	}

}
