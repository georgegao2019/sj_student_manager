package com.sj.oa.project.service.check;

import com.sj.oa.project.mapper.CheckLatelightoutMapper;
import com.sj.oa.project.po.CheckLatelightout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by gaojun on 2019/8/1.
 * 晚归检查service
 */
@Service
@Transactional
public class CheckLatelightoutServiceImpl implements ICheckLatelightoutService {

    @Autowired
    private CheckLatelightoutMapper checkLatelightoutMapper;


    @Override
    public int insertSelective(CheckLatelightout record) {
        return checkLatelightoutMapper.insertSelective(record);
    }

    @Override
    public CheckLatelightout selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(CheckLatelightout record) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] id) {
        return checkLatelightoutMapper.deleteByPrimaryKeys(id);
    }

    @Override
    public List<CheckLatelightout> selectByCheckLatelightout(CheckLatelightout record) {
        return checkLatelightoutMapper.selectByCheckLatelightout(record);
    }
}
