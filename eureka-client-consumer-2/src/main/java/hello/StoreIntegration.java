package hello;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * hystrix 熔断器
 */
@Component
public class StoreIntegration {
  @HystrixCommand(fallbackMethod = "defaultStores")
  public Object getStores(Map<String, Object> parameters) {
    //do stuff that might fail
    return new Object();
  }

  public Object defaultStores(Map<String, Object> parameters) {
    return new Object();
  }
}
