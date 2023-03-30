package org.group9.gradingsystemserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class GradingSystemServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GradingSystemServerApplication.class, args);
    }

}
