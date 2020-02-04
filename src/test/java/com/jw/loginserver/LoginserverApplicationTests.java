package com.jw.loginserver;

import com.jw.loginserver.dao.User;
import com.jw.loginserver.dao.UserMapper;
import com.jw.loginserver.proto.ProtostuffUtil;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.runtime.RuntimeSchema;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class LoginserverApplicationTests {

    @Test
    void contextLoads() {

    }

    @Autowired
    private UserMapper userMapper;

    @Test
    void test() {
        User user = userMapper.query(1);
        System.out.print(user);
    }

    @Test
    void proto() {
        User user = new User();
        user.setUserid(2);
        user.setAccount("root");
        user.setPasswd("123456");


        byte[] bytess = ProtostuffUtil.serializer(user);
        System.out.println(bytess);
        User newUser = ProtostuffUtil.deserializer(bytess, User.class);
        System.out.println("==============================");
        System.out.println(newUser);
    }

    @Test
    void client() throws Exception {
        new NettyClient("127.0.0.1", 8080).start();
    }
}
