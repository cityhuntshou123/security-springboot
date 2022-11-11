package com.cityhuntshou.security.springboot.controller;

import com.cityhuntshou.security.springboot.model.AuthenticationRequest;
import com.cityhuntshou.security.springboot.model.UserDto;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    @PreAuthorize("hasAuthority('p1')")
    public String r1(HttpSession session) {
        String userName = "";
        //UserDto userDto = (UserDto)session.getAttribute(UserDto.SESSION_USER_KEY);
        //if (userDto == null) {
        //    fullName = "匿名";
        //} else {
        //    fullName = userDto.getFullname();
        //}
        userName = getUserName();

        return userName + " 访问资源r1";
    }


    @GetMapping(value = "/r/r2", produces = "text/plain;charset=utf-8")
    @PreAuthorize("hasAuthority('p2')")
    public String r2(HttpSession session) {
        String userName = "";
        //UserDto userDto = (UserDto)session.getAttribute(UserDto.SESSION_USER_KEY);
        //if (userDto == null) {
        //    fullName = "匿名";
        //} else {
        //    fullName = userDto.getFullname();
        //}

        userName = getUserName();

        return userName + " 访问资源r2";
    }

    @RequestMapping(value = "/login-success", produces = "text/plain;charset=utf-8")
    public String login(AuthenticationRequest request, HttpSession session) {
        return getUserName() + " 登录成功";
    }

    /**
     * 获取当前登录用户的信息
     * @return
     */
    private String getUserName() {
        String userName = "";
        // 当前认证通过的用户身份
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 用户身份对象
        Object principal = authentication.getPrincipal();
        if (principal == null) {
            userName = "匿名";
        }

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        }

        return userName;
    }


}
