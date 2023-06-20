package com.example.buituananh.services;

import com.example.buituananh.entities.Employee;
import com.example.buituananh.entities.dtos.EmployeeDto;
import com.example.buituananh.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee create(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto);
        BeanUtils.copyProperties(employeeDto, employee);
        return employeeRepository.save(employee);
    }
}
