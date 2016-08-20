package com.springapp.mvc.service;


import com.springapp.mvc.dao.UserMapper;
import com.springapp.mvc.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author gjy
 * @Description: -com.springapp.mvc.service
 * @date 2016/8/9 10:36
 */
@Service
public class PaymentService {

  private  static Logger logger= LoggerFactory.getLogger(PaymentService.class);
    @Autowired
    private UserMapper userMapper;

    public void insert(){
        logger.info("*******************insert************************");
         User user= userMapper.queryUserById(1);

    }
}
