package uz.es.telegraph.config;

import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uz.es.telegraph.exceptons.ObjectsNotFoundException;
import uz.es.telegraph.exceptons.UniqueException;
import uz.es.telegraph.exceptons.UserCheckException;

@ControllerAdvice
public class GlobalExceptions extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {UserCheckException.class})
    public ResponseEntity<String> UserCheckException(
            UserCheckException e
    ) {
        System.out.println("e.getMessage() = " + e.getMessage());
        return ResponseEntity.status(401).body(e.getLocalizedMessage());
    }
    @ExceptionHandler(value = {ObjectsNotFoundException.class})
    public ResponseEntity<String> ObjectNotFoundException(
            ObjectsNotFoundException e
    ){
        System.out.printf("e.getMessage() =" + e.getMessage());
        return ResponseEntity.status(401).body(e.getLocalizedMessage());
    }
@ExceptionHandler(value = {UniqueException.class})
    public ResponseEntity<String> UniqueException(
            UserCheckException e
){
    System.out.printf("e.getMessage()=" + e.getMessage());
    return ResponseEntity.status(500).body(e.getLocalizedMessage());
}
}


