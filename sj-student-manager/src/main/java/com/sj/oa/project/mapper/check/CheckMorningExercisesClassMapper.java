package com.sj.oa.project.mapper.check;

import com.sj.oa.project.po.check.CheckMorningExercisesClass;

import java.util.List;

public interface CheckMorningExercisesClassMapper {

    /**
     * 添加
     */
    int insertSelective(CheckMorningExercisesClass record);

    /**
     * 根据Id主键查询单个用户 登录用此方法
     */
    CheckMorningExercisesClass selectByPrimaryKey(Integer id);

    /**
     * 更改用户
     */
    int updateByPrimaryKeySelective(CheckMorningExercisesClass record);


    /*
     *
     * 批量删除用户
     */
    int deleteByPrimaryKeys(Integer[] ids);

    /*
     *
     * 用户列表 以及 根据条件查询
     */
    List<CheckMorningExercisesClass> selectByCheckMorningExercisesClass();
}
