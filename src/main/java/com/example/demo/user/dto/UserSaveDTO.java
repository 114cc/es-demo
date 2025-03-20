package com.example.demo.user.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 类 名: UserSaveDTO
 * 描 述:
 * 创 建：2025年03月17日
 */
@Data
public class UserSaveDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String age;

    private Integer sex;

}
