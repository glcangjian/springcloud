package com.apache.nacos_feign_client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @InterfaceName：RemoteClient
 * @Description:
 * @Date: 2020/5/31 1:19 PM
 * @Author: lin.guo
 **/
@FeignClient(name = "nacos-feign-server")
public interface RemoteClient {
    @GetMapping("/hello")
    String hello();
}
