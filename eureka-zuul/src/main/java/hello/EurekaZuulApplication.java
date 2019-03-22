package hello;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaServer
@SpringBootApplication
@EnableZuulProxy
public class EurekaZuulApplication {

  public static void main(String[] args) {
    SpringApplication.run(EurekaZuulApplication.class, args);
  }
}
