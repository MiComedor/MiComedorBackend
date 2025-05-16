package pe.edu.upc.micomedor.dtos;

import pe.edu.upc.micomedor.entities.Users;

public class NoteByUserDTO {
    public String getNoteTextByUser() {
        return noteTextByUser;
    }

    public void setNoteTextByUser(String noteTextByUser) {
        this.noteTextByUser = noteTextByUser;
    }

    private String noteTextByUser;
}
