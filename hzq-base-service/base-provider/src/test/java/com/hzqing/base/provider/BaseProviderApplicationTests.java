package com.hzqing.base.provider;


import com.hzqing.base.api.dto.user.AddUserRequest;
import com.hzqing.base.api.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseProviderApplicationTests {

    @Autowired
    IUserService userService;

    @Test
    public void contextLoads() {

        AddUserRequest request = new AddUserRequest();
        request.setUsername("list");
        request.setEmail("mmd0308@126.com");
        userService.createUser(request);
    }

}
