package pe.edu.upc.micomedor.servicesInterfaces;

import pe.edu.upc.micomedor.entities.TaskCoordination;

import java.util.List;

public interface ITaskCoordinationService {
    public void insert(TaskCoordination taskCoordination);
    public void delete(int idTaskCoordination);
    public  TaskCoordination listId(int idTaskCoordination);
    public List<TaskCoordination> list();
    public void update(TaskCoordination taskCoordination);
}
