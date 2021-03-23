package bstorm.akimts.CorrectionExo1.presentation;

import bstorm.akimts.CorrectionExo1.dto.SectionDTO;
import bstorm.akimts.CorrectionExo1.exceptions.ElementAlreadyExistsException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CrudController<DTO, ID> {

    // Create
    ResponseEntity<DTO> create(DTO dto) throws ElementAlreadyExistsException;

    // Read
    ResponseEntity<DTO> getOne(ID id);
    List<DTO> getAll();

    // Update
    SectionDTO update(DTO dto, ID id);

    // Delete
    SectionDTO delete(ID id);

}
