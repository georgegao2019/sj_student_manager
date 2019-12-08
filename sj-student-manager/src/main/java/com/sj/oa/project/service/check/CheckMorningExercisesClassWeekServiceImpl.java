package com.sj.oa.project.service.check;


import com.sj.oa.project.mapper.check.CheckMorningExercisesClassWeekMapper;
import com.sj.oa.project.po.check.CheckMorningExercisesClassWeek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CheckMorningExercisesClassWeekServiceImpl implements ICheckMorningExercisesClassWeekService {

    @Autowired
    private CheckMorningExercisesClassWeekMapper CheckMorningExercisesClassWeekMapper;


    @Override
    public int insertSelective(CheckMorningExercisesClassWeek record) {
        return CheckMorningExercisesClassWeekMapper.insertSelective(record);
    }

    @Override
    public CheckMorningExercisesClassWeek selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<CheckMorningExercisesClassWeek> selectByCheckMorningExercisesClassWeek() {
        return CheckMorningExercisesClassWeekMapper.selectByCheckMorningExercisesClassWeek();
    }


    @Override
    public String getWeek1Mark(String className) {
        return CheckMorningExercisesClassWeekMapper.getWeek1Mark(className);
    }

    @Override
    public String getWeek2Mark(String className) {
        return CheckMorningExercisesClassWeekMapper.getWeek2Mark(className);
    }

    @Override
    public String getWeek3Mark(String className) {
        return CheckMorningExercisesClassWeekMapper.getWeek3Mark(className);
    }

    @Override
    public String getWeek4Mark(String className) {
        return CheckMorningExercisesClassWeekMapper.getWeek4Mark(className);
    }

    @Override
    public String getWeek5Mark(String className) {
        return CheckMorningExercisesClassWeekMapper.getWeek5Mark(className);
    }



}
