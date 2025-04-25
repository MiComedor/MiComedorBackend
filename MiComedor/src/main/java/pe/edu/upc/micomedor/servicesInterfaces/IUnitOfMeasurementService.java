package pe.edu.upc.micomedor.servicesInterfaces;


import pe.edu.upc.micomedor.entities.UnitOfMeasurement;

import java.util.List;

public interface IUnitOfMeasurementService {
    public void insert(UnitOfMeasurement uom);
    public void delete(int idUnitOfMeasurement);
    public UnitOfMeasurement listId(int UnitOfMeasurement);
    public List<UnitOfMeasurement> list();
    public void update(UnitOfMeasurement unitOfMeasurement);
}
