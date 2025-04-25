package pe.edu.upc.micomedor.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="BudgetCategory")
public class BudgetCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBudgetCategory;
    @Column(name = "name",length = 50, unique = true)
    private String name;

    public BudgetCategory() {
    }

    public BudgetCategory(int idBudgetCategory, String name) {
        this.idBudgetCategory = idBudgetCategory;
        this.name = name;
    }

    public int getIdBudgetCategory() {
        return idBudgetCategory;
    }

    public void setIdBudgetCategory(int idBudgetCategory) {
        this.idBudgetCategory = idBudgetCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}