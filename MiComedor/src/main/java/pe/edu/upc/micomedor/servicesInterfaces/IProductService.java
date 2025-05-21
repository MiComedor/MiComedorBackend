package pe.edu.upc.micomedor.servicesInterfaces;
import pe.edu.upc.micomedor.entities.Product;
import pe.edu.upc.micomedor.entities.Ration;

import java.util.List;

public interface IProductService {
    public void insert(Product product);
    public void delete(int idProduct);
    public  Product listId(int idProduct);
    public List<Product> list();
    public void update(Product product);


    List<Product> findByUserId(int idUser);
}
