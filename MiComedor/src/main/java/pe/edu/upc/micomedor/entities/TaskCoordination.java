package pe.edu.upc.micomedor.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name="TaskCoordination")
public class TaskCoordination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTaskCoordination;
    @Column(name = "fullname", nullable = false, length = 50)
    private String fullname;
    @Column(name = "dateTask", nullable = false)
    private LocalDate dateTask;
    @Column(name = "timeTask", nullable = false)
    private LocalTime timeTask;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private Users users;
    @ManyToOne
    @JoinColumn(name = "idTypeOfTask")
    private TypeOfTask typeOfTask;

    public TaskCoordination() {
    }

    public TaskCoordination(int idTaskCoordination, String fullname, LocalDate dateTask, LocalTime timeTask, Users users, TypeOfTask typeOfTask) {
        this.idTaskCoordination = idTaskCoordination;
        this.fullname = fullname;
        this.dateTask = dateTask;
        this.timeTask = timeTask;
        this.users = users;
        this.typeOfTask = typeOfTask;
    }

    public int getIdTaskCoordination() {
        return idTaskCoordination;
    }

    public void setIdTaskCoordination(int idTaskCoordination) {
        this.idTaskCoordination = idTaskCoordination;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public LocalDate getDateTask() {
        return dateTask;
    }

    public void setDateTask(LocalDate dateTask) {
        this.dateTask = dateTask;
    }

    public LocalTime getTimeTask() {
        return timeTask;
    }

    public void setTimeTask(LocalTime timeTask) {
        this.timeTask = timeTask;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public TypeOfTask getTypeOfTask() {
        return typeOfTask;
    }

    public void setTypeOfTask(TypeOfTask typeOfTask) {
        this.typeOfTask = typeOfTask;
    }
}
