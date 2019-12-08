package com.sj.oa.project.service.check;

import com.sj.oa.project.mapper.check.CheckMorningExercisesMapper;
import com.sj.oa.project.po.check.CheckMorningExercises;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by gaojun on 2019/8/6.
 */
@Transactional
@Service
public class CheckMoringExercisesService implements ICheckMorningExercisesService{
    @Autowired
    private CheckMorningExercisesMapper checkMorningExercisesMapper;


    @Override
    public int insertSelective(CheckMorningExercises record) {
        return checkMorningExercisesMapper.insertSelective(record);
    }

    @Override
    public CheckMorningExercises selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(CheckMorningExercises record) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKeys(Integer[] id) {
        return checkMorningExercisesMapper.deleteByPrimaryKeys(id);
    }

    @Override
    public List<CheckMorningExercises> selectByCheckMorningExercises(CheckMorningExercises record) {
        return checkMorningExercisesMapper.selectByCheckMorningExercises(record);
    }

    @Override
    public String findlateName(String className){

        return checkMorningExercisesMapper.findlateName(className);
    }

    @Override
    public String findqingjiaName(String className){

        return checkMorningExercisesMapper.findqingjiaName(className);
    }
}
