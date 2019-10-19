package com.nsu.dao.bean;

import com.nsu.domain.bean.Rotation;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 内容：
 * 轮播图
 * @author: wangqiao
 * @time: 2019/10/11
 */
@Repository("rotationDao")
public interface RotationDao {
    //获取所有的轮播图+城市筛选
    @Select( "select * from Rotation where city = #{city}" )
    List<Rotation> findAll(Rotation rotation);
}
