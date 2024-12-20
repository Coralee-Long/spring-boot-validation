package spring.validation.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring.validation.model.Employee;

import java.util.Optional;

public interface EmployeeRepo extends MongoRepository<Employee, String> {

   Optional<Employee> findByPhone(String phone);
}
