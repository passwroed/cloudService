package cn.passwored.provider;

import cn.passwored.configuration.DubboSentinelConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;
/**
 * @program: cloudService
 * @description:
 * @author: WangKe
 * @create: 2020-06-04 11:38
 **/
@SpringBootApplication
//        (scanBasePackageClasses = {ProviderAdminApplication.class, DubboSentinelConfiguration.class})
@MapperScan(basePackages = "cn.passwored.provider.mapper")
public class ProviderAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderAdminApplication.class, args);
    }
}
