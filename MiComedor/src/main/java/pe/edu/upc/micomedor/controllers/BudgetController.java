package pe.edu.upc.micomedor.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.micomedor.dtos.BudgetDTO;
import pe.edu.upc.micomedor.entities.Budget;
import pe.edu.upc.micomedor.servicesInterfaces.IBudgetService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/budget")
public class BudgetController {
    @Autowired
    private IBudgetService bS;

    @PostMapping
    public void insertar(@RequestBody BudgetDTO budgetDTO){
        ModelMapper m=new ModelMapper();
        Budget b=m.map(budgetDTO, Budget.class);
        bS.insert(b);
    }

    @GetMapping
    public List<BudgetDTO> listar(){
        return bS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, BudgetDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){ bS.delete(id);}

    @PutMapping
    public void update(@RequestBody BudgetDTO dto) {
        ModelMapper m = new ModelMapper();
        Budget b = m.map(dto, Budget.class);
        bS.insert(b);
    }

    @GetMapping("/{id}")
    public BudgetDTO listById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        Budget budget = bS.listId(id);
        return m.map(budget, BudgetDTO.class);
    }
}
