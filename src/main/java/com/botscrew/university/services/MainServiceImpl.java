package com.botscrew.university.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MainServiceImpl implements MainService {

    private DepartmentService departmentService;
    private LectorService lectorService;

    @Autowired
    public MainServiceImpl(DepartmentService departmentService, LectorService lectorService) {
        this.departmentService = departmentService;
        this.lectorService = lectorService;
    }

    @Override
    public void recognizeRequestAndDelegate(String... args) {
        StringBuilder request = new StringBuilder();
        Arrays.stream(args).forEach(a -> request.append(a).append(' '));
        String requestString = request.toString();
        if (requestString.contains("Who is head of department")) {
            System.out.println(
                    departmentService.getHead(
                            requestString.replaceAll("Who is head of department", "").trim())
            );
        } else if (requestString.contains("Show statistic.")) {
            System.out.println(
                    departmentService.getStatistic(
                            requestString.split(" ")[1])
            );
        } else if (requestString.contains("Show the average salary for department")) {
            System.out.println(departmentService.getAverageSalary(
                    requestString.replaceAll("Show the average salary for department", "").trim())
            );
        } else if (requestString.contains("Show count of employee for ")) {
            System.out.println(departmentService.getCountOfEmloyee(
                    requestString.replaceAll("Show count of employee for", "").trim())
            );
        } else if (requestString.contains("Global search by ")) {
            System.out.println(lectorService.globalSearchBy(
                    requestString.replaceAll("Global search by", "").trim())
            );
        } else {
            System.out.println(String.format("'%s' : no valid command found", requestString));
        }
    }
}
