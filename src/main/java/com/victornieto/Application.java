package com.victornieto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by victor.nieto.castan on 08/06/2017.
 */
@SpringBootApplication
@EnableScheduling
public class Application {

    @Bean
    public CommandLineRunner tutorial() {
        return new ProducerRunner();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}
