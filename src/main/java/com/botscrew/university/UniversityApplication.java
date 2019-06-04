package com.botscrew.university;

import com.botscrew.university.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {

    private final MainService mainService;

    @Autowired
    public UniversityApplication(MainService mainService) {
        this.mainService = mainService;
    }


    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length > 0) {
            mainService.recognizeRequestAndDelegate(args);
        } else {
            System.out.println("No arguments found\n" +
                    "Usage:\n\n" +
                    "Who is head of department {department_name}\n" +
                    "Answer:\n" +
                    "Head of {department_name} department is {head_of_department_name}\n" +
                    "Show {department_name} statistic\n" +
                    "Answer:\n" +
                    "assistants - {assistants_count}. associate professors - {associate_professors_count} professors -{professors_count}\n" +
                    "Show the average salary for department {department_name}\n" +
                    "Answer:\n" +
                    "The average salary of {department_name} is {average_salary}\n" +
                    "Show count of employee for {department_name}\n" +
                    "Answer:\n" +
                    "{employee_count}\n" +
                    "Global search by {template}\n" +
                    "Example: Global search by van\n" +
                    "Answer:\n" +
                    "Ivan Petrenko, Petro Ivanov");
        }
    }
}
