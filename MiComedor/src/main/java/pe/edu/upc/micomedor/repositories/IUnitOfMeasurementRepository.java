package pe.edu.upc.micomedor.repositories;

import org.springframework.data.repository.CrudRepository;
import pe.edu.upc.micomedor.entities.UnitOfMeasurement;

public interface IUnitOfMeasurementRepository extends CrudRepository<UnitOfMeasurement, Integer> {
}
