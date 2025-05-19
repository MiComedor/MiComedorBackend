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

import java.time.LocalDate;
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

        // Asociar tipo de producto
        ProductType pt = new ProductType();
        pt.setIdProductType(productDTO.getProductType_id());
        p.setProductType(pt);

        // Asociar unidad de medida
        UnitOfMeasurement uom = new UnitOfMeasurement();
        uom.setIdUnitOfMeasurement(productDTO.getUnitOfMeasurement_id());
        p.setUnitOfMeasurement(uom);

        // Asociar usuario
        Users u = new Users();
        u.setIdUser(productDTO.getUser_id());
        p.setUsers(u);

        // ✅ Lógica: solo guardar fecha si es PERECIBLE (id == 1)
        if (productDTO.getProductType_id() == 1 && productDTO.getExpirationDate() != null && !productDTO.getExpirationDate().isEmpty()) {
            p.setExpirationDate(LocalDate.parse(productDTO.getExpirationDate()));
        } else {
            p.setExpirationDate(null);
        }



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
