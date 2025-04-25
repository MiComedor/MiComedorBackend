package pe.edu.upc.micomedor.repositories;

import org.springframework.data.repository.CrudRepository;
import pe.edu.upc.micomedor.entities.BudgetCategory;

public interface IBudgetCategoryRepository extends CrudRepository<BudgetCategory, Integer> {
}
