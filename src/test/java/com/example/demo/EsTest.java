package com.example.demo;

import com.example.demo.user.dto.UserSaveDTO;
import com.example.demo.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 类 名: EsTest
 * 描 述:
 * 作 者: 王宇龙
 * 创 建：2025年03月14日
 */

@SpringBootTest(classes = DemoApplication.class)
public class EsTest {

    @Autowired
    private UserService userService;

    @Test
    public void creatIndex() {
        UserSaveDTO userSaveDTO = new UserSaveDTO();
        userSaveDTO.setName("张三");
        userSaveDTO.setAge("18");
        userSaveDTO.setSex(1);
        userService.save(userSaveDTO);
    }

    @Test
    public void selectUserAll() {
    }

}
