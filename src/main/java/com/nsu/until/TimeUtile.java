package com.nsu.until;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/9/23
 */
public class TimeUtile {
    //10.69.4.21
    //47.93.42.220
    public static String host="http://40.121.19.201:8080/test/";

    //获取当前的时间 string类型
    public static String getTime()
    {
        String time = new String();
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
        time = sdf.format( new Date() );
        return time;
    }
}
