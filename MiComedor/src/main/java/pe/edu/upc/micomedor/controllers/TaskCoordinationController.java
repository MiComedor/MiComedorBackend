package pe.edu.upc.micomedor.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.micomedor.dtos.RationByUserIdDTO;
import pe.edu.upc.micomedor.dtos.TaskCoordinationByUserIdDTO;
import pe.edu.upc.micomedor.dtos.TaskCoordinationDTO;
import pe.edu.upc.micomedor.entities.Ration;
import pe.edu.upc.micomedor.entities.TaskCoordination;
import pe.edu.upc.micomedor.servicesInterfaces.ITaskCoordinationService;

import java.util.List;
import java.util.ArrayList;
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

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id,@RequestBody TaskCoordinationDTO dto) {
        dto.setIdTaskCoordination(id);
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

    @GetMapping("/taskCoordinationByUser/{idUser}")
    public List<TaskCoordinationByUserIdDTO> obtenerListaTareasPorUsuario(@PathVariable int idUser) {
        List<TaskCoordination> taskCoordinations = tcS.findTaskCoordinationByUserId(idUser);
        List<TaskCoordinationByUserIdDTO> resultado = new ArrayList<>();

        for (TaskCoordination taskCoordination : taskCoordinations) {
            TaskCoordinationByUserIdDTO dto = new TaskCoordinationByUserIdDTO();
            dto.setIdTaskCoordination(taskCoordination.getIdTaskCoordination());
            dto.setFullname(taskCoordination.getFullname());
            dto.setDateTask(taskCoordination.getDateTask());
            dto.setTimeTask(taskCoordination.getTimeTask());
            dto.setNameTypeTask(taskCoordination.getTypeOfTask().getNameTypeTask());
            resultado.add(dto);
        }

        return resultado;
    }
}