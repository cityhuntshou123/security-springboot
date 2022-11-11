package com.cityhuntshou.security.springboot.dao;

import lombok.Data;

/**
 * @author lipeitao
 * @apiNote
 * @date 2022/11/11 16:44
 */
@Data
public class PermissionDto {
    private Long id;
    private String code;
    private String description;
    private String url;
}
