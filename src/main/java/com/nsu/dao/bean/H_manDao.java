package com.nsu.dao.bean;

import com.nsu.domain.bean.H_man;
import com.nsu.domain.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 内容：
 * 受助人
 * @author: wangqiao
 * @time: 2019/10/15
 */
@Repository("H_manDao")
public interface H_manDao {

    /**
     * 通过用户id--查询志愿者id-->他的结对的受助者信息
     * @return List<H_man> 受助者列表
     */
    @Select( "SELECT * FROM Wait_h_man where h_id in(" +
            "SELECT h_id FROM Relation where v_id in (" +
            "SELECT v_id FROM Volunteer where id = #{id}" +
            "))" )
    List<H_man> findById(User user);

    /**
     * 添加受助者  待审核
     *
     * @param h_man
     */
    @Insert("INSERT INTO Wait_h_man (name,sex,age,star,b_day,photo,h_type,address,introduce,province,city,area,title,path) VALUES (#{name},#{sex},#{age},#{star},#{b_day},#{photo},#{h_type},#{address},#{introduce},#{province},#{city},#{area},#{title},#{path})")
    @Options(useGeneratedKeys = true, keyProperty = "h_id")
    void addH_man(H_man h_man);

    /**
     * 每次拿15条数据出来
     * @return
     */
    @Select( "select * from Wait_h_man limit #{x},#{y}" )
    List<H_man> findBySection(@Param("x") Long x, @Param("y") Long y);

    /**
     * 获取位置 省+市+区
     * @return
     */
    @Select( "select province,city,area from Wait_h_man" )
    List<H_man> findByAllPosition();
}
