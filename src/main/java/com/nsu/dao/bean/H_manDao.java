package com.nsu.dao.bean;

import com.nsu.domain.bean.H_man;
import com.nsu.domain.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 内容：
 * 受助人
 * @author: wangqiao
 * @time: 2019/10/15
 */
@Repository("h_manDao")
public interface H_manDao {

    /**
     * 通过用户id--查询志愿者id-->他的结对的受助者信息
     * @return List<H_man> 受助者列表
     */
    @Select( "SELECT * FROM H_man where state='成功' and h_id in(" +
            "SELECT h_id FROM Relation where v_id in (" +
            "SELECT v_id FROM Volunteer where id = 47" +
            "))" )
    List<H_man> findById(User user);

    /**
     * 查询受助者数量
     * @return
     */
    @Select( "select count(1) from H_man" )
    Long findNum();

    /**
     * 添加受助者  待审核
     * @param h_man
     */
    @Insert( "INSERT INTO H_man VALUES (#{h_id}, #{name},#{sex},#{age},#{star},#{b_day},#{photo},#{h_type},#{address},#{introduce},#{state},#{province},#{city},#{area})" )
    void addH_man(H_man h_man);
}
