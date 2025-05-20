package pe.edu.upc.micomedor.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.micomedor.entities.Ration;
import pe.edu.upc.micomedor.entities.TaskCoordination;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskCoordinationRepository extends JpaRepository<TaskCoordination, Integer> {
@Query(value = "select * from task_coordination where user_id = :idUser", nativeQuery = true)
List<TaskCoordination> findTaskCoordinationByUser(@Param("idUser") int idUser);
}
