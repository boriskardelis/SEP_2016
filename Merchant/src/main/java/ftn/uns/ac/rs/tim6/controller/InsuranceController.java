package ftn.uns.ac.rs.tim6.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.drools.runtime.StatefulKnowledgeSession;
import ftn.uns.ac.rs.tim6.dto.AgeSubCategoryDto;
import ftn.uns.ac.rs.tim6.dto.InsurancePriceDto;
import ftn.uns.ac.rs.tim6.dto.MerchantDto;
import ftn.uns.ac.rs.tim6.dto.PaymentUrlIdDto;
import ftn.uns.ac.rs.tim6.model.Insurance;
import ftn.uns.ac.rs.tim6.model.Pricelist;
import ftn.uns.ac.rs.tim6.model.RiskCategory;
import ftn.uns.ac.rs.tim6.model.RiskSubcategory;
import ftn.uns.ac.rs.tim6.service.InsuranceService;
import ftn.uns.ac.rs.tim6.service.RiskSubcategoryService;
import ftn.uns.ac.rs.tim6.util.DroolsReadKnowlageBase;

@RestController
@RequestMapping("/api")
public class InsuranceController {

	@Autowired
	InsuranceService insuranceService;

	@Autowired
	RiskSubcategoryService riskSubcategoryService;

	@RequestMapping(value = "/insurances", method = RequestMethod.GET)
	public ResponseEntity<List<Insurance>> handleGetAllInsurances() {
		List<Insurance> insurances = (List<Insurance>) insuranceService.getAll();
		return new ResponseEntity<List<Insurance>>(insurances, HttpStatus.OK);
	}

	@RequestMapping(value = "/price", method = RequestMethod.POST)
	public InsurancePriceDto handlePrice(@RequestBody String jsonInString) throws JsonProcessingException, IOException {

		InsurancePriceDto dto = new InsurancePriceDto();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(jsonInString);

		RiskSubcategory region = mapper.convertValue(node.get("region"), RiskSubcategory.class);
		RiskSubcategory sum = mapper.convertValue(node.get("sum"), RiskSubcategory.class);
		RiskSubcategory ageCarrier = mapper.convertValue(node.get("ageCarrier"), RiskSubcategory.class);

		Object ageType = mapper.convertValue(node.get("ageType"), Object.class);
		ArrayList<AgeSubCategoryDto> lista = citanjeAgeKategorija(ageType);

		for (AgeSubCategoryDto ageSubCategoryDto : lista) {
			System.out.println("id " + ageSubCategoryDto.getId());
			System.out.println("broj " + ageSubCategoryDto.getNumber());
		}

		dto.getRisks().add(region);
		dto.getRisks().add(sum);
		dto.getRisks().add(ageCarrier);

		DroolsReadKnowlageBase kbase = new DroolsReadKnowlageBase();

		try {

			StatefulKnowledgeSession ksession = kbase.getSession();
			ksession.insert(dto);
			ksession.fireAllRules();

		} catch (Exception e) {
			System.out.println(" GRESKA KOD DROOLS-A ");
			e.printStackTrace();
		}

		System.out.println("izasli iz drools-a, cena: " + dto.getTotalPrice());

		return dto;
	}
	
	@RequestMapping(value = "/buy", method = RequestMethod.POST)
	public ResponseEntity<PaymentUrlIdDto> handleBuy(@RequestBody Double suma) throws IOException {

		System.out.println("suma od frontenda: " + suma);
		PaymentUrlIdDto puid = new PaymentUrlIdDto();
		MerchantDto mdto = new MerchantDto();
		mdto.setAmount(suma);

		try {
			
			RestTemplate client = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<MerchantDto> entity = new HttpEntity<MerchantDto>(mdto,headers);
			
			puid = client.postForObject("http://localhost:7070/api/urlid",entity, PaymentUrlIdDto.class);
			return new ResponseEntity<PaymentUrlIdDto>(puid, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<PaymentUrlIdDto>(puid, HttpStatus.BAD_REQUEST);
		}
		
		

	}

	private ArrayList<AgeSubCategoryDto> citanjeAgeKategorija(Object ageType) {
		String ageString = ageType.toString();
		ageString = ageString.replace("{", "");
		ageString = ageString.replace("}", "");
		ageString = ageString.replace(",", "");
		
		/*RiskSubcategory sub = new RiskSubcategory();
		RiskCategory cat = new RiskCategory();
		
		
		Pricelist pricelist = new Pricelist();*/
		
		

		String[] parts = ageString.split("idAgeSub=");
		String kolicina = parts[0];
		String kljucevi = parts[1];
		ArrayList<AgeSubCategoryDto> lista = new ArrayList<AgeSubCategoryDto>();

		for (String retval : kljucevi.split(" ")) {

			AgeSubCategoryDto ascd = new AgeSubCategoryDto();
			ascd.setId(Character.getNumericValue(retval.charAt(2)));

			for (String retvalKolicina : kolicina.split(" ")) {

				int kljuc1 = Character.getNumericValue(retval.charAt(0));
				int kljuc2 = Character.getNumericValue(retvalKolicina.charAt(0));

				if (kljuc1 == kljuc2) {
					String[] partsKolicina = retvalKolicina.split("=");
					String brojOsoba = partsKolicina[1];
					ascd.setNumber(Integer.valueOf(brojOsoba));
				}
			}

			lista.add(ascd);
		}
		return lista;
	}

}
