package pe.edu.upc.micomedor.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="budget")
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBudget;

    @Column(name = "descriptionBudget", nullable = false, length = 50)
    private String descriptionProduct;

    @Column(name = "amountBudget", nullable = false)
    private float amountBudget;

    // ⭐ CAMBIO: forzamos a que se guarde solo la FECHA (sin hora)
    @Column(name = "dateBudget", nullable = false, columnDefinition = "DATE")
    private LocalDate dateBudget;

    @ManyToOne
    @JoinColumn(name = "User_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "budgetCategory_id")
    private BudgetCategory budgetCategory;

    public Budget() {
    }

    public Budget(int idBudget, String descriptionProduct, float amountBudget,
                  LocalDate dateBudget, Users users, BudgetCategory budgetCategory) {
        this.idBudget = idBudget;
        this.descriptionProduct = descriptionProduct;
        this.amountBudget = amountBudget;
        this.dateBudget = dateBudget;
        this.users = users;
        this.budgetCategory = budgetCategory;
    }

    public int getIdBudget() {
        return idBudget;
    }

    public void setIdBudget(int idBudget) {
        this.idBudget = idBudget;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public float getAmountBudget() {
        return amountBudget;
    }

    public void setAmountBudget(float amountBudget) {
        this.amountBudget = amountBudget;
    }

    public LocalDate getDateBudget() {
        return dateBudget;
    }

    public void setDateBudget(LocalDate dateBudget) {
        this.dateBudget = dateBudget;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public BudgetCategory getBudgetCategory() {
        return budgetCategory;
    }

    public void setBudgetCategory(BudgetCategory budgetCategory) {
        this.budgetCategory = budgetCategory;
    }
}
