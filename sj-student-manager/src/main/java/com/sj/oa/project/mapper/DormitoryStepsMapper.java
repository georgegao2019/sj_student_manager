package com.sj.oa.project.mapper;


import com.sj.oa.project.po.dormitory.DormitorySteps;

import java.util.List;

/**
 * Created by gaojun on 2019/7/31.
 */
public interface DormitoryStepsMapper {

    /**
     * 添加
     */
    int insertSelective(DormitorySteps record);

    /**
     * 根据Id主键查询单个用户 登录用此方法
     */
    DormitorySteps selectByPrimaryKey(Integer id);

    /**
     * 更改用户
     */
    int updateByPrimaryKeySelective(DormitorySteps record);


    /*
     *
     * 批量删除用户
     */
    int deleteByPrimaryKeys(Integer[] ids);

    /*
     *
     * 用户列表 以及 根据条件查询
     */
    List<DormitorySteps> selectByDormitorySteps(DormitorySteps record);

    /* 校验宿舍楼code */
    DormitorySteps checkStepUnique(DormitorySteps record);

}
