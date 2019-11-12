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
    @Transactional
    public Employee getEmployee(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Employee.class,id);
    }

    @Override
    @Transactional
    public void saveOrUpdateEmployee(Employee e) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(e);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        Session session = entityManager.unwrap(Session.class);
        session.remove(session.get(Employee.class, id));
    }

}
