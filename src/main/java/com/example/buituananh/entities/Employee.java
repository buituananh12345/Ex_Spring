package com.example.buituananh.entities;

import com.example.buituananh.entities.dtos.EmployeeDto;
import lombok.*;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String fullName;
    public String salary;

    public Employee(EmployeeDto employeeDto) {
        BeanUtils.copyProperties(employeeDto, this);
    }
}
