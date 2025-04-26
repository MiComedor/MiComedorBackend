package pe.edu.upc.micomedor.servicesInterfaces;

import pe.edu.upc.micomedor.entities.Note;

import java.util.List;

public interface INoteService {
    public void insert(Note note);
    public void delete(int idNote);
    public  Note listId(int idNote);
    public List<Note> list();
    public void update(Note note);
}
