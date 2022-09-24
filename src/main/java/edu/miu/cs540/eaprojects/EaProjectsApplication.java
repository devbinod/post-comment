package edu.miu.cs540.eaprojects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EaProjectsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EaProjectsApplication.class, args);
    }

}
