package hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProviderRestController {

  @GetMapping("/hello/{name}")
  public String index(@PathVariable String name) {
    return "hello!" + name;
  }


  @GetMapping("/testFeign/{name}")
  public String feignTest(@PathVariable String name) {
    return "hello feign " + name;
  }
}
