package com.botscrew.university.services;

import com.botscrew.university.models.Degree;
import com.botscrew.university.models.Lector;
import com.botscrew.university.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public String getHead(String departmentName) {
        String head = departmentRepository.findByNameIgnoreCase(departmentName).getHeadOfDepartment();
        return String.format("Head of %s department is %s", departmentName, head);
    }

    @Override
    public String getStatistic(String departmentName) {
        AtomicInteger assistanCount= new AtomicInteger();
        AtomicInteger associateProfessorCount= new AtomicInteger();
        AtomicInteger proffesorCount= new AtomicInteger();

        List<Lector> lectors = departmentRepository.findByNameIgnoreCase(departmentName).getLectors();
        lectors.forEach(a -> {
            if (a.getDegree().equals(Degree.assistant)) assistanCount.getAndIncrement();
            if (a.getDegree().equals(Degree.associate_professor)) associateProfessorCount.getAndIncrement();
            if (a.getDegree().equals(Degree.professor)) proffesorCount.getAndIncrement();

        });
        return String.format("assistants - %d. " +
                        "associate professors - %d " +
                        "professors - %d",
                assistanCount.intValue(),associateProfessorCount.intValue(),proffesorCount.intValue());
    }

    @Override
    public String getAverageSalary(String departmentName) {
                BigDecimal summOfSalaries = departmentRepository.findByNameIgnoreCase(departmentName)
                        .getLectors().stream()
                .map(Lector::getSalary)
                .reduce(BigDecimal.valueOf(0), BigDecimal::add);
        BigDecimal quantity = BigDecimal.valueOf(departmentRepository.findByNameIgnoreCase(departmentName).getLectors().size());
        return String.format("The average salary of {department_name} is %d", (summOfSalaries.divide(quantity, RoundingMode.HALF_UP)).longValue());
    }

    @Override
    public int getCountOfEmloyee(String department) {
        return departmentRepository.findByNameIgnoreCase(department).getLectors().size();
    }
}

