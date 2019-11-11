package pl.filiphagno.cruddemo.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.filiphagno.cruddemo.entity.Employee;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Employee> getEmployees() {

        Session session = entityManager.unwrap(Session.class);

        return session
                .createQuery("from Employee", Employee.class)
                .getResultList();
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Employee.class,id);
    }

    @Override
    public void updateEmployee(Employee e) {

    }

    @Override
    public void deleteEmployee(int id) {

    }
}
