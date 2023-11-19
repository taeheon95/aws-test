package com.example.s3test;

import com.example.s3test.config.YamlPropertyLoadFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(
        value = {"classpath:database.yml", "classpath:aws.yml"},
        factory = YamlPropertyLoadFactory.class
)
public class S3testApplication {

    public static void main(String[] args) {
        SpringApplication.run(S3testApplication.class, args);
    }

}
