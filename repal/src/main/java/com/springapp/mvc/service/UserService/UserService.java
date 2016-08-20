package com.springapp.mvc.service.UserService;


import com.mongodb.WriteResult;
import com.springapp.mvc.common.PageModel;
import com.springapp.mvc.dao.UserDao;
import com.springapp.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gjy on 2016/3/11.
 */
@Service
public class UserService {


    private static String USER_COLLECTION = "User";

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     *
     * @param user
     */
    public void saveUser(User user){

        mongoTemplate.save(user, USER_COLLECTION);

    }
    public void updateUser(){
        Criteria criteria=new Criteria();
         criteria.where("phone").is("13931200761");
        Query query=new Query(criteria);
        Update update=new Update();
       update.set("name","******");

        mongoTemplate.updateFirst(query,update,User.class,USER_COLLECTION);

    }

    /**
     *
     * @param name
     * @return
     */
    public User findUserByName(String name){

        return mongoTemplate.findOne(new Query(Criteria.where("name").is(name)), User.class, USER_COLLECTION);

    }
    public PageModel<User> findByPhone(PageModel<User> page,String phone){
/*        Criteria criatira = new Criteria();
        criatira.andOperator(
                Criteria.where("phone").is(phone),
                Criteria.where("name").is("张晓松")
        );*/

    /*  criteria=  criteria.where("date").is("2016/8/13 13:54:53");*/

        Query query=new Query();
        page.setRowCount((int)mongoTemplate.count(query, User.class, USER_COLLECTION));

        query.skip(page.getSkip());
        query.limit(page.getPageSize());

        query.with(new Sort(Sort.Direction.DESC,"date")).with(new Sort(Sort.Direction.ASC,"phone"));
        List<User> list =    mongoTemplate.find(query, User.class, USER_COLLECTION);
        page.setDatas(list);

        return page;

    }
}
