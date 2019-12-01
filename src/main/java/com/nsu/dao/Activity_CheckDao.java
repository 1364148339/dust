package com.nsu.dao;

import com.nsu.domain.Activity_Check;
import com.nsu.domain.Activity_Volunteer;
import com.nsu.domain.Check;
import com.nsu.domain.bean.Activity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 内容：
 * 签到
 * @author: wangqiao
 * @time: 2019/11/17
 */
public interface Activity_CheckDao {

    /**
     * 发起签到
     * 将签到信息存入签到表中
     *
     * @param activity_check
     */
    @Insert("insert into Activity_Check_#{a_id} (check_num,continued_time) values(#{check_num},#{continued_time})")
    @Options(useGeneratedKeys = true, keyProperty = "check_id")
    void initiateSignIn(Activity_Check activity_check);


    /**
     * 创建签到表
     *
     * @param tableName
     */
    @Update("CREATE TABLE ${tableName} (\n" +
            "  `v_id` bigint(20) NOT NULL COMMENT '签到的志愿者id',\n" +
            "  `check_num` varchar(10) DEFAULT NULL COMMENT '签到码',\n" +
            "  `location_info` varchar(255) DEFAULT NULL COMMENT '位置信息',\n" +
            "  PRIMARY KEY (`v_id`)\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;")
    void creatCheckInForm(@Param("tableName") String tableName);

    /**
     * 导入志愿者编号
     * @param list
     * @param tableName
     */
    @Insert("<script> " +
            "insert into ${tableName}"+
            "(v_id" + ") " +
            "values " +
            "<foreach collection=\"items\" index=\"index\" item=\"item\" separator=\",\"> "
            +
            "(#{item.v_id})"
            +
            "</foreach> " +
            "</script>")
    void importVolunteers(@Param("items") List<Activity_Volunteer> list, @Param("tableName") String tableName);

    /**
     * 修改签到状态
     * @param tableName
     * @param check_id
     */
    @Update( "update ${tableName} set check_status='0' where check_id=${check_id}" )
    void modifyCheckInStatus(@Param("tableName") String tableName,@Param("check_id") Integer check_id);

    /**
     * 获取最底下的签到的状态
     * @param activity 活动id
     * @return
     */
    @Select( "select check_status from Activity_Check_#{a_id} ORDER BY check_id DESC LIMIT 1 " )
    String findStatus(Activity activity);

    /**
     * 获取最底下的check_id
     * @param activity 活动id
     * @return
     */
    @Select( "select check_id from Activity_Check_#{a_id} ORDER BY check_id DESC LIMIT 1 " )
    Integer findCheckId(Activity activity);

    /**
     * 获取最底下的check_num
     * @param activity 活动id
     * @return
     */
    @Select( "select check_num from Activity_Check_#{a_id} ORDER BY check_id DESC LIMIT 1 " )
    String  findCheckNum(Activity activity);
    /**
     * 志愿者签到
     * @param tableName
     * @param check
     */
    @Update( "update ${tableName} set check_num=#{check.check_num},location_info=#{check.position_info} where v_id=#{check.id}" )
    void checkIn(@Param("tableName") String tableName,@Param("check") Check check);
}