package com.sj.oa.project.service.check;

import com.sj.oa.project.mapper.CheckLatebackMapper;
import com.sj.oa.project.po.check.CheckLateback;
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
public class CheckLatebackServiceImpl implements ICheckLatebackService {

    @Autowired
    private CheckLatebackMapper checkLatebackMapper;


    @Override
    public int insertSelective(CheckLateback checkLateback) {
        return checkLatebackMapper.insertSelective(checkLateback);
    }

    @Override
    public CheckLateback selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(CheckLateback majorInfo) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] id) {
        return checkLatebackMapper.deleteByPrimaryKeys(id);
    }

    @Override
    public List<CheckLateback> selectByCheckLateback(CheckLateback record) {
        return checkLatebackMapper.selectByCheckLateBack(record);
    }
}
