package pe.edu.upc.micomedor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.micomedor.entities.Product;
import pe.edu.upc.micomedor.entities.Ration;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "SELECT * FROM product WHERE user_id = :idUser", nativeQuery = true)
    List<Product> findProductsByUserId(@Param("idUser") int idUser);
}
