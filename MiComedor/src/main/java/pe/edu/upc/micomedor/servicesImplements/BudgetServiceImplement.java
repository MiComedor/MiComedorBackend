package pe.edu.upc.micomedor.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.micomedor.entities.Budget;
import pe.edu.upc.micomedor.repositories.IBudgetRepository;
import pe.edu.upc.micomedor.repositories.IProductTypeRepository;
import pe.edu.upc.micomedor.servicesInterfaces.IBudgetService;

import java.util.List;

@Service
public class BudgetServiceImplement implements IBudgetService {
    @Autowired
    private IBudgetRepository bR;
    @Override
    public void insert(Budget budget) {
        bR.save(budget);
    }
    @Override
    public List<Budget> list() {
        return bR.findAll();
    }
    @Override
    public Budget listId(int id) {
        return bR.findById(id).orElse(new Budget());
    }
    @Override
    public void delete(int id) {
        bR.deleteById(id);
    }
    @Override
    public void update(Budget budget) {
        bR.save(budget);
    }
}
