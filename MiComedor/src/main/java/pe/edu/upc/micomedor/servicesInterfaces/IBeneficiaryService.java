package pe.edu.upc.micomedor.servicesInterfaces;

import pe.edu.upc.micomedor.entities.Beneficiary;
import java.util.List;

public interface IBeneficiaryService {
    void insert(Beneficiary beneficiary);
    void delete(int idBeneficiary);
    Beneficiary listId(int idBeneficiary);
    List<Beneficiary> list();
    void update(Beneficiary beneficiary);
    List<Beneficiary> findBeneficiaryByUserId(int idUser);
    void deleteBeneficiaryActive(int id);
    List<Beneficiary> findActiveByUserId(int userId);
    Beneficiary saveBenefiaryConfirm(Beneficiary beneficiary);
    Beneficiary findByUserIdAndDni(int userId, int dni);

    // 💡 ADDED: update con validación de unicidad y manejo de conflicto
    Beneficiary updateWithConflictCheck(Beneficiary beneficiary);
}
