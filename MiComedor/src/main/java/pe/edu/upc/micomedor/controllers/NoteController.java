package pe.edu.upc.micomedor.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.micomedor.dtos.NoteByUserDTO;
import pe.edu.upc.micomedor.dtos.NoteDTO;
import pe.edu.upc.micomedor.entities.Note;
import pe.edu.upc.micomedor.servicesInterfaces.INoteService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private INoteService nS;

    @PostMapping
    public void insertar(@RequestBody NoteDTO noteDTO){
        ModelMapper m=new ModelMapper();
        Note n=m.map(noteDTO, Note.class);
        nS.insert(n);
    }

    @GetMapping
    public List<NoteDTO> listar(){
        return nS.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y, NoteDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){ nS.delete(id);}

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody NoteDTO dto) {
        dto.setIdNote(id);
        ModelMapper m = new ModelMapper();
        Note n = m.map(dto, Note.class);
        nS.insert(n);
    }

    @GetMapping("/{id}")
    public NoteDTO listById(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        Note note = nS.listId(id);
        return m.map(note, NoteDTO.class);
    }


    @GetMapping("/notaPorUsuario/{idUser}")
    public List<NoteByUserDTO> obtenerNotasPorUsuario(@PathVariable int idUser) {
        List<Note> notas = nS.findNotasByUserId(idUser);
        List<NoteByUserDTO> resultado = new ArrayList<>();

        for (Note nota : notas) {
            NoteByUserDTO dto = new NoteByUserDTO();
            dto.setIdNote(nota.getIdNote()); // agrega el ID
            dto.setNoteTextByUser(nota.getNoteText());
            resultado.add(dto);
        }

        return resultado;
    }



}



