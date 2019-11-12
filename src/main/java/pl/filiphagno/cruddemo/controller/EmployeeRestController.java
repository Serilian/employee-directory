package pl.filiphagno.cruddemo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.filiphagno.cruddemo.controller.exceptions.EmployeeRestException;
import pl.filiphagno.cruddemo.entity.Employee;
import pl.filiphagno.cruddemo.service.EmployeeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeService.getEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.getEmployee(employeeId);

        if(employee == null) {
            throw new EmployeeRestException("Cant find employee with id: " + employeeId);
        }

        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        employeeService.addOrUpdateEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/employees")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        employeeService.addOrUpdateEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<Map<String, String>> deleteEmployee(@PathVariable int employeeId) {
        employeeService.deleteEmployee(employeeId);
        Map<String, String> map = new HashMap<>();
        map.put("message", "Employee deleted");
        map.put("timestamp", ""+System.currentTimeMillis());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }


}
