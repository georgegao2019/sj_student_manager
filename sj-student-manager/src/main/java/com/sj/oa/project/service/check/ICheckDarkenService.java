package com.sj.oa.project.service.check;

import com.sj.oa.project.po.check.CheckDarken;

import java.util.List;

/**
 * Created by gaojun on 2019/7/31.
 */
public interface ICheckDarkenService {

    int insertSelective(CheckDarken record);

    CheckDarken selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CheckDarken record);

    int deleteByPrimaryKeys(Integer[] id);

    //列表条件查询
    List<CheckDarken> selectByCheckDarken(CheckDarken record);
}
