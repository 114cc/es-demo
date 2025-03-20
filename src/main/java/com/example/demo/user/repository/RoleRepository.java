package com.example.demo.user.repository;

import com.example.demo.user.domain.Role;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * 类 名: RoleRepository
 * 描 述:
 * 创 建：2025年03月18日
 */
@Repository
public interface RoleRepository extends ElasticsearchRepository<Role, Long> {

}
