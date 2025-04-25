package pe.edu.upc.micomedor.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.micomedor.entities.BudgetCategory;

import pe.edu.upc.micomedor.repositories.IBudgetCategoryRepository;
import pe.edu.upc.micomedor.servicesInterfaces.IBudgetCategoryService;


import java.util.List;


@Service
public class BudgetCategoryServiceImplement implements IBudgetCategoryService {
    @Autowired
    private IBudgetCategoryRepository bcR;
    @Override
    public void insert(BudgetCategory budgetCategory) {bcR.save(budgetCategory);}
    @Override
    public void delete(int id) {
        bcR.deleteById(id);
    }
    @Override
    public BudgetCategory listId(int id) {
        return bcR.findById(id).orElse(new BudgetCategory());
    }
    @Override
    public List<BudgetCategory> list() {
        return (List<BudgetCategory>) bcR.findAll();
    }
    @Override
    public void update(BudgetCategory budgetCategory) { bcR.save(budgetCategory);
    }

}