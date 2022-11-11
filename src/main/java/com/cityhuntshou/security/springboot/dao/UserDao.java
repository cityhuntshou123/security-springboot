package com.cityhuntshou.security.springboot.dao;

import com.cityhuntshou.security.springboot.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lipeitao
 * @apiNote
 * @date 2022/11/11 15:00
 */
@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public UserDto getUserByUserName(String userName) {
        String sql = "select id, username, password, fullname, mobile from t_user where username = ?";
        List<UserDto> list = jdbcTemplate.query(sql, new Object[]{userName}, new BeanPropertyRowMapper<>(UserDto.class));
        if (list == null && list.size() <= 0) {
            return null;
        }

        return list.get(0);
    }
}
