package ftn.uns.ac.rs.tim6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ftn.uns.ac.rs.tim6.model.Pricelist;
import ftn.uns.ac.rs.tim6.model.RiskSubcategory;

@Repository
public interface RiskSubcategoryRepository extends JpaRepository<RiskSubcategory, Long> {

	@Query("SELECT r FROM RiskSubcategory r INNER JOIN r.nameTranslate n INNER JOIN n.language l INNER JOIN r.pricelistItems p INNER JOIN p.pricelist pp WHERE l.languageName = :language AND :pricelistOne = p.pricelist ")
	public List<RiskSubcategory> findSubcategoriesByLanguage(@Param("language") String language, @Param("pricelistOne") Pricelist pricelistOne);

}