package com.nsu.until;


import com.nsu.domain.bean.Luser;
import java.util.Map;
import java.util.Set;

/**
 * 内容：
 * 爱心人士工具类
 * @author: wangqiao
 * @time: 2019/10/17
 */
public class LuserUntil {

    //解析上传的map
    public static Luser analysisMap(Map<String,String> map)
    {
        Luser luser = new Luser();
        //解析map  封装到类中
        Set<String> keySet = map.keySet();
        for(String key:keySet)
        {
            String value = map.get( key );
            if("id".equals( key ))
            {
                //录入用户id
                luser.setId( new Long( value ) );
            }
            //名字
            else if("name".equals( key ))
            {
                luser.setName( value );
            }
            //性别
            else if("sex".equals( key ))
            {
                luser.setSex( value );
            }
            else if("province".equals( key ))
            {
                luser.setProvince( value );
            }
            else if("city".equals( key ))
            {
                luser.setCity( value );
            }
            //地址
            else if("address".equals( key ))
            {
                luser.setAddress( value );
            }
            else if("area".equals( key ))
            {
                luser.setArea( value );
            }
            //年龄
            else
            {
                luser.setAge( new Integer( value ) );
            }

        }

        return luser;
    }
}
