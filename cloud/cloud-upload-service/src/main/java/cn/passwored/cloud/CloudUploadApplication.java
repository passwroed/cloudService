package cn.passwored.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: cloudService
 * @description:
 * @author: WangKe
 * @create: 2020-06-13 14:59
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class CloudUploadApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudUploadApplication.class, args);
    }
}
