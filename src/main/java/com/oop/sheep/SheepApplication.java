package com.oop.sheep;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author 13889
 * @tite MockSoftwareApplication
 * @projectName mocksoftware
 * @description : TODO
 * @date 2021/12/19 15:56
 */
@SpringBootApplication
public class SheepApplication {

    public static void main(String[] args) {


        SpringApplicationBuilder builder = new SpringApplicationBuilder(SheepApplication.class);
        builder.headless(false).run(args);

    }
}
