package pl.filiphagno.cruddemo.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRESTExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleNotFoundException(EmployeeRestException e) {
        EmployeeErrorResponse errorResponse = new EmployeeErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(e.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<EmployeeErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleGeneralException (Exception e) {
        EmployeeErrorResponse errorResponse = new EmployeeErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(e.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<EmployeeErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }



}
