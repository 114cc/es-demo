
package com.example.demo.user.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 类 名: Role
 * 描 述:
 * 作 者: 王宇龙
 * 创 建：2025年03月17日
 */
@Data
public class RoleSaveDTO implements Serializable {

    private Long id;

    private String name;

    private String code;

}
