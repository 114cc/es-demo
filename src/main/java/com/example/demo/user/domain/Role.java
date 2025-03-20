package com.example.demo.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * 类 名: Role
 * 描 述:
 * 作 者: 王宇龙
 * 创 建：2025年03月17日
 */
@Data
@Document(indexName = "role")
@JsonIgnoreProperties("_class")
public class Role implements Serializable {

    @Id
    @Field(type = FieldType.Long)
    private Long id;

    @Field(type = FieldType.Keyword)
    private String name;

    @Field(type = FieldType.Keyword)
    private String code;

}
