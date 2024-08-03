package com.collection.demo.controller;
import com.collection.demo.exception.EmployeeNotFoundException;
import com.collection.demo.model.Employee;
import com.collection.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.List;
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }
    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                @RequestParam int salary, @RequestParam int department) {
        return employeeService.addEmployee(firstName,lastName,salary,department);
    }
    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                   @RequestParam int salary, @RequestParam int department) {
        return employeeService.removeEmployee(firstName,lastName,salary,department);
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                @RequestParam int salary, @RequestParam int department) {
        Employee employee = employeeService.findEmployee(firstName,lastName,salary,department);
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }
    @GetMapping
    public Collection<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
