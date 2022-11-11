package com.cityhuntshou.security.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

/**
 * @author lipeitao
 * @apiNote
 * @date 2022/11/10 13:36
 */
@Data
@AllArgsConstructor
public class UserDto {
    public static final String SESSION_USER_KEY = "_user";
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;

    /**
     * 拥有的权限
     */
    private Set<String> authorities;
}
