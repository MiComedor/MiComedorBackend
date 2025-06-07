package pe.edu.upc.micomedor.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.micomedor.dtos.BudgetCategoryDTO;
import pe.edu.upc.micomedor.entities.BudgetCategory;
import pe.edu.upc.micomedor.servicesInterfaces.IBudgetCategoryService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/budgetCategory")
public class BudgetCategoryController {
    @Autowired
    private IBudgetCategoryService bcS;

    @PostMapping
    public void insertar(@RequestBody BudgetCategoryDTO budgetCategoryDTO){
        ModelMapper m=new ModelMapper();
        BudgetCategory bc=m.map(budgetCategoryDTO, BudgetCategory.class);
        bcS.insert(bc);
    }

    @GetMapping
    public List<BudgetCategoryDTO> listar(){
        return bcS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, BudgetCategoryDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){ bcS.delete(id);}

    @PutMapping
    public void update(@RequestBody BudgetCategoryDTO dto) {
        ModelMapper m = new ModelMapper();
        BudgetCategory u = m.map(dto, BudgetCategory.class);
        bcS.insert(u);
    }

    @GetMapping("/{id}")
    public BudgetCategoryDTO listById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        BudgetCategory bc = bcS.listId(id);
        return m.map(bc, BudgetCategoryDTO.class);
    }
}
