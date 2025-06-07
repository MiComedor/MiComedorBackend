package pe.edu.upc.micomedor.servicesInterfaces;


import pe.edu.upc.micomedor.entities.RationType;

import java.util.List;

public interface IRationTypeService {
    public void insert(RationType rt);
    public void delete(int idRationType);
    public RationType listId(int idRationType);
    public List<RationType> list();
    public void update(RationType rationType);
}
