package pl.filiphagno.cruddemo.service;

import pl.filiphagno.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    Employee getEmployee(int id);
    void addOrUpdateEmployee(Employee e);
    void deleteEmployee(int id);
}
