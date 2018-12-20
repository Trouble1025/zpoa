package org.java.zpoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ZpoaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZpoaApplication.class, args);
    }
}
