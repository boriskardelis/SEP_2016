package ftn.uns.ac.rs.tim6.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ftn.uns.ac.rs.tim6.model.Pricelist;

@Repository
public interface PricelistRepository extends JpaRepository<Pricelist, Long> {
	
	 @Query("SELECT pp FROM Pricelist pp WHERE pp.startDate < :sqlDate ORDER BY pp.startDate DESC") 
	 public List<Pricelist> findCurrentPriceList(@Param("sqlDate") Date sqlDate);
	  

}
