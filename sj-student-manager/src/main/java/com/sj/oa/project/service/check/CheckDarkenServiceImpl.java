package com.sj.oa.project.service.check;



import com.sj.oa.project.mapper.check.CheckDarkenMapper;
import com.sj.oa.project.po.check.CheckDarken;
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
public class CheckDarkenServiceImpl implements ICheckDarkenService{

    @Autowired
    private CheckDarkenMapper checkDarkenMapper;


    @Override
    public int insertSelective(CheckDarken record) {
        return checkDarkenMapper.insertSelective(record);
    }

    @Override
    public CheckDarken selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(CheckDarken record) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] id) {
        return checkDarkenMapper.deleteByPrimaryKeys(id);
    }

    @Override
    public List<CheckDarken> selectByCheckDarken(CheckDarken record) {
        return checkDarkenMapper.selectByCheckDarken(record);
    }

    @Override
    public List<CheckDarken> selectByCheckDarkenThisWeekend(CheckDarken record) {
        return checkDarkenMapper.selectByCheckDarkenThisWeekend(record);
    }
}
