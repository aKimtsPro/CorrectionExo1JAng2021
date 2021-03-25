package bstorm.akimts.CorrectionExo1.presentation;

import bstorm.akimts.CorrectionExo1.dto.IdentifiedDTO;
import bstorm.akimts.CorrectionExo1.dto.StudentDTO;
import bstorm.akimts.CorrectionExo1.exceptions.ElementAlreadyExistsException;
import bstorm.akimts.CorrectionExo1.exceptions.ElementNotFoundException;
import bstorm.akimts.CorrectionExo1.service.CrudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public abstract class AbstractCrudController<DTO extends IdentifiedDTO<ID>, ID> implements CrudController<DTO, ID> {

    protected final CrudService<DTO, ID> service;

    public AbstractCrudController(CrudService<DTO, ID> service) {
        this.service = service;
    }

    @Override
    @GetMapping("/{id}") // GET - {domaine}/?/{id}
    public ResponseEntity<DTO> getOne(@PathVariable ID id) {
        try {
            return ResponseEntity
                    .ok( service.getOne(id) ) ;
        } catch (ElementNotFoundException e) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }

    @Override
    @GetMapping // GET - {domaine}/?
    public List<DTO> getAll() {
        return service.getAll();
    }

    @Override
    @PutMapping("/{id}") // PUT - localhost:8080/section/id
    public ResponseEntity<DTO> update(@Valid @RequestBody DTO dto, @PathVariable("id") ID id) {

        try {
            service.update(dto, id);
            return ResponseEntity.ok( service.getOne(id) );
        } catch (ElementNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }

    @Override
    @DeleteMapping("/{id}/delete") // DELETE - {domaine}/student/{id}/delete
    public ResponseEntity<DTO> delete(@PathVariable ID id) {
        DTO dto = null;
        try {
            dto = service.getOne(id);
            service.delete(id);
            return ResponseEntity.ok( dto );
        } catch (ElementNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @Override
    @PostMapping // POST - {domaine}/student
    public ResponseEntity<DTO> create(@Valid @RequestBody DTO dto) {
        try {
            service.insert(dto);
            return ResponseEntity.ok( service.getOne(dto.getId()) );
        } catch (ElementAlreadyExistsException | ElementNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
