package com.sj.oa.project.mapper.check;

import com.sj.oa.project.po.check.CheckCourse;

import java.util.List;

/**
 * Created by jackiechan 2019/10/31
 */
public interface CheckCourseMapper {

    /**
     * 添加
     */
    int insertSelective(CheckCourse record);

    /**
     * 根据Id主键查询单个用户 登录用此方法
     */
    CheckCourse selectByPrimaryKey(Integer id);

    /**
     * 更改用户
     */
    int updateByPrimaryKeySelective(CheckCourse record);


    /*
     *
     * 批量删除用户
     */
    int deleteByPrimaryKeys(Integer[] ids);

    /*
     *
     * 用户列表 以及 根据条件查询
     */
    List<CheckCourse> selectByCheckCourse(CheckCourse record);
}
