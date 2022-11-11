package com.cityhuntshou.security.springboot.dao;

import com.cityhuntshou.security.springboot.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        if (list == null || list.size() <= 0) {
            return null;
        }

        return list.get(0);
    }

    public List<String> getUserPermissionByUserId(String userId) {
        String sql = "SELECT * FROM \n" +
                "t_user_role ur \n" +
                "INNER JOIN t_role_permission rp ON rp.`role_id` = ur.`role_id`\n" +
                "INNER JOIN t_permission p ON p.`id` = rp.`permission_id`\n" +
                "WHERE ur.`user_id` = ?";
        List<PermissionDto> permissionCodes = jdbcTemplate.query(sql, new Object[]{userId}, new BeanPropertyRowMapper<>(PermissionDto.class));
        if (permissionCodes == null || permissionCodes.size() == 0) {
            return new ArrayList<>();
        }

        return permissionCodes.stream().map(PermissionDto::getCode).collect(Collectors.toList());
    }
}
