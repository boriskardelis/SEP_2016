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

	public Pricelist findCurrentPriceList() {
		List<Pricelist> lista = pricelistRepository.findCurrentPriceList(new Date());
		return lista.get(0);
	}

	public List<RiskSubcategory> getCurrentPricelistSubcategories() {

		Pricelist p = findCurrentPriceList();
		List<PricelistItem> pricelistItems = p.getPricelistItems();
		List<RiskSubcategory> riskSubcategories = new ArrayList<RiskSubcategory>();

		for (PricelistItem listItem : pricelistItems) {
			riskSubcategories.add(listItem.getRiskSubcategory());
		}

		return riskSubcategories;
	}

	public List<PricelistItem> getCurrentPricelistItems() {
		Pricelist p = findCurrentPriceList();
		List<PricelistItem> pricelistItems = p.getPricelistItems();
		return pricelistItems;
	}

}
