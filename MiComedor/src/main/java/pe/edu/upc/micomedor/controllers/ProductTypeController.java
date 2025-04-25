package pe.edu.upc.micomedor.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public void insert(@RequestBody ProductTypeDTO DeliveryTypeDTO) {
        ModelMapper m = new ModelMapper();
        ProductType p = m.map(DeliveryTypeDTO, ProductType.class);
        iD.insert(p);
    }

    @GetMapping
    //@PreAuthorize("hasAnyAuthority('USUARIO','EMPRENDIMIENTO', 'ADMIN')")
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


}
