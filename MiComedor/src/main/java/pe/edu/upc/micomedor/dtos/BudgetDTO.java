
package pe.edu.upc.micomedor.dtos;

import pe.edu.upc.micomedor.entities.BudgetCategory;
import pe.edu.upc.micomedor.entities.Users;

import java.time.LocalDate;

public class BudgetDTO {
    private int idBudget;
    private String descriptionProduct;
    private float amountBudget;
    private LocalDate dateBudget;
    private Users users;
    private BudgetCategory budgetCategory;

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
