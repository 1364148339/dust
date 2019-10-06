package com.nsu.service;

import com.nsu.domain.bean.H_article;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 内容：
 * 文章
 * @author: wangqiao
 * @time: 2019/10/6
 */
@Service("h_articleService")
public interface H_articleService {
    /**
     * 查询所有
     * @return
     */
    List<H_article> findAll();

    /**
     * 通过编号查询文章
     * @param h_article
     * @return
     */
    H_article findById(H_article h_article);
}
