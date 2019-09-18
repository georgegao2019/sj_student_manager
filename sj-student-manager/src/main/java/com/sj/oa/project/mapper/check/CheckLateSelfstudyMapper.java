package com.sj.oa.project.mapper.check;

import com.sj.oa.project.po.check.CheckLateSelfstudy;

import java.util.List;

/**
 * Created by gaojun on 2019/7/31.
 */
public interface CheckLateSelfstudyMapper {

    /**
     * 添加
     */
    int insertSelective(CheckLateSelfstudy record);

    /**
     * 根据Id主键查询单个用户 登录用此方法
     */
    CheckLateSelfstudy selectByPrimaryKey(Integer id);

    /**
     * 更改用户
     */
    int updateByPrimaryKeySelective(CheckLateSelfstudy record);


    /*
     *
     * 批量删除用户
     */
    int deleteByPrimaryKeys(Integer[] ids);

    /*
     *
     * 用户列表 以及 根据条件查询
     */
    List<CheckLateSelfstudy> selectByCheckLateSelfstudy(CheckLateSelfstudy record);
}
