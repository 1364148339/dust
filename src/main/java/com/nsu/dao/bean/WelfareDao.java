package com.nsu.dao.bean;

import com.nsu.domain.bean.Welfare;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 内容：
 * 公益组织
 * @author: wangqiao
 * @time: 2019/10/10
 */
@Repository("welfareDao")
public interface WelfareDao {
    /**
     * 公益组织认证
     *
     */
    @Insert( "INSERT INTO Wait_welfare (id,address,bs_url,province,city,name,introduce,reason,area) VALUES (#{id},#{address},#{bs_url},#{province},#{city},#{name},#{introduce},#{reason},#{area})" )
    void authentication(Welfare welfare);

    /**
     * 通过组织id查询 组织信息
     * @param welfare
     * @return
     */
    @Select( "select * from Welfare where o_id = #{o_id}" )
    Welfare findById(Welfare welfare);
}
