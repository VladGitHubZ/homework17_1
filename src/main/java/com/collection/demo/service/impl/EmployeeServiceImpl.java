package com.collection.demo.service.impl;

import com.collection.demo.exception.EmployeeAlreadyAddedException;
import com.collection.demo.exception.EmployeeNotFoundException;
import com.collection.demo.exception.EmployeeStorageIsFullException;
import com.collection.demo.model.Employee;
import com.collection.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {

        employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int salary, int department) {
       Employee employee = new Employee(firstName,lastName,salary,department);
       if (employees.containsKey(employee.getFullName())){
           throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(),employee);
        return employee;

    }


    @Override
    public Employee removeEmployee(String firstName, String lastName, int salary, int department) {
        Employee employee = new Employee(firstName,lastName,salary,department);
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, int salary, int department) {
        Employee employee = new Employee(firstName,lastName,salary,department);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Collection<Employee> getAllEmployees() {
         return Collections.unmodifiableCollection(employees.values());
    }
}
