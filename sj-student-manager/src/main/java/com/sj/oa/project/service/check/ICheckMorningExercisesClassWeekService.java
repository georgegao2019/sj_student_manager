package com.sj.oa.project.service.check;

import com.sj.oa.project.po.check.CheckMorningExercisesClassWeek;

import java.util.List;

public interface ICheckMorningExercisesClassWeekService {

    int insertSelective(CheckMorningExercisesClassWeek record);

    CheckMorningExercisesClassWeek selectByPrimaryKey(Integer id);



    //列表条件查询
    List<CheckMorningExercisesClassWeek> selectByCheckMorningExercisesClassWeek();



    String getWeek1Mark(String className);

    String getWeek2Mark(String className);

    String getWeek3Mark(String className);

    String getWeek4Mark(String className);

    String getWeek5Mark(String className);



}
