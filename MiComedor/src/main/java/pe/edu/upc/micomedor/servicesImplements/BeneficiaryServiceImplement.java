package pe.edu.upc.micomedor.servicesImplements;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
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

}
