package com.example.demo.user.repository;

import com.example.demo.user.domain.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * 类 名: UserRepository
 * 描 述:
 * 创 建：2025年03月18日
 */
@Repository
public interface UserRepository extends ElasticsearchRepository<User, Long> {

    User findUserById(Long id);
}
