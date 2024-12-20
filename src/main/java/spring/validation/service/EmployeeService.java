package spring.validation.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import spring.validation.model.Employee;
import spring.validation.repo.EmployeeRepo;

import java.util.List;

@Service
public class EmployeeService {

   @Value ("${spring.data.mongodb.uri}")
   private String mongoUri;

   @PostConstruct
   public void logMongoUri() {
      System.out.println("MongoDB URI: " + mongoUri);
   }

   private final EmployeeRepo repo;

   public EmployeeService(EmployeeRepo repo) {
      this.repo = repo;
   }

   public List<Employee> getAllEmployees() {
      return repo.findAll();
   }

   public Employee getEmployeeByPhoneNumber(String phoneNumber) {
      return repo.findByPhone(phoneNumber)
          .orElseThrow(() -> new RuntimeException("Employee not found with phone number: " + phoneNumber));
   }

   public Employee createEmployee(Employee employee) {
      return repo.save(employee);
   }
}
