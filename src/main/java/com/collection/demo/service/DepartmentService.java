package com.collection.demo.service;

import com.collection.demo.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
        Employee getEmployeeWithMaxSalary(int departmentId);
        Employee getEmployeeWithMinSalary(int departmentId);
        Collection<Employee> getAllEmployeesByDepartment(int departmentId);
        Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartment();
}
