package pe.edu.upc.micomedor.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="TypeOfTask")
public class TypeOfTask implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeOfTask;
    @Column(name = "nameTypeTask", length = 50, unique = true)
    private String nameTypeTask;

    public TypeOfTask() {
    }

    public TypeOfTask(int idTypeOfTask, String nameTypeTask) {
        this.idTypeOfTask = idTypeOfTask;
        this.nameTypeTask = nameTypeTask;
    }

    public int getIdTypeOfTask() {
        return idTypeOfTask;
    }

    public void setIdTypeOfTask(int idTypeOfTask) {
        this.idTypeOfTask = idTypeOfTask;
    }

    public String getNameTypeTask() {
        return nameTypeTask;
    }

    public void setNameTypeTask(String nameTypeTask) {
        this.nameTypeTask = nameTypeTask;
    }
}
