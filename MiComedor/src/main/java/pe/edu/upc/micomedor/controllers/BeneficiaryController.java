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

    @PutMapping("/deleteActive/{id}")
    public void eliminar(@PathVariable("id") Integer id){ ibS.deleteBeneficiaryActive(id);}

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody BeneficiaryDTO dto) {
        ModelMapper m = new ModelMapper();
        Beneficiary existing = ibS.listId(id); // obtener el actual desde DB
        if (existing == null) return; // o lanza error

        Beneficiary updated = m.map(dto, Beneficiary.class);
        updated.setIdBeneficiary(id);
        updated.setUsers(existing.getUsers()); // ⬅️ conserva el user actual

        ibS.insert(updated);
    }

    @GetMapping("/{id}")
    public BeneficiaryDTO listById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        Beneficiary beneficiary = ibS.listId(id);
        return m.map(beneficiary, BeneficiaryDTO.class);
    }
    @GetMapping("/beneficiarioPorUsuario/{idUser}")
    public List<BeneficiaryByUserDTO> obtenerListaBeneficiariosPorUsuario(@PathVariable int idUser) {
        List<Beneficiary> beneficiaries = ibS.findActiveByUserId(idUser);
        List<BeneficiaryByUserDTO> resultado = new ArrayList<>();

        for (Beneficiary beneficiary : beneficiaries) {
            BeneficiaryByUserDTO dto = new BeneficiaryByUserDTO();
            dto.setIdBeneficiary(beneficiary.getIdBeneficiary());
            dto.setDniBenefeciary(beneficiary.getDniBenefeciary());
            dto.setFullnameBenefeciary(beneficiary.getFullnameBenefeciary());
            dto.setAgeBeneficiary(beneficiary.getAgeBeneficiary());
            dto.setObservationsBeneficiary(beneficiary.getObservationsBeneficiary());
            dto.setActive(beneficiary.getIsActive());
            resultado.add(dto);
        }
        return resultado;
    }
    @GetMapping("/beneficiarioPorUsuarioGeneral/{idUser}")
    public List<BeneficiaryByUserDTO> obtenerListaBeneficiariosPorUsuarioGeneral(@PathVariable int idUser) {
        List<Beneficiary> beneficiaries = ibS.findBeneficiaryByUserId(idUser);
        List<BeneficiaryByUserDTO> resultado = new ArrayList<>();

        for (Beneficiary beneficiary : beneficiaries) {
            BeneficiaryByUserDTO dto = new BeneficiaryByUserDTO();
            dto.setIdBeneficiary(beneficiary.getIdBeneficiary());
            dto.setDniBenefeciary(beneficiary.getDniBenefeciary());
            dto.setFullnameBenefeciary(beneficiary.getFullnameBenefeciary());
            dto.setAgeBeneficiary(beneficiary.getAgeBeneficiary());
            dto.setObservationsBeneficiary(beneficiary.getObservationsBeneficiary());
            dto.setActive(beneficiary.getIsActive());
            resultado.add(dto);
        }
        return resultado;
    }
}
