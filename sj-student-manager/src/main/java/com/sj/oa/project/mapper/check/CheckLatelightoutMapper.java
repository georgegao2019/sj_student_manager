package com.sj.oa.project.mapper.check;

import com.sj.oa.project.po.check.CheckLatelightout;

import java.util.List;

/**
 * Created by gaojun on 2019/7/31.
 */
public interface CheckLatelightoutMapper {

    /**
     * 添加
     */
    int insertSelective(CheckLatelightout record);

    /**
     * 根据Id主键查询单个用户 登录用此方法
     */
    CheckLatelightout selectByPrimaryKey(Integer id);

    /**
     * 更改用户
     */
    int updateByPrimaryKeySelective(CheckLatelightout record);


    /*
     *
     * 批量删除用户
     */
    int deleteByPrimaryKeys(Integer[] ids);

    /*
     *
     * 用户列表 以及 根据条件查询
     */
    List<CheckLatelightout> selectByCheckLatelightout(CheckLatelightout record);
}
