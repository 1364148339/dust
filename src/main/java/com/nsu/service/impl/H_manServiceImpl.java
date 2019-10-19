package com.nsu.service.impl;

import com.nsu.dao.bean.H_manDao;
import com.nsu.domain.bean.H_man;
import com.nsu.domain.bean.User;
import com.nsu.service.H_manService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 内容：
 *
 * @author: wangqiao
 * @time: 2019/10/15
 */
@Service("h_manServiceImpl")
public class H_manServiceImpl implements H_manService {

    @Autowired @Qualifier("h_manDao")
    private H_manDao h_manDao;
    @Override
    public List<H_man> findById(User user) {
        return h_manDao.findById( user );
    }

    @Override
    public Long findNum() {
        return h_manDao.findNum();
    }

    @Override
    public void addH_man(H_man h_man) {
         h_manDao.addH_man( h_man );
    }
}
