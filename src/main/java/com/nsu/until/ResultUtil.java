package com.nsu.until;

import com.nsu.domain.Results;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/11/19
 */
public class ResultUtil {
    public static Results<?> selects(Long count,Object object)
    {
        Results<?> result = new Results<>();
        result.setCode( 0 );
        result.setCount( count );
        result.setData( object );
        return result;
    }

    public static Results<?> failure(Long count,Object object)
    {
        Results<?> result = new Results<>();
        //失败
        result.setCode( 10 );
        result.setCount( count );
        result.setData( object );
        return result;
    }
}
