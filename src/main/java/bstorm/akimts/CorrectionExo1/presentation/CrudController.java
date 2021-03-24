package bstorm.akimts.CorrectionExo1.presentation;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CrudController<DTO, ID> {

    // Create
    ResponseEntity<DTO> create(DTO dto);

    // Read
    ResponseEntity<DTO> getOne(ID id);
    List<DTO> getAll();

    // Update
    ResponseEntity<DTO> update(DTO dto, ID id);

    // Delete
    ResponseEntity<DTO> delete(ID id);

}
