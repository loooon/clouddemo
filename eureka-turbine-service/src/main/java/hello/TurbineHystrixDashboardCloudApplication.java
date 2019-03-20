package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author michael
 */
@EnableEurekaClient // 配置本应用将使用服务注册和服务发现
@EnableHystrixDashboard
@EnableTurbine // http://127.0.0.1:12086/hystrix
@EnableDiscoveryClient
@SpringBootApplication
public class TurbineHystrixDashboardCloudApplication {
  public static void main(String[] args) {
    //    args = new String[1];
    //    args[0] = "--spring.profiles.active=dashboard";
    SpringApplication.run(TurbineHystrixDashboardCloudApplication.class, args);
  }
}