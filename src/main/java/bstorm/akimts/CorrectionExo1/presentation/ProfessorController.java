package bstorm.akimts.CorrectionExo1.presentation;

import bstorm.akimts.CorrectionExo1.dto.ProfessorDTO;
import bstorm.akimts.CorrectionExo1.service.CrudService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prof")
@Profile("api")
public class ProfessorController extends AbstractCrudController<ProfessorDTO, Integer> {
    public ProfessorController(CrudService<ProfessorDTO, Integer> service) {
        super(service);
    }
}
