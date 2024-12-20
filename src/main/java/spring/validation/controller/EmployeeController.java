package spring.validation.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring.validation.model.Employee;
import spring.validation.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Validated
public class EmployeeController {

   private final EmployeeService service;

   public EmployeeController(EmployeeService service) {
      this.service = service;
   }

   @GetMapping
   public List<Employee> getEmployees() {
      return service.getAllEmployees();
   }

   @GetMapping("/search")
   public Employee getEmployeeByPhoneNumber(@RequestParam String phone) {
      return service.getEmployeeByPhoneNumber(phone);
   }

   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
   public Employee createEmployee (@Valid @RequestBody Employee employee) {
      return service.createEmployee(employee);
   }
}
