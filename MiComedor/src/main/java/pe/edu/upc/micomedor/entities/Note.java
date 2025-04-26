package pe.edu.upc.micomedor.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNote;
    @Column(name = "noteText", nullable = false, length = 500)
    private String noteText;
    @ManyToOne
    @JoinColumn(name = "User_id")
    private Users users;

    public Note() {
    }

    public Note(int idNote, String noteText, Users users) {
        this.idNote = idNote;
        this.noteText = noteText;
        this.users = users;
    }

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
