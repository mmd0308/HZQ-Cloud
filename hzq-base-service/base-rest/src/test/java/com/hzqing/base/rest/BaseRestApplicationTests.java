package com.hzqing.base.rest;

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


//
//        DeleteMenuRequest request = new DeleteMenuRequest();
//        request.setId(2);
//        userService.deleteUser(request);
    }

}
