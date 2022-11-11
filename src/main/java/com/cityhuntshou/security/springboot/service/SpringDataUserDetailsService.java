package com.cityhuntshou.security.springboot.service;

import com.cityhuntshou.security.springboot.dao.UserDao;
import com.cityhuntshou.security.springboot.model.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private UserDao userDao;

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
        UserDto userByUserName = userDao.getUserByUserName(s);
        if (userByUserName == null) {
            // 如果用户查不到，返回null,由 provider来抛出异常
            return null;
        }

        // userDto -> UserDetails
        UserDetails userDetails = User.withUsername(userByUserName.getUsername())
                .password(userByUserName.getPassword())
                .authorities("p1").build();
        return userDetails;
    }
}
