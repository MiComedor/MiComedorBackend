package pe.edu.upc.micomedor.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.micomedor.dtos.ProductDTO;
import pe.edu.upc.micomedor.entities.Product;
import pe.edu.upc.micomedor.entities.ProductType;
import pe.edu.upc.micomedor.entities.UnitOfMeasurement;
import pe.edu.upc.micomedor.entities.Users;
import pe.edu.upc.micomedor.servicesInterfaces.IProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService pS;

    @PostMapping
    public void insertar(@RequestBody ProductDTO productDTO){
        Product p = new Product();
        p.setDescriptionProduct(productDTO.getDescriptionProduct());
        p.setAmountProduct(productDTO.getAmountProduct());

        ProductType pt = new ProductType();
        pt.setIdProductType(productDTO.getProductType_id());
        p.setProductType(pt);

        UnitOfMeasurement uom = new UnitOfMeasurement();
        uom.setIdUnitOfMeasurement(productDTO.getUnitOfMeasurement_id());
        p.setUnitOfMeasurement(uom);

        Users u = new Users();
        u.setIdUser(productDTO.getUser_id()); // ajusta según cómo se llama el campo en `Users`
        p.setUsers(u);

        pS.insert(p);
    }

    @GetMapping
    public List<ProductDTO> listar(){
        return pS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, ProductDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){ pS.delete(id);}

    @PutMapping
    public void update(@RequestBody ProductDTO dto) {
        ModelMapper m = new ModelMapper();
        Product p = m.map(dto, Product.class);
        pS.insert(p);
    }

    @GetMapping("/{id}")
    public ProductDTO listById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        Product product = pS.listId(id);
        return m.map(product, ProductDTO.class);
    }
}
