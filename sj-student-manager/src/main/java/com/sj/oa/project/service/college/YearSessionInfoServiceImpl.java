package com.sj.oa.project.service.college;

import com.sj.oa.project.mapper.college.YearSessionInfoMapper;
import com.sj.oa.project.po.college.YearSessionInfo;
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
public class YearSessionInfoServiceImpl implements IYearSessionInfoService {

    @Autowired
    private YearSessionInfoMapper yearSessionInfoMapper;


    @Override
    public int insertSelective(YearSessionInfo record) {
        return yearSessionInfoMapper.insertSelective(record);
    }

    @Override
    public YearSessionInfo selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(YearSessionInfo record) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] id) {
        return yearSessionInfoMapper.deleteByPrimaryKeys(id);
    }

    @Override
    public List<YearSessionInfo> selectByYearSessionInfo(YearSessionInfo record) {
        return yearSessionInfoMapper.selectByYearSessionInfo(record);
    }
}
