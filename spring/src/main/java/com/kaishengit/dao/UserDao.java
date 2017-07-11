package com.kaishengit.dao;

import com.kaishengit.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by gedmk on 2017/7/11.
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemp;

    public void Insert(User user) {
        String sql = "insert into t_user (user_name,address,password,account_id) values (?,?,?,?)";
        jdbcTemp.update(sql,user.getUser_name(),user.getAddress(),user.getPassword(),user.getAccount_id());
    }

    public User findById(int id) {
        String sql = "select * from t_user where id = ?";
        return jdbcTemp.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
               User user = new User();
               user.setUser_name(resultSet.getString("user_name"));
               user.setPassword(resultSet.getString("password"));
               user.setAccount_id(resultSet.getInt("account_id"));
               user.setAddress(resultSet.getString("address"));
               user.setId(resultSet.getInt("id"));
               return user;
            }
        },id);


    }

}
