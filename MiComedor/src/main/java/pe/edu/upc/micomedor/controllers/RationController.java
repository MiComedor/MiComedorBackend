package pe.edu.upc.micomedor.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.micomedor.dtos.RationByUserIdDTO;
import pe.edu.upc.micomedor.dtos.RationDTO;
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

}
