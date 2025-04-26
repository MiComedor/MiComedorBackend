package pe.edu.upc.micomedor.servicesInterfaces;
import pe.edu.upc.micomedor.entities.Budget;

import java.util.List;

public interface IBudgetService {
    public void insert(Budget budget);
    public void delete(int idBugget);
    public Budget listId(int idBudget);
    public List<Budget> list();
    public void update(Budget budget);
}
