package pe.edu.upc.micomedor.servicesImplements;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pe.edu.upc.micomedor.entities.Beneficiary;
import pe.edu.upc.micomedor.repositories.IBeneficiaryRepository;
import pe.edu.upc.micomedor.servicesInterfaces.IBeneficiaryService;

import java.util.List;

@Service
public class BeneficiaryServiceImplement implements IBeneficiaryService {
    @Autowired
    private IBeneficiaryRepository bR;

    @Override
    public void insert(Beneficiary beneficiary) {
        bR.save(beneficiary);
    }

    @Override
    public void delete(int id) {
        bR.deleteById(id);
    }

    @Override
    public Beneficiary listId(int id) {
        return bR.findById(id).orElse(new Beneficiary());
    }

    @Override
    public List<Beneficiary> list() {
        return bR.findAll();
    }

    @Override
    public void update(Beneficiary beneficiary) {
        bR.save(beneficiary);
    }

    @Override
    public List<Beneficiary> findBeneficiaryByUserId(int idUser) {
        return bR.findBeneficiaryByUserId(idUser);
    }

    @Override
    @Transactional
    public void deleteBeneficiaryActive (int id) {
        bR.deleteBeneficiaryActive(id);
    }

    @Override
    public List <Beneficiary> findActiveByUserId(int userId) {
        return bR.findActiveByUserId(userId);
    }

    @Override
    public Beneficiary saveBenefiaryConfirm(Beneficiary beneficiary) {
        int userId = beneficiary.getUsers().getIdUser();
        int dni = beneficiary.getDniBenefeciary();

        Beneficiary existing = bR.buscarBeneficiarioPorDni(userId, dni);

        if (existing != null) {
            if (existing.getIsActive()) {
                throw new RuntimeException("Beneficiary is active: This beneficiary already exists for this user and is active.");
            } else {
                throw new RuntimeException("Beneficiary is inactive: This beneficiary already exists but is inactive. Reactivate?");
            }
        }
        return bR.save(beneficiary);
    }

    @Override
    public Beneficiary findByUserIdAndDni(int userId, int dni) {
        return bR.buscarBeneficiarioPorDni(userId, dni);
    }

    // 💡 ADDED: Update con validación previa de unicidad
    @Override
    public Beneficiary updateWithConflictCheck(Beneficiary beneficiary) {
        int currentId = beneficiary.getIdBeneficiary();
        int dni = beneficiary.getDniBenefeciary();

        // === IMPORTANTE ===
        // Hoy tu entidad tiene @Column(unique = true) en dniBenefeciary,
        // lo que hace la unicidad GLOBAL. Por eso usamos este exists global:
        boolean existsSameDniOnAnother =
                bR.existsByDniBenefeciaryAndIdBeneficiaryNot(dni, currentId);

        // Si prefieres unicidad POR USUARIO, usa en su lugar:
        // boolean existsSameDniOnAnother =
        //     bR.existsByUsers_IdUserAndDniBenefeciaryAndIdBeneficiaryNot(
        //            beneficiary.getUsers().getIdUser(), dni, currentId);

        if (existsSameDniOnAnother) {
            // Lanza 409 para que el controller o el advice devuelvan Conflict
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe un beneficiario con ese DNI.");
        }

        return bR.save(beneficiary);
    }
}
