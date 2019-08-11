package com.hzqing.base.rest;

import com.hzqing.base.api.dto.user.AddUserRequest;
import com.hzqing.base.api.dto.user.AddUserResponse;
import com.hzqing.base.api.service.IUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseRestApplicationTests {

    @Reference
    IUserService userService;

    @Test
    public void contextLoads() {

        AddUserRequest request = new AddUserRequest();
        request.setEmail("mmd0308@126.com");
        request.setUsername("张莉萨");
        AddUserResponse user = userService.createUser(request);
        System.out.println(user);


//
//        DeleteMenuRequest request = new DeleteMenuRequest();
//        request.setId(2);
//        userService.deleteUser(request);
    }

}
