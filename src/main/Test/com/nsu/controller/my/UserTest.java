package com.nsu.controller.my;

import com.nsu.controller.login.CheckLoginController;
import com.nsu.domain.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/10/9
 */
public class UserTest {
    /**
     * 检查手机号是否存在
     */
    @Test
    public void checkPhoneNumberTest()
    {
        ApplicationContext a = new ClassPathXmlApplicationContext( "applicationContext.xml" );
        UserController userController = (UserController)a.getBean( "userController" );


        User user = new User();
        user.setId( 4L );

        User s = userController.getUserById( user );

        System.out.println( s );
    }


    @Test
    public void cccc() throws Exception {
        ApplicationContext a = new ClassPathXmlApplicationContext( "applicationContext.xml" );
        PairController pairController = (PairController)a.getBean( "pairController" );

        Map<String,String> map = new HashMap<>();
        map.put("name","王伟杰");
        map.put("sex", "男");
        map.put("b_day", "2001-12-12");
        map.put("address", "ssssssss");
        map.put("introduce","kkkkkkkk");
        map.put( "id","47" );
        map.put( "age","13" );
        map.put( "star","双子座" );
       // pairController.upload_Article(map );



    }
}
