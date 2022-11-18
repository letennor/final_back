package com.final_back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jdbc")
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/list")
    public List<Map<String, Object>> getList() {
        String sql = "select * from user_basic_info";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @RequestMapping("/addUserInfo")
    public Object addUser() {
        String sql = "insert into role_pri(role_pri_id, role_id, privilege_id, gmt_create, gmt_modified)" + "values (2, 1, 1, '2022-11-11', '2022-12-11');";
        int update = jdbcTemplate.update(sql);
        return update;
    }

    @RequestMapping("/modifyUserInfo/{id}")
    public Object modifyUserInfo(@PathVariable("id") int id){
        String sql = "update user_basic_info set name=?, email=? where user_basic_info.user_info_id = " + id;
        Object[] objects = new Object[2];
        objects[0] = "李四";
        objects[1] = "allala@12.com";
        int update = jdbcTemplate.update(sql, objects);
        return update;
    }

}
