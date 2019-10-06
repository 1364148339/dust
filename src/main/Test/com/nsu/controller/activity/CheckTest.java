package com.nsu.controller.activity;

import com.nsu.domain.Activity;
import com.nsu.domain.Activity_Volunteer;
import com.nsu.domain.bean.Volunteer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/10/4
 */
public class CheckTest {
    /**
     * 检查手机号是否存在
     */
    @Test
    public void checkPhoneNumberTest()
    {
        ApplicationContext a = new ClassPathXmlApplicationContext( "applicationContext.xml" );
        CheckActivityController check = (CheckActivityController)a.getBean( "checkActivity" );

        Activity_Volunteer activity = new Activity_Volunteer();
        activity.setA_id( 2L );
        activity.setV_id( 1L );

        String  res =check.checkVolunteer(activity);
        System.out.println( res );
    }
}
