package pe.edu.upc.micomedor.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.micomedor.dtos.TaskCoordinationDTO;
import pe.edu.upc.micomedor.entities.TaskCoordination;
import pe.edu.upc.micomedor.servicesInterfaces.ITaskCoordinationService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/taskCoordination")
public class TaskCoordinationController {
    @Autowired
    private ITaskCoordinationService tcS;

    @PostMapping
    public void insertar(@RequestBody TaskCoordinationDTO taskCoordinationDTO){
        ModelMapper m=new ModelMapper();
        TaskCoordination tc=m.map(taskCoordinationDTO, TaskCoordination.class);
        tcS.insert(tc);
    }

    @GetMapping
    public List<TaskCoordinationDTO> listar(){
        return tcS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, TaskCoordinationDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){ tcS.delete(id);}

    @PutMapping
    public void update(@RequestBody TaskCoordinationDTO dto) {
        ModelMapper m = new ModelMapper();
        TaskCoordination tc = m.map(dto, TaskCoordination.class);
        tcS.insert(tc);
    }

    @GetMapping("/{id}")
    public TaskCoordinationDTO listById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        TaskCoordination taskCoordination = tcS.listId(id);
        return m.map(taskCoordination, TaskCoordinationDTO.class);
    }
}