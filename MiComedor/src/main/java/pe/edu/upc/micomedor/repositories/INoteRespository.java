package pe.edu.upc.micomedor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.micomedor.entities.Note;

import java.util.List;

@Repository
public interface INoteRespository extends JpaRepository<Note, Integer> {
    @Query(value = "SELECT * FROM note n WHERE n.user_id = :idUser", nativeQuery = true)
    List<Note> findNotasByUserId(@Param("idUser") int idUser);

}
