package cn.passwored.configuration;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: cloudService
 * @description: 仅 Dubbo 服务需要该配置，Spring Cloud Alibaba 无需加载该配置
 * @author: WangKe
 * @create: 2020-06-03 09:56
 **/
@Configuration
public class DubboSentinelConfiguration {

    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }

}
