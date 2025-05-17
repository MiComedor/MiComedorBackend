package pe.edu.upc.micomedor.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.micomedor.entities.Note;
import pe.edu.upc.micomedor.entities.Ration;
import pe.edu.upc.micomedor.repositories.IRationRepository;
import pe.edu.upc.micomedor.servicesInterfaces.IRationService;

import java.util.List;

@Service
public class RationServiceImplement  implements IRationService {
    @Autowired
    private IRationRepository rR;
    @Override
    public void insert(Ration ration) {
        rR.save(ration);
    }
    @Override
    public void delete(int id) {
        rR.deleteById(id);
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
    public void update(Ration ration) {
        rR.save(ration);
    }

    @Override
    public List<Ration> findRationByUserId(int idUser) {
        return rR.findRationByUserId(idUser);
    }
}
