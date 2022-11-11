package com.cityhuntshou.security.springboot.controller;

import com.cityhuntshou.security.springboot.model.AuthenticationRequest;
import com.cityhuntshou.security.springboot.model.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author lipeitao
 * @apiNote
 * @date 2022/11/10 13:51
 */
@RestController
public class AuthenticationController {

    @GetMapping(value = "/r/r1", produces = "text/plain;charset=utf-8")
    public String r1(HttpSession session) {
        String fullName = "";
        UserDto userDto = (UserDto)session.getAttribute(UserDto.SESSION_USER_KEY);
        if (userDto == null) {
            fullName = "匿名";
        } else {
            fullName = userDto.getFullname();
        }

        return fullName + " 访问资源r1";
    }

    @GetMapping(value = "/r/r2", produces = "text/plain;charset=utf-8")
    public String r2(HttpSession session) {
        String fullName = "";
        UserDto userDto = (UserDto)session.getAttribute(UserDto.SESSION_USER_KEY);
        if (userDto == null) {
            fullName = "匿名";
        } else {
            fullName = userDto.getFullname();
        }

        return fullName + " 访问资源r2";
    }

    @RequestMapping(value = "/login-success", produces = "text/plain;charset=utf-8")
    public String login(AuthenticationRequest request, HttpSession session) {
        return "登录成功";
    }

}
