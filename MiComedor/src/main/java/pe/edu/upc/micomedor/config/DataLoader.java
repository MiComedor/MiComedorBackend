package pe.edu.upc.micomedor.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.upc.micomedor.entities.ProductType;
import pe.edu.upc.micomedor.entities.UnitOfMeasurement;
import pe.edu.upc.micomedor.repositories.IProductTypeRepository;
import pe.edu.upc.micomedor.repositories.IUnitOfMeasurementRepository;

@Component
public class DataLoader {

    @Autowired
    private IUnitOfMeasurementRepository uomRepo;
    @Autowired
    private IProductTypeRepository productTypeRepo;


    @PostConstruct
    public void init() {
        if (uomRepo.count() == 0) {
            uomRepo.save(new UnitOfMeasurement(0, "Kilogramos", "Kg"));
            uomRepo.save(new UnitOfMeasurement(0, "Litros", "Lt"));
            uomRepo.save(new UnitOfMeasurement(0, "Unidades", "Ud"));
        }

        if (productTypeRepo.count() == 0) {
            productTypeRepo.save(new ProductType("Perecible"));
            productTypeRepo.save(new ProductType("No perecible"));
        }
    }



}
