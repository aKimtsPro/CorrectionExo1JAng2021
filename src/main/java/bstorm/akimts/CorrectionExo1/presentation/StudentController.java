package bstorm.akimts.CorrectionExo1.presentation;

import bstorm.akimts.CorrectionExo1.dto.SectionDTO;
import bstorm.akimts.CorrectionExo1.dto.StudentDTO;
import bstorm.akimts.CorrectionExo1.exceptions.ElementAlreadyExistsException;
import bstorm.akimts.CorrectionExo1.exceptions.ElementNotFoundException;
import bstorm.akimts.CorrectionExo1.service.CrudService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student") // {domaine}/student
@Profile("api")
public class StudentController extends AbstractCrudController<StudentDTO, Integer> {

    public StudentController(CrudService<StudentDTO, Integer> service) {
        super(service);
    }
}
