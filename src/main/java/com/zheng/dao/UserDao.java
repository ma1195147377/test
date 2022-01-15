package com.zheng.dao;

import com.zheng.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> selectUsers();
    public int insertUser(User user);
    public int updateUser(User user);

    List<User> newSelect(User user);
}
