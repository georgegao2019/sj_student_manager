package com.sj.oa.project.service.college;

import com.sj.oa.project.po.ClassInfo;

import java.util.List;

/**
 * Created by gaojun on 2019/7/30.
 */
public interface IClassInfoService {

    int insertSelective(ClassInfo classInfo);

    ClassInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClassInfo classInfo);

    //列表条件查询
    List<ClassInfo> selectByClassInfo(ClassInfo classInfo);
}
