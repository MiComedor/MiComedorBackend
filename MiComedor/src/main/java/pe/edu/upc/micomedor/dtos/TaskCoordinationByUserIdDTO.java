package pe.edu.upc.micomedor.dtos;

import pe.edu.upc.micomedor.entities.TypeOfTask;
import pe.edu.upc.micomedor.entities.Users;
import java.time.LocalDate;
import java.time.LocalTime;
public class TaskCoordinationByUserIdDTO {
    private int idTaskCoordination;
    private String fullname;
    private LocalDate dateTask;
    private LocalTime timeTask;
    private String nameTypeTask;

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

    public String getNameTypeTask() {
        return nameTypeTask;
    }

    public void setNameTypeTask(String nameTypeTask) {
        this.nameTypeTask = nameTypeTask;
    }
}
