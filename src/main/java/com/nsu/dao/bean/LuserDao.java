package com.nsu.dao.bean;

import com.nsu.domain.bean.Luser;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * 内容：
 * 爱心人士：Luser
 * @author: wangqiao
 * @time: 2019/10/2
 */
@Repository("luserDao")
public interface LuserDao {

    /**
     * 爱心人士认证
     * 向审核表里丢数据
     * @param luser
     */
    @Insert( "INSERT INTO Wait_luser (id,name,sex,age,address,rid_photo,lid_photo,province,city,area) VALUES " +
            "(#{id},#{name},#{sex},#{age},#{address},#{rid_photo},#{lid_photo},#{province},#{city},#{area})" )
    void addAuthentication(Luser luser);
}
