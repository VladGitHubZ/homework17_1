package com.collection.demo.service.impl;

import com.collection.demo.model.Employee;
import com.collection.demo.service.DepartmentService;
import com.collection.demo.service.EmployeeService;
import org.springframework.stereotype.Service;
import com.collection.demo.exception.EmployeeAlreadyAddedException;
import com.collection.demo.exception.EmployeeNotFoundException;
import com.collection.demo.exception.EmployeeStorageIsFullException;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getEmployeeWithMaxSalary(int departmentId) {
        Object EmployeeNotFoundException;
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee getEmployeeWithMinSalary(int departmentId) {
        Object EmployeeNotFoundException;
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> getAllEmployeesByDepartment(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartment() {
        return employeeService.getAllEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
