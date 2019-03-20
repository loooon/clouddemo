package hello;

import org.apache.catalina.Store;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "service-provider")
public interface ServiceProviderClient {
  @RequestMapping(method = RequestMethod.GET, value = "/stores")
  List<Store> getStores();

  @RequestMapping(method = RequestMethod.GET, value = "/testFeign/{name}")
  String testFeign(@PathVariable("name") String name);

  @RequestMapping(method = RequestMethod.POST, value = "/stores/{storeId}", consumes = "application/json")
  Store update(@PathVariable("storeId") Long storeId, Store store);
}

