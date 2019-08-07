package com.ravi.programming;

import com.ravi.programming.toyrobo.ToyRobo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


@SpringBootApplication
public class ProgrammingApplication {

    private static final ToyRobo toyRobo = new ToyRobo();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = null;
        System.out.println("Please enter board size:");
        do {
            command = scanner.nextLine().toUpperCase();
            toyRobo.performCommand(command);
        } while (!"REPORT".equals(command));
        SpringApplication.run(ProgrammingApplication.class, args);
    }
}


