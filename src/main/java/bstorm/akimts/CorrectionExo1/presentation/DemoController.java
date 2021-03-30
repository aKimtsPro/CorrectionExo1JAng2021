package bstorm.akimts.CorrectionExo1.presentation;

import bstorm.akimts.CorrectionExo1.exceptions.DemoException;
import bstorm.akimts.CorrectionExo1.rapport.Rapport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/demo")
public class DemoController {

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

    @GetMapping("/crash")
    public ResponseEntity<Integer> testCrash() throws DemoException {
        throw new DemoException();
    }

    @ExceptionHandler(DemoException.class)
    public ResponseEntity<Rapport> demoHandler(DemoException ex, HttpServletRequest request){

        Rapport r = new Rapport(
                ex.getMessage(),
                HttpStatus.I_AM_A_TEAPOT.value(),
                request.getRequestURI()
        );

        return ResponseEntity
                .status(HttpStatus.I_AM_A_TEAPOT)
                .body(r);
    }
}
