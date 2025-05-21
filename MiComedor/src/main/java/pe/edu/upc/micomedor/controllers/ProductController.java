package pe.edu.upc.micomedor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.micomedor.dtos.ProductDTO;
import pe.edu.upc.micomedor.dtos.ProductosAvencerDiarioDTO;
import pe.edu.upc.micomedor.dtos.ProductosAvencerSemanalDTO;
import pe.edu.upc.micomedor.entities.Product;
import pe.edu.upc.micomedor.entities.ProductType;
import pe.edu.upc.micomedor.entities.UnitOfMeasurement;
import pe.edu.upc.micomedor.entities.Users;
import pe.edu.upc.micomedor.servicesInterfaces.IProductService;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.sql.Date;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService pS;

    // ✅ INSERTAR PRODUCTO
    @PostMapping
    public void insertar(@RequestBody ProductDTO dto) {
        Product p = new Product();
        p.setDescriptionProduct(dto.getDescriptionProduct());
        p.setAmountProduct(dto.getAmountProduct());

        ProductType pt = new ProductType();
        pt.setIdProductType(dto.getProductType_id());
        p.setProductType(pt);

        UnitOfMeasurement uom = new UnitOfMeasurement();
        uom.setIdUnitOfMeasurement(dto.getUnitOfMeasurement_id());
        p.setUnitOfMeasurement(uom);

        Users user = new Users();
        user.setIdUser(dto.getUser_id());
        p.setUsers(user);

        if (dto.getExpirationDate() != null && !dto.getExpirationDate().isEmpty()) {
            p.setExpirationDate(LocalDate.parse(dto.getExpirationDate()));
        } else {
            p.setExpirationDate(null);
        }

        pS.insert(p);
    }

    // ✅ LISTAR PRODUCTOS
    @GetMapping
    public List<ProductDTO> listar() {
        return pS.list().stream().map(p -> {
            ProductDTO dto = new ProductDTO();
            dto.setIdProduct(p.getIdProduct());
            dto.setDescriptionProduct(p.getDescriptionProduct());
            dto.setAmountProduct(p.getAmountProduct());
            dto.setUser_id(p.getUsers().getIdUser());

            if (p.getUnitOfMeasurement() != null) {
                dto.setUnitOfMeasurementAbbreviation(p.getUnitOfMeasurement().getAbbreviation());
            }
            if (p.getProductType() != null) {
                dto.setProductTypeName(p.getProductType().getNameProductType());
            }
            if (p.getExpirationDate() != null) {
                dto.setExpirationDate(p.getExpirationDate().toString());
            }

            return dto;
        }).collect(Collectors.toList());
    }

    // ✅ ELIMINAR PRODUCTO
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        pS.delete(id);
    }

    // ✅ ACTUALIZAR PRODUCTO
    @PutMapping
    public void update(@RequestBody ProductDTO dto) {
        Product p = new Product();
        p.setIdProduct(dto.getIdProduct());
        p.setDescriptionProduct(dto.getDescriptionProduct());
        p.setAmountProduct(dto.getAmountProduct());

        ProductType pt = new ProductType();
        pt.setIdProductType(dto.getProductType_id());
        p.setProductType(pt);

        UnitOfMeasurement uom = new UnitOfMeasurement();
        uom.setIdUnitOfMeasurement(dto.getUnitOfMeasurement_id());
        p.setUnitOfMeasurement(uom);

        Users u = new Users();
        u.setIdUser(dto.getUser_id());
        p.setUsers(u);

        if (dto.getExpirationDate() != null && !dto.getExpirationDate().isEmpty()) {
            p.setExpirationDate(LocalDate.parse(dto.getExpirationDate()));
        } else {
            p.setExpirationDate(null);
        }

        pS.update(p);
    }

    // ✅ LISTAR POR ID
    @GetMapping("/{id}")
    public ProductDTO listById(@PathVariable("id") int id) {
        Product p = pS.listId(id);
        ProductDTO dto = new ProductDTO();
        dto.setIdProduct(p.getIdProduct());
        dto.setDescriptionProduct(p.getDescriptionProduct());
        dto.setAmountProduct(p.getAmountProduct());
        dto.setUser_id(p.getUsers().getIdUser());

        if (p.getUnitOfMeasurement() != null) {
            dto.setUnitOfMeasurementAbbreviation(p.getUnitOfMeasurement().getAbbreviation());
        }
        if (p.getProductType() != null) {
            dto.setProductTypeName(p.getProductType().getNameProductType());
        }
        if (p.getExpirationDate() != null) {
            dto.setExpirationDate(p.getExpirationDate().toString());
        }

        return dto;
    }

    @GetMapping("/reporteProductosAvencerDiario/{idUser}")
    public List<ProductosAvencerDiarioDTO> obtenerPresupuestoPorDia(@PathVariable int idUser) {
        List<Object[]> filaLista = pS.productosAvencerDiario(idUser);
        List<ProductosAvencerDiarioDTO> dtoLista = new ArrayList<>();
        for (Object[] fila : filaLista) {
            ProductosAvencerDiarioDTO dto = new ProductosAvencerDiarioDTO();
            dto.setDescripcionProducto((String) fila[0]);
            dto.setExpirationDate(((Date) fila[1]).toLocalDate());
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/reporteProductosAvencerSemanal/{idUser}")
    public List<ProductosAvencerSemanalDTO> obtenerPresupuestoPorSemanal(@PathVariable int idUser) {
        List<Object[]> filaLista = pS.productosAvencerSemana(idUser);
        List<ProductosAvencerSemanalDTO> dtoLista = new ArrayList<>();
        for (Object[] fila : filaLista) {
            ProductosAvencerSemanalDTO dto = new ProductosAvencerSemanalDTO();
            dto.setDescripcionProducto((String) fila[0]);
            dto.setDiaVencimientos((String) fila[1]);
            dto.setFechaVencimiento((String) fila[2]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}
