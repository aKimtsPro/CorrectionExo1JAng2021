package bstorm.akimts.CorrectionExo1.presentation;

import bstorm.akimts.CorrectionExo1.exceptions.DemoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> demoHandler(DemoException ex){
        return ResponseEntity
                .status(HttpStatus.I_AM_A_TEAPOT)
                .body(ex.getMessage());
    }
}
