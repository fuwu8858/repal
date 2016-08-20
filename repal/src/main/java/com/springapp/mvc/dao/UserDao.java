package com.springapp.mvc.dao;


import com.springapp.mvc.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by gjy on 2016/3/11.
 */
@Repository
public interface UserDao {

    User queryUserById(int userId) ;
    int insert(User user);
}
