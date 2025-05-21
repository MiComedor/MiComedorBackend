package pe.edu.upc.micomedor.servicesImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.micomedor.entities.Product;
import pe.edu.upc.micomedor.repositories.IProductRepository;
import pe.edu.upc.micomedor.servicesInterfaces.IProductService;

import java.util.List;

@Service
public class ProductServiceImplement implements IProductService {
    @Autowired
    private IProductRepository pR;
    @Override
    public void insert(Product product) {
        pR.save(product);
    }
    @Override
    public void delete(int id) {
        pR.deleteById(id);
    }
    @Override
    public Product listId(int id) {
        return pR.findById(id).orElse(new Product());
    }
    @Override
    public List<Product> list() {
        return pR.findAll();
    }
    @Override
    public void update(Product product) {
        pR.save(product);
    }
    @Override
    public List<Object[]> productosAvencerDiario(int idUser) {
       return pR.productosAvencerDiario(idUser);
    }

    @Override
    public List<Object[]> productosAvencerSemana(int idUser) {
        return pR.productosAvencerSemana(idUser);
    }
}
