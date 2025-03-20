package com.example.demo.user.controller;

import com.example.demo.user.domain.User;
import com.example.demo.user.dto.UserSaveDTO;
import com.example.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类 名: UserController
 * 描 述:
 * 作 者: 王宇龙
 * 创 建：2025年03月19日
 */
@RequestMapping(value = "/admin/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/list")
    public List<User> listUserPage(@RequestParam(value = "pageNum", defaultValue = "0") Integer pageNum, @RequestParam(value = "pageSize", defaultValue = "50") Integer pageSize, @RequestParam("keyWord") String keyWord) {
        return userService.listUserPage(pageNum, pageSize, keyWord);
    }

    @PostMapping(value = "/saveUser")
    public String saveUser(@Validated @RequestBody UserSaveDTO saveDTO) {
        userService.save(saveDTO);
        return "新增成功";
    }
}
