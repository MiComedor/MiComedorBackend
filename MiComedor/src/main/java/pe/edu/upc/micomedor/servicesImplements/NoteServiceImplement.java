package pe.edu.upc.micomedor.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.micomedor.entities.Note;
import pe.edu.upc.micomedor.repositories.INoteRespository;
import pe.edu.upc.micomedor.servicesInterfaces.INoteService;

import java.util.List;

@Service
public class NoteServiceImplement implements INoteService {
    @Autowired
    private INoteRespository nR;
    @Override
    public void insert(Note note) {
        nR.save(note);
    }
    @Override
    public List<Note> list() {
        return nR.findAll();
    }
    @Override
    public Note listId(int id) {
        return nR.findById(id).orElse(new Note());
    }
    @Override
    public void delete(int id) {
        nR.deleteById(id);
    }
    @Override
    public void update(Note budget) {
        nR.save(budget);
    }
}
