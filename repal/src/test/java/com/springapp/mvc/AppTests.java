package com.springapp.mvc;




import com.mongodb.WriteResult;
import com.springapp.mvc.common.PageModel;
import com.springapp.mvc.model.User;
import com.springapp.mvc.service.UserService.UserService;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/mongo-config.xml"})
public class AppTests  {

@Autowired
private UserService userService;


    @Test
    public void tt(){
/*for(int i=1;i<=5;i++){
    User user=new User();
    user.setName("王晓松");
    user.setPhone("1393120076"+i);
    user.setDate(new Date());
    userService.saveUser(user);
}*/
userService.updateUser();

/*

        page.setPageNo(3);
        page.setPageSize(2);
     PageModel<User> list=userService.findByPhone( page,"13931200761");
        System.out.println(list.getTotalPages());
        System.out.println(list.getPageNo());
           int i=1;
        for(User user:list.getDatas()){
            System.out.println(i+++"*****************"+user.get_id()+"*********"+user.getName()+"*************"+user.getPhone()+"*******"+user.getDate());
        }*/


/*   DateTime date=     new DateTime().millisOfSecond().withMinimumValue();
        System.out.println(date.toString("yyyy年M月 H:mm:ss"));

  ;
        long time=new DateTime().getMillis();
        System.out.println(time);
        System.out.println(new DateTime(time));
   */ }
}
