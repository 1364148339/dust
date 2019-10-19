package com.nsu.until;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/9/23
 */
public class TimeUntile {

//    //获取当前的年 string类型
//    public static String getTimeYear()
//    {
//        String time = new String(  );
//        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy" );
//        time = sdf.format( new Date(  ) );
//        return time;
//    }

    //获取当前的时间 string类型
    public static String getTime()
    {
        String time = new String();
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
        time = sdf.format( new Date() );
        return time;
    }
}
