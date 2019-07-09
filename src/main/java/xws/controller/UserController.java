package xws.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xws.dao.FamilyMapper;
import xws.dao.UserMapper;
import xws.entity.Family;
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

    @Autowired
    private FamilyMapper familyMapper;


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


    @RequestMapping(value = "/insertFamily", method = RequestMethod.GET)
    public String insertFamily(@RequestParam(value = "userId") Long userId) {

        if (userId == null) {
            return "userId is null";
        }

        Family family = new Family();
        family.setPhone("13533244456");
        family.setAddress("address");
        family.setModifytime(new Date());
        family.setCreatetime(new Date());
        family.setName("刘备");
        family.setRelationid((byte) 1);
        family.setUserid(userId);
        familyMapper.insert(family);
        return JSON.toJSONString(family);
    }


}
