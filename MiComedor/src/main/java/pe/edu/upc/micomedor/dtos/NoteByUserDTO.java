package pe.edu.upc.micomedor.dtos;

public class NoteByUserDTO {
    private int idNote;               // <-- ID necesario para editar/eliminar
    private String noteTextByUser;

    // Getters y Setters
    public int getIdNote() {
        return idNote;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    public String getNoteTextByUser() {
        return noteTextByUser;
    }

    public void setNoteTextByUser(String noteTextByUser) {
        this.noteTextByUser = noteTextByUser;
    }
}