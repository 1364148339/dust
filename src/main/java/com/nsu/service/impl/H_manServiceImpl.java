package com.nsu.service.impl;

import com.nsu.dao.bean.H_manDao;
import com.nsu.domain.bean.H_man;
import com.nsu.domain.bean.User;
import com.nsu.service.H_manService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 内容：
 * @author: wangqiao
 * @time: 2019/10/15
 */
@Service("h_manServiceImpl")
public class H_manServiceImpl implements H_manService {

    @Autowired
    private H_manDao h_manDao;
    @Override
    public List<H_man> findById(User user) {

        return h_manDao.findById( user );
    }


    @Override
    public void addH_man(H_man h_man) {

       h_manDao.addH_man( h_man );
    }

    @Override
    public List<H_man> findBySection(Long x, Long y) {
        return  h_manDao.findBySection( x,y );
    }

    @Override
    public List<String> findByAllPosition() {
        List<H_man> h_manList = h_manDao.findByAllPosition();
        List<String> list = new ArrayList<>(  );
        StringBuffer stringBuffer = new StringBuffer(  );
        for(H_man h_man:h_manList)
        {
            stringBuffer.append( h_man.getProvince() );
            stringBuffer.append( h_man.getCity() );
            stringBuffer.append( h_man.getArea() );
            list.add( stringBuffer.toString() );
            stringBuffer.setLength( 0 );
        }
        return list;
    }
}
