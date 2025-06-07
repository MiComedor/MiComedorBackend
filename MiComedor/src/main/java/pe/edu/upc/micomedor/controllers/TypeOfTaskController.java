package pe.edu.upc.micomedor.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.micomedor.dtos.TypeOfTaskDTO;
import pe.edu.upc.micomedor.entities.TypeOfTask;
import pe.edu.upc.micomedor.servicesInterfaces.ITypeOfTaskService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/typeOfTask")
public class TypeOfTaskController {
    @Autowired
    private ITypeOfTaskService totS;

    @PostMapping
    public void insertar(@RequestBody TypeOfTaskDTO typeOfTaskDTO){
        ModelMapper m=new ModelMapper();
        TypeOfTask tot=m.map(typeOfTaskDTO, TypeOfTask.class);
        totS.insert(tot);
    }

    @GetMapping
    public List<TypeOfTaskDTO> listar(){
        return totS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, TypeOfTaskDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){ totS.delete(id);}

    @PutMapping
    public void update(@RequestBody TypeOfTaskDTO dto) {
        ModelMapper m = new ModelMapper();
        TypeOfTask u = m.map(dto, TypeOfTask.class);
        totS.insert(u);
    }

    @GetMapping("/{id}")
    public TypeOfTaskDTO listById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        TypeOfTask tot = totS.listId(id);
        return m.map(tot, TypeOfTaskDTO.class);
    }
}
