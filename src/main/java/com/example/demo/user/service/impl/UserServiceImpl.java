package com.example.demo.user.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.StrPool;
import cn.hutool.core.util.StrUtil;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.example.demo.user.domain.User;
import com.example.demo.user.dto.UserSaveDTO;
import com.example.demo.user.repository.UserRepository;
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
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ElasticsearchClient elasticsearchClient;

    @Override
    public List<User> listUserPage(Integer pageNum, Integer pageSize, String keyWord) {
        Integer curPageNum = pageNum <= 0 ? 0 : (pageNum - 1) * pageSize;
        List<User> result = new ArrayList<>(16);
        SearchResponse<User> response = null;
        try {
            response = elasticsearchClient.search(builder -> builder
//                            .query(q -> q.match(m -> m.field("name").query(keyWord)))
                            .index("user")
                            // 年龄排序
                            .sort(sort -> sort.field(field -> field.field("age").order(SortOrder.Desc)))
                            // 配置高亮
                            .highlight(h ->
                                    h.highlightQuery(hq -> hq.match(m -> m.field("name")
                                            .query(keyWord)))
                                            .fields("name", f -> f
                                            .fragmentSize(10)))
                            .from(curPageNum)
                            .size(pageSize)
                            .aggregations("age", agg -> agg.terms(group -> group.field("age"))),
                    User.class);
        } catch (IOException e) {
            log.error("获取es用户数据失败:{}", e.getMessage());
            throw new RuntimeException("获取es用户数据失败");
        }
        List<Hit<User>> hits = response.hits().hits();
        if (CollUtil.isEmpty(hits)) {
            return result;
        }
        return hits.stream()
                .map(user -> {
                    User source = user.source();
                    List<String> nameHigh = user.highlight().get("name");
                    if (CollUtil.isEmpty(nameHigh)) {
                        return source;
                    }
                    source.setName(StrUtil.join(StrPool.COMMA, nameHigh));
                    return source;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void save(UserSaveDTO saveDTO) {
        User user = new User();
        BeanUtil.copyProperties(saveDTO, user);
        userRepository.save(user);
    }
}
