package pe.edu.upc.micomedor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.micomedor.entities.Ration;

@Repository
public interface IRationRepository extends JpaRepository<Ration, Integer> {
    @Query(value = "select * from ration where user_id = :idUser", nativeQuery = true)
    List<Ration> findRationByUserId(@Param("idUser") int idUser);

}
