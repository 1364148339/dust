package com.nsu.dao.bean;

import com.nsu.domain.bean.Relation;
import com.nsu.domain.bean.User;
import com.nsu.domain.bean.Volunteer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 内容：
 * 志愿者：Volunteer
 * @author: wangqiao
 * @time: 2019/10/2
 */
@Repository("volunteerDao")
public interface VolunteerDao {
    /**
     * 查找所有志愿者
     * @return
     */
    @Select( "select * from Volunteer" )
    List<Volunteer> findAll();

    /**
     * 通过志愿者编号查找志愿者
     * @param volunteer 志愿者编号
     * @return
     */
    @Select( "select * from Volunteer where v_id = #{v_id}" )
    Volunteer findById(Volunteer volunteer);

    /**
     * 通过用户id 查询 志愿者id
     * @param user
     * @return
     */
    @Select( "select * from Volunteer where id = #{id}" )
    Volunteer findByUserId(User user);

    /**
     * 志愿者认证
     * @param volunteer 志愿者全部信息
     */
    @Insert( "INSERT INTO Wait_volunteer (id,name,sex,age,address,rid_photo,lid_photo,ff_photo,province,city,area)" +
            " VALUES (#{id},#{name},#{sex},#{age},#{address},#{rid_photo},#{lid_photo},#{ff_photo},#{province},#{city},#{area}" )
    void authentication(Volunteer volunteer);


    /**
     * 添加结对
     * @param relation  志愿者编号  上传之间   受助者编号
     */
    @Insert( "INSERT INTO Relation (v_id,up_time,h_id) VALUES (#{v_id},#{up_time},#{h_id} )" )
    void addPair(Relation relation);

}
