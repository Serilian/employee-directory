package pl.filiphagno.cruddemo.controller.exceptions;

public class EmployeeRestException extends RuntimeException {
    public EmployeeRestException(String message) {
        super(message);
    }
}
