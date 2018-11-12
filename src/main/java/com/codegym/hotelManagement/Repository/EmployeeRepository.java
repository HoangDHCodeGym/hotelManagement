package com.codegym.hotelManagement.Repository;

import com.codegym.hotelManagement.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
}
