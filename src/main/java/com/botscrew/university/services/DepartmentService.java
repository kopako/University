package com.botscrew.university.services;

import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {

    String getHead(String departmentName);

    String getStatistic(String departmentName);

    String getAverageSalary(String departmentName);

    String getCountOfEmloyee(String department);

    String globalSearchBy(String template);
}
