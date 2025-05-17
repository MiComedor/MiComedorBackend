package pe.edu.upc.micomedor.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.micomedor.dtos.RationTypeDTO;
import pe.edu.upc.micomedor.entities.RationType;
import pe.edu.upc.micomedor.servicesInterfaces.IRationTypeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rationType")
public class RationTypeController {
    @Autowired
    private IRationTypeService rtS;

    @PostMapping
    public void insertar(@RequestBody RationTypeDTO rationTypeDTO){
        ModelMapper m=new ModelMapper();
        RationType rt=m.map(rationTypeDTO, RationType.class);
        rtS.insert(rt);
    }

    @GetMapping
    public List<RationTypeDTO> listar(){
        return rtS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, RationTypeDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){ rtS.delete(id);}

    @PutMapping
    public void update(@RequestBody RationTypeDTO dto) {
        ModelMapper m = new ModelMapper();
        RationType u = m.map(dto, RationType.class);
        rtS.insert(u);
    }

    @GetMapping("/{id}")
    public RationTypeDTO listById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        RationType rt = rtS.listId(id);
        return m.map(rt, RationTypeDTO.class);
    }
}