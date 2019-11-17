package com.sj.oa.project.mapper.check;

import com.sj.oa.project.po.check.CheckDarken;


import java.util.List;

public interface CheckDarkenMapper {

    /**
     * 添加
     */
    int insertSelective(CheckDarken record);

    /**
     * 根据Id主键查询单个用户 登录用此方法
     */
    CheckDarken selectByPrimaryKey(Integer id);

    /**
     * 更改用户
     */
    int updateByPrimaryKeySelective(CheckDarken record);


    /*
     *
     * 批量删除用户
     */
    int deleteByPrimaryKeys(Integer[] ids);

    /*
     *
     * 用户列表 以及 根据条件查询
     */
    List<CheckDarken> selectByCheckDarken(CheckDarken record);

    /*
     *
     * 用户列表 以及 根据条件查询
     */
    List<CheckDarken> selectByCheckDarkenThisWeekend(CheckDarken record);



}
