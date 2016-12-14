package ftn.uns.ac.rs.tim6.repository;
import ftn.uns.ac.rs.tim6.model.IssuerMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IssuerMessageRepository extends JpaRepository<IssuerMessage, Long> {

}
