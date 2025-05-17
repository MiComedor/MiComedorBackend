package pe.edu.upc.micomedor.servicesInterfaces;

import pe.edu.upc.micomedor.entities.Note;
import pe.edu.upc.micomedor.entities.Ration;

import java.util.List;

public interface IRationService {
    public void insert(Ration ration);
    public void delete(int idRation);
    public  Ration listId(int idRation);
    public List<Ration> list();
    public void update(Ration ration);
    List<Ration> findRationByUserId(int idUser);
}
