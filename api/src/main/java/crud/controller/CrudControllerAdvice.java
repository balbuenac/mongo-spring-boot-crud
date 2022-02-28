package crud.controller;

import com.demo.common.exceptions.CategoryException;
import com.demo.common.exceptions.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CrudControllerAdvice {

    @ExceptionHandler(value = {CategoryException.class})
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public ErrorMessage resourceNotFoundException(CategoryException ex) {
        return new ErrorMessage(ex.getMessage());
    }

}
