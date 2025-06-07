package pe.edu.upc.micomedor.servicesInterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.micomedor.entities.Note;

import java.util.List;

public interface INoteService {
    public void insert(Note note);
    public void delete(int idNote);
    public  Note listId(int idNote);
    public List<Note> list();
    public void update(Note note);
    List<Note> findNotasByUserId(int idUser);
}
