package ftn.uns.ac.rs.tim6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.ac.rs.tim6.model.RoadHelpInsurance;

@Repository
public interface RoadHelpInsuranceRepository extends JpaRepository<RoadHelpInsurance, Long>  {

}
