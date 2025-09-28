package pe.edu.upc.micomedor.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.micomedor.entities.Budget;
import pe.edu.upc.micomedor.entities.BudgetCategory;
import pe.edu.upc.micomedor.entities.Users;
import pe.edu.upc.micomedor.repositories.IBudgetRepository;
import pe.edu.upc.micomedor.repositories.IRationRepository;
import pe.edu.upc.micomedor.servicesInterfaces.IBudgetService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BudgetServiceImplement implements IBudgetService {

    // ⚠️ Ajusta este ID si tu "Ingreso" no es 1 en budget_category
    private static final int INCOME_CATEGORY_ID = 1;

    @Autowired
    private IBudgetRepository bR;

    @Autowired
    private IRationRepository rR; // Necesario para sumar precios de raciones

    @Override
    public void insert(Budget budget) {
        bR.save(budget);
    }

    @Override
    public List<Budget> list() {
        return bR.findAll();
    }

    @Override
    public Budget listId(int id) {
        return bR.findById(id).orElse(new Budget());
    }

    @Override
    public void delete(int id) {
        bR.deleteById(id);
    }

    @Override
    public void update(Budget budget) {
        bR.save(budget);
    }

    @Override
    public List<Object[]> PresupuestoPorDia(int idUser) {
        return bR.PresupuestoPorDia(idUser);
    }

    @Override
    public List<Object[]> PresupuestoPorSemana(int idUser) {
        return bR.PresupuestoPorSemana(idUser);
    }

    @Override
    public List<Budget> listByUser(int idUser) {
        return bR.findBudgetsByUserId(idUser);
    }

    // === NUEVO ===
    // Upsert del ingreso diario a partir de las raciones del día
    @Override
    @Transactional
    public void upsertDailyIncomeFromRations(int idUser, LocalDate date) {
        // 1) Calcular suma de precios y cantidad de raciones del día
        Double total = rR.sumPriceByUserAndDate(idUser, date);
        long cantidad = Optional.ofNullable(rR.countByUserAndDate(idUser, date)).orElse(0L);
        float totalFloat = total != null ? total.floatValue() : 0f;

        // 2) Buscar si ya existe un registro de budget (categoría Ingreso) para ese usuario/fecha
        Optional<Budget> opt = bR.findByUserDateAndCategory(idUser, date, INCOME_CATEGORY_ID);

        // Si no hay raciones o total = 0 => eliminar el registro existente (si lo hay)
        if (totalFloat <= 0f || cantidad == 0L) {
            opt.ifPresent(budget -> bR.deleteById(budget.getIdBudget()));
            return;
        }

        // 3) Crear/actualizar Budget
        Budget budget = opt.orElseGet(Budget::new);

        // Setear entidades por ID (sin necesidad de cargar la fila completa)
        Users u = new Users();
        u.setIdUser(idUser);

        BudgetCategory cat = new BudgetCategory();
        cat.setIdBudgetCategory(INCOME_CATEGORY_ID);

        budget.setUsers(u);
        budget.setBudgetCategory(cat);
        budget.setDateBudget(date);
        budget.setAmountBudget(totalFloat);

        // Descripción amigable
        budget.setDescriptionProduct("Ingresos por raciones del día (" + cantidad + " raciones)");

        // 4) Guardar
        bR.save(budget);
    }
}