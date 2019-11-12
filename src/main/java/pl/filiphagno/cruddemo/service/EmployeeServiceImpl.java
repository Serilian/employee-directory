package pl.filiphagno.cruddemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.filiphagno.cruddemo.DAO.EmployeeDAO;
import pl.filiphagno.cruddemo.entity.Employee;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeDAO.getEmployees();
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    public void addOrUpdateEmployee(Employee e) {
        employeeDAO.saveOrUpdateEmployee(e);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
