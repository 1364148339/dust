package com.nsu.until;

import com.nsu.domain.bean.Volunteer;

import java.util.Map;
import java.util.Set;

/**
 * 内容：
 * 志愿者工具类---解析Map
 * @author: wangqiao
 * @time: 2019/10/17
 */
public class VolunteerUntil {


    //解析上传的map
    public static Volunteer analysisMap(Map<String,String> map)
    {
        Volunteer volunteer = new Volunteer();
        //解析map  封装到类中
        Set<String> keySet = map.keySet();
        for(String key:keySet)
        {
            String value = map.get( key );
            if("id".equals( key ))
            {
                //录入用户id
                volunteer.setId( new Long( value ) );
            }
            //名字
            else if("name".equals( key ))
            {
                volunteer.setName( value );
            }
            //性别
            else if("sex".equals( key ))
            {
                volunteer.setSex( value );
            }
            //地址
            else if("address".equals( key ))
            {
                volunteer.setAddress( value );
            }
            //省
            else if("province".equals( key ))
            {
                volunteer.setProvince( value );
            }
            //市
            else if("city".equals( key ))
            {
                volunteer.setCity( value );
            }
            //区
            else if("area".equals( key ))
            {
                volunteer.setArea( value );
            }
            //年龄
            else if("age".equals( key ))
            {
                volunteer.setAge( new Integer( value ) );
            }

        }

        return volunteer;
    }
}
