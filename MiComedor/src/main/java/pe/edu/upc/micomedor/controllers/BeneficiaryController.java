package pe.edu.upc.micomedor.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.micomedor.dtos.BeneficiaryByUserDTO;
import pe.edu.upc.micomedor.dtos.BeneficiaryDTO;
import pe.edu.upc.micomedor.dtos.RationByUserIdDTO;
import pe.edu.upc.micomedor.entities.Beneficiary;
import pe.edu.upc.micomedor.servicesInterfaces.IBeneficiaryService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/beneficiary")
public class BeneficiaryController {
    @Autowired
    private IBeneficiaryService ibS;

    @PostMapping
    public void insertar(@RequestBody BeneficiaryDTO beneficiaryDTO){
        ModelMapper m=new ModelMapper();
        Beneficiary b=m.map(beneficiaryDTO, Beneficiary.class);
        ibS.insert(b);
    }

    @GetMapping
    public List<BeneficiaryDTO> listar(){
        return ibS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, BeneficiaryDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){ ibS.delete(id);}

    @PutMapping
    public void update(@RequestBody BeneficiaryDTO dto) {
        ModelMapper m = new ModelMapper();
        Beneficiary u = m.map(dto, Beneficiary.class);
        ibS.insert(u);
    }

    @GetMapping("/{id}")
    public BeneficiaryDTO listById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        Beneficiary beneficiary = ibS.listId(id);
        return m.map(beneficiary, BeneficiaryDTO.class);
    }

    @GetMapping("/beneficiarioPorUsuario/{idUser}")
    public List<BeneficiaryByUserDTO> obtenerListaBeneficiariosPorUsuario(@PathVariable int idUser) {
        List<Beneficiary> beneficiaries = ibS.findBeneficiaryByUserId(idUser);
        List<BeneficiaryByUserDTO> resultado = new ArrayList<>();

        for (Beneficiary beneficiary : beneficiaries) {
            BeneficiaryByUserDTO dto = new BeneficiaryByUserDTO();
            dto.setIdBeneficiary(beneficiary.getIdBeneficiary());
            dto.setDniBenefeciary(beneficiary.getDniBenefeciary());
            dto.setFullnameBenefeciary(beneficiary.getFullnameBenefeciary());
            dto.setAgeBeneficiary(beneficiary.getAgeBeneficiary());
            dto.setObservationsBeneficiary(beneficiary.getObservationsBeneficiary());
            resultado.add(dto);
        }

        return resultado;
    }
}
