package pe.edu.upc.micomedor.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.micomedor.dtos.BeneficiaryDTO;
import pe.edu.upc.micomedor.dtos.ProductTypeDTO;
import pe.edu.upc.micomedor.entities.ProductType;
import pe.edu.upc.micomedor.servicesInterfaces.IProductTypeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/producttype")
public class ProductTypeController {
    @Autowired
    private IProductTypeService iD;

    @PostMapping
    public void insert(@RequestBody ProductTypeDTO ProductTypeDTO) {
        ModelMapper m = new ModelMapper();
        ProductType p = m.map(ProductTypeDTO, ProductType.class);
        iD.insert(p);
    }

    @GetMapping
    public List<ProductTypeDTO> list() {
        return iD.list().stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, ProductTypeDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        iD.delete(id);
    }

    @PutMapping
    public void update(@RequestBody ProductTypeDTO dto) {
        ModelMapper m = new ModelMapper();
        ProductType u = m.map(dto, ProductType.class);
        iD.insert(u);
    }
    @GetMapping("/{id}")
    public ProductTypeDTO listById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        ProductType productType = iD.listId(id);
        return m.map(productType, ProductTypeDTO.class);
    }
}
