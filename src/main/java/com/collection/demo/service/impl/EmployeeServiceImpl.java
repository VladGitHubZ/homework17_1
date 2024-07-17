package com.collection.demo.service.impl;

import com.collection.demo.exception.EmployeeAlreadyAddedException;
import com.collection.demo.exception.EmployeeNotFoundException;
import com.collection.demo.exception.EmployeeStorageIsFullException;
import com.collection.demo.model.Employee;
import com.collection.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employees;

    public EmployeeServiceImpl() {
        employees = new ArrayList<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
       Employee employee = new Employee(firstName,lastName);
       if (employees.contains(employee)){
           throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;

    }


    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        if (!employees.contains(employee)){
            throw new EmployeeNotFoundException();
        }

        employees.remove(employee);

        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee findEmployee = new Employee(firstName,lastName);
        for (Employee employee : employees) {
            if (employee.equals(findEmployee)){
                return employee;
            }
        }
        return null;
   }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }
}
