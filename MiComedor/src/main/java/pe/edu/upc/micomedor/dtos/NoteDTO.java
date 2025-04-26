package pe.edu.upc.micomedor.dtos;

import pe.edu.upc.micomedor.entities.Users;

public class NoteDTO {
    private int idNote;
    private String noteText;
    private Users users;

    public int getIdNote() {
        return idNote;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
