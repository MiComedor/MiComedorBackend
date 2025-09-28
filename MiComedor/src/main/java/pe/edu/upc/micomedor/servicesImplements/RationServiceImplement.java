package pe.edu.upc.micomedor.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.micomedor.entities.Ration;
import pe.edu.upc.micomedor.repositories.IRationRepository;
import pe.edu.upc.micomedor.servicesInterfaces.IBudgetService;
import pe.edu.upc.micomedor.servicesInterfaces.IRationService;

import java.time.LocalDate;
import java.util.List;

@Service
public class RationServiceImplement  implements IRationService {

    @Autowired
    private IRationRepository rR;

    @Autowired
    private IBudgetService bS; // Para actualizar el presupuesto diario

    @Override
    @Transactional
    public void insert(Ration ration) {
        // Guardar ración
        rR.save(ration);
        // Recalcular presupuesto del día para ese usuario/fecha
        bS.upsertDailyIncomeFromRations(ration.getUsers().getIdUser(), ration.getDate());
    }

    @Override
    @Transactional
    public void delete(int id) {
        // Obtener ración antes de borrar para conocer usuario/fecha
        Ration existing = rR.findById(id).orElse(null);
        if (existing != null) {
            int idUser = existing.getUsers().getIdUser();
            LocalDate date = existing.getDate();

            // Borrar ración
            rR.deleteById(id);

            // Recalcular presupuesto del día (si ya no hay raciones => borra el budget)
            bS.upsertDailyIncomeFromRations(idUser, date);
        } else {
            // Si no existe, mantener conducta actual
            rR.deleteById(id);
        }
    }

    @Override
    public Ration listId(int id) {
        return rR.findById(id).orElse(new Ration());
    }

    @Override
    public List<Ration> list() {
        return rR.findAll();
    }

    @Override
    @Transactional
    public void update(Ration ration) {
        // Actualizar ración
        rR.save(ration);
        // Recalcular presupuesto del día
        bS.upsertDailyIncomeFromRations(ration.getUsers().getIdUser(), ration.getDate());
    }

    @Override
    public List<Ration> findRationByUserId(int idUser) {
        return rR.findRationByUserId(idUser);
    }

    @Override
    public int reporteDiarioRacionPorDia(int idUser) {
        return rR.reporteDiarioRacionPorDia(idUser);
    }

    @Override
    public List<Object[]> reporteSemanalRaciones(int idUser) {
        return rR.reporteSemanalRaciones(idUser);
    }

    @Override
    public List<Object[]> cantidadBeneficiarioPorDia(int idUser) {
        return  rR.cantidadBeneficiarioPorDia(idUser);
    }

    @Override
    public List<Object[]> cantidadBeneficiarioPorSemana(int idUser) {
        return rR.cantidadBeneficiarioPorSemana(idUser);
    }
}