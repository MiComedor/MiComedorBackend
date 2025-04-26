package pe.edu.upc.micomedor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.micomedor.entities.UnitOfMeasurement;

@Repository
public interface IUnitOfMeasurementRepository extends JpaRepository<UnitOfMeasurement, Integer> {
}
