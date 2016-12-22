package ftn.uns.ac.rs.tim6.dto;

import java.util.ArrayList;
import java.util.List;

import ftn.uns.ac.rs.tim6.model.PricelistItem;

public class InsurancePriceDto {

	private double premiumPrice;
	private double taxPrice;
	private double discountPrice;
	private double totalPrice;

	private int days;

	private ArrayList<PricelistItem> items = new ArrayList<PricelistItem>();
	private ArrayList<AgeSubCategoryDto> ages = new ArrayList<AgeSubCategoryDto>();

	public double getPremiumPrice() {
		return premiumPrice;
	}

	public void setPremiumPrice(double premiumPrice) {
		this.premiumPrice = premiumPrice;
	}

	public double getTaxPrice() {
		return taxPrice;
	}

	public void setTaxPrice(double taxPrice) {
		this.taxPrice = taxPrice;
	}

	public double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public List<AgeSubCategoryDto> getAges() {
		return ages;
	}

	public ArrayList<PricelistItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<PricelistItem> items) {
		this.items = items;
	}

	public void setAges(ArrayList<AgeSubCategoryDto> ages) {
		this.ages = ages;
	}

}
