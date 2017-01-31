package ftn.uns.ac.rs.tim6.dto;

import java.util.ArrayList;
import java.util.Date;
import ftn.uns.ac.rs.tim6.model.RiskSubcategory;

public class InsuranceDto {

	private ArrayList<RiskSubcategory> itemsListForDrools = new ArrayList<RiskSubcategory>();
	private Date startDate;
	private Date endDate;
	private ArrayList<AgeSubCategoryDto> ageList = new ArrayList<AgeSubCategoryDto>();

	public ArrayList<RiskSubcategory> getItemsListForDrools() {
		return itemsListForDrools;
	}

	public void setItemsListForDrools(ArrayList<RiskSubcategory> itemsListForDrools) {
		this.itemsListForDrools = itemsListForDrools;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public ArrayList<AgeSubCategoryDto> getAgeList() {
		return ageList;
	}

	public void setAgeList(ArrayList<AgeSubCategoryDto> ageList) {
		this.ageList = ageList;
	}

}
