package pe.edu.upc.micomedor.servicesInterfaces;

import pe.edu.upc.micomedor.entities.TypeOfTask;

import java.util.List;

public interface ITypeOfTaskService {
    public void insert(TypeOfTask tot);
    public void delete(int idTypeOfTask);
    public TypeOfTask listId(int idTypeOfTask);
    public List<TypeOfTask> list();
    public void update(TypeOfTask typeOfTask);
}
