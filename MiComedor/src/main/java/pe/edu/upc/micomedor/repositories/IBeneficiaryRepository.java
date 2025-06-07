package pe.edu.upc.micomedor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.micomedor.entities.Beneficiary;
import pe.edu.upc.micomedor.entities.Ration;

import java.util.List;

@Repository
public interface IBeneficiaryRepository extends JpaRepository<Beneficiary, Integer> {
    @Query(value = "select * from beneficiary where user_id = :idUser", nativeQuery = true)
    List<Beneficiary> findBeneficiaryByUserId(@Param("idUser") int idUser);
}
