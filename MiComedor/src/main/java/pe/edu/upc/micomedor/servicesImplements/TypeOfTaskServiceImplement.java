package pe.edu.upc.micomedor.servicesImplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.micomedor.entities.TypeOfTask;
import pe.edu.upc.micomedor.repositories.ITypeOfTaskRepository;
import pe.edu.upc.micomedor.servicesInterfaces.ITypeOfTaskService;

import java.util.List;

@Service
public class TypeOfTaskServiceImplement implements ITypeOfTaskService {
    @Autowired
    private ITypeOfTaskRepository totR;
    @Override
    public void insert(TypeOfTask tot) {
        totR.save(tot);
    }
    @Override
    public void delete(int id) {
        totR.deleteById(id);
    }
    @Override
    public TypeOfTask listId(int id) {
        return totR.findById(id).orElse(new TypeOfTask());
    }
    @Override
    public List<TypeOfTask> list() {
        return totR.findAll();
    }
    @Override
    public void update(TypeOfTask typeOfTask) {
        totR.save(typeOfTask);
    }
}
