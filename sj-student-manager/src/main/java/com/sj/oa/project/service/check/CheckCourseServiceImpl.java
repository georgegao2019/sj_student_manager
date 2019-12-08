package com.sj.oa.project.service.check;

import com.sj.oa.project.mapper.check.CheckCourseMapper;
import com.sj.oa.project.po.check.CheckCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
@Transactional
public class CheckCourseServiceImpl implements ICheckCourseService{

    @Autowired
    private CheckCourseMapper checkCourseMapper;

    @Override
    public int insertSelective(CheckCourse record) {
        return checkCourseMapper.insertSelective(record);
    }

    @Override
    public CheckCourse selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(CheckCourse record) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] id) {
        return checkCourseMapper.deleteByPrimaryKeys(id);
    }

    @Override
    public List<CheckCourse> selectByCheckCourse(CheckCourse record) {
        return checkCourseMapper.selectByCheckCourse(record);
    }
}
