package bstorm.akimts.CorrectionExo1.presentation;

import bstorm.akimts.CorrectionExo1.dto.ProfessorDTO;
import bstorm.akimts.CorrectionExo1.service.CrudService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleValidation(MethodArgumentNotValidException ex){
        return ex.getMessage();
    }
}
