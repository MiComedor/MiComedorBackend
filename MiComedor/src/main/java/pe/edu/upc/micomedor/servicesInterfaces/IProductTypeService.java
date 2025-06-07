package pe.edu.upc.micomedor.servicesInterfaces;
import pe.edu.upc.micomedor.entities.ProductType;


import java.util.List;

public interface IProductTypeService {
    public void insert(ProductType pt);
    public List<ProductType> list();
    public ProductType listId(int id);
    public void delete(int id);
    public void update(ProductType productType);
}
