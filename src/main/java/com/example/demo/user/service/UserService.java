package com.example.demo.user.service;

import com.example.demo.user.domain.User;
import com.example.demo.user.dto.UserSaveDTO;

import java.util.List;

/**
 * 类 名: UserService
 * 描 述:
 * 作 者: 王宇龙
 * 创 建：2025年03月17日
 */
public interface UserService {

    List<User> listUserPage(Integer pageNum, Integer pageSizepageSize, String keyWord);

    void save(UserSaveDTO saveDTO);

}
