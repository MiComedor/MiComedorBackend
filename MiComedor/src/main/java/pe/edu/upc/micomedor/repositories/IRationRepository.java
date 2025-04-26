package pe.edu.upc.micomedor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.micomedor.entities.Ration;

public interface IRationRepository extends JpaRepository<Ration, Integer>{
}
