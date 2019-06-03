package com.botscrew.university.services;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface DepartmentService {

    String getHead(String departmentName);

    String getStatistic(String departmentName);

    BigDecimal getAverageSalary(String departmentName);

    int getCountOfEmloyee(String department);
}
