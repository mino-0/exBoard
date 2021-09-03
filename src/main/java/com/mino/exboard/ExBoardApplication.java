package com.mino.exboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ExBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExBoardApplication.class, args);
    }

}
