package com.nsu.dao.bean;

import com.nsu.domain.bean.H_article;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/10/6
 */
@Repository("h_articleDao")
public interface H_articleDao {

    /**
     * 查询所有
     * @return
     */
    @Select( "select * from H_article" )
    List<H_article> findAll();

    /**
     * 通过编号查询文章
     * @param h_article
     * @return
     */
    @Select( "select * from H_article where a_id = #{a_id}" )
    H_article findById(H_article h_article);
}
