package pe.edu.upc.micomedor.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.micomedor.entities.BudgetCategory;

@Repository
public interface IBudgetCategoryRepository extends JpaRepository<BudgetCategory, Integer> {
}
