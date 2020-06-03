package cn.passwored.configuration;

import cn.passwored.interceptor.FeignRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: cloudService
 * @description: Feign 全局配置
 * @author: WangKe
 * @create: 2020-06-03 09:53
 **/
@Configuration
public class FeignRequestConfiguration {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return new FeignRequestInterceptor();
    }
}
