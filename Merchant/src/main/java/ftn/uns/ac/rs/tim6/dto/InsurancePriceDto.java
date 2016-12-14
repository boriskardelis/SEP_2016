package ftn.uns.ac.rs.tim6.dto;

import java.util.ArrayList;
import java.util.List;

import ftn.uns.ac.rs.tim6.model.RiskSubcategory;

public class InsurancePriceDto {
	
	private double premiumPrice;
	private double taxPrice;
	private double discountPrice;
	private double totalPrice;
	private List<RiskSubcategory> risks = new ArrayList<RiskSubcategory>();
	private int days;
	
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
	public List<RiskSubcategory> getRisks() {
		return risks;
	}
	public void setRisks(List<RiskSubcategory> risks) {
		this.risks = risks;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}

}
