package bstorm.akimts.CorrectionExo1.presentation;

import bstorm.akimts.CorrectionExo1.exceptions.DemoException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerAdviser extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DemoException.class)
    public ResponseEntity<String> demoHandler(DemoException ex, HttpServletRequest request){
        return ResponseEntity
                .status(HttpStatus.I_AM_A_TEAPOT)
                .body(request.getRequestURI() + " -> depuis le controller advice");
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        StringBuilder builder = new StringBuilder();

        if( ex.getGlobalErrorCount() > 0 )
        {
            builder.append("- global errors -------------------");
            for (ObjectError globalError : ex.getBindingResult().getGlobalErrors()) {
                builder.append("\n")
                        .append( globalError.getObjectName() )
                        .append(" - ")
                        .append( globalError.getDefaultMessage() );
            }
            builder.append("\n");
        }

        if( ex.getFieldErrorCount() > 0 )
        {
            builder.append("- field errors -------------------");
            for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
                builder.append("\n")
                        .append( fieldError.getField() )
                        .append(" - ")
                        .append( fieldError.getDefaultMessage() );
            }
        }

        return ResponseEntity.badRequest().body(builder.toString());
    }

}
