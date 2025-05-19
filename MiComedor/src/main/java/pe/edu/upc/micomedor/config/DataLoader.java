package pe.edu.upc.micomedor.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.upc.micomedor.entities.ProductType;
import pe.edu.upc.micomedor.entities.RationType;
import pe.edu.upc.micomedor.entities.UnitOfMeasurement;
import pe.edu.upc.micomedor.repositories.IProductTypeRepository;
import pe.edu.upc.micomedor.repositories.IRationTypeRepository;
import pe.edu.upc.micomedor.repositories.IUnitOfMeasurementRepository;

@Component
public class DataLoader {

    @Autowired
    private IUnitOfMeasurementRepository uomRepo;
    @Autowired
    private IProductTypeRepository productTypeRepo;
    @Autowired
    private IRationTypeRepository rationTypeRepository;


    @PostConstruct
    public void init() {
        if (uomRepo.count() == 0) {
            uomRepo.save(new UnitOfMeasurement(0, "Kilogramos", "Kg"));
            uomRepo.save(new UnitOfMeasurement(0, "Litros", "Lts"));
            uomRepo.save(new UnitOfMeasurement(0, "Unidades", "Ud"));
        }

        if (productTypeRepo.count() == 0) {
            productTypeRepo.save(new ProductType("Perecible"));
            productTypeRepo.save(new ProductType("No perecible"));
        }

        if (rationTypeRepository.count() == 0) {
            rationTypeRepository.save(new RationType(0, "Desayuno"));
            rationTypeRepository.save(new RationType(0, "Almuerzo"));
            rationTypeRepository.save(new RationType(0, "Cena"));
            rationTypeRepository.save(new RationType(0, "Adicional"));
        }


    }



}
