package ftn.uns.ac.rs.tim6.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
import ftn.uns.ac.rs.tim6.model.PricelistItem;
import ftn.uns.ac.rs.tim6.model.RiskSubcategory;
import ftn.uns.ac.rs.tim6.service.InsuranceService;
import ftn.uns.ac.rs.tim6.service.PricelistService;
import ftn.uns.ac.rs.tim6.service.RiskSubcategoryService;
import ftn.uns.ac.rs.tim6.util.DroolsReadKnowlageBase;

@RestController
@RequestMapping("/api")
public class InsuranceController {

	@Autowired
	InsuranceService insuranceService;

	@Autowired
	RiskSubcategoryService riskSubcategoryService;

	@Autowired
	PricelistService pricelistService;

	@RequestMapping(value = "/insurances", method = RequestMethod.GET)
	public ResponseEntity<List<Insurance>> handleGetAllInsurances() {
		List<Insurance> insurances = (List<Insurance>) insuranceService.getAll();
		return new ResponseEntity<List<Insurance>>(insurances, HttpStatus.OK);
	}

	@RequestMapping(value = "/price", method = RequestMethod.POST)
	public InsurancePriceDto handlePrice(@RequestBody String jsonInString) throws JsonProcessingException, IOException {

		InsurancePriceDto dto = new InsurancePriceDto();
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<RiskSubcategory> riskSubcategories = new ArrayList<RiskSubcategory>();
		List<PricelistItem> curentPricelistItems = pricelistService.getCurrentPricelistItems();
		DroolsReadKnowlageBase kbase = new DroolsReadKnowlageBase();

		/* CITANJE PODATAKA OD FRONTEND-A */
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

		riskSubcategories.add(region);
		riskSubcategories.add(sum);
		riskSubcategories.add(ageCarrier);

		for (RiskSubcategory risk : riskSubcategories) {
			for (PricelistItem item : curentPricelistItems) {
				if (item.getRiskSubcategory().getName().equals(risk.getName())) {
//					System.out.println("ODABRANI");
//					System.out.println("od fronta risk: " + risk.getName());
//					System.out.println("od fronta item: " + item.getRiskSubcategory().getName());
					dto.getItems().add(item);
				}
			}
		}

		/* CITANJE PODATAKA OD FRONTEND-A */

		try {

			System.out.println(" ULAZIMO U DROOLS ");
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
	public ResponseEntity<PaymentUrlIdDto> handleBuy(@RequestBody BigDecimal suma) throws IOException {

		System.out.println("suma od frontenda: " + suma);
		PaymentUrlIdDto puid = new PaymentUrlIdDto();
		Random randomGenerator = new Random();
		MerchantDto mdto = new MerchantDto();
		RestTemplate client = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();

		// TODO korak 2. setovati sve atribute u merchantu
		mdto.setMerchantId("merchantov id");
		mdto.setMerchantPassword("password");
		mdto.setAmount(suma);
		// TODO korak 2.1 orderId Number(10) -> Integer duzine 10
		mdto.setMerchantOrderID(randomGenerator.nextInt(1000));
		// TODO korak 2.2 kakav i odakle timestamp
		mdto.setMerchantTimestamp(new Date());
		// TODO korak 2.3 univerzalan url?
//		mdto.setErrorUrl("www.error.url");

		try {

			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<MerchantDto> entity = new HttpEntity<MerchantDto>(mdto, headers);

			puid = client.postForObject("http://localhost:7070/api/urlid", entity, PaymentUrlIdDto.class);
			System.out.println(puid);
			System.out.println(puid.getPaymentId());
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
