package pe.edu.upc.micomedor.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.upc.micomedor.entities.*;
import pe.edu.upc.micomedor.repositories.*;

@Component
public class DataLoader {

    @Autowired
    private IUnitOfMeasurementRepository uomRepo;
    @Autowired
    private IProductTypeRepository productTypeRepo;
    @Autowired
    private IRationTypeRepository rationTypeRepository;
    @Autowired
    private ITypeOfTaskRepository typeOfTaskRepository;
    @Autowired
    private IBudgetCategoryRepository budgetCategoryRepository;


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

        if (budgetCategoryRepository.count() == 0) {
            budgetCategoryRepository.save(new BudgetCategory(0, "Ingresos"));
            budgetCategoryRepository.save(new BudgetCategory(0, "Egresos"));
        }



        if(typeOfTaskRepository.count() == 0){
            typeOfTaskRepository.save(new TypeOfTask(0, "Lavar verduras y frutas"));
            typeOfTaskRepository.save(new TypeOfTask(0, "Cortar ingredientes"));
            typeOfTaskRepository.save(new TypeOfTask(0, "Cocinar alimentos"));
            typeOfTaskRepository.save(new TypeOfTask(0, "Limpiar ollas y utensilios"));
            typeOfTaskRepository.save(new TypeOfTask(0, "Preparar platos o bandejas para servir"));
            typeOfTaskRepository.save(new TypeOfTask(0, "Repartir comida"));
            typeOfTaskRepository.save(new TypeOfTask(0, "Controlar porciones"));
            typeOfTaskRepository.save(new TypeOfTask(0, "Limpiar mesas y sillas"));
            typeOfTaskRepository.save(new TypeOfTask(0, "Barrer y trapear el piso"));
            typeOfTaskRepository.save(new TypeOfTask(0, "Lavar platos y cubiertos"));
            typeOfTaskRepository.save(new TypeOfTask(0, "Vaciar y limpiar tachos de basura"));
            typeOfTaskRepository.save(new TypeOfTask(0, "Limpiar baños"));
            typeOfTaskRepository.save(new TypeOfTask(0, "Guardar insumos y donaciones"));
            typeOfTaskRepository.save(new TypeOfTask(0, "Controlar inventario"));
            typeOfTaskRepository.save(new TypeOfTask(0, "Organizar turnos de voluntarios"));

        }

    }



}
