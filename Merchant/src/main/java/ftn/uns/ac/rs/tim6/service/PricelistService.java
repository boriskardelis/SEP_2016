package ftn.uns.ac.rs.tim6.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.uns.ac.rs.tim6.model.Pricelist;
import ftn.uns.ac.rs.tim6.model.PricelistItem;
import ftn.uns.ac.rs.tim6.model.RiskSubcategory;
import ftn.uns.ac.rs.tim6.repository.PricelistRepository;
import ftn.uns.ac.rs.tim6.util.DateConverter;

@Service
@Transactional
public class PricelistService implements GenericService<Pricelist> {

	@Autowired
	private PricelistRepository pricelistRepository;

	public List<Pricelist> getAll() {
		return pricelistRepository.findAll();
	}

	@Override
	public Pricelist save(Pricelist t) {
		return pricelistRepository.save(t);
	}

	@Override
	public Pricelist findById(long id) {
		return pricelistRepository.findOne(id);
	}

	public Pricelist getCurrentPricelist() {
		List<Pricelist> allPricelists = pricelistRepository.findAll();
		Date danas = new Date();
//		Date uporedi = new Date();

		System.out.println("new Date danas +++ " + danas);

		for (Pricelist pricelist : allPricelists) {
			
			Date noviDatum = DateConverter.convertToJavaDate(pricelist.getStartDate());
			System.out.println("1 svi pricelist datumi: " + noviDatum);
			if (noviDatum.after(danas)) {
				//jos ne vazi
				System.out.println("2 jos ne vazi datumi: " + noviDatum);
			}else if (noviDatum.before(danas)) {
				//TODO nadji najnoviji
				//vracam prvi validan
				System.out.println("2 nadji najnoviji datumi: " + noviDatum);
				return pricelist;
			}

		}

		return null;

	}

	public List<RiskSubcategory> getCurrentPricelistSubcategories() {

		Pricelist p = getCurrentPricelist();
		List<PricelistItem> pricelistItems = p.getPricelistItems();
		List<RiskSubcategory> riskSubcategories = new ArrayList<RiskSubcategory>();

		System.out.println("izvlacimo subCategory ");
		for (PricelistItem listItem : pricelistItems) {
			riskSubcategories.add(listItem.getRiskSubcategory());
//			System.out.println(listItem.getRiskSubcategory().getName());
		}

		return riskSubcategories;
	}

	public List<PricelistItem> getCurrentPricelistItems() {
		Pricelist p = getCurrentPricelist();
		List<PricelistItem> pricelistItems = p.getPricelistItems();
		return pricelistItems;
	}

}
