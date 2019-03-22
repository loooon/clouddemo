package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServiceProviderApplication2 {
  private static final Logger LOGGER = LoggerFactory.getLogger(ServiceProviderApplication2.class);

  public static void main(String[] args) throws InterruptedException {
    SpringApplication.run(ServiceProviderApplication2.class, args);
  }
}