package ftn.uns.ac.rs.tim6.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ftn.uns.ac.rs.tim6.model.Pricelist;
import ftn.uns.ac.rs.tim6.model.RiskSubcategory;

@Repository
public interface RiskSubcategoryRepository extends JpaRepository<RiskSubcategory, Long> {
	
	
	// @Query("SELECT r FROM RiskSubcategory r INNER JOIN r.nameTranslate n INNER JOIN n.language l INNER JOIN r.pricelistItems p INNER JOIN p.pricelist pp WHERE l.languageName = :language AND pp.startDate < :sqlDate ORDER BY pp.startDate DESC LIMIT 1")
	// public List<RiskSubcategory> findSubcategoriesByLanguage(@Param("language") String language, @Param("sqlDate") Date sqlDate);
	 
	 @Query("SELECT r FROM RiskSubcategory r INNER JOIN r.nameTranslate n INNER JOIN n.language l INNER JOIN r.pricelistItems p INNER JOIN p.pricelist pp WHERE l.languageName = :language AND :pricelistOne = p.pricelist ")
	 public List<RiskSubcategory> findSubcategoriesByLanguage(@Param("language") String language, @Param("pricelistOne") Pricelist pricelistOne);
	 
	
}

//SELECT * FROM pricelist p WHERE start_date < "2017-10-11 00:00:00" order by start_date desc LIMIT 1;

//SELECT * FROM risk_subcategory r INNER JOIN name_translate n ON r.name_translate = n.name_translate_id INNER JOIN language l ON n.language = l.language_id INNER JOIN 
//pricelist_item p ON p.risk_subcategory = r.risk_subcategory_id INNER JOIN pricelist pp ON pp.pricelist_id = p.pricelist WHERE l.language_name = 'English' AND pp.start_date