package pe.edu.upc.micomedor.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.micomedor.entities.TaskCoordination;
import pe.edu.upc.micomedor.repositories.ITaskCoordinationRepository;
import pe.edu.upc.micomedor.servicesInterfaces.ITaskCoordinationService;

import java.util.List;

@Service
public class TaskCoordinationServiceImplement implements ITaskCoordinationService {
    @Autowired
    private ITaskCoordinationRepository tcR;
    @Override
    public void insert(TaskCoordination taskCoordination) {
        tcR.save(taskCoordination);
    }
    @Override
    public void delete(int id) {
        tcR.deleteById(id);
    }
    @Override
    public TaskCoordination listId(int id) {
        return tcR.findById(id).orElse(new TaskCoordination());
    }
    @Override
    public List<TaskCoordination> list() {
        return tcR.findAll();
    }
    @Override
    public void update(TaskCoordination taskCoordination) {
        tcR.save(taskCoordination);
    }
}
