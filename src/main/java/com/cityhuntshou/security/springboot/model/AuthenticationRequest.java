package com.cityhuntshou.security.springboot.model;

import lombok.Data;

/**
 * @author lipeitao
 * @apiNote 请求对象
 * @date 2022/11/10 13:36
 */
@Data
public class AuthenticationRequest {

    private String username;

    private String password;
}
