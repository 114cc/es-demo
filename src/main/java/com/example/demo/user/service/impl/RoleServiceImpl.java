package com.example.demo.user.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.example.demo.user.domain.Role;
import com.example.demo.user.domain.User;
import com.example.demo.user.dto.RoleSaveDTO;
import com.example.demo.user.dto.UserSaveDTO;
import com.example.demo.user.repository.RoleRepository;
import com.example.demo.user.repository.UserRepository;
import com.example.demo.user.service.RoleService;
import com.example.demo.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类 名: UserServiceImpl
 * 描 述:
 * 创 建：2025年03月17日
 */
@Slf4j
@Service("roleServiceImpl")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void save(RoleSaveDTO saveDTO) {
        Role role = new Role();
        BeanUtil.copyProperties(saveDTO, role);
        roleRepository.save(role);
    }
}
