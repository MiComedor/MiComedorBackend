package pe.edu.upc.micomedor.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.micomedor.entities.UnitOfMeasurement;
import pe.edu.upc.micomedor.repositories.IUnitOfMeasurementRepository;
import pe.edu.upc.micomedor.servicesInterfaces.IUnitOfMeasurementService;

import java.util.List;

@Service
public class UnitOfMeasurementServiceImplement implements IUnitOfMeasurementService {

    @Autowired
    private IUnitOfMeasurementRepository uomR;
    @Override
    public void insert(UnitOfMeasurement uom) {
        uomR.save(uom);
    }
    @Override
    public void delete(int id) {
        uomR.deleteById(id);
    }
    @Override
    public UnitOfMeasurement listId(int id) {
        return uomR.findById(id).orElse(new UnitOfMeasurement());
    }
    @Override
    public List<UnitOfMeasurement> list() {
        return (List<UnitOfMeasurement>) uomR.findAll();
    }
    @Override
    public void update(UnitOfMeasurement unitOfMeasurement) {
        uomR.save(unitOfMeasurement);
    }

}
