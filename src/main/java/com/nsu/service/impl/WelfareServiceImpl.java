package com.nsu.service.impl;

import com.nsu.dao.bean.WelfareDao;
import com.nsu.domain.bean.Welfare;
import com.nsu.service.WelfareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 内容：
 * 公益组织
 * @author: wangqiao
 * @time: 2019/10/10
 */
@Service("welfareServiceImpl")
public class WelfareServiceImpl implements WelfareService {

    @Autowired@Qualifier("welfareDao")
    private WelfareDao welfareDao;

    /**
     * 认证
     * @param welfare
     */
    @Override
    public void authentication(Welfare welfare) {
      welfareDao.authentication( welfare );
    }
}
