package hello;

import org.apache.catalina.Store;

import java.util.List;


class HystrixClientFallback implements ServiceProviderClient {

  @Override
  public List<Store> getStores() {
    return null;
  }

  /**
   * fallback
   *
   * @param name
   * @return
   */
  @Override
  public String testFeign(String name) {
    return "feign fallback success!!!";
  }

  @Override
  public Store update(Long storeId, Store store) {
    return null;
  }
}