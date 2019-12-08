package com.sj.oa.project.service.check;

import com.sj.oa.project.mapper.check.CheckMorningExercisesClassMapper;
import com.sj.oa.project.po.check.CheckMorningExercisesClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * yy
 */
@Transactional
@Service
public class CheckMorningExercisesClassServiceImpl implements ICheckMorningExercisesClassService {

    @Autowired
    private CheckMorningExercisesClassMapper checkMorningExercisesClassMapper;


    @Override
    public int insertSelective(CheckMorningExercisesClass record) {
        return checkMorningExercisesClassMapper.insertSelective(record);
    }

    @Override
    public CheckMorningExercisesClass selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(CheckMorningExercisesClass record) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] id) {
        return checkMorningExercisesClassMapper.deleteByPrimaryKeys(id);
    }

    @Override
    public List<CheckMorningExercisesClass> selectByCheckMorningExercisesClass() {
        return checkMorningExercisesClassMapper.selectByCheckMorningExercisesClass();
    }




}
