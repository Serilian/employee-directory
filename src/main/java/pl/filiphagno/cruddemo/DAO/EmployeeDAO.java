package pl.filiphagno.cruddemo.DAO;

import pl.filiphagno.cruddemo.entity.Employee;
import java.util.List;

public interface EmployeeDAO {

    List<Employee> getEmployees();

    Employee getEmployee(int id);

    void saveOrUpdateEmployee(Employee e);

    void deleteEmployee(int id);

}
