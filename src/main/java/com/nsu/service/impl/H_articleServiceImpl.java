package com.nsu.service.impl;

import com.nsu.dao.bean.H_articleDao;
import com.nsu.domain.bean.H_article;
import com.nsu.service.H_articleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/10/6
 */
@Service("h_articleService")
public class H_articleServiceImpl implements H_articleService {

    @Autowired@Qualifier("h_articleDao")
    private H_articleDao h_articleDao;
    /**
     * 查询所有
     * @return
     */
    @Override
    public List<H_article> findAll() {
        List<H_article> list = h_articleDao.findAll();
        return list;
    }

    /**
     * 通过编号查询文章
     * @param h_article
     * @return
     */
    @Override
    public H_article findById(H_article h_article) {
        H_article h = h_articleDao.findById( h_article );
        return h;
    }
}
