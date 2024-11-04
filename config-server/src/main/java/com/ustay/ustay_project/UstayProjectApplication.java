package com.ustay.ustay_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class UstayProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(UstayProjectApplication.class, args);
    }
}
