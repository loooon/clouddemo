package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.CountDownLatch;

@EnableEurekaServer
@SpringBootApplication
public class ServiceProviderApplication {
  private static final Logger LOGGER = LoggerFactory.getLogger(ServiceProviderApplication.class);


  public static void main(String[] args) throws InterruptedException {
    //    SpringApplication.run(ServiceProviderApplication.class, args);

    ApplicationContext ctx = SpringApplication.run(ServiceProviderApplication.class, args);

  /*  StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
    CountDownLatch latch = ctx.getBean(CountDownLatch.class);

    LOGGER.info("Sending message...");
    template.convertAndSend("chat", "Hello from Redis!");

    latch.await();
*/
    //    System.exit(0);

  }


}