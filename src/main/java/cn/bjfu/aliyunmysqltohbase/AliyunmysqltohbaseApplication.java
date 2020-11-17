package cn.bjfu.aliyunmysqltohbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
public class AliyunmysqltohbaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(AliyunmysqltohbaseApplication.class, args);
    }

}
