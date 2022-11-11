package com.cityhuntshou.security.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author lipeitao
 * @apiNote
 * @date 2022/11/11 11:19
 */
@Service
public class SpringDataUserDetailsService implements UserDetailsService {

    Logger logger = LoggerFactory.getLogger(SpringDataUserDetailsService.class);
    /**
     * 根据账号查询 用户信息
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        logger.info("登录账号:" + s);
        UserDetails userDetails = User.withUsername("zhangsan").password("$2a$10$yUMblOhiygHmreudPbtt1OCP88r8kSKheGWd3Qefsx6scJTgi92Be").authorities("p1").build();

        return userDetails;
    }
}
