package com.sj.oa.project.service.college;

import com.sj.oa.project.mapper.MajorInfoMapper;
import com.sj.oa.project.po.MajorInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by gaojun on 2019/7/30.
 */
@Service
@Transactional
public class MajorInfoServiceImpl implements IMajorInfoService {

    @Autowired
    private MajorInfoMapper majorInfoMapper;

    @Override
    public int insertSelective(MajorInfo majorInfo) {
        return 0;
    }

    @Override
    public MajorInfo selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(MajorInfo majorInfo) {
        return 0;
    }

    /**
     * 列表查询
     * @param record
     * @return
     */
    @Override
    public List<MajorInfo> selectByMajorInfo(MajorInfo record) {
        return majorInfoMapper.selectByMajorInfo(record);
    }
}
