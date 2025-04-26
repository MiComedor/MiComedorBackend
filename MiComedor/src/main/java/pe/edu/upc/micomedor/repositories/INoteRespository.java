package pe.edu.upc.micomedor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.micomedor.entities.Note;

@Repository
public interface INoteRespository extends JpaRepository<Note, Integer> {
}
