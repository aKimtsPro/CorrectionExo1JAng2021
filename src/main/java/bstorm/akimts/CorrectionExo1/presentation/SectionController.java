package bstorm.akimts.CorrectionExo1.presentation;

import bstorm.akimts.CorrectionExo1.dto.SectionDTO;
import bstorm.akimts.CorrectionExo1.exceptions.ElementAlreadyExistsException;
import bstorm.akimts.CorrectionExo1.exceptions.ElementNotFoundException;
import bstorm.akimts.CorrectionExo1.service.CrudService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/section") // localhost:8080/section
@Profile("api")
public class SectionController extends AbstractCrudController<SectionDTO, Integer> {

    public SectionController(CrudService<SectionDTO, Integer> service) {
        super(service);
    }

//    @Override
//    @PostMapping// POST - localhost:8080/section
//    public ResponseEntity<SectionDTO> create(@RequestBody SectionDTO sectionDTO ){
//
//        try {
//            service.insert(sectionDTO);
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("fromController", "SectionController");
//            headers.add("fromController", "SectionController2");
//
//            return new ResponseEntity<SectionDTO>(
//                    sectionDTO,
//                    headers,
//                    HttpStatus.CREATED
//            );
//
//        } catch (ElementAlreadyExistsException e) {
//            return ResponseEntity
//                    .badRequest()
//                    .header("fromController", "SectionController", "SectionController2")
//                    .build();
//        }
//    }

    @GetMapping("/test2")
    public void test2(@RequestHeader("accept") String contentType){
        System.out.println(contentType);
    }

    @GetMapping("/params")
    public void testParams(@RequestParam Map<String, String> params){
        params.forEach((key, value) -> System.out.println(key + " - " + value));
    }

    @GetMapping("/param")
    public void testParam(@RequestParam("id") int id ){
        System.out.println(id);
    }
}
