package com.dhcc.service.controller;

import com.dhcc.service.Client.UserClient;
import com.dhcc.service.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author lipengfei
 * @create 2019-10-22-15:48
 */
@Controller
@RequestMapping("customer/user")
//@DefaultProperties(defaultFallback = "fallbackMethod") //定义全局的熔断器
public class UserController {
//    @Autowired
//    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserClient userClient;

    @GetMapping
    @ResponseBody
    @HystrixCommand  //声明熔断方法
    public User queryUserById(@RequestParam("id")Long id){
       /* if (id==1){
            throw new RuntimeException("太忙了");

        }*/
        // 根据服务名称，获取服务实例。有可能是集群，所以是service实例集合
        //List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
        // 因为只有一个Service-provider。所以获取第一个实例
       // ServiceInstance instance = instances.get(0);
        // 获取ip和端口信息，拼接成服务地址
        //String baseUrl = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/" + id;
       // return this.restTemplate.getForObject(baseUrl, String.class);

        //return this.restTemplate.getForObject("http://service-provider/user/"+id,String.class);
        return this.userClient.queryUserById(id);

    }
   /* public String fallbackMethod(){
        return "请求繁忙，请稍后再试！";
    }*/
}
