package com.sj.oa.project.service.classall;

import com.sj.oa.project.mapper.ClassMapper;
import com.sj.oa.project.po.Classall;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dell on 2019-07-31.
 */@Service
public class IClassServiceImpl implements IClassService {
    private Logger log = LoggerFactory.getLogger(IClassServiceImpl.class);

    @Autowired
    ClassMapper classMapper;


    @Override
    public int deleteByPrimaryKeys(Integer[] id) throws Exception {
        return 0;
    }

    @Override
    public int insertSelective(Classall record) {
        return 0;
    }

    @Override
    public Classall selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(Classall record) throws Exception {
        return 0;
    }

    @Override
    public List<Classall> selectClassList(Classall classall) {
        return classMapper.selectClassList(classall);
    }
}
