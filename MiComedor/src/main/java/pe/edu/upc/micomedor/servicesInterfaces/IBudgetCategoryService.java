package pe.edu.upc.micomedor.servicesInterfaces;

import pe.edu.upc.micomedor.entities.BudgetCategory;
import pe.edu.upc.micomedor.entities.ProductType;

import java.util.List;

public interface IBudgetCategoryService {
    public void insert(BudgetCategory pt);

    public List<BudgetCategory> list();

    public BudgetCategory listId(int id);

    public void delete(int id);

    void update(BudgetCategory budgetCategory);


}