package hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description : 测试客户端负载均衡的接口API
 * @Author hanyahong
 * @Date 2017/12/7- 18:01
 */
@RestController
@RequestMapping(value = "/test")
public class TestRibbonApiController {

  /**
   * 注入RestTemplate
   */
  @Autowired
  RestTemplate restTemplate;


  @RequestMapping(value = "/blog/name", method = RequestMethod.GET)
  public String testGetNameOfBlog() {
    String url = "http://CLOUD-SERVICE/ribbon/name";
    return restTemplate.getForObject(url, String.class);
  }


  /**
   * call by restTemplate
   *
   * @param name name
   * @return value
   */
  //  @HystrixCommand(fallbackMethod = "testBalance")
  @GetMapping("/testBalance/{name}")
  public String index(@PathVariable("name") String name) {
    return restTemplate.getForEntity("http://service-provider/testBalance/" + name, String.class).getBody();
  }
}
