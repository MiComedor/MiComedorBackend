package pe.edu.upc.micomedor.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.micomedor.dtos.RationDTO;
import pe.edu.upc.micomedor.entities.Ration;
import pe.edu.upc.micomedor.servicesInterfaces.IRationService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ration")
public class RationController {
    @Autowired
    private IRationService rS;

    @PostMapping
    public void insertar(@RequestBody RationDTO rationDTO){
        ModelMapper m=new ModelMapper();
        Ration r=m.map(rationDTO, Ration.class);
        rS.insert(r);
    }

    @GetMapping
    public List<RationDTO> listar(){
        return rS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, RationDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){ rS.delete(id);}

    @PutMapping
    public void update(@RequestBody RationDTO dto) {
        ModelMapper m = new ModelMapper();
        Ration r = m.map(dto, Ration.class);
        rS.insert(r);
    }

    @GetMapping("/{id}")
    public RationDTO listById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        Ration ration = rS.listId(id);
        return m.map(ration, RationDTO.class);
    }
}
