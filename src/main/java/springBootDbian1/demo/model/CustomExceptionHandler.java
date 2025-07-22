package springBootDbian1.demo.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(TachesNotFoundException.class)
    public ResponseEntity<ApiError>  handleExeptionTacheNotFound(TachesNotFoundException e){
        ApiError apiError = new ApiError();
        apiError.setMessage(e.getMessage());
        apiError.setCode(HttpStatus.NOT_FOUND.value());
        apiError.setTimxestamp(LocalDateTime.now());

        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }
}
