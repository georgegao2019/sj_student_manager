package com.sj.oa.project.service.check;

import com.sj.oa.project.po.check.CheckMorningExercises;

import java.util.List;

/**
 * Created by gaojun on 2019/7/31.
 */
public interface ICheckMorningExercisesService {

    int insertSelective(CheckMorningExercises record);

    CheckMorningExercises selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CheckMorningExercises record);

    int deleteByPrimaryKeys(Integer[] id);

    //列表条件查询
    List<CheckMorningExercises> selectByCheckMorningExercises(CheckMorningExercises record);
}
