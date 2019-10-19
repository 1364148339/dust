package com.nsu.service.impl;

import com.nsu.dao.bean.RotationDao;
import com.nsu.domain.bean.Rotation;
import com.nsu.service.RotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 内容：
 * 轮播图
 * @author: wangqiao
 * @time: 2019/10/11
 */
@Service
public class RotationServiceImpl implements RotationService {

    @Autowired @Qualifier("rotationDao")
    private RotationDao rotationDao;
    @Override
    public List<Rotation> findAll(Rotation rotation) {
        return rotationDao.findAll(rotation);
    }
}
