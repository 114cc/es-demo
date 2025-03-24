package com.example.demo.user.repository;

import com.example.demo.user.domain.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类 名: UserRepository
 * 描 述:
 * 创 建：2025年03月18日
 */
@Repository
public interface UserRepository extends ElasticsearchRepository<User, Long> {

    /**
     * 根据id查询用户
     * @param id 数据ID
     * @return 用户信息
     */
    User findUserById(Long id);

    /**
     * 描 述： 根据用户名称模糊查询用户列表
     * 作 者： 王宇龙
     * @param name 用户名称
     * @return 用户列表
     */
    List<User> findUserByNameIsLike(String name);
}
