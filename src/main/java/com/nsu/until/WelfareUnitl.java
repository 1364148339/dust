package com.nsu.until;

import com.nsu.domain.bean.Welfare;

import java.util.Map;
import java.util.Set;

/**
 * 内容：
 * 公益组织工具类--解析map
 * @author: wangqiao
 * @time: 2019/10/19
 */
public class WelfareUnitl {
    //解析上传的map
    public static Welfare analysisMap(Map<String,String> map)
    {
        Welfare welfare = new Welfare();
        //解析map  封装到类中
        Set<String> keySet = map.keySet();
        for(String key:keySet)
        {
            String value = map.get( key );
            if("id".equals( key ))
            {
                //录入用户id
                welfare.setId( new Long( value ) );
            }
            //公益组织名称
            else if("name".equals( key ))
            {
                welfare.setName( value );
            }
            //地址
            else if("address".equals( key ))
            {
                welfare.setAddress( value );
            }
            //省
            else if("province".equals( key ))
            {
                welfare.setProvince( value );
            }
            //市
            else if("city".equals( key ))
            {
                welfare.setCity( value );
            }
            //区
            else if("area".equals( key ))
            {
                welfare.setArea( value );
            }
            //组织介绍
            else if("introduce".equals( key ))
            {
                welfare.setIntroduce( value );
            }
            //申请原因
            else if("reason".equals( key ))
            {
                welfare.setReason( value );
            }
        }

        return welfare;
    }
}
