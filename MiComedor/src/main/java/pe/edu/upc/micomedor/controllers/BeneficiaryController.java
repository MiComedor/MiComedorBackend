package pe.edu.upc.micomedor.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.micomedor.dtos.BeneficiaryByUserDTO;
import pe.edu.upc.micomedor.dtos.BeneficiaryDTO;
import pe.edu.upc.micomedor.entities.Beneficiary;
import pe.edu.upc.micomedor.servicesInterfaces.IBeneficiaryService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

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
    @PostMapping("/saveConfirm")
    public ResponseEntity<?> saveConfirm(@RequestBody BeneficiaryDTO beneficiaryDTO) {
        ModelMapper m = new ModelMapper();
        Beneficiary b = m.map(beneficiaryDTO, Beneficiary.class);

        try {
            Beneficiary saved = ibS.saveBenefiaryConfirm(b);
            BeneficiaryDTO responseDTO = m.map(saved, BeneficiaryDTO.class);
            return ResponseEntity.ok(Map.of(
                    "status", 200,
                    "message", "Beneficiary saved successfully",
                    "beneficiary", responseDTO
            ));
        } catch (RuntimeException e) {
            String msg = e.getMessage();

            // IMPORTANTE: Primero verificar caso inactivo (409) antes que activo (400)
            // porque "inactive" debe tener prioridad sobre "active"
            if (msg.contains("inactive")) {
                // Caso: beneficiario inactivo - retorna 409 Conflict
                return ResponseEntity.status(409).body(Map.of(
                        "status", 409,
                        "message", msg,
                        "canReactivate", true
                ));
            }

            if (msg.contains("active")) {
                return ResponseEntity.badRequest().body(Map.of(
                        "status", 400,
                        "message", msg,
                        "canReactivate", false
                ));
            }

            // Cualquier otro error
            return ResponseEntity.internalServerError().body(Map.of(
                    "status", 500,
                    "message", "Unexpected error: " + msg
            ));
        }
    }
    @PutMapping("/reactivate/{userId}/{dni}")
    public ResponseEntity<?> reactivate(@PathVariable int userId, @PathVariable int dni) {
        Beneficiary existing = ibS.findByUserIdAndDni(userId, dni);

        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        if (existing.getIsActive()) {
            return ResponseEntity.badRequest().body("Beneficiary is already active.");
        }

        existing.setIsActive(true);
        ibS.insert(existing); 

        return ResponseEntity.ok(Map.of(
                "message", "Beneficiary reactivated successfully",
                "beneficiary", existing
        ));
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
