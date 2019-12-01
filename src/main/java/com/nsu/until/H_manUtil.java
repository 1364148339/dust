package com.nsu.until;

import com.nsu.domain.bean.H_man;
import com.nsu.domain.bean.User;

import java.util.Map;
import java.util.Set;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/10/16
 */
public class H_manUtil {

    //解析map
    public static Object[] analysisMap(Map<String,String> map)
    {
        Object[] ojb = new Object[2];
        H_man h_man = new H_man();
        User user = new User();
        ojb[0] = h_man;
        ojb[1] = user;
        //解析map  封装到类中
        Set<String> keySet = map.keySet();
        for(String key:keySet)
        {
            String value = map.get( key );
            if("name".equals( key ))
            {
                h_man.setName( value );
            }
            else if("sex".equals( key ))
            {
                h_man.setSex( value );
            }
            else if("b_day".equals( key ))
            {
                h_man.setB_day( value );
            }
            else if("address".equals( key ))
            {
                h_man.setAddress( value );
            }
            else if("introduce".equals( key ))
            {
                h_man.setIntroduce( value );
            }
            else if("age".equals( key ))
            {
                h_man.setAge( new Integer( value ) );
            }
            else if("star".equals( key ))
            {
                h_man.setStar( value );
            }
            else if("province".equals( key ))
            {
                h_man.setProvince( value );
            }
            else if("city".equals( key ))
            {
                h_man.setCity( value );
            }
            else if("area".equals( key ))
            {
                h_man.setArea( value );
            }
            else if("title".equals( key ))
            {
                h_man.setTitle( value );
            }
            else if("id".equals( key ))
            {
                user.setId( new Long( value ) );
            }

        }
        //受助对象
        h_man.setH_type( "儿童" );
        return ojb;
    }

    //得到星座
//    public static String getStar(String b_day)
//    {
//        //二维数组
//        String[][] list = new String[12][31];
//        String[] Star = new String[]{"魔蝎座","水瓶座","双鱼座","白羊座","金牛座", "双子座","巨蟹座","狮子座","处女座", "天秤座","天蝎座","射手座"};
//        //1.取月份和天数
//        String Month = b_day.split( "-" )[1];
//        int month = Integer.parseInt( Month );
//        String Day = b_day.split( "-" )[2];
//        int day = Integer.parseInt( Day );
//        if(month==1)
//        {
//            if(day<=19) return Star[0];
//            else return Star[1];
//        }
//        else if(month==2)
//        {
//            if(day<=18) return Star[1];
//            else return Star[2];
//        }
//        else if(month==3)
//        {
//            if(day<=20) return Star[2];
//            else return Star[3];
//        }
//        else if(month==4)
//        {
//            if(day<=19) return Star[3];
//            else return Star[4];
//        }
//        else if(month==5)
//        {
//            if(day<=20) return Star[4];
//            else return Star[5];
//        }
//        else if(month==6)
//        {
//            if(day<=21) return Star[5];
//            else return Star[6];
//        }
//        else if(month==7)
//        {
//            if(day<=22) return Star[6];
//            else return Star[7];
//        }
//        else if(month==8)
//        {
//            if(day<=22) return Star[7];
//            else return Star[8];
//        }
//        else if(month==9)
//        {
//            if(day<=22) return Star[8];
//            else return Star[9];
//        }
//        else if(month==10)
//        {
//            if(day<=23) return Star[9];
//            else return Star[10];
//        }
//        else if(month==11)
//        {
//            if(day<=22) return Star[10];
//            else return Star[11];
//        }
//        else if(month==12)
//        {
//            if(day<=21) return Star[11];
//            else return Star[0];
//        }
//        return null;
//    }
//
//    public static void main(String[] args) {
//        String b_day = "1998-6-20";
//        System.out.println( getStar( b_day ) );
//    }
}
