package hello;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ServiceInvokeRestController {
  @Autowired
  private DiscoveryClient discoveryClient;


  @Bean
  @LoadBalanced
  RestTemplate rest() {
    return new RestTemplate();
  }

  /**
   * call by restTemplate
   */
  @Autowired
  private RestTemplate restTemplate;

  /**
   * call by feign
   */
  @Autowired
  private StoreClient storeClient;

  @RequestMapping("/service-instances/{applicationName}")
  public List<ServiceInstance> serviceInstancesByApplicationName(
      @PathVariable String applicationName) {
    return this.discoveryClient.getInstances(applicationName);
  }

  /**
   * call by restTemplate
   *
   * @param name name
   * @return value
   */
  @GetMapping("/helloHystrix/{name}")
  public String hello(@PathVariable("name") String name) {
    return restTemplate.getForEntity("http://service-provider/hello/" + name, String.class).getBody();
  }

  public String helloFallback(@PathVariable("name") String name) {
    return "hello " + name + " ,this is returned by helloFallback.";
  }

  /**
   * call by openFeign
   *
   * @param name name
   * @return value
   */
  @HystrixCommand(fallbackMethod = "messageHystrixFallback")
  @GetMapping("/messageHystrix/{name}")
  public String messageHystrix(@PathVariable("name") String name) {
    return storeClient.testFeign(name);
  }

  public String messageHystrixFallback(@PathVariable("name") String name) {
    return "hello " + name + " ,this is returned by messageHystrixFallback.";
  }

}
