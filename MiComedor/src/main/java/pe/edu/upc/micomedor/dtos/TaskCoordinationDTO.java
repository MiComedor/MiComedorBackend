package pe.edu.upc.micomedor.dtos;

import pe.edu.upc.micomedor.entities.TypeOfTask;
import pe.edu.upc.micomedor.entities.Users;

import java.time.LocalDate;
import java.time.LocalTime;

public class TaskCoordinationDTO {
    private int idTaskCoordination;
    private String fullname;
    private LocalDate dateTask;
    private LocalTime timeTask;
    private Users users;
    private TypeOfTask typeOfTask;

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
