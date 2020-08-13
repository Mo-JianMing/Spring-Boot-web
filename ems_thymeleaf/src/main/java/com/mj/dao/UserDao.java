package com.mj.dao;

import com.mj.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    void save(User user);
    List<User> select();
    String sId(String name);
}
