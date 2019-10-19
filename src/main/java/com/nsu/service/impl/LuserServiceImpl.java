package com.nsu.service.impl;

import com.nsu.dao.bean.LuserDao;
import com.nsu.domain.bean.Luser;
import com.nsu.service.LuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 内容：
 * 爱心人士
 * @author: wangqiao
 * @time: 2019/10/10
 */
@Service("luserServiceImpl")
public class LuserServiceImpl implements LuserService {


    @Autowired@Qualifier("luserDao")
    private LuserDao luserDao;
    /**
     * 爱心人士认证
     * @param luser
     */
    @Override
    public void addAuthentication(Luser luser) {
        luserDao.addAuthentication( luser );
    }
}
