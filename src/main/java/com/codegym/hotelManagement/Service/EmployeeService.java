package com.codegym.hotelManagement.Service;

import com.codegym.hotelManagement.model.Employee;

public interface EmployeeService {
    Iterable<Employee> findAll();
    Employee findById(int id);
    void save(Employee employee);
    void deleteById(int id);
}
