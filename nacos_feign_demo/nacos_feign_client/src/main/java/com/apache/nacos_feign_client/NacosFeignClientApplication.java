package com.apache.nacos_feign_client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@RestController
public class NacosFeignClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosFeignClientApplication.class, args);
    }

    @Resource
    private RemoteClient remoteClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/feign")
    public String test(){
        return remoteClient.hello();
    }

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/consumer")
    public String test1() {
        String result = restTemplate.getForObject("http://nacos-feign-server/hello",String.class);
        return "Return : " + result;
    }
}
