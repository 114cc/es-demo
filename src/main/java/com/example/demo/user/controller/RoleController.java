package com.example.demo.user.controller;

import com.example.demo.user.domain.User;
import com.example.demo.user.dto.RoleSaveDTO;
import com.example.demo.user.dto.UserSaveDTO;
import com.example.demo.user.service.RoleService;
import com.example.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping(value = "/save")
    public String save(@Validated @RequestBody RoleSaveDTO saveDTO) {
        roleService.save(saveDTO);
        return "新增成功";
    }
}
