package com.nsu.controller.activity;

import com.nsu.domain.Activity;
import com.nsu.domain.Activity_Volunteer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/10/4
 */
public class ActivityControllerTest {

    /**
     * 通过活动编号 查到活动的所有数据
     */
    @Test
    public void checkActivityTest()
    {
        ApplicationContext a = new ClassPathXmlApplicationContext( "applicationContext.xml" );
        ActivityController activityController = (ActivityController)a.getBean( "activityController" );


        Activity activity = new Activity();
        activity.setA_id( 2L );

        Activity  res = activityController.getActivity( activity );
        System.out.println( res );
    }

    /**
     * 通过活动编号 查到活动的所有数据
     */
    @Test
    public void checkListTest()
    {
        ApplicationContext a = new ClassPathXmlApplicationContext( "applicationContext.xml" );
        ActivityController activityController = (ActivityController)a.getBean( "activityController" );


       List<Activity> list= activityController.getAll();
       for (Activity activity:list)
       {
           System.out.println( activity );
       }

    }
}
