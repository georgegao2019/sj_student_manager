package com.sj.oa.project.mapper.check;

import com.sj.oa.project.po.check.CheckMorningExercisesClassWeek;

import java.util.List;

public interface CheckMorningExercisesClassWeekMapper {


    /**
     * 添加
     */
    int insertSelective(CheckMorningExercisesClassWeek record);

    /**
     * 根据Id主键查询单个用户 登录用此方法
     */
    CheckMorningExercisesClassWeek selectByPrimaryKey(Integer id);





    /*
     *
     * 用户列表 以及 根据条件查询
     */
    List<CheckMorningExercisesClassWeek> selectByCheckMorningExercisesClassWeek();

    /**
     * 获取周一的分数
     * @param className
     * @return
     */
    String getWeek1Mark(String className);

    String getWeek2Mark(String className);

    String getWeek3Mark(String className);

    String getWeek4Mark(String className);

    String getWeek5Mark(String className);


}
