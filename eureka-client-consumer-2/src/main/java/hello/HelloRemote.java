//package hello;
//
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//@EnableFeignClients(name= "service-provider")
//public interface HelloRemote {
//
//  //restful api 调用
//  @GetMapping("/hello/{name}")
//  public String hello(@PathVariable("name") String name);
//
//  //传统api调用
//  //@GetMapping(value = "/hello")
//  //public String hello(@RequestParam(value = "name") String name);
//}