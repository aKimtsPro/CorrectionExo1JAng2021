package bstorm.akimts.CorrectionExo1.presentation;

import bstorm.akimts.CorrectionExo1.dto.DemoDTO;
import bstorm.akimts.CorrectionExo1.dto.rapport.Rapport;
import bstorm.akimts.CorrectionExo1.exceptions.DemoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/demo") // http://localhost:8080/demo/truc - GET
public class DemoController {

    @GetMapping("/truc/{id}")
    public ResponseEntity<DemoDTO> truc(@RequestBody String body, @PathVariable("id") int id) {

        System.out.println(body);

        DemoDTO dto = new DemoDTO(body, 74544);
        return ResponseEntity
                .ok()
                .header("key", "value")
                .body(dto);
    }

    @GetMapping("/test2")
    public void test2(@RequestHeader("accept") String accept){
        System.out.println(accept);
    }

    @GetMapping("/params")
    public void testParams(@RequestParam Map<String, String> params){
        params.forEach((key, value) -> System.out.println(key + " - " + value));
    }

    @GetMapping("/param")
    public void testParam(@RequestParam("id") int id ){
        System.out.println(id);
    }

    @GetMapping("/crash")
    public ResponseEntity<Integer> testCrash() throws DemoException {
        throw new DemoException();
    }

    @ExceptionHandler(DemoException.class)
    public ResponseEntity<Rapport> demoHandler(DemoException ex, HttpServletRequest request){

        Rapport r = new Rapport(
                ex.getMessage(),
                request.getRequestURI(),
                HttpStatus.I_AM_A_TEAPOT.value()
        );

        return ResponseEntity
                .status(HttpStatus.I_AM_A_TEAPOT)
                .body(r);
    }
}
