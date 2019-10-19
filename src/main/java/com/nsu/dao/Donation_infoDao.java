package com.nsu.dao;

import com.nsu.domain.Donation_info;
import com.nsu.domain.bean.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/10/9
 */
@Repository("donation_infoDao")
public interface Donation_infoDao {

    /**
     * 通过用户id查询帮助过的人
     * @param user
     * @return
     */
    @Select( "SELECT * FROM Donation_info where id = #{id}" )
    Donation_info findById(User user);
}
