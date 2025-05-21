package pe.edu.upc.micomedor.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.micomedor.dtos.*;
import pe.edu.upc.micomedor.entities.Ration;
import pe.edu.upc.micomedor.servicesInterfaces.IRationService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

@RestController
@RequestMapping("/ration")
public class RationController {
    @Autowired
    private IRationService rS;

    @PostMapping
    public void insertar(@RequestBody RationDTO rationDTO){
        ModelMapper m=new ModelMapper();
        Ration r=m.map(rationDTO, Ration.class);
        rS.insert(r);
    }

    @GetMapping
    public List<RationDTO> listar(){
        return rS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, RationDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){ rS.delete(id);}

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id,@RequestBody RationDTO dto) {
        dto.setIdRation(id);
        ModelMapper m = new ModelMapper();
        Ration r = m.map(dto, Ration.class);
        rS.insert(r);
    }

    @GetMapping("/{id}")
    public RationDTO listById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        Ration ration = rS.listId(id);
        return m.map(ration, RationDTO.class);
    }
    @GetMapping("/racionPorUsuario/{idUser}")
    public List<RationByUserIdDTO> obtenerListaRacionesPorUsuario(@PathVariable int idUser) {
        List<Ration> rations = rS.findRationByUserId(idUser);
        List<RationByUserIdDTO> resultado = new ArrayList<>();

        for (Ration ration : rations) {
        RationByUserIdDTO dto = new RationByUserIdDTO();
            dto.setIdRation(ration.getIdRation());
            dto.setDate(ration.getDate());
            dto.setNameRationType(ration.getRationType().getNameRationType());
            dto.setDniBenefeciary(ration.getBeneficiary().getDniBenefeciary());
            dto.setPrice(ration.getPrice());
            resultado.add(dto);
        }

        return resultado;
    }

    @GetMapping("/racionPorDia/{idUser}")
    public RacionesPorDiaDTO obtenerListaRacionDia(@PathVariable int idUser) {
        int total = rS.reporteDiarioRacionPorDia(idUser);
        RacionesPorDiaDTO dto = new RacionesPorDiaDTO();
        dto.setTotalRacionPorDia(total);
        return dto;
    }

    @GetMapping("/reporteRacionesSemanales/{idUser}")
    public List<RacionesPorSemanaDTO> obtenerRacionesPorSemana(@PathVariable int idUser) {
        List<Object[]> filaLista = rS.reporteSemanalRaciones(idUser);
        List<RacionesPorSemanaDTO> dtoLista = new ArrayList<>();
        for (Object[] fila : filaLista) {
            RacionesPorSemanaDTO dto = new RacionesPorSemanaDTO();
            dto.setDia((String) fila[0]);
            dto.setFecha((String) fila[1]);
            dto.setTotalRaciones(((Number) fila[2]).intValue());
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/reporteTotalRacionesBeneficiarios/{idUser}")
    public List<BeneficiariosPorDiaDTO> obtenerRacionesBeneficiarioPorDia(@PathVariable int idUser) {
        List<Object[]> filaLista = rS.cantidadBeneficiarioPorDia(idUser);
        List<BeneficiariosPorDiaDTO> dtoLista = new ArrayList<>();
        for (Object[] fila : filaLista) {
            BeneficiariosPorDiaDTO dto = new BeneficiariosPorDiaDTO();
            dto.setBeneficiariosPorDia(((Number) fila[0]).intValue());
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/reporteTotalRacionesBeneficiariosSemana/{idUser}")
    public List<BeneficiarioPorSemanaDTO> obtenerRacionesBeneficiarioPorSemana(@PathVariable int idUser) {
        List<Object[]> filaLista = rS.cantidadBeneficiarioPorSemana(idUser);
        List<BeneficiarioPorSemanaDTO> dtoLista = new ArrayList<>();
        for (Object[] fila : filaLista) {
            BeneficiarioPorSemanaDTO dto = new BeneficiarioPorSemanaDTO();
            dto.setDia(((String) fila[0]));
            dto.setFecha(((String) fila[1]));
            dto.setTotalBeneficiarios(((Number) fila[2]).intValue());
            dtoLista.add(dto);
        }
        return dtoLista;
    }

}
