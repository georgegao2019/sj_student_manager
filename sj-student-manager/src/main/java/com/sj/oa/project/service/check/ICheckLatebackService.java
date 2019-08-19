package com.sj.oa.project.service.check;

import com.sj.oa.project.po.check.CheckLateback;

import java.util.List;

/**
 * Created by gaojun on 2019/7/31.
 */
public interface ICheckLatebackService {

    int insertSelective(CheckLateback checkLateback);

    CheckLateback selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CheckLateback majorInfo);

    int deleteByPrimaryKeys(Integer[] id);

    //列表条件查询
    List<CheckLateback> selectByCheckLateback(CheckLateback record);
}
