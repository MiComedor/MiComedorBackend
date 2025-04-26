package pe.edu.upc.micomedor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.micomedor.entities.TaskCoordination;

public interface ITaskCoordinationRepository extends JpaRepository<TaskCoordination, Integer> {
}
