package com.sj.oa.project.service.check;


import com.sj.oa.project.po.check.CheckCourse;

import java.util.List;

/**
 * Created by jackierchan on 2019/7/31.
 */
public interface ICheckCourseService {

    int insertSelective(CheckCourse record);

    CheckCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CheckCourse record);

    int deleteByPrimaryKeys(Integer[] id);

    //列表条件查询
    List<CheckCourse>  selectByCheckCourse(CheckCourse record);
}
