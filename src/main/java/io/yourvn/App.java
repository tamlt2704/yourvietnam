package io.yourvn;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableBatchProcessing
@ComponentScan("io.yourvn.config")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
