package pe.edu.upc.micomedor.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.micomedor.dtos.BudgetDTO;
import pe.edu.upc.micomedor.dtos.PresupuestoPorDiaDTO;

import pe.edu.upc.micomedor.dtos.PresupuestoPorSemanaDTO;
import pe.edu.upc.micomedor.entities.Budget;
import pe.edu.upc.micomedor.servicesInterfaces.IBudgetService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.sql.Date;

@RestController
@RequestMapping("/budget")
public class BudgetController {
    @Autowired
    private IBudgetService bS;

    @PostMapping
    public void insertar(@RequestBody BudgetDTO budgetDTO){
        ModelMapper m=new ModelMapper();
        Budget b=m.map(budgetDTO, Budget.class);
        bS.insert(b);
    }

    @GetMapping
    public List<BudgetDTO> listar(){
        return bS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, BudgetDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){ bS.delete(id);}

    @PutMapping
    public void update(@RequestBody BudgetDTO dto) {
        ModelMapper m = new ModelMapper();
        Budget b = m.map(dto, Budget.class);
        bS.insert(b);
    }

    @GetMapping("/{id}")
    public BudgetDTO listById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        Budget budget = bS.listId(id);
        return m.map(budget, BudgetDTO.class);
    }

    @GetMapping("/reportePresupuestoPorDia/{idUser}")
    public List<PresupuestoPorDiaDTO> obtenerPresupuestoPorDia(@PathVariable int idUser) {
        List<Object[]> filaLista = bS.PresupuestoPorDia(idUser);
        List<PresupuestoPorDiaDTO> dtoLista = new ArrayList<>();
        for (Object[] fila : filaLista) {
            PresupuestoPorDiaDTO dto = new PresupuestoPorDiaDTO();
            dto.setIngresosHoy(((Number) fila[0]).intValue());
            dto.setEgresosHoy(((Number) fila[1]).intValue());
            dto.setSaldoFinal(((Number) fila[2]).intValue());
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/reportePresupuestoPorSemana/{idUser}")
    public List<PresupuestoPorSemanaDTO> obtenerPresupuestoPorSemana(@PathVariable int idUser) {
        List<Object[]> filaLista = bS.PresupuestoPorSemana(idUser);
        List<PresupuestoPorSemanaDTO> dtoLista = new ArrayList<>();
        for (Object[] fila : filaLista) {
            PresupuestoPorSemanaDTO dto = new PresupuestoPorSemanaDTO();
            if (fila[0] != null) {
                dto.setFecha(((Date) fila[0]).toLocalDate());
            } else {
                dto.setFecha(null); // o algún valor por defecto si aplica
            }
            dto.setDia(fila[1] != null ? (String) fila[1] : "");
            dto.setFechasDiaMes(fila[2] != null ? (String) fila[2] : "");
            dto.setIngresosPorDia(fila[3] != null ? ((Number) fila[3]).intValue() : 0);
            dto.setEgresosPorDia(fila[4] != null ? ((Number) fila[4]).intValue() : 0);
            dto.setSaldoPorDia(fila[5] != null ? ((Number) fila[5]).intValue() : 0);

            dtoLista.add(dto);
        }
        return dtoLista;
    }

}
