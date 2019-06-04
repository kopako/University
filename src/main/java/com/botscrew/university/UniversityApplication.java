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
            System.out.println("No arguments found");
        }
    }
}
