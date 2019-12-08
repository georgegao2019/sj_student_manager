package com.sj.oa.project.service.check;

import com.sj.oa.project.po.check.CheckMorningExercisesClass;

import java.util.List;

public interface ICheckMorningExercisesClassService {

    int insertSelective(CheckMorningExercisesClass record);

    CheckMorningExercisesClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CheckMorningExercisesClass record);

    int deleteByPrimaryKeys(Integer[] id);

    //列表条件查询
    List<CheckMorningExercisesClass> selectByCheckMorningExercisesClass();




}
