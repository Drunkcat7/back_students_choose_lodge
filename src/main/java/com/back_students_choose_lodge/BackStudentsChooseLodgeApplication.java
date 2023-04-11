package com.back_students_choose_lodge;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.back_students_choose_lodge.dao")
public class BackStudentsChooseLodgeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackStudentsChooseLodgeApplication.class, args);
    }

}
