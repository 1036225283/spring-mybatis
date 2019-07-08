package xws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xws.dao.UserMapper;
import xws.entity.User;

import java.util.Date;

/**
 * test
 * Created by xws on 5/20/17.
 */

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private DiscoveryClient discoveryClient;


    @Autowired
    private UserMapper userMapper;


    @Value("${spring.application.name}")
    private String applicationName;


    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public User get() {
        User user = new User();
        user.setAge(12);
        return user;
    }

    @RequestMapping(value = "/insertUser", method = RequestMethod.GET)
    public User insertUser() {
        User user = new User();
        user.setAge(12);
        user.setAddress("北京市");
        user.setDeptcode("0000");
        user.setDeptname("开发部");
        user.setPassword("123456");
        user.setCreatetime(new Date());
        user.setModifytime(new Date());
        user.setEmail("id512@126.com");
        user.setPhone("13521307203");
        for (int i = 0; i < 6000; i++) {
            userMapper.insert(user);
        }
        return user;
    }


}
