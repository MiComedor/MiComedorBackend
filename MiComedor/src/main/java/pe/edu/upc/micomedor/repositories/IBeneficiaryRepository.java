package pe.edu.upc.micomedor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.micomedor.entities.Beneficiary;

import java.util.List;

@Repository
public interface IBeneficiaryRepository extends JpaRepository<Beneficiary, Integer> {

    @Query(value = "select * from beneficiary where user_id = :idUser", nativeQuery = true)
    List<Beneficiary> findBeneficiaryByUserId(@Param("idUser") int idUser);

    @Modifying
    @Query(value = "UPDATE beneficiary SET is_active = false WHERE id_beneficiary= :id", nativeQuery = true)
    void deleteBeneficiaryActive(@Param("id") int id);

    @Query(value = "select * from beneficiary where is_active = true and user_id = :userId", nativeQuery = true)
    List<Beneficiary> findActiveByUserId(@Param("userId") int userId);

    @Query(value = "select * from beneficiary where user_id = :idUser and dni_benefeciary = :dniBenefiary", nativeQuery = true)
    Beneficiary buscarBeneficiarioPorDni(@Param("idUser") int idUser, @Param("dniBenefiary") int dniBeneficiary);

    // 💡 ADDED (unicidad GLOBAL de DNI, consistente con @Column(unique = true))
    boolean existsByDniBenefeciaryAndIdBeneficiaryNot(int dniBenefeciary, int idBeneficiary);

    // 💡 ADDED (alternativa si cambias a unicidad POR USUARIO)
    boolean existsByUsers_IdUserAndDniBenefeciaryAndIdBeneficiaryNot(int idUser, int dniBenefeciary, int idBeneficiary);
}
