package pe.edu.upc.micomedor.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.micomedor.entities.ProductType;
import pe.edu.upc.micomedor.repositories.IProductTypeRepository;
import pe.edu.upc.micomedor.servicesInterfaces.IProductTypeService;

import java.util.List;
@Service
public class ProductTypeImplement implements IProductTypeService {
    @Autowired
    private IProductTypeRepository dtR;


    @Override
    public void insert(ProductType dt) {
        dtR.save(dt);
    }

    @Override
    public List<ProductType> list() {
        return dtR.findAll();
    }

    @Override
    public ProductType listId(int id) {
        return dtR.findById(id).orElse(new ProductType());
    }

    @Override
    public void delete(int id) {
        dtR.deleteById(id);
    }


}