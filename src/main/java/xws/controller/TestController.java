package xws.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xws.client.UserClient;
import xws.entity.User;

import java.util.List;

/**
 * test
 * Created by xws on 5/20/17.
 */

@RestController
public class TestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserClient userClient;

    @Value("${spring.application.name}")
    private String applicationName;

    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public List<ServiceInstance> serviceInstancesByApplicationName() {
        return this.discoveryClient.getInstances(applicationName);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        User user = userClient.get();
        System.out.println(JSON.toJSONString(user));

        user = userClient.insertUser();
        System.out.println(JSON.toJSONString(user));

        return JSON.toJSONString(user);
    }


}
