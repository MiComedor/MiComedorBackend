package pe.edu.upc.micomedor.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.micomedor.dtos.BeneficiaryDTO;
import pe.edu.upc.micomedor.dtos.UnitOfMeasurementDTO;
import pe.edu.upc.micomedor.entities.Beneficiary;
import pe.edu.upc.micomedor.entities.UnitOfMeasurement;
import pe.edu.upc.micomedor.servicesInterfaces.IUnitOfMeasurementService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/unitOfMeasurementController")
public class UnitOfMeasurementController {
    @Autowired
    private IUnitOfMeasurementService uomS;

    @PostMapping
    public void insertar(@RequestBody UnitOfMeasurementDTO unitOfMeasurementDTO){
        ModelMapper m=new ModelMapper();
        UnitOfMeasurement uom=m.map(unitOfMeasurementDTO, UnitOfMeasurement.class);
        uomS.insert(uom);
    }

    @GetMapping
    public List<UnitOfMeasurementDTO> listar(){
        return uomS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, UnitOfMeasurementDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){ uomS.delete(id);}

    @PutMapping
    public void update(@RequestBody UnitOfMeasurementDTO dto) {
        ModelMapper m = new ModelMapper();
        UnitOfMeasurement u = m.map(dto, UnitOfMeasurement.class);
        uomS.insert(u);
    }

    @GetMapping("/{id}")
    public UnitOfMeasurementDTO listById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        UnitOfMeasurement unitOfMeasurement = uomS.listId(id);
        return m.map(unitOfMeasurement, UnitOfMeasurementDTO.class);
    }
}
