package pe.edu.upc.micomedor.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.support.PageableUtils;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import pe.edu.upc.micomedor.entities.Ration;
import pe.edu.upc.micomedor.entities.RationType;
import pe.edu.upc.micomedor.repositories.IRationTypeRepository;
import pe.edu.upc.micomedor.servicesInterfaces.IRationTypeService;

import java.util.List;

@Service
public class RationTypeServiceImplement implements IRationTypeService {
    @Autowired
    private IRationTypeRepository rR;
    @Override
    public void insert(RationType rationType) {
        rR.save(rationType);
    }
    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }
    @Override
    public RationType listId(int id) {
        return rR.findById(id).orElse(new RationType());
    }
    @Override
    public List<RationType> list() {
        return rR.findAll();
    }
    @Override
    public void update(RationType category){
            rR.save(category);
    }
}
