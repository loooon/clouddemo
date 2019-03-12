package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ImportResource;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableZuulProxy
@ImportResource("classpath:applicationContext.xml")
//启用服务注册与发现
public class ClientConsumerApplication {
  public static void main(String[] args) {
    SpringApplication.run(ClientConsumerApplication.class, args);
  }

}
